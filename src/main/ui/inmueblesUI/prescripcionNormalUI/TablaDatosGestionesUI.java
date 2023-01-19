package main.ui.inmueblesUI.prescripcionNormalUI;

import main.ui.commonElementsUI.IDebtTable;
import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.By;

public class TablaDatosGestionesUI implements IPeriodTable {
    public static String xpathTable = "//h3[text()='Detalle Gestiones']/following-sibling::table";
    public static String xpathRows = xpathTable + "/tbody/tr";

    @Override
    public By getRows() {
        return By.xpath(xpathRows);
    }

    @Override
    public By getHeader() {
        return By.xpath(xpathRows + "[1]/th");
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
