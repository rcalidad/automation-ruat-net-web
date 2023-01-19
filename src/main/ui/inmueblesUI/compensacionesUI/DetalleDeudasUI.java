package main.ui.inmueblesUI.compensacionesUI;

import main.ui.commonElementsUI.IDebtTable;
import org.openqa.selenium.By;

public class DetalleDeudasUI {
    public static By ttlDetalleDeudas = By.xpath("//h2[normalize-space()='Detalle Deudas']");
    public static By btnProcesar = By.name("btnPagar");
    public static By table = By.xpath("//h3[text()='Datos Deudas']/following-sibling::table");

    public static IDebtTable tablaDatosDeudas = new TablaDatosDeudaUI();

}
