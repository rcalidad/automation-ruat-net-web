package main.tasks.vehiculos.commonVeh;

import main.ui.vehiculosUI.modificarDatosTecnicosOperadorUI.SeleccionarModificacionUI;
import org.openqa.selenium.By;

import java.util.Map;

public class ModificationOption {
    public static Map<String, By> modificationOption = Map.of("MODIFICAR FECHA INICIO DE IMPUESTOS", SeleccionarModificacionUI.lnkModificarFechaInicioImpuestos,
                                                              "MODIFICAR SERVICIO", SeleccionarModificacionUI.lnkModificarServicio);
}
