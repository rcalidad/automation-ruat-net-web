package main.ui.vehiculosUI.commonUI;

import org.openqa.selenium.By;

public class RecordMinuteUI {
    public static By ttlRegistrarMinuta = By.xpath("//h2[text()='REGISTRAR MINUTA']");
    public static By txtFechaMinuta = By.id("txtFecha");
    public static By txtVerificacionFechaMinuta = By.id("txtFechaConfirmacion");
    public static By txtMontoMinuta = By.id("txtMonto");
    public static By txtVerificacionMmontoMinuta = By.id("txtMontoConfirmacion");
    public static By rbtDolares = By.id("US");
    public static By rbtBolivianos = By.id("BS");
    public static By rbtUfvs = By.id("UF");
    public static By btnAceptar = By.name("btnAceptar");
}
