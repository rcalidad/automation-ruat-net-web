package main.tasks.inmuebles.prescripcionNormal;

import main.actions.Click;
import main.actions.IsDisplayed;
import main.actions.Scroll;
import main.tasks.inmuebles.commonInm.SelectRows;
import main.ui.inmueblesUI.prescripcionNormalUI.DetalleGestionesUI;
import org.openqa.selenium.WebDriver;

public class ProcessPrescription {
    public static void byOperation(WebDriver driver, String operation, String range, String initialYear, String finalYear){
        Scroll.toElement(driver, DetalleGestionesUI.table);
        SelectRows.byOperation(driver, DetalleGestionesUI.tablaDetalleGestiones, operation, range, initialYear, finalYear);
        Scroll.toEndPage(driver);
        Click.on(driver,DetalleGestionesUI.btnProcesar);
    }

    public static void recordOperation(WebDriver driver){
        Scroll.toEndPage(driver);
        if (IsDisplayed.element(driver, DetalleGestionesUI.btnTerminar)){
            Click.on(driver, DetalleGestionesUI.btnTerminar);
        }
    }
}
