package main.tasks.vehiculos.mainMenu;

import main.actions.Click;

import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class MainMenu {
    public static void selectOption(WebDriver driver, String textLink){
        Click.on(driver, MainMenuUI.option(textLink));
    }
}
