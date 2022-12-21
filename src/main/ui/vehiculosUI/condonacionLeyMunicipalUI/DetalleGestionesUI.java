package main.ui.vehiculosUI.condonacionLeyMunicipalUI;

import org.openqa.selenium.By;

public class DetalleGestionesUI {
    public static By ttlDetalleGestiones = By.xpath("//h2[text()='Detalle Gestiones']");
    public static By btnProcesar = By.xpath("//input[@value='Procesar']");
    public static By btnAceptar = By.xpath("//input[@value='Aceptar']");
    public static String xpathDetalleGestionesTable = "//h3[text()='Detalle Gestiones']/following-sibling::table";
    public static By tblDetalleGestiones = By.xpath("//h3[text()='Detalle Gestiones']/following-sibling::table");
    public static String xpathDetalleGestionesRows = xpathDetalleGestionesTable.concat("//tr");

    public static By getRows(){
        return By.xpath(xpathDetalleGestionesRows);
    }
    public static By getColumns(int row){
        return By.xpath(xpathDetalleGestionesRows + "[" + row + "]//td");
    }
    public static By getCell(int x, int y){
        return By.xpath(xpathDetalleGestionesRows + "[" + x + "]//td" + "[" + y + "]");
    }
    public static int getColumnOfYear(){
        return 1;
    }
    public static int getColumnOfConcepto(){
        return 2;
    }
    public static By getSelectPorcentaje(int row){
        return By.xpath(xpathDetalleGestionesRows + "[" + row + "]//td/select");
    }
    public static By getCheckbox(int row, int column){
        return By.xpath(xpathDetalleGestionesRows + "[" + row + "]//td[" + column + "]/input");
    }
    public static By getHeader(){
        return By.xpath(xpathDetalleGestionesRows + "[1]//th");
    }

}
