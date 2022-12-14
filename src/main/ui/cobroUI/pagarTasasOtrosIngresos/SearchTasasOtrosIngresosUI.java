package main.ui.cobroUI.pagarTasasOtrosIngresos;

import main.ui.tasasOtrosIngresosUI.liquidacionUI.ProformaUI;
import org.openqa.selenium.By;

import java.util.Map;

public class SearchTasasOtrosIngresosUI {
    public static By ttlBusquedaGeneral = By.xpath("//h2[text()='BUSQUEDA GENERAL']");
    public static By txtIdentificador = By.id("txtIdentificador");
    public static By rbtTasaOtroIngresoValorados = By.id("idTaoi");
    public static By rbtPuestoMercadoComercianteAsociacion = By.id("idMercado");
    public static By rbtSepulturaConcesionCementerio = By.id("idCementerio");
    public static By rbtArbitrioMunicipal = By.id("idArbitrio");
    public static By rbtPublicidadPermanente = By.id("idPublicidad");
    public static By rbtInfraccionesAutorizaciones = By.id("idInfracciones");
    public static By rbtPagoConjunto = By.id("idPagoConjunto");
    public static By lstGobiernoMunicipal = By.id("cbxAlcaldia");
    public static By btnBuscar = By.name("btnBuscar");

    public static Map<String, By> tasaType = Map.of("TO", rbtTasaOtroIngresoValorados,
            "ME", rbtPuestoMercadoComercianteAsociacion,
            "CE", rbtSepulturaConcesionCementerio,
            "AR", rbtArbitrioMunicipal,
            "PU", rbtPublicidadPermanente,
            "IM", rbtInfraccionesAutorizaciones);

}
