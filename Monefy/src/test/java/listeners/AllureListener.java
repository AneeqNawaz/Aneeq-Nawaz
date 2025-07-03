package listeners;

import Base.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testInstance;
            takeScreenshotOnFailure(result.getMethod().getMethodName(), baseTest.getDriver());
        }
    }

    @Attachment(value = "Failure screenshot for {testMethod}", type = "image/png")
    public byte[] takeScreenshotOnFailure(String testMethod, org.openqa.selenium.WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // You can override other ITestListener methods if needed (e.g. onTestStart, onTestSkipped)
}
