package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class CustomersPage extends BasePage{
    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    void checkNewCustomer(String zipCode) {
        WebElement zipCodeElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//td[@class='ng-binding' and (contains(text(),'" + zipCode + "'))]")));
        Assertions.assertTrue(zipCodeElement.isDisplayed());
        //xpath в ассерте не убирал, так как в локаторе необходима переменная
    }
}
