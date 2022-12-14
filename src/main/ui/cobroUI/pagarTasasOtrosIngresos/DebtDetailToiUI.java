package main.ui.cobroUI.pagarTasasOtrosIngresos;

import main.ui.commonElementsUI.DebtTable;
import org.openqa.selenium.By;

public class DebtDetailToiUI implements DebtTable {
    public static By ttlDetalleDeudas = By.xpath("//h2[text()='Detalle Deudas']");
    public static String xpathDebtTable = "//h3[text()='Datos Deuda (Bs.)']/following-sibling::table//table";
    public static By debtTable = By.xpath(xpathDebtTable);
    public static String xpathRows = xpathDebtTable.concat("//tr");
    public static By debtTableRows = By.xpath(xpathRows);
    public static By btnPagar = By.name("btnPagar");
    public static By btnPagarTOIM = By.name("pagar");
    public static By debtTableTOIM = By.xpath("//h3[text()='Datos Deuda (Bs.)']/following-sibling::table");
    public static By paginador = By.xpath("//*[text()='2']/parent::td/*");
    public static By paginadorSuperior = By.xpath("//h3[text()='Datos Deuda (Bs.)']/following-sibling::table/tbody/tr[2]/td/*");

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
    public static By getCell(int x, int y){
        return By.xpath(xpathRows + "[" + x + "]/td[" + y + "]");
    }

    @Override
    public int getColumnOfYear() {
        return 2;
    }

    @Override
    public int getColumnOfDebt() {
        return 3;
    }
}
