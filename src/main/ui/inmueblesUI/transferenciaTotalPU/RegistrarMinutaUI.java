package main.ui.inmueblesUI.transferenciaTotalPU;

import org.openqa.selenium.By;

import java.util.Map;

public class RegistrarMinutaUI {
    public static By ttlRegistrarMinuta = By.xpath("//h2[text()='REGISTRAR MINUTA']");
    public static By lstTipoTransferencia = By.id("cbxTipoTransferencia");
    public static By txtObservacion = By.id("txaObservacion");
    public static By txtFechaMinuta = By.id("txtFechaMinuta");
    public static By txtVerificacionFechaMinuta = By.id("txtVerificaFechaMinuta");
    public static By txtMontoMinuta = By.id("txtMontoMinuta");
    public static By txtVerificacionMontoMinuta = By.id("txtVerificaMontoMinuta");
    public static By rbtDolares = By.id("rbtDOLARES");
    public static By rbtBolivianos = By.id("rbtBOLIVIANOS");
    public static By btnAceptar = By.name("btnAceptar");

    public static Map<String, By> currency = Map.of("DOLARES", rbtDolares, "BOLIVIANOS", rbtBolivianos);
}
