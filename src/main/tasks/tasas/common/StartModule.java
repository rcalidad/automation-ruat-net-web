package main.tasks.tasas.common;

import main.actions.Click;
import main.actions.IsDisplayed;
import main.actions.WaitUntilElement;
import main.ui.tasasOtrosIngresosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StartModule {
    public static void getIntoModule(WebDriver driver, String grouper, String subGrouper, String module){
        //WaitUntilElement.isVisibleElement(driver, MainMenuUI.getOption(grouper));
        WaitUntilElement.isVisibleElement(driver, MainMenuUI.divMainMenu);
        List<WebElement> optionsMainMenu = driver.findElements(MainMenuUI.allLinkMainMenu);
        boolean flag = false;
        int positionModule = -1;
        for (WebElement element: optionsMainMenu) {
            String text = element.getText();
            if (text.equals(module)){
                positionModule = optionsMainMenu.indexOf(element);
                break;
            }
        }
        if (positionModule != -1){
            while (!flag){
                if (!IsDisplayed.element(driver, MainMenuUI.getOption(module))){
                    for (int i = positionModule - 1; i >= 0; i = i - 1){
                        if (optionsMainMenu.get(i).isDisplayed()){
                            optionsMainMenu.get(i).click();
                            break;
                        }
                    }
                }else {
                    Click.on(driver, MainMenuUI.getOption(module));
                    flag = true;
                }
            }
        }
    }

    public static void clickOnHiddenElement(WebDriver driver, String module){
        JavascriptExecutor jscriptExecutor = (JavascriptExecutor) driver;
        WebElement hiddenElement = driver.findElement(MainMenuUI.getOption(module));
        String script = "arguments[0].click();";
        jscriptExecutor.executeScript(script, hiddenElement);
    }

    public static void loadProforma(WebDriver driver, String option){
        WaitUntilElement.isVisibleElement(driver, MainMenuUI.lnkLiquidacion);
        Click.on(driver, MainMenuUI.lnkLiquidacion);
        WaitUntilElement.isVisibleElement(driver, MainMenuUI.getOption(option));
        Click.on(driver, MainMenuUI.getOption(option));
    }
}
