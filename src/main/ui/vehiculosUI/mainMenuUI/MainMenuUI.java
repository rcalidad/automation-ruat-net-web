/**A
 * @description Elementos HTML relacionados al men� principal del subsistema veh�culos
 * @date 12/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.vehiculosUI.mainMenuUI;

import org.openqa.selenium.By;

public class MainMenuUI {
    public static By lnkProforma = By.linkText("Proforma");
    public static By lnkCerrarSesion = By.linkText("Cerrar Sesi�n");
    public static By option(String link){
        By optionLink = By.linkText(link);
        return optionLink;
    }
}
