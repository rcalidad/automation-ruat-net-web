package main.ui.actividadesEconomicasUI.commonUI;

import org.openqa.selenium.By;

public class SearchTaxpayerUI {
    public static By ttlBusquedaContribuyente = By.xpath("//h2[text()='BUSQUEDA CONTRIBUYENTE']");
    public static By txtNumeroDocumento = By.xpath("//th[text()='Número de Documento']/following-sibling::td[1]/input");
    public static By lstTipoDocumento = By.xpath("//th[text()='Tipo de Documento']/following-sibling::td/select");
    public static By btnBuscar = By.name("btnBuscar");

    public static By lnkAsociar = By.linkText("Asociar");

}
