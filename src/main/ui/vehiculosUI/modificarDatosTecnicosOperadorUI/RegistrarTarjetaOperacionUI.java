package main.ui.vehiculosUI.modificarDatosTecnicosOperadorUI;

import org.openqa.selenium.By;

public class RegistrarTarjetaOperacionUI {
    public static By ttlRegistrarTarjetaOperacion = By.xpath("//h2[text()='REGISTRAR TARJETA OPERACION']");
    public static By txtInstitucionEmisor = By.id("institucion");
    public static By txtTipoTarjetaOperacion = By.id("tipoTarjeta");
    public static By txtNombreAutoridadEmisora = By.id("txtAutoridad");
    public static By txtNumeroTarjeta = By.id("txtnumTarjeta");
    public static By txtFechaInicio = By.id("txtFechaIni");
    public static By txtFechaFin = By.id("txtFechaFin");
    public static By btnAceptar = By.name("btnAceptar");
}
