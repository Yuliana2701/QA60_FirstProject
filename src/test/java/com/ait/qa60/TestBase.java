package com.ait.qa60;

import com.ait.qa60.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));
//@BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }
//@AfterMethod
    @AfterSuite
    public void tearDown() {
        app.stop();
    }
    @BeforeMethod
    public void startTest(Method method){
        logger.info("Start test" + method.getName());
    }
    @AfterMethod
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED:" +result.getMethod().getMethodName());
        }
        else {
            logger.error("FAILED:" +result.getMethod()
                    .getMethodName()+" Screenshot path:" +app.getUser()
                    .takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("======================================================");
    }

}

