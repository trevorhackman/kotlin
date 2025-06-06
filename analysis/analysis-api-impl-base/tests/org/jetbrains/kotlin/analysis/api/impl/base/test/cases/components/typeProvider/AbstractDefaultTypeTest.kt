/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.typeProvider

import org.jetbrains.kotlin.analysis.api.symbols.DebugSymbolRenderer
import org.jetbrains.kotlin.analysis.api.symbols.KaClassifierSymbol
import org.jetbrains.kotlin.analysis.test.framework.base.AbstractAnalysisApiBasedTest
import org.jetbrains.kotlin.analysis.test.framework.projectStructure.KtTestModule
import org.jetbrains.kotlin.analysis.test.framework.services.expressionMarkerProvider
import org.jetbrains.kotlin.analysis.test.framework.targets.getTestTargetSymbols
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.test.services.TestServices
import org.jetbrains.kotlin.test.services.assertions
import org.jetbrains.kotlin.types.Variance

abstract class AbstractDefaultTypeTest : AbstractAnalysisApiBasedTest() {
    override fun doTestByMainFile(mainFile: KtFile, mainModule: KtTestModule, testServices: TestServices) {
        copyAwareAnalyzeForTest(mainFile) { contextFile ->
            val declarationAtCaret =
                testServices.expressionMarkerProvider.getBottommostElementOfTypeAtCaretOrNull<KtDeclaration>(contextFile)
            val symbol = declarationAtCaret?.symbol ?: getTestTargetSymbols(testDataPath, contextFile).single()

            val defaultType = (symbol as KaClassifierSymbol).defaultType
            val actual = DebugSymbolRenderer().renderType(this@copyAwareAnalyzeForTest, defaultType)
            testServices.assertions.assertEqualsToTestOutputFile(actual)

            val prettyType = defaultType.render(position = Variance.INVARIANT)
            testServices.assertions.assertEqualsToTestOutputFile(prettyType, extension = "pretty.txt")
        }
    }
}
