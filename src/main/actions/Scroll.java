package main.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll {
    public static void toElement(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String script = "arguments[0].scrollIntoView(true);";
        javascriptExecutor.executeScript(script, element);
    }
    public static void toElement(WebDriver driver, By locator){
        WebElement element = driver.findElement(locator);
        toElement(driver, element);
    }
    public static void toElementOnTheMiddle(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String script = "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});";
        javascriptExecutor.executeScript(script, element);
    }
    public static void toEndPage(WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        javascriptExecutor.executeScript(script);
    }
    public static void toTopPage(WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String script = "window.scrollTo(document.body.scrollHeight, 0)";
        javascriptExecutor.executeScript(script);
    }
}
