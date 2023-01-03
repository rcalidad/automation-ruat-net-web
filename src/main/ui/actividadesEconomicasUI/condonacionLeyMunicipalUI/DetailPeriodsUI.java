package main.ui.actividadesEconomicasUI.condonacionLeyMunicipalUI;

import main.ui.actividadesEconomicasUI.commonUI.periodDetailTableUI.IPeriodDetailTable;
import org.openqa.selenium.By;

public class DetailPeriodsUI {
    public static By ttlDetalleGestiones = By.xpath("//h2[text()='DETALLE GESTIONES']");
    public static By btnProcesar = By.xpath("//input[@value='Procesar']");
    public static By btnAceptar = By.id("btnAceptar");
    public static IPeriodDetailTable tblDetalleGestiones = new DetailPeriodsTable();
}
