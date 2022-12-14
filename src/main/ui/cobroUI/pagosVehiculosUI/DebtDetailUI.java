package main.ui.cobroUI.pagosVehiculosUI;

import main.ui.commonElementsUI.DebtTable;
import org.openqa.selenium.By;

public class DebtDetailUI implements DebtTable {
    public static By ttlDetalleDeDeudas = By.xpath("//h2[text()=' DETALLE DE DEUDAS']");
    public static By btnPagar = By.name("pagar");
    public static String xpathDebtTable = "//h3[text()='Deudas (en Bs.)']/following-sibling::table";
    public static String xpathDebtTableRows = xpathDebtTable.concat("//tr");
    public static By debtTableRows = By.xpath(xpathDebtTableRows);

    @Override
    public By getRowsOfTable() {
        return By.xpath(xpathDebtTableRows);
    }
    @Override
    public By getColumnsOfARow(int row){
        return By.xpath(xpathDebtTableRows + "[" + row + "]//td");
    }
    @Override
    public By getCellOfTable(int x, int y){
        return By.xpath(xpathDebtTableRows + "[" + x + "]/td[" + y + "]");
    }

    @Override
    public int getColumnOfYear() {
        return 1;
    }

    @Override
    public int getColumnOfDebt() {
        return 2;
    }

    public static By getColumns(int row){
        return By.xpath(xpathDebtTableRows + "[" + row + "]//td");
    }
    public static By getCell(int x, int y){
        return By.xpath(xpathDebtTableRows + "[" + x + "]/td[" + y + "]");
    }
}
