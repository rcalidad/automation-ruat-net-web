package main.ui.actividadesEconomicasUI.commonUI.periodDetailTableUI;

import org.openqa.selenium.By;

public interface IPeriodDetailTable {
    By getRowsOfTable();
    By getColumnsOfARow(int row);
    By getCellOfTable(int i, int j);
    int getColumnOfYear();
    By getHeader();
}
