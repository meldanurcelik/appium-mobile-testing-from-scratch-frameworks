package AppiumFramework.Resources;

import AppiumFramework.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // This method will execute before the main test start (@Test)
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // This method will execute only when the test is pass.
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // This method will execute only on the event of fail test.
        //screenshot
        String s = result.getName();
        try {
            Base.getScreenshot(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // This method will execute only if any of the main test(@Test) get skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(ITestContext context) {
        // This method will execute before starting of Test suite.
    }

    @Override
    public void onFinish(ITestContext context) {
        // This method will execute, Once the Test suite is finished.
    }

}