package main.ui.cobroUI.pagarActividadesEconomicasUI;

import org.openqa.selenium.By;

public class SearchActividadesEconomicasUI {
    public static By ttlBuscarActividadesEconomicas = By.xpath("//h2[text()='Buscar Actividad Economica']");
    public static By txtIdentificador = By.id("txtIdentificador");
    public static By rbtLicencia = By.id("NRO_LICENCIA");
    public static By rbtNumeroActividad = By.id("ID_ACTIVIDAD");
    public static By lstGobiernoMunicipal = By.xpath("//th[text()='Gobierno Municipal']/following-sibling::td/select");
    public static By btnBuscar = By.name("btnBuscar");
}
