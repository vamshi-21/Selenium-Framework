package com.vamtester.pageobjects;

import io.reactivex.rxjava3.annotations.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="submit")
    private WebElement submitBtn;




    public void login(String username, String password)
    {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        submitBtn.click();
    }

    public LoginPage(@NonNull WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }



}
