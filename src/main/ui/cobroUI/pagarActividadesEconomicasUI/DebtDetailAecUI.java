package main.ui.cobroUI.pagarActividadesEconomicasUI;

import main.ui.commonElementsUI.IDebtTable;
import org.openqa.selenium.By;

public class DebtDetailAecUI implements IDebtTable {
    public static By ttlDetallDeudas = By.xpath("//form[@id='frmRegistrar']/table/tbody/tr/td/h2");
    public static String xpathDebtTable = "//h3[text()='Deudas (en Bs)']/following-sibling::table";
    public static By debtTable = By.xpath(xpathDebtTable);
    public static String xpathRows = xpathDebtTable.concat("//tr");
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
