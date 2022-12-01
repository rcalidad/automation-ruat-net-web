package main.ui.vehiculosUI.transferenciaUI;

import org.openqa.selenium.By;

public class AsignarPropiedadUI {
    public static By ttlAsignarPropiedad = By.xpath("//h2[text()='ASIGNAR PROPIEDAD']");
    public static By txtDocumento = By.id("txtNumDocumento");
    public static By lstTipoDocumento = By.xpath("//th[text()='Tipo Documento']/following-sibling::td/select");
    public static By btnBuscar = By.name("btnBuscar");
    public static By btnAceptar = By.name("btnAceptar");
}
