package main.ui.actividadesEconomicasUI.compensacionesUI;

import main.ui.commonElementsUI.IDebtTable;
import org.openqa.selenium.By;

public class DebtDetailUI {
    public static By ttlDetalleDeudas = By.xpath("//h2[text()='DETALLE DE DEUDAS']");
    public static By btnProcesar = By.name("btnPagar");
    public static IDebtTable debtsTable = new DebtDetailTableUI();
}
