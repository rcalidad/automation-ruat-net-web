package main.ui.inmueblesUI.commonUI.interfacesUI;

import org.openqa.selenium.By;

public interface IPeriodTable {
    By getRows();
    By getHeader();
    By getColumns(int x);
    By getCell(int x, int y);
    By getPager();
}
