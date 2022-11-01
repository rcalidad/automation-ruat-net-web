package main.ui.tasasOtrosIngresosUI.mainMenuUI;

import org.openqa.selenium.By;

public class MainMenuUI {
    public static By divMainMenu = By.id("menu-lista");
    public static By allLinkMainMenu = By.xpath("//div[@id='menu-lista']//a");

    public static By lnkTasasSimplesOtrosIngresos = By.linkText("TASAS SIMPLES Y OTROS INGRESOS");
    public static By lnkPublicidadPermanente = By.linkText("PUBLICIDAD PERMANENTE");
    public static By lnkMercados = By.linkText("MERCADOS");
    public static By lnkAsociaciones = By.linkText("ASOCIACIONES");
    public static By lnkLiquidacion = By.linkText("LIQUIDACION");
    public static By lnkTramites = By.linkText("TRAMITES");
    public static By lnkConsultaDetallePagos = By.linkText("CONSULTA DETALLADA PAGOS");
    public static By lnkComprobantePagoCero = By.linkText("COMPROBANTE PAGO EN CERO");

    public static By getGrouper(String grouper){
        return By.linkText(grouper);
    }
    public static By getOption(String option){
        return By.linkText(option);
    }
}
