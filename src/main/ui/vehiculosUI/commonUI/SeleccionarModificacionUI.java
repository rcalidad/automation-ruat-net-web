package main.ui.vehiculosUI.commonUI;

import org.openqa.selenium.By;

public class SeleccionarModificacionUI {
    public static By ttlSeleccionarModificacion = By.xpath("//h2[text()='SELECCIONAR MODIFICACION']");
    public static By lnkModificarFechaInicioImpuestos = By.xpath("//th[text()='FECHA INICIO DE IMPUESTOS']/following-sibling::td/a");
    public static By lnkModificarServicio = By.xpath("//th[text()='SERVICIO']/following-sibling::td/a");
    public static By lnkModificarDatosTecnicos = By.xpath("//th[text()='MODIFICAR DATOS TECNICOS']/following-sibling::td/a");
    public static By lnkModificarDatosTestimonio = By.xpath("//th[text()='MODIFICAR DATOS TESTIMONIO']/following-sibling::td/a");
    public static By lnkModificarDatosMinuta = By.xpath("//th[text()='MODIFICAR DATOS MINUTA']/following-sibling::td/a");
    public static By btnAceptar = By.name("btnValidar");
}
