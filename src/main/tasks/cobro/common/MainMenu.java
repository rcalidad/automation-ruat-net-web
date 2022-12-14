package main.tasks.cobro.common;

import main.actions.Click;
import main.actions.WaitUntilElement;

import main.ui.cobroUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class MainMenu {
    public static void selectOption(WebDriver driver, String textLink){
        WaitUntilElement.isVisibleElement(driver, MainMenuUI.lnkCerrarSesion, 2);
        Click.on(driver, MainMenuUI.getGrouper(textLink));
    }
}
