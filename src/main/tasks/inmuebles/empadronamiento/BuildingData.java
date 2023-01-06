package main.tasks.inmuebles.empadronamiento;

import main.actions.Click;
import main.actions.Enter;
import main.actions.IsDisplayed;
import main.actions.SelectOption;
import main.ui.inmueblesUI.empadronamientoUI.DatosConstruccionUI;
import org.openqa.selenium.WebDriver;

public class BuildingData {
    public static void addConstructionData(WebDriver driver, String block, String year, String buildYear, String area, String buildType, String taxArea){
        Enter.text(driver, DatosConstruccionUI.txtBloque, block);
        Enter.text(driver, DatosConstruccionUI.txtGestion, year);
        Enter.text(driver, DatosConstruccionUI.txtAnioConstruccion, buildYear);
        Enter.text(driver, DatosConstruccionUI.txtSuperficie, area);
        SelectOption.byText(driver, DatosConstruccionUI.lstTipoConstruccion, buildType);
        if (IsDisplayed.element(driver, DatosConstruccionUI.lstZonaTributaria)){
            SelectOption.byText(driver, DatosConstruccionUI.lstZonaTributaria, taxArea);
        }

    }
    public static void record(WebDriver driver){
        Click.on(driver, DatosConstruccionUI.btnAceptar);
    }
}
