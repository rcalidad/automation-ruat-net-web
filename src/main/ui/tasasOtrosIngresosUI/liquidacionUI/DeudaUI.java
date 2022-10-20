package main.ui.tasasOtrosIngresosUI.liquidacionUI;

import org.openqa.selenium.By;

public class DeudaUI {
    public static String xpathDebtTable = "//form[@id='frmRegistrar']//h3[contains(.,'Datos Deuda')]/following-sibling::table//table";
    public static String xpathRows = xpathDebtTable.concat("//tr");
    public static String xpathHeader = xpathDebtTable.concat("//tr[1]");
    public static By rowsDebtTable = By.xpath(xpathRows);
    public static By headerDebtTable = By.xpath(xpathHeader);
    public static By btnDetallada = By.name("btnDetallada");
    public static By btnResumida = By.name("btnResumida");

    public static By getCell(int i, int j){
        return By.xpath(xpathRows + "[" + i + "]/td[" + j + "]");
    }


    //form[@id='frmRegistrar']//h3[contains(.,'Datos Deuda')]/following-sibling::table
}
