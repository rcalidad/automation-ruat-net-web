/**A
 * @description Tareas disponibles en el menú principal.
 * @date 06/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.tasks.actividadesEconomicas.mainMenu;

import main.actions.Click;
import main.ui.actividadesEconomicasUI.commonUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class MainMenu {
    public static void seleccionarProforma(WebDriver driver){
        Click.on(driver, MainMenuUI.lnkProforma);
    }
    public static void selectOption(WebDriver driver, String textLink){
        Click.on(driver, MainMenuUI.option(textLink));
    }
}
