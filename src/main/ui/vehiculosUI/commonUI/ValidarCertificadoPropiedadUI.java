package main.ui.vehiculosUI.commonUI;

import org.openqa.selenium.By;

public class ValidarCertificadoPropiedadUI {
    public static By ttlModificacionDatosTecnicos = By.xpath("//h1[text()='MODIFICACION DE DATOS TECNICOS']");
    public static By txtCRPVA = By.id("txtCRPVA");
    public static By txtNumeroCopia = By.id("txtNumCopia");
    public static By btnAceptar = By.name("btnValidar");
}
