package main.ui.inmueblesUI.condonacionLeyMunicipalUI;

import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.By;

public class DetalleCondonacionUI {
    public static By ttlDetalleCondonacion = By.xpath("//h2[text()='DETALLE CONDONACION']");
    public static By lstLeyMunicipal = By.id("cbxLeyMunicipal");
    public static By btnAceptar = By.name("btnAceptar");
    public static By btnProcesar = By.name("btnProcesar");
    public static By lnkAnterior = By.linkText("Anterior");

    public static IPeriodTable tablaDatosCondonacion = new TablaDatosCondonacionUI();
    public static By tblDatosCondonacion = By.xpath(TablaDatosCondonacionUI.xpathTabla);

    public static IPeriodTable tablaDetalleCondonacion = new TablaDetalleCondonacionUI();
    public static By tblDetalleCondonacion = By.xpath(TablaDetalleCondonacionUI.xpathTabla);

}
