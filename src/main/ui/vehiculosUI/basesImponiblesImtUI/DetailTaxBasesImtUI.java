package main.ui.vehiculosUI.basesImponiblesImtUI;

import org.openqa.selenium.By;

public class DetailTaxBasesImtUI {
    public static By ttlDetalleBaseImponibleImt = By.xpath("//h2[text()='DETALLE BASE IMPONIBLE IMT']");
    public static By btnAceptar = By.name("btnAceptar");
    public static String xpathTablaDatosMinuta = "//h3[text()='Datos Minuta']/following-sibling::table[1]";
    public static String xpathDatosMinutaRows = xpathTablaDatosMinuta.concat("//tr");
    public static By tblDatosMinuta = By.xpath("//h3[text()='Datos Minuta']/following-sibling::table[1]");
    public static String xpathTablaDetalleBaseImponibleImt = "//h3[text()='Detalle Base Imponible IMT']/following-sibling::table[1]";
    public static String xpathDetalleBaseImponibleImtRows = xpathTablaDetalleBaseImponibleImt.concat("//tr");
    public static By tblDetalleBaseImponibleImt = By.xpath("//h3[text()='Detalle Base Imponible IMT']/following-sibling::table[1]");

    public static By getDatosMinutaRows(){
        return By.xpath(xpathDatosMinutaRows);
    }
    public static By getDetalleBaseImponibleImtRows(){
        return By.xpath(xpathDetalleBaseImponibleImtRows);
    }
    public static By getColumnsOfDatosMinuta(int row){
        return  By.xpath(xpathDatosMinutaRows + "[" + row + "]//td");
    }
    public static By getColumnsOfDetalleBaseImponibleImtRows(int row){
        return By.xpath(xpathDetalleBaseImponibleImtRows + "[" + row + "]//td");
    }
    public static By getHeaderDatosMinuta(){
        return  By.xpath(xpathDatosMinutaRows + "[" + 1 + "]//th");
    }
    public static By getCellDetalleBaseImponible(int x, int y){
        return By.xpath(xpathDetalleBaseImponibleImtRows + "[" + x + "]//td[" + y + "]");
    }
}
