package main.tasks.cobro.loteoTasasOtrosIngresos;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.helpers.common.tasas.ConstantsTOI;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.cobro.common.Verify;
import main.tasks.commonTasks.CloseChildWindows;
import main.ui.cobroUI.loteoUI.LoteoTasasOtrosIngresosUI;
import org.openqa.selenium.WebDriver;

public class LoteoTasasOtrosIngresos {
    public static void now(WebDriver driver, ExtentTest extentTest, int numCase){
        if (Verify.isReady(driver, extentTest, LoteoTasasOtrosIngresosUI.btnImprimir)){
            String originalWindow = driver.getWindowHandle();
            Click.on(driver, LoteoTasasOtrosIngresosUI.btnImprimir);
            if (Verify.isReady(driver, extentTest, LoteoTasasOtrosIngresosUI.msgFinalizo)){
                FileBuilder.moveAndRenameFile("reporte.pdf", "LOTEO", "TASAS", "REPORTE", ConstantsTOI.SUBSYSTEM_ID, numCase);
                CloseChildWindows.now(driver, originalWindow);
            }
        }
    }
}
