package com.ait.qa60.fw;

import com.ait.qa60.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void openLoginForm() {
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("Email"), email);
        type(By.name("Password"), password);
    }

    public void submitLogin() {
        click(By.xpath("//input[@value='Log in']"));
    }

    public void login(String email, String password) {
        openLoginForm();
        fillLoginForm(email, password);
        submitLogin();
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.xpath("//a[text()='Log out']"));
    }

    public void openRegistrationForm() {
        click(By.cssSelector("a[href='/register']"));
    }

    public void fillRegistrationForm(User user) {
        if (user.getGender().equalsIgnoreCase("female")) {
            click(By.id("gender-female"));
        } else {
            click(By.id("gender-male"));
        }
        type(By.id("FirstName"), user.getFirstName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getPassword());
    }

    public void submitRegistration() {
        click(By.xpath("//input[@value='Register']"));
    }

    public void register(User user) {
        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
    }
}

