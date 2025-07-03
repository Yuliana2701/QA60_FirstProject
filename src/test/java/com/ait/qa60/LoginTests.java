package com.ait.qa60;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTests extends com.ait.qa60.TestBase {

    @Test(priority = 1)
    public void loginPositiveTest() {
        app.getUser().login("yulia27@gmail.com", "Yuliana123!");

        Assert.assertTrue(app.getUser().isLoggedIn(), "User should be logged in");
    }

}



