package main.tasks.cobro.common;

import main.actions.Click;
import main.actions.IsDisplayed;
import main.actions.WaitUntilElement;

import main.helpers.common.cobro.CobroOptions;
import main.ui.cobroUI.commonUI.FramesUI;
import main.ui.cobroUI.mainMenuUI.LeftMenuUI;
import main.ui.cobroUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class LoadModule {
    public static void whichIs(WebDriver driver, String subGrouper, String module){
        if(IsDisplayed.element(driver, LeftMenuUI.getOption(subGrouper))){
            Click.on(driver, LeftMenuUI.getOption(subGrouper));
            if(WaitUntilElement.isElementVisible(driver, LeftMenuUI.getOption(module))){
                Click.on(driver, LeftMenuUI.getOption(module));
            }
        }
    }
    public static void fromMainMenu(WebDriver driver, String subGrouper, String module){
        if(IsDisplayed.element(driver, MainMenuUI.lnkCerrarSesion)){
            MainMenu.selectOption(driver, CobroOptions.menu.get(module.toUpperCase()));
            driver.switchTo().frame(FramesUI.frameNameMenuLateral);
            whichIs(driver, subGrouper, module);
            driver.switchTo().parentFrame();
            driver.switchTo().frame(FramesUI.frameNameContenido);
        }
    }
}
