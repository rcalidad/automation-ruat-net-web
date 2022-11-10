package main.ui.vehiculosUI.commonUI;

import org.openqa.selenium.By;

public class ReceiveDocumentationUI {
    public static By ttlRecepcionarDocumentacion = By.xpath("//h2[text()='RECEPCIONAR DOCUMENTACION']");
    public static By chkCrpva = By.xpath("(//input[@id='chkFoco'])[1]");
    public static By chkDocumentoIdentidad = By.xpath("(//input[@id='chkFoco'])[2]");
    public static By cbxGestorTramite = By.id("tipoGestorTramite");
    public static By btnLimpiar = By.id("btnSubmit2");
    public static By btnGrabar = By.id("btnSubmit");
}
