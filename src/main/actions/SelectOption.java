package main.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectOption {
    public static void byText(WebDriver driver, By locator, String option){
        WebDriverWait wait = new WebDriverWait(driver, 1);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select initialYear = new Select(element);
        initialYear.selectByVisibleText(option);
    }
    public static void byPartialtext(){}
}
