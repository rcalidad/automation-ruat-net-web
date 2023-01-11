package main.ui.inmueblesUI.autoavaluosUI;

import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.By;

public class PeriodDetailTable implements IPeriodTable {
    public static By pager = By.xpath("//*[text()='2']/parent::td/*");
    public static String xpathTable = "//h3[text()='Detalle Gestiones']/following-sibling::table/tbody/tr//table";
    public static String xpathRows = xpathTable + "/tbody/tr";
    public static By table = By.xpath(xpathTable);

    @Override
    public By getRows() {
        return By.xpath(xpathRows);
    }

    @Override
    public By getHeader() {
        return By.xpath(xpathRows + "[1]/th");
    }

    @Override
    public By getColumns(int x) { //x >= 2
        return By.xpath(xpathRows + "[" + x + "]/td");
    }

    @Override
    public By getCell(int x, int y) {
        return By.xpath(xpathRows + "[" + x + "]/td[" + y + "]");
    }

    @Override
    public By getPager() {
        return pager;
    }
}
