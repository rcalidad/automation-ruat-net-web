package main.tasks.inmuebles.empadronamiento;

import main.actions.Click;
import main.actions.IsDisplayed;
import main.ui.inmueblesUI.empadronamientoUI.DatosConstruccionesUI;
import org.openqa.selenium.WebDriver;

public class BuildingsData {
    public static boolean addBuildingDetails(WebDriver driver){
        if (IsDisplayed.element(driver, DatosConstruccionesUI.lnkAdicionarDetalleConstrucciones)){
            Click.on(driver, DatosConstruccionesUI.lnkAdicionarDetalleConstrucciones);
            return true;
        }
        return false;
    }
    public static boolean addCommonAreasDetail(WebDriver driver){
        if (IsDisplayed.element(driver, DatosConstruccionesUI.lnkAdicionarDetalleAreasComunes)){
            Click.on(driver, DatosConstruccionesUI.lnkAdicionarDetalleConstrucciones);
            return true;
        }
        return false;
    }
    public static void recordData(WebDriver driver){
        Click.on(driver, DatosConstruccionesUI.btnAceptar);
    }
}
