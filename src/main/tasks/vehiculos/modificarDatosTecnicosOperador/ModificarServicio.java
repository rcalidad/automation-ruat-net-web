package main.tasks.vehiculos.modificarDatosTecnicosOperador;

import com.aventstack.extentreports.ExtentTest;
import main.actions.*;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.modificarDatosTecnicosOperadorUI.ModificarServicioUI;
import org.openqa.selenium.WebDriver;

public class ModificarServicio {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, ModificarServicioUI.ttlModificarServicio);
    }
    public static void toParticular(WebDriver driver, String initialDate, String option){
        Log.recordInLog("Modificando servicio: Particular...");
        Scroll.toEndPage(driver);
        SelectOption.byText(driver, ModificarServicioUI.lstServicio, option);
        //Enter.text(driver, ModificarServicioUI.txtFechaInicio, initialDate);
        Enter.dateByElementId(driver, ModificarServicioUI.txtFechaInicio, initialDate);
        Click.on(driver, ModificarServicioUI.btnAceptar);
    }
    public static void toOfficial(WebDriver driver, String initialDate, String option){
        Log.recordInLog("Modificando servicio: Oficial...");
        Scroll.toTopPage(driver);
        SelectOption.byText(driver, ModificarServicioUI.lstServicio, option);
        //Enter.text(driver, ModificarServicioUI.txtFechaInicio, option);
        Enter.dateByElementId(driver, ModificarServicioUI.txtFechaInicio, initialDate);
        Click.on(driver, ModificarServicioUI.btnAceptar);
    }
    public static void toPublic(WebDriver driver, ExtentTest extentTest, String option, String nroCard, String initialDate, String finalDate){
        Log.recordInLog("Modificando servicio: P�blico...");
        Scroll.toEndPage(driver);
        SelectOption.byText(driver, ModificarServicioUI.lstServicio, option);
        Click.on(driver, ModificarServicioUI.btnAceptar);
        RegistrarTarjetaOperacion.isReady(driver, extentTest);
        RegistrarTarjetaOperacion.fillForm(driver, nroCard, initialDate, finalDate);
    }

}