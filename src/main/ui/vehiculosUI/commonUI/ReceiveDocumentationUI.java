package main.ui.vehiculosUI.commonUI;

import org.openqa.selenium.By;

public class ReceiveDocumentationUI {
    public static By ttlRecepcionarDocumentacion = By.xpath("//h2[text()='RECEPCIONAR DOCUMENTACION']");
    public static By chkCrpva = By.xpath("//td[contains(.,'CRPVA')]/following-sibling::td/input");
    public static By chkDocumentoIdentidad = By.xpath("(//input[@id='chkFoco'])[2]");
    public static By chkSolicitudCorreccionDatos = By.xpath("//td[contains(.,'SOLICITUD DE CORRECCION DE DATOS')]/following-sibling::td/input");
    public static By chkMinutaCompraVenta = By.xpath("//td[contains(.,'MINUTA DE COMPRA Y VENTA')]/following-sibling::td/input");
    public static By chkDocumentoIdentidadComprador = By.xpath("//td[contains(.,'DOCUMENTO DE IDENTIDAD COMPRADOR')]/following-sibling::td/input");
    public static By chkDocumentoDeIdentidad = By.xpath("//td[contains(.,'DOCUMENTO DE IDENTIDAD')]/following-sibling::td/input");
    public static By chkNotaSolicitud = By.xpath("//td[contains(.,'NOTA SOLICITUD')]/following-sibling::td/input");

    public static By lstGestorTramite = By.id("tipoGestorTramite");
    public static By btnLimpiar = By.id("btnSubmit2");
    public static By btnGrabar = By.id("btnSubmit");

}
