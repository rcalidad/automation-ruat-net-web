package main.tasks.vehiculos.commonVeh;

import main.actions.Click;
import main.actions.Scroll;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.commonUI.LeftMenuUI;
import org.openqa.selenium.WebDriver;

public class ReturnMainMenu {
    public static void fromAModule(WebDriver driver){
        driver.switchTo().parentFrame();
        driver.switchTo().frame(FramesUI.frameNameMenuLateral);
        Scroll.toEndPage(driver);
        Click.on(driver, LeftMenuUI.lnkMenuPrincipal);
        driver.switchTo().parentFrame();
    }
}
