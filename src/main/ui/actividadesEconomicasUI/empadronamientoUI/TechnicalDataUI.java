package main.ui.actividadesEconomicasUI.empadronamientoUI;

import org.openqa.selenium.By;

public class TechnicalDataUI {
    public static By ttlDatosTecnicos = By.xpath("//h2[text()='DATOS TECNICOS']");
    public static By lstZonaTributaria = By.id("cbxZonas");
    public static By txtSuperficie = By.id("txtSuperficie");
    public static By lstRubro = By.xpath("//th[text()='Rubro']/following-sibling::td/select");
    public static By lstSubRubro = By.xpath("//th[text()='Sub Rubro']/following-sibling::td/select");
    public static By lstTipoActividad = By.xpath("//th[text()='Tipo Actividad']/following-sibling::td/select");
    public static By btnAceptar = By.id("btnSubmit");
}
