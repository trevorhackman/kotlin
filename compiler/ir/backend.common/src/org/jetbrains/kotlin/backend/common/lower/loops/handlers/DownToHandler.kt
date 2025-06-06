/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.common.lower.loops.handlers

import org.jetbrains.kotlin.backend.common.CommonBackendContext
import org.jetbrains.kotlin.backend.common.lower.createIrBuilder
import org.jetbrains.kotlin.backend.common.lower.loops.*
import org.jetbrains.kotlin.ir.builders.irInt
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.expressions.IrConst
import org.jetbrains.kotlin.ir.expressions.IrConstKind
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.impl.IrConstImpl
import org.jetbrains.kotlin.ir.symbols.IrSymbol
import org.jetbrains.kotlin.ir.util.hasShape
import org.jetbrains.kotlin.ir.util.kotlinFqName
import org.jetbrains.kotlin.name.FqName

/** Builds a [HeaderInfo] for progressions built using the `downTo` extension function. */
internal class DownToHandler(private val context: CommonBackendContext) : HeaderInfoHandler<IrCall, ProgressionType> {
    private val preferJavaLikeCounterLoop = context.preferJavaLikeCounterLoop
    private val progressionElementTypes = context.symbols.progressionElementTypes

    override fun matchIterable(expression: IrCall): Boolean {
        val callee = expression.symbol.owner
        return callee.hasShape(extensionReceiver = true, regularParameters = 1) &&
                callee.parameters[0].type in progressionElementTypes &&
                callee.parameters[1].type in progressionElementTypes &&
                callee.kotlinFqName == FqName("kotlin.ranges.downTo")
    }

    override fun build(expression: IrCall, data: ProgressionType, scopeOwner: IrSymbol) =
        with(context.createIrBuilder(scopeOwner, expression.startOffset, expression.endOffset)) {
            val first = expression.arguments[0]!!
            val last = expression.arguments[1]!!
            val step = irInt(-1)
            val direction = ProgressionDirection.DECREASING

            if (preferJavaLikeCounterLoop) {
                // Convert range with inclusive lower bound to exclusive lower bound if possible.
                // This affects loop code performance on JVM.
                val lastExclusive = last.convertToExclusiveLowerBound(data)
                if (lastExclusive != null) {
                    return@with ProgressionHeaderInfo(
                        data,
                        first = first,
                        last = lastExclusive,
                        step = step,
                        direction = direction,
                        isLastInclusive = false,
                        canOverflow = false,
                        originalLastInclusive = last
                    )
                }
            }

            ProgressionHeaderInfo(data, first = first, last = last, step = step, direction = direction)
        }

    private fun IrExpression.convertToExclusiveLowerBound(progressionType: ProgressionType): IrExpression? {
        if (progressionType is UnsignedProgressionType) {
            // On JVM, prefer unsigned counter loop with inclusive bound
            if (preferJavaLikeCounterLoop || this.constLongValue == 0L) return null
        }

        val irConst = this as? IrConst ?: return null
        return when (irConst.kind) {
            IrConstKind.Char -> {
                val charValue = irConst.value as Char
                if (charValue != Char.MIN_VALUE)
                    IrConstImpl.char(startOffset, endOffset, type, charValue.dec())
                else
                    null
            }
            IrConstKind.Byte -> {
                val byteValue = irConst.value as Byte
                if (byteValue != Byte.MIN_VALUE)
                    IrConstImpl.byte(startOffset, endOffset, type, byteValue.dec())
                else
                    null
            }
            IrConstKind.Short -> {
                val shortValue = irConst.value as Short
                if (shortValue != Short.MIN_VALUE)
                    IrConstImpl.short(startOffset, endOffset, type, shortValue.dec())
                else
                    null
            }
            IrConstKind.Int -> {
                val intValue = irConst.value as Int
                if (intValue != Int.MIN_VALUE)
                    IrConstImpl.int(startOffset, endOffset, type, intValue.dec())
                else
                    null
            }
            IrConstKind.Long -> {
                val longValue = irConst.value as Long
                if (longValue != Long.MIN_VALUE)
                    IrConstImpl.long(startOffset, endOffset, type, longValue.dec())
                else
                    null
            }
            else ->
                null
        }
    }
}
