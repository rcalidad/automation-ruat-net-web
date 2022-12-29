package main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI;

import main.ui.actividadesEconomicasUI.commonUI.periodDetailTableUI.IPeriodsToSanctionTable;
import org.openqa.selenium.By;

public class RegisterPenaltyUI {
    public static By ttlRegistrarMulta = By.xpath("//h2[text()='Registrar Multa']");
    public static By txtNumeroDocumento = By.id("txtNumeroDocumento");
    public static By txtFechaDocumento = By.id("txtFechaDocumento");
    public static By txtAutorizadoPor = By.id("txtAutorizadoPor");
    public static By txtCargo = By.id("txtCargo");
    public static By lstMotivo = By.id("cbxMotivoMulta");
    public static By txtObservaciones = By.id("txtObservacion");
    public static By btnRegistrar = By.id("btnGuardar");
    public static String xpathtblGestionesSancionar = "//h3[contains(.,'a Sancionar')]/following-sibling::table";
    public static By tblGestionesASancionar = By.xpath(xpathtblGestionesSancionar);
    public static String xpathTblGestionesSancionarRows = xpathtblGestionesSancionar + "/tbody/tr";

    public static IPeriodsToSanctionTable sanctionTable = new PeriodsToSanctionTable();
}
