package main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI;

import main.ui.actividadesEconomicasUI.commonUI.periodDetailTableUI.IPeriodDetailTable;
import org.openqa.selenium.By;

public class PeriodDetailTable implements IPeriodDetailTable {
    public static String xpathTable = "//*[@id='divGestiones']/table";
    public static String xpathRows = "//*[@id='divGestiones']/table//tr";
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
        return By.xpath(xpathRows + "[" + i + "]/td" + "[" + j + "]");
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
