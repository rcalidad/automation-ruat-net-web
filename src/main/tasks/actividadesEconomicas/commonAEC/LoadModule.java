package main.tasks.actividadesEconomicas.commonAEC;

import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.tasks.actividadesEconomicas.helpersAEC.ChangeFrame;
import main.tasks.actividadesEconomicas.menu.LeftMenu;
import main.tasks.actividadesEconomicas.menu.MainMenu;
import org.openqa.selenium.WebDriver;

public class LoadModule {
    public static void fromMainMenu(WebDriver driver, String grouper, String module){
        MainMenu.selectOption(driver, grouper);
        ChangeFrame.toLeftMenuFromParentFrame(driver);
        LeftMenu.goTo(driver, module);
        ChangeFrame.toContentFromAnotherFrame(driver);
    }
}
