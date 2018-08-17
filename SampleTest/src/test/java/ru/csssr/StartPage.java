package ru.csssr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//--- Page Objects ---
public class StartPage {

    private WebDriver driver;

    public StartPage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(String pageURL) {
        driver.get(pageURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public boolean openLayer(int lNumber){
        String sectLinkText = "";
        switch (lNumber){
            case 1: sectLinkText = "ВНИКАТЬ В ДЕТАЛИ ПРОЕКТОВ";   break;
            case 2: sectLinkText = "НАХОДИТЬ НЕСОВЕРШЕНСТВА";     break;
            case 3: sectLinkText = "СОПРОВОЖДАТЬ ПРОЕКТЫ";        break;
            case 4: sectLinkText = "РАБОТАТЬ С ФАЙЛАМИ ПРОЕКТОВ"; break;
        }

        WebElement sectLink = driver.findElement(By.linkText(sectLinkText));
        sectLink.click();
        WebElement layer = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div[" + lNumber + "]"));

        try{
            (new WebDriverWait(driver, 2)).until(ExpectedConditions.invisibilityOf(layer));
        }
        catch (Exception e){
            ;
        }

        return layer.isDisplayed();
    }


    public WebElement screenShotSoftLink(){
        return driver.findElement(By.linkText("Софт для быстрого создания скриншотов"));
    }
}
