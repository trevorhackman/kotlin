/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.dataFlowInfoProvider;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.fir.test.configurators.AnalysisApiFirTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.dataFlowInfoProvider.AbstractExitPointSnapshotTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeDependentAnalysisSourceModuleExitPointSnapshotTestGenerated extends AbstractExitPointSnapshotTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Dependent,
        AnalysisApiMode.Ide
      )
    );
  }

  @Test
  public void testAllFilesPresentInExitPointSnapshot() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow")
  @TestDataPath("$PROJECT_ROOT")
  public class ControlFlow {
    @Test
    public void testAllFilesPresentInControlFlow() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("breakContinue.kt")
    public void testBreakContinue() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/breakContinue.kt");
    }

    @Test
    @TestMetadata("breakContinue2.kt")
    public void testBreakContinue2() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/breakContinue2.kt");
    }

    @Test
    @TestMetadata("breakReturn.kt")
    public void testBreakReturn() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/breakReturn.kt");
    }

    @Test
    @TestMetadata("breakReturn2.kt")
    public void testBreakReturn2() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/breakReturn2.kt");
    }

    @Test
    @TestMetadata("continueReturn.kt")
    public void testContinueReturn() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/continueReturn.kt");
    }

    @Test
    @TestMetadata("continueReturn2.kt")
    public void testContinueReturn2() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/continueReturn2.kt");
    }

    @Test
    @TestMetadata("defaultTryCatch.kt")
    public void testDefaultTryCatch() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/defaultTryCatch.kt");
    }

    @Test
    @TestMetadata("defaultTryCatch2.kt")
    public void testDefaultTryCatch2() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/defaultTryCatch2.kt");
    }

    @Test
    @TestMetadata("nonLocalReturnFromNestedInline.kt")
    public void testNonLocalReturnFromNestedInline() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/nonLocalReturnFromNestedInline.kt");
    }

    @Test
    @TestMetadata("parenthesis.kt")
    public void testParenthesis() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/parenthesis.kt");
    }

    @Nested
    @TestMetadata("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/conditionalJumps")
    @TestDataPath("$PROJECT_ROOT")
    public class ConditionalJumps {
      @Test
      public void testAllFilesPresentInConditionalJumps() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/conditionalJumps"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("break.kt")
      public void testBreak() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/conditionalJumps/break.kt");
      }

      @Test
      @TestMetadata("break2.kt")
      public void testBreak2() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/conditionalJumps/break2.kt");
      }

      @Test
      @TestMetadata("break3.kt")
      public void testBreak3() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/conditionalJumps/break3.kt");
      }

      @Test
      @TestMetadata("break4.kt")
      public void testBreak4() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/conditionalJumps/break4.kt");
      }

      @Test
      @TestMetadata("break5.kt")
      public void testBreak5() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/conditionalJumps/break5.kt");
      }

      @Test
      @TestMetadata("return.kt")
      public void testReturn() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/conditionalJumps/return.kt");
      }

      @Test
      @TestMetadata("return2.kt")
      public void testReturn2() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/conditionalJumps/return2.kt");
      }

      @Test
      @TestMetadata("return3.kt")
      public void testReturn3() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/conditionalJumps/return3.kt");
      }
    }

    @Nested
    @TestMetadata("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/definiteJumps")
    @TestDataPath("$PROJECT_ROOT")
    public class DefiniteJumps {
      @Test
      public void testAllFilesPresentInDefiniteJumps() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/definiteJumps"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("return.kt")
      public void testReturn() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/definiteJumps/return.kt");
      }

      @Test
      @TestMetadata("return2.kt")
      public void testReturn2() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/definiteJumps/return2.kt");
      }

      @Test
      @TestMetadata("return3.kt")
      public void testReturn3() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/definiteJumps/return3.kt");
      }

      @Test
      @TestMetadata("return4.kt")
      public void testReturn4() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/definiteJumps/return4.kt");
      }
    }

    @Nested
    @TestMetadata("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/differentTargets")
    @TestDataPath("$PROJECT_ROOT")
    public class DifferentTargets {
      @Test
      public void testAllFilesPresentInDifferentTargets() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/differentTargets"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("break.kt")
      public void testBreak() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/differentTargets/break.kt");
      }

      @Test
      @TestMetadata("return.kt")
      public void testReturn() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/differentTargets/return.kt");
      }
    }

    @Nested
    @TestMetadata("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence")
    @TestDataPath("$PROJECT_ROOT")
    public class ExitPointEquivalence {
      @Test
      public void testAllFilesPresentInExitPointEquivalence() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("breakAndReturn.kt")
      public void testBreakAndReturn() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence/breakAndReturn.kt");
      }

      @Test
      @TestMetadata("breakAndReturn2.kt")
      public void testBreakAndReturn2() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence/breakAndReturn2.kt");
      }

      @Test
      @TestMetadata("breakContinueAndDefault.kt")
      public void testBreakContinueAndDefault() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence/breakContinueAndDefault.kt");
      }

      @Test
      @TestMetadata("continueAndReturn.kt")
      public void testContinueAndReturn() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence/continueAndReturn.kt");
      }

      @Test
      @TestMetadata("defaultAndBreak.kt")
      public void testDefaultAndBreak() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence/defaultAndBreak.kt");
      }

      @Test
      @TestMetadata("defaultAndContinue.kt")
      public void testDefaultAndContinue() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence/defaultAndContinue.kt");
      }

      @Test
      @TestMetadata("defaultAndReturn.kt")
      public void testDefaultAndReturn() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence/defaultAndReturn.kt");
      }

      @Test
      @TestMetadata("defaultAndReturnInWhen.kt")
      public void testDefaultAndReturnInWhen() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence/defaultAndReturnInWhen.kt");
      }

      @Test
      @TestMetadata("defaultAndReturnInWhen2.kt")
      public void testDefaultAndReturnInWhen2() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence/defaultAndReturnInWhen2.kt");
      }

      @Test
      @TestMetadata("multipleBreaks.kt")
      public void testMultipleBreaks() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/exitPointEquivalence/multipleBreaks.kt");
      }
    }

    @Nested
    @TestMetadata("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/unconditionalJumps")
    @TestDataPath("$PROJECT_ROOT")
    public class UnconditionalJumps {
      @Test
      public void testAllFilesPresentInUnconditionalJumps() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/unconditionalJumps"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("break.kt")
      public void testBreak() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/unconditionalJumps/break.kt");
      }

      @Test
      @TestMetadata("break2.kt")
      public void testBreak2() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/unconditionalJumps/break2.kt");
      }

      @Test
      @TestMetadata("break3.kt")
      public void testBreak3() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/unconditionalJumps/break3.kt");
      }

      @Test
      @TestMetadata("break4.kt")
      public void testBreak4() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/unconditionalJumps/break4.kt");
      }

      @Test
      @TestMetadata("nonLocalReturn.kt")
      public void testNonLocalReturn() {
        runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/controlFlow/unconditionalJumps/nonLocalReturn.kt");
      }
    }
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues")
  @TestDataPath("$PROJECT_ROOT")
  public class DefaultValues {
    @Test
    public void testAllFilesPresentInDefaultValues() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("annotationInfixOperatorProperty.kt")
    public void testAnnotationInfixOperatorProperty() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/annotationInfixOperatorProperty.kt");
    }

    @Test
    @TestMetadata("annotationValueCode.kt")
    public void testAnnotationValueCode() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/annotationValueCode.kt");
    }

    @Test
    @TestMetadata("anonymousFunction.kt")
    public void testAnonymousFunction() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/anonymousFunction.kt");
    }

    @Test
    @TestMetadata("anonymousObject.kt")
    public void testAnonymousObject() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/anonymousObject.kt");
    }

    @Test
    @TestMetadata("assignmentTarget.kt")
    public void testAssignmentTarget() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/assignmentTarget.kt");
    }

    @Test
    @TestMetadata("assignmentValue.kt")
    public void testAssignmentValue() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/assignmentValue.kt");
    }

    @Test
    @TestMetadata("calleeExpression.kt")
    public void testCalleeExpression() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/calleeExpression.kt");
    }

    @Test
    @TestMetadata("conditionCheck.kt")
    public void testConditionCheck() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/conditionCheck.kt");
    }

    @Test
    @TestMetadata("errorDefaultType.kt")
    public void testErrorDefaultType() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/errorDefaultType.kt");
    }

    @Test
    @TestMetadata("expressionBlock.kt")
    public void testExpressionBlock() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/expressionBlock.kt");
    }

    @Test
    @TestMetadata("flexibleDefaultType.kt")
    public void testFlexibleDefaultType() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/flexibleDefaultType.kt");
    }

    @Test
    @TestMetadata("functionBodyBlock.kt")
    public void testFunctionBodyBlock() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/functionBodyBlock.kt");
    }

    @Test
    @TestMetadata("functionCall.kt")
    public void testFunctionCall() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/functionCall.kt");
    }

    @Test
    @TestMetadata("incrementPostfix.kt")
    public void testIncrementPostfix() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/incrementPostfix.kt");
    }

    @Test
    @TestMetadata("infixOperator.kt")
    public void testInfixOperator() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/infixOperator.kt");
    }

    @Test
    @TestMetadata("infixOperatorProperty.kt")
    public void testInfixOperatorProperty() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/infixOperatorProperty.kt");
    }

    @Test
    @TestMetadata("infixOperatorVariable.kt")
    public void testInfixOperatorVariable() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/infixOperatorVariable.kt");
    }

    @Test
    @TestMetadata("lambdaExpression.kt")
    public void testLambdaExpression() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/lambdaExpression.kt");
    }

    @Test
    @TestMetadata("lambdaImplicitReturn.kt")
    public void testLambdaImplicitReturn() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/lambdaImplicitReturn.kt");
    }

    @Test
    @TestMetadata("nullableDefaultType.kt")
    public void testNullableDefaultType() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/nullableDefaultType.kt");
    }

    @Test
    @TestMetadata("objectQualifier.kt")
    public void testObjectQualifier() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/objectQualifier.kt");
    }

    @Test
    @TestMetadata("packageQualifier.kt")
    public void testPackageQualifier() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/packageQualifier.kt");
    }

    @Test
    @TestMetadata("singleTypedExpression.kt")
    public void testSingleTypedExpression() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/singleTypedExpression.kt");
    }

    @Test
    @TestMetadata("suspendFunctionCall.kt")
    public void testSuspendFunctionCall() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/suspendFunctionCall.kt");
    }

    @Test
    @TestMetadata("typeQualifier.kt")
    public void testTypeQualifier() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/typeQualifier.kt");
    }

    @Test
    @TestMetadata("variableDeclaration.kt")
    public void testVariableDeclaration() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/variableDeclaration.kt");
    }

    @Test
    @TestMetadata("whenCondition.kt")
    public void testWhenCondition() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/whenCondition.kt");
    }

    @Test
    @TestMetadata("while.kt")
    public void testWhile() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/defaultValues/while.kt");
    }
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/languageConstructs")
  @TestDataPath("$PROJECT_ROOT")
  public class LanguageConstructs {
    @Test
    public void testAllFilesPresentInLanguageConstructs() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/languageConstructs"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("arrayLiteral.kt")
    public void testArrayLiteral() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/languageConstructs/arrayLiteral.kt");
    }

    @Test
    @TestMetadata("labeledReturn.kt")
    public void testLabeledReturn() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/languageConstructs/labeledReturn.kt");
    }

    @Test
    @TestMetadata("nonLocalReturn.kt")
    public void testNonLocalReturn() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/languageConstructs/nonLocalReturn.kt");
    }

    @Test
    @TestMetadata("nonLocalReturn2.kt")
    public void testNonLocalReturn2() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/languageConstructs/nonLocalReturn2.kt");
    }

    @Test
    @TestMetadata("parameter.kt")
    public void testParameter() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/languageConstructs/parameter.kt");
    }

    @Test
    @TestMetadata("parameterDefaultValue.kt")
    public void testParameterDefaultValue() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/languageConstructs/parameterDefaultValue.kt");
    }

    @Test
    @TestMetadata("return.kt")
    public void testReturn() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/languageConstructs/return.kt");
    }

    @Test
    @TestMetadata("trailingSemicolon.kt")
    public void testTrailingSemicolon() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/languageConstructs/trailingSemicolon.kt");
    }
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables")
  @TestDataPath("$PROJECT_ROOT")
  public class Variables {
    @Test
    public void testAllFilesPresentInVariables() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("arrayElementAugmentedReassignment.kt")
    public void testArrayElementAugmentedReassignment() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/arrayElementAugmentedReassignment.kt");
    }

    @Test
    @TestMetadata("arrayElementIncrementPostfix.kt")
    public void testArrayElementIncrementPostfix() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/arrayElementIncrementPostfix.kt");
    }

    @Test
    @TestMetadata("arrayElementIncrementPrefix.kt")
    public void testArrayElementIncrementPrefix() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/arrayElementIncrementPrefix.kt");
    }

    @Test
    @TestMetadata("augmentedReassignment.kt")
    public void testAugmentedReassignment() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/augmentedReassignment.kt");
    }

    @Test
    @TestMetadata("classPropertyReassignment.kt")
    public void testClassPropertyReassignment() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/classPropertyReassignment.kt");
    }

    @Test
    @TestMetadata("conditionalReassignment.kt")
    public void testConditionalReassignment() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/conditionalReassignment.kt");
    }

    @Test
    @TestMetadata("destructuredReassignment.kt")
    public void testDestructuredReassignment() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/destructuredReassignment.kt");
    }

    @Test
    @TestMetadata("errorTargetReassignment.kt")
    public void testErrorTargetReassignment() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/errorTargetReassignment.kt");
    }

    @Test
    @TestMetadata("incrementPostfix.kt")
    public void testIncrementPostfix() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/incrementPostfix.kt");
    }

    @Test
    @TestMetadata("incrementPrefix.kt")
    public void testIncrementPrefix() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/incrementPrefix.kt");
    }

    @Test
    @TestMetadata("lambdaParameterReassignment.kt")
    public void testLambdaParameterReassignment() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/lambdaParameterReassignment.kt");
    }

    @Test
    @TestMetadata("localVariable.kt")
    public void testLocalVariable() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/localVariable.kt");
    }

    @Test
    @TestMetadata("parameterReassignment.kt")
    public void testParameterReassignment() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/parameterReassignment.kt");
    }

    @Test
    @TestMetadata("simpleReassignment.kt")
    public void testSimpleReassignment() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/simpleReassignment.kt");
    }

    @Test
    @TestMetadata("topLevelPropertyReassignment.kt")
    public void testTopLevelPropertyReassignment() {
      runTest("analysis/analysis-api/testData/components/dataFlowInfoProvider/exitPointSnapshot/variables/topLevelPropertyReassignment.kt");
    }
  }
}
