package main.ui.inmueblesUI.autoavaluosUI;

import org.openqa.selenium.By;

public class RegistrarSolicitudUI {
    public static By ttlRegistrarSolicitud = By.xpath("//h2[text()='REGISTRAR SOLICITUD']");
    public static By lstOrigenSolicitud = By.id("cbxOrigen");
    public static By txtFecha = By.id("txtFecha");
    public static By txtNumeroDocumento = By.id("txtNumeroDocumento");
    public static By txtAutorizadoPor = By.id("txtAutoridad");
    public static By txtCargo = By.id("txtCargo");
    public static By txtObservaciones = By.id("txaObservaciones");
    public static By btnLimpiar = By.name("btnLimpiar");
    public static By btnAceptar = By.name("btnAceptar");
}
