package main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI;

import main.ui.actividadesEconomicasUI.commonUI.periodDetailTableUI.IPeriodDetailTable;
import org.openqa.selenium.By;

public class DetailPeriodsUI {
    public static By ttlDetalleGestiones = By.xpath("//h2[text()='DETALLE GESTIONES']");
    public static By lstTipoMulta = By.id("cbxTipoMulta");
    public static By tblDetalleGestiones = By.xpath("//*[@id='divGestiones']/table");
    public static By btnProcesar = By.xpath("//input[@value='Procesar']");
    public static By btnAceptar = By.xpath("//input[@value='Aceptar']");

    public static IPeriodDetailTable detailTable = new PeriodDetailTable();
}
