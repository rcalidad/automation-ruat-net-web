package main.tasks.inmuebles.empadronamiento;

import main.actions.*;
import main.ui.inmueblesUI.empadronamientoUI.DatosTerrenoUI;
import org.openqa.selenium.WebDriver;

public class AreaData {
    public static void fillAreaData(WebDriver driver, String year, String area){
        Enter.text(driver, DatosTerrenoUI.txtGestion, year);
        Enter.text(driver, DatosTerrenoUI.txtSuperficie, area);
        if (IsDisplayed.element(driver, DatosTerrenoUI.rbtM2)){
            Click.on(driver, DatosTerrenoUI.rbtM2);
        }
        if (IsDisplayed.element(driver, DatosTerrenoUI.lstTaxArea)){
            SelectOption.nonEmptyRandomValue(driver, DatosTerrenoUI.lstTaxArea);
        }
        SelectOption.waitUntilLoadOptions(driver, DatosTerrenoUI.lstInclinacion);
        SelectOption.nonEmptyRandomValue(driver, DatosTerrenoUI.lstInclinacion);
        SelectOption.nonEmptyRandomValue(driver, DatosTerrenoUI.lstMaterialVia);
        SelectOption.nonEmptyRandomValue(driver, DatosTerrenoUI.lstInclinacionTerreno);
    }
    public static void selectAllServices(WebDriver driver){
        Click.on(driver, DatosTerrenoUI.chkTodosLosServicios);
    }
    public static void recordData(WebDriver driver, int numBuilds){
        Scroll.toEndPage(driver);
        Click.on(driver, DatosTerrenoUI.btnAceptar);
        if (WaitUntilAlert.isPresent(driver, 1)){
            String message = DisplayAlert.getText(driver);
            if(message.contains("registrar")){
                if (numBuilds > 0){
                    DisplayAlert.toAcept(driver);
                }else {
                    DisplayAlert.cancel(driver);
                }
            }
        }
    }
}
