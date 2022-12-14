package main.ui.cobroUI.commonUI;

import org.openqa.selenium.By;

public class RecordPaymentUI {
    //public static By ttlRegistrarPagos = By.xpath("//h2[text()='REGISTRAR PAGOS']");
    //public static By ttlRegistrarPagos = By.xpath("//h2[contains(.,'REGISTRAR PAGOS')]");
    public static By ttlRegistrarPagos = By.xpath("//form[@id='formulario']/table/tbody/tr/td/h2");
    public static By txtDeuda = By.xpath("//th[text()='Deuda']/following-sibling::td");
    public static By txtMontoEfectivo = By.id("txtMonto");
    public static By txtVerificacionMontoEfectivo = By.id("txtVerifica");
    public static By btnAceptar = By.name("aceptar");
}
