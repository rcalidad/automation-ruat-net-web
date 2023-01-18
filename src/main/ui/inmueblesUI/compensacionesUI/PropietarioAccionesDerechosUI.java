package main.ui.inmueblesUI.compensacionesUI;

import org.openqa.selenium.By;

public class PropietarioAccionesDerechosUI {
    public static String xpathTable = "//h3[text()='Resultados']/following-sibling::table//table";
    public static String xpathRows = xpathTable + "/tbody/tr";
    public static By tablaPropietarios = By.xpath(xpathTable);

    public static By getRows(){
        return By.xpath(xpathRows);
    }
    public static By getColumns(int row){
        return By.xpath(xpathRows + "[" + row + "]/td");
    }
    public static By getCell(int x, int y){
        return By.xpath(xpathRows + "[" + x + "]/td[" + y + "]");
    }
}
