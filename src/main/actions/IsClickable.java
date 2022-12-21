package main.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsClickable {
    public static final int     TIME_SECOND                = 3;
    public static boolean element(WebDriver webDriver, By locator){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, TIME_SECOND);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            return element.isEnabled();
        }catch (Exception exception){
            return false;
        }
    }
    public static boolean element(WebDriver webDriver, By locator, int time){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, time);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            return element.isEnabled();
        }catch (Exception exception){
            return false;
        }
    }
}
