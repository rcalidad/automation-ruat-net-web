package main.tasks.actividadesEconomicas.compensaciones;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.compensacionesUI.VerifyCompensationUI;
import org.openqa.selenium.WebDriver;

public class VerifyCompensation {
    public static void now(WebDriver driver, ExtentTest extentTest){
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Verificación de Compensación...");
        Click.on(driver, VerifyCompensationUI.btnCompensar);
        VerifyAlert.containsThisText(driver, "seguro");
    }
}
