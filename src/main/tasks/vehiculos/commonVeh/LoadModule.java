package main.tasks.vehiculos.commonVeh;

import main.actions.Click;
import main.actions.WaitUntilElement;
import main.ui.vehiculosUI.commonUI.LeftMenuUI;
import org.openqa.selenium.WebDriver;

public class LoadModule {
    public static void whichIs(WebDriver driver, String module){
        WaitUntilElement.isVisibleElement(driver, LeftMenuUI.getOption(module));
        Click.on(driver, LeftMenuUI.getOption(module));
    }
}
