package main.ui.inmueblesUI.compensacionesUI;

import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.By;

public class TablaDetalleSujetosPasivosUI implements IPeriodTable {
    public static String xpathTable = "//h3[text()='Datos Sujetos Pasivos Inmueble']/following-sibling::table";
    public static By TablaDatosSujetosPasivosInmuebles = By.xpath(xpathTable);
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
