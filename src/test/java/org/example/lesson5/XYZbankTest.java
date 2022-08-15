package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;



public class XYZbankTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

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
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get(XYZ_BASE_URL);
    }
    @BeforeEach
    void loginAsBankManager() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                (By.xpath("//button[text()='Bank Manager Login']"))));
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
    }


    @Test
    void addCustomerTest() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                (By.xpath("//button[contains(@ng-click,'add')]"))));
        driver.findElement(By.xpath("//button[contains(@ng-click,'add')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                (By.xpath("//input[contains(@placeholder,'First Name')]"))));
        driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys(lastName);
        int zipCode = new Random().nextInt(5000);//генерируем уникальный zip code
        driver.findElement(By.xpath("//input[contains(@placeholder,'Post Code')]")).sendKeys("E" + zipCode);
        driver.findElement(By.xpath("//button[text()='Add Customer']")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//button[contains(@ng-click,'show')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//td[.='E" + zipCode + "']"))));
        Assertions.assertEquals(driver.findElement(By.xpath("//td[.='E" + zipCode + "']")).getText(), "E" + zipCode);
        //я хотел сделать assert более логичным чем этот,
        // но привязать локатор к чему то кроме имени в данном случае будет еще более не логичным
    }

    @Test
    void openAccountTest() {
        addCustomerTest(); //пришлось вызвать тест в тесте, т.к. в данном сайте при обновлении страницы
        // пропадают все пользователи которых создаем , я сначала думал можно добавить куку,
        // но куки пустые, там как то в локальную память помещаются данные, вообщем сделал так
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                (By.xpath("//button[contains(@ng-click,'open')]"))));
        driver.findElement(By.xpath("//button[contains(@ng-click,'open')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((By.id("userSelect"))));
        driver.findElement(By.id("userSelect")).click();
        driver.findElement(By.xpath("//option[text()='" + firstName + " " + lastName + "']")).click();
        driver.findElement(By.id("currency")).click();
        driver.findElement(By.xpath("//option[@value='Dollar']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assertions.assertEquals(driver.switchTo().alert().getText().contains("Account created"),true);

    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
