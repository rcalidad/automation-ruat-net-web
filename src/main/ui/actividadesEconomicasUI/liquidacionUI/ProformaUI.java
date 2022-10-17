/**A
 * @description Representación de elementos HTML relacionados a la liquidación de Actividades Económicas empadronadas
 * @date 06/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.actividadesEconomicasUI.liquidacionUI;

import org.openqa.selenium.By;

public class ProformaUI {
    public static By lnkProforma        = By.linkText("Proforma");
    public static By txtIdentificador   = By.id("txtIdentificador");
    public static By rbtNumeroLicencia  = By.id("NRO_LICENCIA");
    public static By rbtNumeroActividad = By.id("ID_ACTIVIDAD");
    public static By btnBuscar          = By.name("btnBuscar");
    public static By btnContinuar       = By.id("btnContinuar");
    public static By imgEnProgreso      = By.id("fondo");
    //div[@id='fondo']/strong[contains(.,'En progreso')]


}
