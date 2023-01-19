package main.ui.vehiculosUI.compensacionesUI;

import main.ui.commonElementsUI.IDebtTable;
import org.openqa.selenium.By;

public class DetalleDeudasUI implements IDebtTable {
    public static By ttlDetallDeudas = By.xpath("//h2[text()='DETALLE DE DEUDAS']");
    public static String xpathDebtTable = "//h3[text()='Detalle Deudas Sujetas a Compensación(Bs)']/following-sibling::table";
    public static By debtTable = By.xpath(xpathDebtTable);
    public static String xpathRows = xpathDebtTable.concat("//tr");
    public static By debtTableRows = By.xpath(xpathRows);
    public static By btnProcesar = By.name("btnPagar");
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
