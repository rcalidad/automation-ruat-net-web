package main.ui.inmueblesUI.autoavaluosUI;

import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.By;

public class DetalleAutoavaluosUI {
    public static By ttlDetalleAutoavaluos = By.xpath("//h2[text()='DETALLE AUTOAVALUOS']");
    public static By btnAceptar = By.xpath("//input[@value='Aceptar']");

    public static IPeriodTable tablaDetalleGestiones = new PeriodDetailTable();
}
