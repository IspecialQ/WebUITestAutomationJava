package org.example.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Bank Manager Login']")
    private WebElement bankManagerLoginButton;


    public BankManagerMenuPage clickBankManagerLoginButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(bankManagerLoginButton));
        bankManagerLoginButton.click();
        return new BankManagerMenuPage(driver);
    }

}
