package main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI;

import main.ui.actividadesEconomicasUI.commonUI.periodDetailTableUI.IPeriodsToSanctionTable;
import org.openqa.selenium.By;

public class ModifyPenaltyUI {
    public static By ttlModificarMulta = By.xpath("//h2[text()='MODIFICAR MULTA']");
    public static By lstMotivo = By.id("cbxMotivoMulta");
    public static By txtObservaciones = By.id("txtObservacion");
    public static By btnRegistrar = By.id("btnGuardar");
    public static String xpathtblGestionesSancionar = "//h3[contains(.,'a Sancionar')]/following-sibling::table";
    public static By tblGestionesASancionar = By.xpath(xpathtblGestionesSancionar);
    public static String xpathTblGestionesSancionarRows = xpathtblGestionesSancionar + "/tbody/tr";

    public static IPeriodsToSanctionTable sanctionTable = new PeriodsToSanctionTable();
}
