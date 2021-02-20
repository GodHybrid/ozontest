package test.tesuto.Utility;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureListener extends AllureJunit4
{
    @Override
    public void testFailure(Failure failure)
    {
        saveScreenshot();
        super.testFailure(failure);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot()
    {
        return ((TakesScreenshot)Initialization.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
