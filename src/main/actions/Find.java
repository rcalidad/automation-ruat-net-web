package main.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Find {
    public static List<WebElement> elements(WebDriver webDriver, By locator) {
        List<WebElement> elements = null;
        try {
            elements = webDriver.findElements(locator);
            return elements;
        } catch (Exception e) {
            return elements;
        }
    }
}

