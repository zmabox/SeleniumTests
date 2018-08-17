package ru.csssr;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SampleTest {

    public ChromeDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();  // Solution for max window for Chrom
        options.addArguments("--start-maximized");    // only on Windows
        driver = new ChromeDriver(options);
        System.out.println("setUp performed");
    }

    @After
    public void tearDown() {

        driver.quit();
        System.out.println("tearDown performed");
    }

    @Test
    public void linkTest() {
        System.out.println("The Link test started");
        String expURL = "http://monosnap.com/"; // URL expected
//        String expURL = "http://app.prntscr.com/ru/"; // just for checking test
        StartPage page = new StartPage(driver);
        page.openPage("http://blog.csssr.ru/qa-engineer/");
        page.openLayer(2);
        String realURL = page.screenShotSoftLink().getAttribute("href");
        System.out.println("Expected URL:" + expURL);
        System.out.println(" Current URL:" + realURL);
        Assert.assertTrue(realURL.equals(expURL));
    }

    @Test
    public void scndOpenLayer() {
        System.out.println("The Second Open Layer test started");
        StartPage page = new StartPage(driver);
        page.openPage("http://blog.csssr.ru/qa-engineer/");
        int invisLs = 0;
        for (int nL=1; nL<=4; nL++){
            page.openLayer(nL);
            // second click and checking for visibility
            boolean Vis = page.openLayer(nL);
            if (!Vis){invisLs++;}
            System.out.println("Layer №" + nL + " is visible: " + Vis);
        }
        Assert.assertEquals("Not visible layers are present.",0, invisLs);
    }
}
