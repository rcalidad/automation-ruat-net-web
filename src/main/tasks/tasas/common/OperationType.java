package main.tasks.tasas.common;

import main.ui.tasasOtrosIngresosUI.liquidacionUI.DeudaUI;
import org.openqa.selenium.By;

import java.util.Map;

public class OperationType {
    public static String soloLiquidar = "SOLO LIQUIDAR";
    public static Map<String, By> operationType = Map.of("PROFORMA DETALLADA", DeudaUI.btnDetallada,
                                                         "PROFORMA RESUMIDA", DeudaUI.btnResumida);
}
