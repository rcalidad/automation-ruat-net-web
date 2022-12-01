package main.tasks.vehiculos.commonVeh;

import main.ui.vehiculosUI.commonUI.SeleccionarModificacionUI;
import org.openqa.selenium.By;

import java.util.Map;

public class ModificationOption {
    public static Map<String, By> modificationOption = Map.of("MODIFICAR FECHA INICIO DE IMPUESTOS", SeleccionarModificacionUI.lnkModificarFechaInicioImpuestos,
                                                              "MODIFICAR SERVICIO", SeleccionarModificacionUI.lnkModificarServicio,
                                                              "MODIFICAR DATOS TECNICOS", SeleccionarModificacionUI.lnkModificarDatosTecnicos,
                                                              "MODIFICAR DATOS TESTIMONIO", SeleccionarModificacionUI.lnkModificarDatosTestimonio,
                                                              "MODIFICAR DATOS MINUTA", SeleccionarModificacionUI.lnkModificarDatosMinuta);

    public static Map<String, String> modificationProcess = Map.of("MODIFICAR FECHA INICIO DE IMPUESTOS", "modifyTaxStartDate",
                                                                   "MODIFICAR SERVICIO", "modifyService",
                                                                   "MODIFICAR DATOS TECNICOS", "modifyTechnicalData",
                                                                   "MODIFICAR DATOS MINUTA", "modifyMinuteData");
}
