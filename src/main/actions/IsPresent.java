package main.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsPresent {
    public static final int     TIME_SECOND                = 3;
    public static boolean elements(WebDriver webDriver, By locator){
        boolean isPresent = false;
        try{
            WebDriverWait wait = new WebDriverWait(webDriver,TIME_SECOND);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            //return webDriver.findElements(locator);
            isPresent = (webDriver.findElements(locator).size() > 0)? true: false;
            return isPresent;
        }catch (Exception e){
            //  e.printStackTrace();
            return isPresent;
        }
    }
}
