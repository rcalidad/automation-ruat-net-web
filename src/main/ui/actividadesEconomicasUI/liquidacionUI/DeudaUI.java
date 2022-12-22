/**A
 * @description Representación de elementos HTML relacionados a la tabla de deudas de una Actividad Económica
 * @date 06/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.actividadesEconomicasUI.liquidacionUI;

import main.ui.commonElementsUI.DebtTable;
import org.openqa.selenium.By;

public class DeudaUI implements DebtTable {
    public static By ttlDetalleDeudas = By.xpath("//h2[text()='Detalle Deudas']");
    public static String xpathTablaDeudas   = "//form[@id='frmProforma']//h3[contains(.,'Deudas (Bs)')]/following-sibling::table";
    public static String xpathFila          = xpathTablaDeudas.concat("//tr");
    public static String xpathCabecera      = xpathTablaDeudas.concat("//tr[1]/*");
    public static By filas                  = By.xpath(xpathFila);
    public static By cabecera               = By.xpath(xpathCabecera);
    public static By btnProformaDetallada   = By.name("btnDetallada");
    public static By proformaResumidaButton = By.name("btnResumida");

    public static By getCell(int i, int j){
        return By.xpath(xpathFila + "[" + i + "]/td[" + j + "]");
    }

    @Override
    public By getRowsOfTable() {
        return By.xpath(xpathFila);
    }

    @Override
    public By getColumnsOfARow(int row) {
        return By.xpath(xpathFila + "[" + row + "]/td");
    }

    @Override
    public By getCellOfTable(int i, int j) {
        return By.xpath(xpathFila + "[" + i + "]/td[" + j + "]");
    }

    @Override
    public int getColumnOfYear() {
        return 1;
    }

    @Override
    public int getColumnOfDebt() {
        return 2;
    }
}
