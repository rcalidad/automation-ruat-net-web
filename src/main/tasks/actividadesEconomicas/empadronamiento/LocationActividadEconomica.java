package main.tasks.actividadesEconomicas.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.IsDisplayed;
import main.actions.SelectOption;
import main.ui.actividadesEconomicasUI.empadronamientoUI.LocationActividadEconomicaUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationActividadEconomica {
    public static void register(WebDriver driver, String area){
        Click.on(driver, LocationActividadEconomicaUI.municipalArea.get(area));
        if(IsDisplayed.element(driver, LocationActividadEconomicaUI.lstZona)){
            SelectOption.firstOptionDifferentOfEmpty(driver, LocationActividadEconomicaUI.lstZona);
            SelectOption.waitUntilLoadOptions(driver, LocationActividadEconomicaUI.lstUnidadVecinal);
            SelectOption.firstOptionDifferentOfEmpty(driver, LocationActividadEconomicaUI.lstUnidadVecinal);
            SelectOption.waitUntilLoadOptions(driver, LocationActividadEconomicaUI.lstBarrio);
            SelectOption.firstOptionDifferentOfEmpty(driver, LocationActividadEconomicaUI.lstBarrio);
            SelectOption.waitUntilLoadOptions(driver, LocationActividadEconomicaUI.lstManzano);
            SelectOption.firstOptionDifferentOfEmpty(driver, LocationActividadEconomicaUI.lstManzano);
            SelectOption.waitUntilLoadOptions(driver, LocationActividadEconomicaUI.lstTipoLugar);
            SelectOption.firstOptionDifferentOfEmpty(driver, LocationActividadEconomicaUI.lstTipoLugar);
            SelectOption.waitUntilLoadOptions(driver, LocationActividadEconomicaUI.lstNombreLugar);
            SelectOption.firstOptionDifferentOfEmpty(driver, LocationActividadEconomicaUI.lstNombreLugar);
            Click.on(driver, LocationActividadEconomicaUI.chkSinNumeroPuerta);
            Click.on(driver, LocationActividadEconomicaUI.btnAceptar);
        }
    }
}
