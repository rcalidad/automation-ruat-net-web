package main.tasks.inmuebles.empadronamiento;

import main.actions.*;
import main.ui.inmueblesUI.empadronamientoUI.DatosTerrenoUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AreaData {
    public static void fillAreaData(WebDriver driver, String year, String area){
        Enter.text(driver, DatosTerrenoUI.txtGestion, year);
        Enter.text(driver, DatosTerrenoUI.txtSuperficie, area);
        if (IsDisplayed.element(driver, DatosTerrenoUI.rbtM2, 1)){
            Click.on(driver, DatosTerrenoUI.rbtM2);
        }
        if (IsDisplayed.element(driver, DatosTerrenoUI.lstTaxArea, 1)){
            if (IsClickable.element(driver, DatosTerrenoUI.lstTaxArea, 1)){
                SelectOption.nonEmptyRandomValue(driver, DatosTerrenoUI.lstTaxArea);
            }
        }
        SelectOption.waitUntilLoadOptions(driver, DatosTerrenoUI.lstInclinacion, 1);
        SelectOption.nonEmptyRandomValue(driver, DatosTerrenoUI.lstInclinacion);
        SelectOption.nonEmptyRandomValue(driver, DatosTerrenoUI.lstMaterialVia);
        if (IsDisplayed.element(driver, DatosTerrenoUI.lstInclinacionTerreno, 1)){
            SelectOption.nonEmptyRandomValue(driver, DatosTerrenoUI.lstInclinacionTerreno);
        }
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
