package main.ui.vehiculosUI.commonUI;

import org.openqa.selenium.By;

public class AssignOwnerUI {
    public static By txtNumeroDocumento = By.id("txtNumDocumento");
    public static By txtComplementoNumeroDocumento = By.id("txtNroComplemento");
    public static By lstTipoDocumento = By.xpath("//th[text()='Tipo Documento']/following-sibling::td/select");
    public static By btnBuscar = By.name("btnBuscar");

}
