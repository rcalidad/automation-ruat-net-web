package main.ui.cobroUI.pagarInmuebleUI;

import org.openqa.selenium.By;

public class SearchInmuebleUI {
    public static By ttlBusquedaInmueble = By.xpath("//h2[text()='BUSQUEDA INMUEBLE']");
    public static By txtIdentificador = By.id("txtIdentificador");
    public static By rbtNumeroInmueble = By.id("rbtCriterioNIM");
    public static By rbtCodigoCatastral = By.id("rbtCriterioCAT");
    public static By lstGobiernoMunicipal = By.xpath("//th[contains(.,'Gobierno Municipal')]/following-sibling::td/select");
    public static By btnBuscar = By.id("btnAceptar");
}
