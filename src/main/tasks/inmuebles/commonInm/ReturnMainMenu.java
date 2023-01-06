package main.tasks.inmuebles.commonInm;

import main.actions.Click;
import main.actions.WaitUntilElement;
import main.tasks.inmuebles.helpersInm.ChangeFrame;
import main.ui.inmueblesUI.commonUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class ReturnMainMenu {
    public static void fromAModule(WebDriver driver){
        ChangeFrame.toParentFrame(driver);
        Click.on(driver, MainMenuUI.icoInmuebles);
        WaitUntilElement.isElementVisible(driver, MainMenuUI.icoInmuebles);
    }
}
