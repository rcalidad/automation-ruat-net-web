package main.ui.vehiculosUI.condonacionLeyMunicipalImtUI;

import org.openqa.selenium.By;

public class DetalleItemsCondonacionUI {
    public static By ttlDetalleItemsCondonacion = By.xpath("//h2[text()='Detalle Items Condonación']");
    public static By btnProcesar = By.xpath("//input[@value='Procesar']");
    public static By btnAceptar = By.xpath("//input[@value='Aceptar']");
    public static String xpathDetalleItems = "//h3[text()='Detalle Items Condonación']/following-sibling::table";
    public static By tblDetalleItems = By.xpath(xpathDetalleItems);
    public static String xpathDetalleGestionesRows = xpathDetalleItems.concat("//tr");

    public static By getRows(){
        return By.xpath(xpathDetalleGestionesRows);
    }
    public static By getColumns(int row){
        return By.xpath(xpathDetalleGestionesRows + "[" + row + "]//td");
    }
    public static By getCell(int x, int y){
        return By.xpath(xpathDetalleGestionesRows + "[" + x + "]//td" + "[" + y + "]");
    }
    public static By getCheckbox(int row, int column){
        return By.xpath(xpathDetalleGestionesRows + "[" + row + "]//td[" + column + "]/input");
    }
    public static By getHeader(){
        return By.xpath(xpathDetalleGestionesRows + "[1]//th");
    }
}
