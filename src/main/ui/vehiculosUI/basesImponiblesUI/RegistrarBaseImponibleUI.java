package main.ui.vehiculosUI.basesImponiblesUI;

import org.openqa.selenium.By;

public class RegistrarBaseImponibleUI {
    public static By ttlRegistrarBaseImponible = By.xpath("//h2[text()='Registrar Base Imponible']");
    public static By lblGestion = By.xpath("//th[text()='Gestión']/following-sibling::td");
    public static By txtValorInicial = By.id("txtValorInicial");
    public static By txtFechaInicial = By.id("txtFechaInicial");
    public static By txtFechaBalance = By.id("txtFechaBalance");
    public static By txtDepreciacion = By.id("txtDepreciacion");
    public static By txtBaseImponible = By.id("txtBaseImponible");
    public static By txtVerificacionBaseImponible = By.id("txtVerificaBaseImponible");
    public static By txtNumeroFormulario = By.id("txtFormulario");
    public static By btnRegistrar = By.id("btnGuardar");
}
