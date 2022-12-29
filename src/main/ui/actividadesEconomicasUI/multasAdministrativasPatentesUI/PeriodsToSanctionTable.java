package main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI;

import main.ui.actividadesEconomicasUI.commonUI.periodDetailTableUI.IPeriodsToSanctionTable;
import org.openqa.selenium.By;

public class PeriodsToSanctionTable implements IPeriodsToSanctionTable {
    public static String xpathtblGestionesSancionar = "//h3[contains(.,'a Sancionar')]/following-sibling::table";
    public static By tblGestionesASancionar = By.xpath(xpathtblGestionesSancionar);
    public static String xpathTblGestionesSancionarRows = xpathtblGestionesSancionar + "/tbody/tr";
    @Override
    public By getRows() {
        return By.xpath(xpathTblGestionesSancionarRows);
    }

    @Override
    public By getInputMonto(int row) {
        return By.xpath(xpathTblGestionesSancionarRows + "[" + row + "]/td[2]/input");
    }
}
