package main.ui.vehiculosUI.compensacionesUI;

import org.openqa.selenium.By;

public class DatosAutorizacionUI {
    public static By ttlDatosAutorizacion = By.xpath("//h2[text()='DATOS AUTORIZACION']");
    public static By txtNumeroDocumento = By.id("txtNroDocumento");
    public static By txtFechaDocumento = By.id("txtFechaDocumento");
    public static By txtAutorizadoPor = By.id("txtNombreAutoridad");
    public static By txtCargo = By.id("txtCargoAutoridad");
    public static By txtObservaciones = By.id("txtObservacion");
    public static By btnAceptar = By.name("btnAceptar");
}
