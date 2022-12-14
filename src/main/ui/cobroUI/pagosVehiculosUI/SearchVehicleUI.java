package main.ui.cobroUI.pagosVehiculosUI;

import org.openqa.selenium.By;

public class SearchVehicleUI {
    public static By ttlBuscarVehiculo = By.xpath("//h2[text()='Buscar Vehiculo']");
    public static By txtIdentificador = By.id("txtIdentificador");
    public static By rbtPlacaPta = By.id("PTA");
    public static By rbtPoliza = By.id("POL");
    public static By rbtPlacaAnterior = By.id("PANT");
    public static By rbtCopo = By.id("COPO");
    public static By btnBuscar = By.name("btnBuscar");
}
