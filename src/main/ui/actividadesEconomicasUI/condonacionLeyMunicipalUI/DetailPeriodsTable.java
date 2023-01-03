package main.ui.actividadesEconomicasUI.condonacionLeyMunicipalUI;

import main.ui.actividadesEconomicasUI.commonUI.periodDetailTableUI.IPeriodDetailTable;
import org.openqa.selenium.By;

public class DetailPeriodsTable implements IPeriodDetailTable {
    public static String xpathTable = "//div[@id='divGestiones']//table";
    public static By table = By.xpath(xpathTable);
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
        return By.xpath(xpathRows + "[" + i + "]/td" + "[" + j+ "]");
    }

    @Override
    public int getColumnOfYear() {
        return 1;
    }

    @Override
    public By getHeader() {
        return By.xpath(xpathRows + "[1]/th");
    }
}
