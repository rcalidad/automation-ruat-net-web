package main.ui.vehiculosUI.basesImponiblesImtUI;

import org.openqa.selenium.By;

public class RegistrarBaseImponibleImtUI {
    public static By ttlRegistrarBaseImponibleImt = By.xpath("//h2[text()='Registrar Base Imponible IMT']");
    public static By txtBaseImponibleDeclarada = By.id("txtBaseImponibleDeclarada");
    public static By rbtDolares = By.id("US");
    public static By rbtBolivianos = By.id("BS");
    public static By rbtUfv = By.id("UF");
    public static By txtNumeroDocumento = By.id("txtNumeroDocumento");
    public static By txtFechaDocumento = By.id("txtFechaDocumento");
    public static By txtNombreAutoridad = By.id("txtNombreAutoridad");
    public static By txtObservaciones = By.id("txtObservacion");
    public static By btnRegistrar = By.id("btnRegistrar");
    public static By btnLimpiar = By.id("btnSubmit2");
}
