package ru.csssr;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

    public ChromeDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("setUp performed");
    }

    @After
    public void tearDown() {

        driver.quit();
        System.out.println("tearDown performed");
    }

    @Test
    public void linkTest() {

        System.out.println("The test started");
        driver.get("http://blog.csssr.ru/qa-engineer/");

        String expURL = "http://monosnap.com/"; // URL expected
//        String expURL = "http://app.prntscr.com/ru/"; // just for checking test

        WebElement sectLink = driver.findElement(By.linkText("НАХОДИТЬ НЕСОВЕРШЕНСТВА"));
        sectLink.click();

        WebElement scrLink = driver.findElement(By.linkText("Софт для быстрого создания скриншотов"));
        String realURL = scrLink.getAttribute("href");

        System.out.println("Expected URL:" + expURL);
        System.out.println("Current URL:" + realURL);

        Assert.assertTrue(realURL.equals(expURL));

    }

}
