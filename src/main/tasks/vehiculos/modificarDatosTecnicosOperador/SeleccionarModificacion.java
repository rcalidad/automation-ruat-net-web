package main.tasks.vehiculos.modificarDatosTecnicosOperador;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.vehiculos.commonVeh.ModificationOption;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import main.ui.vehiculosUI.modificarDatosTecnicosOperadorUI.SeleccionarModificacionUI;
import org.openqa.selenium.WebDriver;

public class SeleccionarModificacion {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest,SeleccionarModificacionUI.ttlSeleccionarModificacion);
    }
    public static void option(WebDriver driver, String modificationOption){
        String locator = ModificationOption.modificationOption.get(modificationOption).toString();
        Click.on(driver, ModificationOption.modificationOption.get(modificationOption));
    }
}
