/**A
 * @description
 * @date 22/07/2022
 * @author
 */

package main.ui.inmueblesUI.commonUI;

import org.openqa.selenium.By;

public class BusquedaInmuebleUI {
    public static By ttlBusquedaInmueble = By.xpath("//h2[normalize-space()='BUSQUEDA INMUEBLE']");
    public static By txtIdentificador = By.id("txtIdentificador");
    public static By rbtNumeroInmueble = By.id("rbtCriterioNIM");
    public static By rbtCodigoCatastral = By.id("rbtCriterioCAT");
    public static By btnBuscar = By.id("btnAceptar");
}
