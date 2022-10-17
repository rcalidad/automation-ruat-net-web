/**A
 * @description Generar inmuebles empadronados
 * @date 22/07/2022
 * @author Faustina Chambi Camata
 */

package main.ui.inmueblesUI.liquidacionUI;

import org.openqa.selenium.By;

public class ProformaUI {
    public static String pathTable        = "//*[@id='ventana']/form/table/tbody/tr";
    public static By pathTables           = By.xpath(pathTable);
    public static By btnDetallada         = By.name("btnDetallada");
    public static By btnResumida          = By.name("btnResumida");
    public static By pathFilasDatosDeudas =  null;
    public static By moverScroll          = By.xpath ( "td[1]" );
    public static By gestion              = By.xpath ( "td[1]" );
    public static By detalleDeuda         = By.xpath ( "td[2]" );
    public static By checkGestion         = By.xpath ( "td[6]" );
    public static By checkGestionTag      = By.tagName ( "input" );

    public static By getPathFilasDatosDeudas(String path) {
        pathFilasDatosDeudas =   By.xpath (path);
        return pathFilasDatosDeudas;
    }

}
