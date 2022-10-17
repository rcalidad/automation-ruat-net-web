/**A
 * @description
 * @date 22/07/2022
 * @author Tina
 */

package main.ui.inmueblesUI.commonUI;

import org.openqa.selenium.By;

public class GeneratorExcelUI {
    public static By pathOpcionesSubsistema           = By.xpath("//*[@id='menu-lista']/ul/li");
    public static String stringPathOpcionesSubsistema = "//*[@id='menu-lista']/ul/li";
    public static By idIframePrincipal                = By.id("ifrm-contenido");
    public static By idVentanaModal                   = By.id("modal_window");
    public static By idMensajeModal                   = By.id("mensaje-modal");

    //--------------
    public static  By idLogoAplicativo                = By.id("logo-aplicacion");

    //-------------- buscar inmueble ----------
    public static By txtIdentificador                 = By.id("txtIdentificador");
    public static By rbtNumeroInmueble                = By.id("rbtCriterioNIM");
    public static By btnAceptar                       = By.id("btnAceptar");
    public static By pathTituloVista                  = By.xpath("//*[@id='ventana']/form/table/tbody/tr[1]/td/h2");
    public static By pathTituloVistaSinForm           = By.xpath("//*[@id='ventana']/form/table/tbody/tr[1]/td/h2".replaceAll ( "/form", "" ));

    //------------------------ obtener titulo vista -----------
    public static By pathVistaDatosCodCatastral       = By.xpath("/html/body/div[2]/form/table/tbody/tr[1]/td/div[1]/h2");


}
