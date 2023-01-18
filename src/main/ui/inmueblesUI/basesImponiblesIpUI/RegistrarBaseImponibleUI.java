package main.ui.inmueblesUI.basesImponiblesIpUI;

import org.openqa.selenium.By;

public class RegistrarBaseImponibleUI {
    public static By ttlRegistrarBaseImponible = By.xpath("//h2[text()='Registrar Base Imponible']");
    public static By chkLiquidarEnBaseATablas = By.id("chkTipoLiquidacion");
    public static By txtValorInicial = By.id("txtValorInicial");
    public static By txtFechaInicial = By.id("txtFechaInicial");
    public static By txtFechaBalance = By.id("txtFechaBalance");
    public static By txtBaseImponible = By.id("txtBaseImponible");
    public static By txtVerificacionBaseImponible = By.id("txtVerificaBaseImponible");
    public static By txtNumeroFormulario = By.id("txtFormulario");
    public static By txtObservaciones = By.id("txtmotivoanulacion");
    public static By btnLimpiar = By.xpath("//input[@value='Limpiar']");
    public static By btnGrabar = By.id("btnGuardar");
}
