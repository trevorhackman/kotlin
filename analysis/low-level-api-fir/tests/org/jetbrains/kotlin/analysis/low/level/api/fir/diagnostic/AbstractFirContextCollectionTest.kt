/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir.diagnostic

import org.jetbrains.kotlin.analysis.low.level.api.fir.api.DiagnosticCheckerFilter
import org.jetbrains.kotlin.analysis.low.level.api.fir.api.getDiagnostics
import org.jetbrains.kotlin.analysis.low.level.api.fir.api.getOrBuildFirFile
import org.jetbrains.kotlin.analysis.low.level.api.fir.diagnostics.BeforeElementDiagnosticCollectionHandler
import org.jetbrains.kotlin.analysis.low.level.api.fir.diagnostics.beforeElementDiagnosticCollectionHandler
import org.jetbrains.kotlin.analysis.low.level.api.fir.diagnostics.fir.PersistenceContextCollector
import org.jetbrains.kotlin.analysis.low.level.api.fir.file.structure.FileStructureElement
import org.jetbrains.kotlin.analysis.low.level.api.fir.isSourceSession
import org.jetbrains.kotlin.analysis.low.level.api.fir.name
import org.jetbrains.kotlin.analysis.low.level.api.fir.withResolutionFacade
import org.jetbrains.kotlin.analysis.low.level.api.fir.sessions.LLFirResolvableModuleSession
import org.jetbrains.kotlin.analysis.low.level.api.fir.sessions.LLFirSession
import org.jetbrains.kotlin.analysis.low.level.api.fir.sessions.LLFirSessionConfigurator
import org.jetbrains.kotlin.analysis.low.level.api.fir.test.configurators.AnalysisApiFirOutOfContentRootTestConfigurator
import org.jetbrains.kotlin.analysis.low.level.api.fir.test.configurators.AnalysisApiFirScriptTestConfigurator
import org.jetbrains.kotlin.analysis.low.level.api.fir.test.configurators.AnalysisApiFirSourceTestConfigurator
import org.jetbrains.kotlin.analysis.low.level.api.fir.useFirSessionConfigurator
import org.jetbrains.kotlin.analysis.test.framework.base.AbstractAnalysisApiBasedTest
import org.jetbrains.kotlin.analysis.test.framework.projectStructure.KtTestModule
import org.jetbrains.kotlin.fir.SessionConfiguration
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.declarations.FirDeclaration
import org.jetbrains.kotlin.fir.declarations.FirFile
import org.jetbrains.kotlin.fir.resolve.SessionHolderImpl
import org.jetbrains.kotlin.fir.symbols.FirBasedSymbol
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.test.builders.TestConfigurationBuilder
import org.jetbrains.kotlin.test.services.AssertionsService
import org.jetbrains.kotlin.test.services.TestServices
import org.jetbrains.kotlin.test.services.assertions

abstract class AbstractFirContextCollectionTest : AbstractAnalysisApiBasedTest() {
    override fun configureTest(builder: TestConfigurationBuilder) {
        super.configureTest(builder)
        builder.apply {
            useFirSessionConfigurator(::BeforeElementLLFirSessionConfigurator)
        }
    }

    override fun doTestByMainFile(mainFile: KtFile, mainModule: KtTestModule, testServices: TestServices) {
        withResolutionFacade(mainFile) { resolutionFacade ->
            check(resolutionFacade.isSourceSession)

            val session = resolutionFacade.getSessionFor(mainModule.ktModule) as LLFirResolvableModuleSession
            val handler = session.beforeElementDiagnosticCollectionHandler as BeforeElementTestDiagnosticCollectionHandler

            val fileStructureCache = session.moduleComponents.fileStructureCache

            val fileStructure = fileStructureCache.getFileStructure(mainFile)
            val allStructureElements = fileStructure.getAllStructureElements()

            handler.elementsToCheckContext = allStructureElements.map(FileStructureElement::declaration)
            handler.firFile = mainFile.getOrBuildFirFile(resolutionFacade)

            mainFile.getDiagnostics(resolutionFacade, DiagnosticCheckerFilter.ONLY_DEFAULT_CHECKERS)
        }
    }

    private class BeforeElementLLFirSessionConfigurator(private val testServices: TestServices) : LLFirSessionConfigurator {
        @OptIn(SessionConfiguration::class)
        override fun configure(session: LLFirSession) {
            val handler = BeforeElementTestDiagnosticCollectionHandler(testServices.assertions)
            session.register(BeforeElementDiagnosticCollectionHandler::class, handler)
        }
    }

    private class BeforeElementTestDiagnosticCollectionHandler(
        private val assertions: AssertionsService,
    ) : BeforeElementDiagnosticCollectionHandler() {
        lateinit var elementsToCheckContext: List<FirDeclaration>
        lateinit var firFile: FirFile

        override fun beforeGoingNestedDeclaration(declaration: FirDeclaration, context: CheckerContext) {
            if (declaration is FirFile) {
                return
            }
            if (declaration in elementsToCheckContext) {
                val collectedContext = PersistenceContextCollector.collectContext(
                    SessionHolderImpl.createWithEmptyScopeSession(declaration.moduleData.session),
                    firFile,
                    declaration
                )
                compareStructurally(context, collectedContext)
            }
        }

        private fun compareStructurally(expected: CheckerContext, actual: CheckerContext) {
            assertions.assertEquals(expected.containingDeclarations.asString(), actual.containingDeclarations.asString())
        }

        private fun List<FirBasedSymbol<*>>.asString() =
            joinToString(transform = { it.fir.name() })
    }
}

abstract class AbstractFirSourceContextCollectionTest : AbstractFirContextCollectionTest() {
    override val configurator = AnalysisApiFirSourceTestConfigurator(analyseInDependentSession = false)
}

abstract class AbstractFirOutOfContentRootContextCollectionTest : AbstractFirContextCollectionTest() {
    override val configurator get() = AnalysisApiFirOutOfContentRootTestConfigurator
}

abstract class AbstractScriptContextCollectionTest : AbstractFirContextCollectionTest() {
    override val configurator = AnalysisApiFirScriptTestConfigurator(analyseInDependentSession = false)
}
