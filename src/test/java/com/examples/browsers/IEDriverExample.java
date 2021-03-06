package com.examples.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by janesh on 7/8/2015.
 */
public class IEDriverExample {


    private static   final String BASE_URL="http://opensource.demo.orangehrm.com/index.php/auth/login";
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void testIEDriver(){

        driver.get(BASE_URL);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin");
        driver.findElement(By.id("btnLogin")).click();
        Assert.assertEquals(driver.findElement(By.id("welcome")).getText(),"Welcome Admin");


    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
