package main.ui.vehiculosUI.commonUI;

import org.openqa.selenium.By;

public class CommonElementsUI {
    public static By imgEnProgreso = By.id("fondo");
    public static By ttlValidaciones = By.xpath("//h2[text()='NOTIFICACION']");

    public static By btnContinuar = By.id("btnContinuar");

    public static By ttlErrorRojo = By.xpath("//*[text()='HUBO UN ERROR']");
}
