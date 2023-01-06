package main.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SelectOption {
    public static void byText(WebDriver driver, By locator, String option){
        WebDriverWait wait = new WebDriverWait(driver, 1);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select list = new Select(element);
        list.selectByVisibleText(option);
    }
    public static boolean waitUntilLoadOptions(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select lstElement = new Select(element);
        List<WebElement> options = new ArrayList<>();
        int time = 0;
        while(options.isEmpty() && time < 4){
            options = lstElement.getOptions();
            try{
                Thread.sleep(500);
                time ++;
            }catch (Exception exception){}
        }
        return !options.isEmpty();
    }
    public static void firstOption(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select lstElement = new Select(element);
        lstElement.selectByIndex(1);
    }
    public static void firstOptionDifferentOfEmpty(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select lstElement = new Select(element);
        List<WebElement> optionList = lstElement.getOptions();
        for (WebElement option: optionList) {
            if(!option.getText().equals("")){
                lstElement.selectByVisibleText(option.getText());
                break;
            }
        }
    }

    public static void nonEmptyRandomValue(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select lstElement = new Select(element);
        List<WebElement> optionList = lstElement.getOptions();
        int size = optionList.size();
        int index = getRandomNumber(0, size - 1);
        while (optionList.get(index).getText().equals("")){
            index = getRandomNumber(0, size - 1);
        }
        lstElement.selectByIndex(index);
    }

    public static int getRandomNumber(int initialValue, int finalValue){
        int randomNumber = (int)(Math.random() * ((finalValue - initialValue) + 1))  + initialValue;
        return randomNumber;
    }
    public static void byPartialtext(){}
}
