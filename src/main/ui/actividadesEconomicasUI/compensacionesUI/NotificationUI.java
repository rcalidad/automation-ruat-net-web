package main.ui.actividadesEconomicasUI.compensacionesUI;

import org.openqa.selenium.By;

public class NotificationUI {
    public static By ttlNotification = By.xpath("//h2[text()='NOTIFICACION']");
    public static By msgNotificacion = By.xpath("//form[@id='frmNotificacion']/table//p");
    public static By lnkReimpresion = By.linkText("Reimpresi�n");
    public static By lnkNuevaBusqueda = By.linkText("Nueva B�squeda");
    public static By lnkSalir = By.linkText("Salir");

}
