package main.tasks.cobro.loteoVehiculos;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.WaitUntilElement;
import main.helpers.common.vehiculos.ConstantsVEH;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.cobro.common.Verify;
import main.ui.cobroUI.loteoUI.LoteoVehiculosUI;
import org.openqa.selenium.WebDriver;

public class LoteoVehiculos {
    public static boolean toOneVehicleFlow(WebDriver driver){
        Click.on(driver, LoteoVehiculosUI.btnImprimir);
        return WaitUntilElement.isElementVisible(driver, LoteoVehiculosUI.msgFinalizo);
    }
    public static void now(WebDriver driver, ExtentTest extentTest, int numCase){
        if (Verify.isReady(driver, extentTest, LoteoVehiculosUI.btnImprimir)){
            Click.on(driver, LoteoVehiculosUI.btnImprimir);
            if (Verify.isReady(driver, extentTest, LoteoVehiculosUI.msgFinalizo)){
                FileBuilder.moveAndRenameFile("reporte.pdf", "LOTEO", "VEHICULOS", "REPORTE", ConstantsVEH.ID_SUBSYSTEM, numCase);
            }
        }
    }
}
