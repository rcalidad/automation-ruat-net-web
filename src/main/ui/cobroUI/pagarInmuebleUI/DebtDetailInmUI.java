package main.ui.cobroUI.pagarInmuebleUI;

import main.ui.commonElementsUI.IDebtTable;
import org.openqa.selenium.By;

public class DebtDetailInmUI implements IDebtTable {
    public static By ttlDetalleDeudas = By.xpath("//h2[text()='Detalle Deudas']");
    public static String xpathDatosDeuda = "//h3[text()='Datos Deudas (Bs.)']/following-sibling::table";
    public static By debtTable = By.xpath(xpathDatosDeuda);
    public static String xpathRows = xpathDatosDeuda.concat("//tr");
    public static By debtTableRows = By.xpath(xpathRows);
    public static By btnPagar = By.name("pagar");

    @Override
    public By getRowsOfTable() {
        return debtTableRows;
    }

    @Override
    public By getColumnsOfARow(int row) {
        return By.xpath(xpathRows + "[" + row + "]/td");
    }

    @Override
    public By getCellOfTable(int i, int j) {
        return By.xpath(xpathRows + "[" + i + "]/td[" + j + "]");
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
