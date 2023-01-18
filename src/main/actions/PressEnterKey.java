package main.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PressEnterKey {
    public static final int     TIME_SECOND                = 5;
    public static void now(WebDriver webDriver, By localizador){
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_SECOND);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
        //element.clear();
        element.sendKeys(Keys.ENTER);

    }
}
