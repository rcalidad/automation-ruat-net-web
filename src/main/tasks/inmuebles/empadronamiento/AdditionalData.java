package main.tasks.inmuebles.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Clear;
import main.actions.Click;
import main.actions.Enter;
import main.actions.SelectOption;
import main.helpers.dataUtility.ScreenShotHelper;
import main.ui.inmueblesUI.empadronamientoUI.DatosAdicionalesUI;
import org.openqa.selenium.WebDriver;

public class AdditionalData {
    public static void fillDefaultData(WebDriver driver, ExtentTest extentTest){
        //Clear.on(driver, DatosAdicionalesUI.txtNumeroDocumento, 1);
        Enter.text(driver, DatosAdicionalesUI.txtNumeroDocumento, "12345");
        SelectOption.waitUntilLoadOptions(driver, DatosAdicionalesUI.lstInstrumento, 1);
        SelectOption.firstOptionDifferentOfEmpty(driver, DatosAdicionalesUI.lstInstrumento);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Datos adicionales");
        Click.on(driver, DatosAdicionalesUI.btnAceptar);
    }
}
