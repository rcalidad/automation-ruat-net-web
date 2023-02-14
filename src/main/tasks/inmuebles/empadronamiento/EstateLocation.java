package main.tasks.inmuebles.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.empadronamientoUI.UbicacionInmuebleUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EstateLocation {
    public static void defineRandomLocation(WebDriver driver, ExtentTest extentTest){
        if (IsDisplayed.element(driver, UbicacionInmuebleUI.lstMacroDistrito)){
            SelectOption.nonEmptyRandomValue(driver, UbicacionInmuebleUI.lstMacroDistrito);
        }
        selectRandomOption(driver, UbicacionInmuebleUI.lstDistrito);
        if (IsPresent.elements(driver, UbicacionInmuebleUI.lstZonaBarrio)){
            selectRandomOption(driver, UbicacionInmuebleUI.lstZonaBarrio);
        }
        if (IsPresent.elements(driver, UbicacionInmuebleUI.lstZonaComunidad)){
            selectRandomOption(driver, UbicacionInmuebleUI.lstZonaComunidad);
        }
        selectRandomOption(driver, UbicacionInmuebleUI.lstTipoLugar);
        selectRandomOption(driver, UbicacionInmuebleUI.lstNombreLugar);
        Click.on(driver, UbicacionInmuebleUI.chkSinNumero);
        Clear.on(driver, UbicacionInmuebleUI.txtDireccionDescriptiva, 1);
        Enter.text(driver, UbicacionInmuebleUI.txtDireccionDescriptiva, MessagesINM.testText);
        if (IsDisplayed.element(driver, UbicacionInmuebleUI.txtNombreEdificio)){
            Scroll.toElement(driver, UbicacionInmuebleUI.txtNombreEdificio);
            Enter.text(driver, UbicacionInmuebleUI.txtNombreEdificio, MessagesINM.testText);
            Enter.text(driver, UbicacionInmuebleUI.txtPiso, "12");
            SelectOption.nonEmptyRandomValue(driver, UbicacionInmuebleUI.lstTipoUnidadFuncional);
            Enter.text(driver, UbicacionInmuebleUI.txtNumeroUnidadFuncional, "2");
        }
        Scroll.toEndPage(driver);
        if (IsDisplayed.element(driver, UbicacionInmuebleUI.chkSinDato)){
            Click.on(driver, UbicacionInmuebleUI.chkSinDato);
        }
        if (IsPresent.elements(driver, UbicacionInmuebleUI.rbtSi)){
            Click.on(driver, UbicacionInmuebleUI.domicilioGeoreferenciado.get("NO"));
        }
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Datos de ubicación.");
        Click.on(driver, UbicacionInmuebleUI.btnAceptar);
    }
    public static void selectRandomOption(WebDriver driver, By locator){
        SelectOption.waitUntilLoadOptions(driver, locator);
        SelectOption.nonEmptyRandomValue(driver, locator);
    }
}
