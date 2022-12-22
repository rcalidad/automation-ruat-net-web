package main.ui.vehiculosUI.emisionComprobantePagoEnCeroUI;

import org.openqa.selenium.By;

public class NotificacionUI {
    public static By ttlNotificacion = By.xpath("//h2[text()='NOTIFICACION']|//h2[text()='Notificacion']");
    public static By msgNotificacion = By.xpath("//td[contains(.,'correctamente')]");
}
