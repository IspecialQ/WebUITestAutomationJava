package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;


public class PageObjectTest {
    WebDriver driver;
    private final static String XYZ_BASE_URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    private final static String firstName = "Sirius";
    private final static String lastName = "Black";
    private final static String zipCode = String.valueOf(new Random().nextInt(5000));
    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        driver.get(XYZ_BASE_URL);
    }

    @Test
    void addCustomerTest() {
        new MainPage(driver).clickBankManagerLoginButton()
                .clickAddCustomerButton()
                .createCustomer(firstName, lastName, zipCode)
                .clickCustomersButton()
                .checkNewCustomer(zipCode);



    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

}
