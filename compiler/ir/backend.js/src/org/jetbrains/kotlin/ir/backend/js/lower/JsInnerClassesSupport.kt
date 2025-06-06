/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.backend.js.lower

import org.jetbrains.kotlin.backend.common.compilationException
import org.jetbrains.kotlin.backend.common.lower.InnerClassesSupport
import org.jetbrains.kotlin.descriptors.DescriptorVisibilities
import org.jetbrains.kotlin.ir.backend.js.ir.JsIrBuilder.SYNTHESIZED_DECLARATION
import org.jetbrains.kotlin.ir.backend.js.utils.Namer
import org.jetbrains.kotlin.ir.builders.declarations.buildConstructor
import org.jetbrains.kotlin.ir.builders.declarations.buildField
import org.jetbrains.kotlin.ir.builders.declarations.buildValueParameter
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.irAttribute
import org.jetbrains.kotlin.utils.memoryOptimizedPlus
import org.jetbrains.kotlin.ir.util.copyTo
import org.jetbrains.kotlin.ir.util.copyTypeParametersFrom
import org.jetbrains.kotlin.ir.util.defaultType
import org.jetbrains.kotlin.ir.util.nonDispatchParameters
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.utils.addToStdlib.getOrSetIfNull

private var IrClass.outerThisFieldSymbol: IrField? by irAttribute(copyByDefault = false)

private var IrConstructor.innerClassConstructor: IrConstructor? by irAttribute(copyByDefault = false)

private var IrClass.originalInnerClassPrimaryConstructor: IrConstructor? by irAttribute(copyByDefault = false)

class JsInnerClassesSupport(private val irFactory: IrFactory) : InnerClassesSupport {
    override fun getOuterThisField(innerClass: IrClass): IrField =
        if (!innerClass.isInner) compilationException(
            "Class is not inner",
            innerClass
        )
        else {
            innerClass::outerThisFieldSymbol.getOrSetIfNull {
                val outerClass = innerClass.parent as? IrClass
                    ?: compilationException(
                        "No containing class for inner class",
                        innerClass
                    )

                irFactory.buildField {
                    origin = IrDeclarationOrigin.FIELD_FOR_OUTER_THIS
                    name = Name.identifier(Namer.SYNTHETIC_RECEIVER_NAME)
                    type = outerClass.defaultType
                    visibility = DescriptorVisibilities.PROTECTED
                    isFinal = true
                    isExternal = false
                    isStatic = false
                }.also {
                    it.parent = innerClass
                }
            }
        }

    override fun getInnerClassConstructorWithOuterThisParameter(innerClassConstructor: IrConstructor): IrConstructor {
        val innerClass = innerClassConstructor.parent as IrClass
        assert(innerClass.isInner) { "Class is not inner: $innerClass" }

        return innerClassConstructor::innerClassConstructor.getOrSetIfNull {
            createInnerClassConstructorWithOuterThisParameter(innerClassConstructor)
        }.also {
            if (innerClassConstructor.isPrimary) {
                innerClass.originalInnerClassPrimaryConstructor = innerClassConstructor
            }
        }
    }

    override fun getInnerClassOriginalPrimaryConstructorOrNull(innerClass: IrClass): IrConstructor? {
        assert(innerClass.isInner) { "Class is not inner: $innerClass" }

        return innerClass.originalInnerClassPrimaryConstructor
    }

    private fun createInnerClassConstructorWithOuterThisParameter(oldConstructor: IrConstructor): IrConstructor {
        val irClass = oldConstructor.parent as IrClass
        val outerThisType = (irClass.parent as IrClass).defaultType

        val newConstructor = irFactory.buildConstructor {
            updateFrom(oldConstructor)
            returnType = oldConstructor.returnType
        }.also {
            it.parent = oldConstructor.parent
            it.annotations = oldConstructor.annotations
        }

        newConstructor.copyTypeParametersFrom(oldConstructor)

        val newValueParameters = mutableListOf(buildValueParameter(newConstructor) {
            origin = SYNTHESIZED_DECLARATION
            name = Name.identifier(Namer.OUTER_NAME)
            type = outerThisType
            kind = IrParameterKind.Regular
        })

        for (p in oldConstructor.nonDispatchParameters) {
            newValueParameters += p.copyTo(newConstructor)
        }

        newConstructor.parameters = newConstructor.parameters memoryOptimizedPlus newValueParameters

        return newConstructor
    }
}
