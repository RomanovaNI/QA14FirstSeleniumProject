package com.telran.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest {
    //before - setUp(){}
    //Test
    //after - tearDown(){}

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
      // System.setProperty("webdriver.gecko.driver","/Users/natalia/Tools/geckodriver");
       // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public  void searchProductTest(){
        driver.findElement(By.name("search_query")).sendKeys("summer dresses"+ Keys.ENTER);
        String text = driver.findElement(By.className("lighter")).getText();
        Assert.assertEquals(text.toLowerCase(), "\"summer dresses\"");

    }
    @Test
    public void newsletterTest(){
        driver.findElement(By.id("newsletter-input")).sendKeys("loremA@mail.ru"+Keys.ENTER);
        String text=driver.findElement(By.className("alert alert-danger")).getText();
        Assert.assertEquals(text.toLowerCase(), " Newsletter : This email address is already registered.");
    }@Test
    public void tshirtTest(){
        driver.findElement(By.linkText("T-shirts")).click();

    }
    @AfterMethod(enabled = false)
    public void tearDown (){
        driver.quit();
    }
}
