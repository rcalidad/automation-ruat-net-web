package main.tasks.cobro.common;

import main.actions.Click;
import main.actions.IsDisplayed;
import main.ui.cobroUI.commonUI.CommonElementsUI;
import main.ui.cobroUI.commonUI.FramesUI;
import main.ui.cobroUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class ReturnMainMenu {
    public static void fromAModule(WebDriver driver){
        if(!IsDisplayed.element(driver, MainMenuUI.lnkCerrarSesion)){
            driver.switchTo().parentFrame();
            driver.switchTo().frame(FramesUI.frameNameMenuLateral);
            Click.on(driver, CommonElementsUI.btnHome);
            driver.switchTo().parentFrame();
        }
    }
}
