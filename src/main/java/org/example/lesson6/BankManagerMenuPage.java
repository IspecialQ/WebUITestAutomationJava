package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BankManagerMenuPage extends BasePage {
    public BankManagerMenuPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[contains(@ng-click,'add')]")
    private WebElement addCustomerButton;

    @FindBy(xpath = "//button[contains(@ng-click,'show')]")
    private WebElement customersButton;

    public AddCustomerPage clickAddCustomerButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addCustomerButton));
        addCustomerButton.click();
        return new AddCustomerPage(driver);
    }

    public CustomersPage clickCustomersButton() {
    customersButton.click();
    return new CustomersPage(driver);
    }
}
