package main.ui.commonElementsUI;

import org.openqa.selenium.By;

public interface IDebtTable {
    public By getRowsOfTable();
    public By getColumnsOfARow(int row);
    public By getCellOfTable(int i, int j);
    public int getColumnOfYear();
    public int getColumnOfDebt();
}
