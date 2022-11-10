package main.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsChecked {
    public static boolean element(WebDriver driver, By locator){
        WebElement element = driver.findElement(locator);
        return element.isSelected();
    }
}
