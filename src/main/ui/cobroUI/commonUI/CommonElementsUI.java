package main.ui.cobroUI.commonUI;

import org.openqa.selenium.By;

public class CommonElementsUI {
    public static By btnHome = By.xpath("//a[@class='btn fa-home']");
    public static By btnLogout = By.xpath("//a[@class='btn fa-power-off']");

    public static By imgEnProgreso = By.id("fondo");
    public static By btnContinuar = By.id("btnContinuar");

    public static By ttlNotificacion = By.xpath("//h2[text()='NOTIFICACION']");
    public static By msgNotificacion = By.xpath("//table[contains(.,'NOTIFICACION')]/tbody/tr[2]");
    public static By msgNotificacionTasas = By.xpath("//table[contains(.,'NOTIFICACION')]/tbody/tr[4]");

    public static By ttlErrorRojo = By.xpath("//*[text()='HUBO UN ERROR']");
}
