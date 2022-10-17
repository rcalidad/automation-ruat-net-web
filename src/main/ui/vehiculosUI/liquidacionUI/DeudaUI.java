/**A
 * @description Representación de elementos HTML relacionados a la tabla de deudas de un vehículo.
 * @date 12/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.vehiculosUI.liquidacionUI;

import org.openqa.selenium.By;

public class DeudaUI {
    public static String xpathTablaDeudas   = "//div[@id='ventana']//h3[contains(.,'Deudas')]/following-sibling::table";
    public static String xpathFila          = xpathTablaDeudas.concat("//tr");
    public static String xpathCabecera      = xpathTablaDeudas.concat("//tr[1]/*");
    public static By filas                  = By.xpath(xpathFila);
    public static By cabecera               = By.xpath(xpathCabecera);
    public static By btnProformaDetallada   = By.name("btnDetallada");
    public static By proformaResumidaButton = By.name("btnResumida");

    public static By getCell(int i, int j){
        return By.xpath(xpathFila + "[" + i + "]/td[" + j + "]");
    }
}
