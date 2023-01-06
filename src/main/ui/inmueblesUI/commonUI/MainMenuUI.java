package main.ui.inmueblesUI.commonUI;

import org.openqa.selenium.By;

public class MainMenuUI {
    public static By icoInmuebles = By.id("logo-aplicacion");
    public static String xpathGroupers = "//*[@id='menu-lista']/ul/li";
    public static By groupers = By.xpath(xpathGroupers);
    public static By btnMiCuenta = By.xpath("//div[@id='opciones-fijas-cabecera']/ul/li[1]");
    public static By lnkCerrarSesion = By.linkText("Cerrar Sesión");

    public static By getSubElements(String xpathElement, int index){
        String newXpath = xpathElement + "["+ index + "]/ul/li";
        return By.xpath(xpathElement);
    }
    public static By getLink(String xpathElement){
        String xpathLink = xpathElement + "/a";
        return By.xpath(xpathLink);
    }
}
