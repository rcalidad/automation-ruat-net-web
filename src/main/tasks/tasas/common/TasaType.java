package main.tasks.tasas.common;

import main.ui.tasasOtrosIngresosUI.liquidacionUI.ProformaUI;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class TasaType {
    public static Map<String, By> tasaType = Map.of("TO", ProformaUI.rbtTasaOtroIngresoValorados,
                                                    "ME", ProformaUI.rbtPuestoMercadoComercianteAsociacion,
                                                    "CE", ProformaUI.rbtSepulturaConcesionCementerio,
                                                    "AR", ProformaUI.rbtArbitrioMunicipal,
                                                    "PU", ProformaUI.rbtPublicidadPermanente,
                                                    "IM", ProformaUI.rbtInfraccionesAutorizaciones);
}
