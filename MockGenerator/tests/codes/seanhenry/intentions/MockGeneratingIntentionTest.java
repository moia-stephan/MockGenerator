package codes.seanhenry.intentions;

import codes.seanhenry.testhelpers.ImportProjectTestCase;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;

import java.io.IOException;

public class MockGeneratingIntentionTest extends ImportProjectTestCase {

  @Override
  protected String getDataPath() {
    return "testData/TestProject";
  }

  @Override
  protected String getProjectFileName() {
    return "TestProject.xcodeproj";
  }

  public void testAll() throws Exception {
    String[] fileNames = {
      "SimpleProtocol",
      "OptionalProtocol",
      "OverloadProtocol",
      "PropertyProtocol",
      "ClosureProtocol",
      "RecursiveProtocol",
      "MultipleProtocol",
      "DeepInheritance",
      "DiamondInheritanceProtocol",
      "AssociatedTypeProtocol",
      "MultiAssociatedTypeProtocol",
//      "UIKitProtocol",
      "PublicProtocol",
      "OpenProtocol",
      "DefaultValues",
      "Keywords",

      "SimpleClass",
      "UnoverridableClass",
      "FinalClass",
      "InferredTypeClass",
      "PropertyClass",
      "ArgumentInitialiserClass",
      "RequiredInitialiserClass",
      "FailableInitialiserClass",
      "EmptyFailableInitialiserClass",
      "Superclass",
      "NSObjectClass",
      "InternalClass",
      "OpenClass",
      "PublicClass",
      "AvailableClass",

      "Delete",
      "ClassAndProtocol",
    };

    for (String fileName : fileNames) {
      runTest(fileName);
    }
    Assert.assertFalse(isIntentionAvailable("NotAvailableInProductionCodeTarget"));
  }

  private boolean isIntentionAvailable(String fileName) {
    configureFile(fileName + ".swift");
    return getFixture().filterAvailableIntentions("Generate mock").size() > 0;
  }

  private void runTest(String fileName) throws IOException {
    String expectedFileName = fileName + "Mock_expected.swift";
    String mockFileName = fileName + "Mock.swift";
    System.out.println("Running test for " + fileName);
    PsiFile targetFile = configureFile(mockFileName);
    invokeIntention("Generate mock", targetFile);
    assertFilesEqual(expectedFileName, mockFileName);
  }

  @NotNull
  private PsiFile configureFile(String mockFileName) {
    return getFixture().configureByFile(mockFileName);
  }
}
