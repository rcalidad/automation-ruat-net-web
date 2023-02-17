package main.ui.inmueblesUI.empadronamientoUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatosAccionistasUI {
    public static By ttlDatosAccionistas = By.xpath("//h2[normalize-space()='DATOS ACCIONISTAS']");
    public static By lnkAdicionarAccionista = By.linkText("Adicionar");
    public static By txtPorcentajes = By.xpath("//input[@id='txtPorcentaje']");
    public static By btnAceptar = By.id("btnAceptar");

    public static String xpathTable = "//h3[text()='Datos Contribuyente (Acciones y Derechos)']/following-sibling::table";
    public static By tablaDatosContribuyente = By.xpath(xpathTable);
    public static String xpathRows = xpathTable + "/tbody/tr";

    public static By getRows(){
        return By.xpath(xpathRows);
    }
    public static By getTableHeader(){
        return By.xpath(xpathRows + "[1]/th");
    }
    public static By getCell(int x, int y){
        return By.xpath(xpathRows + "[" + x + "]/td[" + y + "]");
    }
    public static By getInput(int x, int y){
        return By.xpath(xpathRows + "[" + x + "]/td[" + y + "]/input");
    }
}
