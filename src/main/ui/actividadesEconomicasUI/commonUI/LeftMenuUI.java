/**A
 * @description Representaci�n de elementos HTML relacionados al men� izquierdo (elementos comunes).
 * @date 06/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.actividadesEconomicasUI.commonUI;

import org.openqa.selenium.By;

public class LeftMenuUI {
    public static By lnkConsultaContribuyente      = By.linkText("Consulta Contribuyentes");
    public static By lnkConsultaActividadEconomica = By.linkText("Consulta Actividad Econ�mica");
    public static By lnkProforma                   = By.linkText("Proforma");
    public static By lnkMenuPrincipal              = By.linkText("Men� Principal");

    public static By selectOptionByText(String text){
        return By.linkText(text);
    }
}
