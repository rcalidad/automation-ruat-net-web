package main.ui.inmueblesUI.autoavaluosUI;

import org.openqa.selenium.By;

public class RegistrarAutoavaluoUI {
    public static By ttlRegistrarAutoavaluo = By.xpath("//h2[text()='REGISTRAR AUTOAVALUO']");
    public static By txtValuacionInmueble = By.id("txtValorInmueble");
    public static By txtVerificacionValuacionInmueble = By.id("txtVerifValorInmueble");
    public static By txtFechaAutoavaluo = By.id("txtFecha");
    public static By txtObservaciones = By.id("textarea");
    public static By btnLimpiar = By.xpath("//*[@value='Limpiar']");
    public static By btnGrabar = By.id("grabar");
}
