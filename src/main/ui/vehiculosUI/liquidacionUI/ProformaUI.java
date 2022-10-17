/**A
 * @description Elementos HTML relacionados al módulo Proforma del subsistema vehículos
 * @date 12/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.vehiculosUI.liquidacionUI;

import org.openqa.selenium.By;

public class ProformaUI {
    public static By lnkProformaVehiculo = By.linkText("Proforma Vehículo");
    public static By txtIdentificador = By.id("txtIdentificador");
    public static By rbtPlacaPta = By.id("PTA");
    public static By rbtPoliza = By.id("POL");
    public static By rbtPlacaAnterior = By.id("PANT");
    public static By rbtCopo = By.id("COPO");
    public static By btnBuscar = By.name("btnBuscar");
    public static By imgEnProgreso = By.id("fondo");
    public static By btnContinuar = By.id("btnContinuar");

}
