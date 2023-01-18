package main.ui.inmueblesUI.basesImponiblesIpUI;

import main.ui.commonElementsUI.IProcedureDetail;
import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.By;

public class DetalleBasesImponiblesUI implements IProcedureDetail {
    public static By ttlDetalleBasesImponibles = By.xpath("//h2[text()='Detalle Bases Imponibles']");
    public static By btnAceptar = By.xpath("//input[@value='Aceptar']");

    public static IPeriodTable tablaDetalleGestiones = new PeriodDetailTable();

    public static IProcedureDetail getInstance(){
        IProcedureDetail procedureDetail = new DetalleBasesImponiblesUI();
        return procedureDetail;
    }
    @Override
    public By getBtnAceptar() {
        return btnAceptar;
    }
}
