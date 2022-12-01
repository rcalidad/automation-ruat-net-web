package main.ui.vehiculosUI.commonUI;

import org.openqa.selenium.By;

public class ModificarDatosMinutaUI {
    public static By ttlModificarDatosMinuta = By.xpath("//h2[text()='MODIFICAR DATOS MINUTA']");
    public static By txtFechaMinuta = By.id("txtFecha");
    public static By txtVerificacionFechaMinuta = By.id("txtFechaConfirmacion");
    public static By txtMontoMinuta = By.id("txtMonto");
    public static By txtVerificacionMontoMinuta = By.id("txtMontoConfirmacion");
    public static By rbtDolares = By.id("US");
    public static By rbtBolivianos = By.id("BS");
    public static By rbtUfvs = By.id("UF");
    public static By txtObservaciones = By.id("txtObservacion");
    public static By btnAceptar = By.name("btnValidar");
    public static By btnRestablecer = By.name("btnRestablecer");
}
