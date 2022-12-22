package main.tasks.actividadesEconomicas.menu;

import main.actions.Click;
import main.ui.actividadesEconomicasUI.commonUI.FramesUI;
import main.ui.actividadesEconomicasUI.commonUI.LeftMenuUI;
import org.openqa.selenium.WebDriver;

public class LeftMenu {
    public static void goTo(WebDriver driver, String module){
        Click.on(driver, LeftMenuUI.selectOptionByText(module));
    }
}
