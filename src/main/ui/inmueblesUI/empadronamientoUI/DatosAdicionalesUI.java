package main.ui.inmueblesUI.empadronamientoUI;

import org.openqa.selenium.By;

public class DatosAdicionalesUI {
    public static By ttlDatosAdicionales = By.xpath("//h2[normalize-space()='DATOS ADICIONALES']");
    public static By txtFojas = By.id("txtFojas");
    public static By txtNumeroDocumento = By.id("txtNumeroFojas");
    public static By txtLibro = By.id("txtLibro");
    public static By txtFecha = By.id("txtFecha");
    public static By lstInstrumento = By.xpath("//th[text()='Instrumento']/following-sibling::td/select");
    public static By txtFolioComputarizado = By.id("txtFolio");
    public static By txtPartidaComputarizadaMatricula = By.id("txtPartida");
    public static By btnAceptar = By.xpath("//input[@value='Aceptar']");
    public static By btnLimpiar = By.xpath("//input[@value='Limpiar']");
}
