package main.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DisplayAlert {
    public static void toAcept(WebDriver webDriver){
        webDriver.switchTo().alert().accept();
    }

    public static void cancel (WebDriver webDriver){
        webDriver.switchTo().alert().dismiss();
    }

    public static String getText (WebDriver webDriver){
        return webDriver.switchTo().alert().getText();
    }

}
