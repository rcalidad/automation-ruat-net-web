package main.ui.vehiculosUI.modificarDatosTecnicosOperadorUI;

import org.openqa.selenium.By;

public class SeleccionarModificacionUI {
    public static By ttlSeleccionarModificacion = By.xpath("//h2[text()='SELECCIONAR MODIFICACION']");
    public static By lnkModificarFechaInicioImpuestos = By.xpath("//th[text()='FECHA INICIO DE IMPUESTOS']/following-sibling::td/a");
    public static By lnkModificarServicio = By.xpath("//th[text()='SERVICIO']/following-sibling::td/a");
    public static By btnAceptar = By.name("btnValidar");
}
