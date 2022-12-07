package main.ui.vehiculosUI.basesImponiblesUI;

import org.openqa.selenium.By;

public class DetailTaxBasesUI {
    public static By ttlDetalleBasesImponibles = By.xpath("//h2[text()='Detalle Bases Imponibles']");
    public static String xpathTablaDetalleBasesImponibles   = "//h3[text()='Detalle Bases Imponibles']/following-sibling::table";
    public static String xpathFila = xpathTablaDetalleBasesImponibles.concat("//tr");
    public static String xpathPrimeraFila = xpathTablaDetalleBasesImponibles.concat("//tr[2]/td");
    public static By filas = By.xpath(xpathFila);
    public static By columnas = By.xpath(xpathPrimeraFila);
    //public static By tblDetalleBasesImponibles = By.xpath("//h3[text()='Detalle Bases Imponibles']/following-sibling::table/tbody/tr");
    public static By btnAceptar = By.xpath("//input[@value='Aceptar']");

    public static By getCell(int x, int y){
        return By.xpath(xpathFila.concat("[") + x + "]/td[" + y + "]");
    }
}
