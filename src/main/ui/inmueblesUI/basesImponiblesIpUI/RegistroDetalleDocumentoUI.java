package main.ui.inmueblesUI.basesImponiblesIpUI;

import org.openqa.selenium.By;

public class RegistroDetalleDocumentoUI {
    public static By ttlRegistroDetalleDocumento = By.xpath("//h2[text()='REGISTRO DETALLE DOCUMENTO']");
    public static By txtAutoridadEmisora = By.id("txtAutoridadResponsable");
    public static By txtFechaDocumento = By.id("txtFechaDocumento");
    public static By txtNumeroSerie = By.id("txtSerie");
    public static By txtNumeroFojas = By.id("txtNumerofojas");
    public static By rbtOriginal = By.xpath("//input[@value='OR']");
    public static By rbtFotocopia = By.xpath("//input[@value='FO']");
    public static By rbtAmbas = By.xpath("//input[@value='AM']");
    public static By txtObservaciones = By.id("txtObservacion");
    public static By btnLimpiar = By.id("btnLimpiar");
    public static By btnAceptar = By.id("btnSubmit");
}
