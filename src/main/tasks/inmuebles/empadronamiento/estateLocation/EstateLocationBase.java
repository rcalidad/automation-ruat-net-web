package main.tasks.inmuebles.empadronamiento.estateLocation;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.empadronamientoUI.UbicacionInmuebleUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class EstateLocationBase {
    public abstract void  defineRandomLocation(WebDriver driver, ExtentTest extentTest, String estateType);

    public void defineBuildingData(WebDriver driver){
        //if (IsDisplayed.element(driver, UbicacionInmuebleUI.txtNombreEdificio, 1)){
        Scroll.toElement(driver, UbicacionInmuebleUI.txtNombreEdificio);
        Enter.text(driver, UbicacionInmuebleUI.txtNombreEdificio, MessagesINM.testText);
        Enter.text(driver, UbicacionInmuebleUI.txtPiso, "12");
        selectRandomOption(driver, UbicacionInmuebleUI.lstTipoUnidadFuncional);
        Enter.text(driver, UbicacionInmuebleUI.txtNumeroUnidadFuncional, "2");
        //}
    }
    public static void recordData(WebDriver driver, ExtentTest extentTest){
        Scroll.toEndPage(driver);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Datos de ubicación.");
        Click.on(driver, UbicacionInmuebleUI.btnAceptar);
    }
    public void selectRandomOption(WebDriver driver, By locator){
        SelectOption.waitUntilLoadOptions(driver, locator, 1);
        SelectOption.nonEmptyRandomValue(driver, locator);
    }
}
