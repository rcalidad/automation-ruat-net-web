/**A
 * @description Elementos HTML relacionados al menú principal del subsistema vehículos
 * @date 12/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.vehiculosUI.mainMenuUI;

import org.openqa.selenium.By;

public class MainMenuUI {
    public static By lnkProforma = By.linkText("Proforma");
    public static By lnkCerrarSesion = By.linkText("Cerrar Sesión");
    public static By option(String link){
        By optionLink = By.linkText(link);
        return optionLink;
    }
}
