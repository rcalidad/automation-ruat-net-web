package main.tasks.vehiculos.commonVeh;

import com.aventstack.extentreports.ExtentTest;
import main.actions.*;
import main.ui.vehiculosUI.commonUI.SeleccionarModificacionUI;
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
