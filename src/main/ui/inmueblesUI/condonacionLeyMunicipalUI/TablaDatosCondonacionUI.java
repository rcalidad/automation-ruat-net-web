package main.ui.inmueblesUI.condonacionLeyMunicipalUI;

import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.By;

public class TablaDatosCondonacionUI implements IPeriodTable {
    public static String xpathTabla = "//h3[text()='Datos Condonación']/following-sibling::table[2]";
    public static String xpathRows = xpathTabla + "/tbody/tr";
    @Override
    public By getRows() {
        return By.xpath(xpathRows);
    }

    @Override
    public By getHeader() {
        return By.xpath(xpathRows + "[1]/*");
    }

    @Override
    public By getColumns(int x) {
        return By.xpath(xpathRows + "[" + x + "]/td");
    }

    @Override
    public By getCell(int x, int y) {
        return By.xpath(xpathRows + "[" + x + "]/td[" + y + "]");
    }

    @Override
    public By getPager() {
        return null;
    }
}
