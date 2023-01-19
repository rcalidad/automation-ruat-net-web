package main.ui.inmueblesUI.compensacionesUI;

import main.ui.commonElementsUI.IDebtTable;
import org.openqa.selenium.By;

public class TablaDatosDeudaUI implements IDebtTable {
    public static String xpathTable = "//h3[text()='Datos Deudas']/following-sibling::table";
    public static String xpathRows = xpathTable + "/tbody/tr";

    @Override
    public By getRowsOfTable() {
        return By.xpath(xpathRows);
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
