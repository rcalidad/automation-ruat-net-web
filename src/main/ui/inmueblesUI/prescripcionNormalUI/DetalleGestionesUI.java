package main.ui.inmueblesUI.prescripcionNormalUI;

import main.ui.commonElementsUI.IDebtTable;
import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.By;

public class DetalleGestionesUI {
    public static By ttlDetalleDeudas = By.xpath("//h2[normalize-space()='DETALLE GESTIONES']");
    public static By btnProcesar = By.name("btnProcesar");
    public static By btnTerminar = By.name("btnTerminar");
    public static By table = By.xpath("//h3[text()='Detalle Gestiones']/following-sibling::table");

    public static IPeriodTable tablaDetalleGestiones = new TablaDatosGestionesUI();
}
