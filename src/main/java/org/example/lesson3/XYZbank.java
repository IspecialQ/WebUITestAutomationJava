package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class XYZbank {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[text()='Bank Manager Login']"))));
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[contains(@ng-click,'add')]"))));
        driver.findElement(By.xpath("//button[contains(@ng-click,'add')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[contains(@placeholder,'First Name')]"))));
        driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).sendKeys("Sirius");
        driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys("Black");
        int zipCode = new Random().nextInt(5000);//для проверки теста
        driver.findElement(By.xpath("//input[contains(@placeholder,'Post Code')]")).sendKeys("E" + zipCode);
        driver.findElement(By.xpath("//button[text()='Add Customer']")).click();

        driver.switchTo().alert().accept(); //Подсмотрел в интернете как решить с принятием алерта

        //Небольшая проверка теста на основе уникального ZIP кода
        driver.findElement(By.xpath("//button[contains(@ng-click,'show')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//td[.='E" + zipCode + "']"))));
        driver.findElement(By.xpath("//td[.='E" + zipCode + "']"));

        Thread.sleep(5000);
        driver.quit();




    }
}
