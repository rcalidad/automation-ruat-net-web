package main.ui.cobroUI.mainMenuUI;

import org.openqa.selenium.By;

public class MainMenuUI {
    public static By lnkCerrarSesion = By.linkText("Cerrar sesión");

    public static By getGrouper(String grouper){
        return By.linkText(grouper);
    }
}
