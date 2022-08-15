package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddCustomerPage extends BasePage{
    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[contains(@placeholder,'First Name')]")
    private WebElement firstNmaeField;

    @FindBy(xpath = "//input[contains(@placeholder,'Last Name')]")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[contains(@placeholder,'Post Code')]")
    private WebElement zipCodeField;

    @FindBy(xpath = "//button[text()='Add Customer']")
    private WebElement addCustomerButton;

    public BankManagerMenuPage createCustomer(String firstName, String lastName, String zipCode) {
        webDriverWait.until(ExpectedConditions.visibilityOf(firstNmaeField));
        firstNmaeField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        zipCodeField.sendKeys(zipCode);
        addCustomerButton.click();
        driver.switchTo().alert().accept();
        return new BankManagerMenuPage(driver);
    }
}
