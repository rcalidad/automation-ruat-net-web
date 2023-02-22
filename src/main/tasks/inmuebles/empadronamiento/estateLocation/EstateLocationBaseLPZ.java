package main.tasks.inmuebles.empadronamiento.estateLocation;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.empadronamientoUI.UbicacionInmuebleUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EstateLocationBaseLPZ extends EstateLocationBase {
    public EstateLocationBaseLPZ(){

    }
    public static EstateLocationBaseLPZ getInstance(){
        EstateLocationBaseLPZ object = new EstateLocationBaseLPZ();
        return object;
    }

    @Override
    public void defineRandomLocation(WebDriver driver, ExtentTest extentTest, String estateType) {
        selectRandomOption(driver, UbicacionInmuebleUI.lstMacroDistrito);
        selectRandomOption(driver, UbicacionInmuebleUI.lstDistrito);
        selectRandomOption(driver, UbicacionInmuebleUI.lstZonaBarrio);
        selectRandomOption(driver, UbicacionInmuebleUI.lstTipoLugar);
        selectRandomOption(driver, UbicacionInmuebleUI.lstNombreLugar);
        Click.on(driver, UbicacionInmuebleUI.chkSinNumero);
        Enter.text(driver, UbicacionInmuebleUI.txtDireccionDescriptiva, MessagesINM.testText);
        if (estateType.equalsIgnoreCase("PROPIEDAD HORIZONTAL")){
            defineBuildingData(driver);
        }
        Scroll.toEndPage(driver);
        if (IsDisplayed.element(driver, UbicacionInmuebleUI.chkSinDato, 1)){
            Click.on(driver, UbicacionInmuebleUI.chkSinDato);
        }
        if (IsDisplayed.element(driver, UbicacionInmuebleUI.rbtSi, 1)){
            Click.on(driver, UbicacionInmuebleUI.domicilioGeoreferenciado.get("NO"));
        }
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Datos de ubicación.");
        Click.on(driver, UbicacionInmuebleUI.btnAceptar);
    }
}
