package main.ui.actividadesEconomicasUI.empadronamientoUI;

import org.openqa.selenium.By;

public class AuthorizationUI {
    public static By ttlAutorizacion = By.xpath("//h2[text()='AUTORIZACION']");
    public static By txtAutorizadoPor = By.id("txtAutoriza");
    public static By lstCargo = By.id("cbxCargo");
    public static By txtFecha = By.id("txtFecha");
    public static By btnAceptar = By.id("btnSubmit");
}
