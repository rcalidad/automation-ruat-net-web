package main.tasks.cobro.loteoInmuebles;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.helpers.common.Inmuebles.ConstantsINM;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.cobro.common.Verify;
import main.tasks.commonTasks.CloseChildWindows;
import main.ui.cobroUI.loteoUI.LoteoInmueblesUI;
import org.openqa.selenium.WebDriver;

public class LoteoInmuebles {
    public static void now(WebDriver driver, ExtentTest extentTest, int numCase){
        if (Verify.isReady(driver, extentTest, LoteoInmueblesUI.btnImprimir)){
            String originalWindow = driver.getWindowHandle();
            Click.on(driver, LoteoInmueblesUI.btnImprimir);
            if (Verify.isReady(driver, extentTest, LoteoInmueblesUI.msgFinalizo)){
                FileBuilder.moveAndRenameFile("reporte.pdf", "LOTEO", "INMUEBLES", "REPORTE", ConstantsINM.SUBSYSTEM_ID, numCase);
                CloseChildWindows.now(driver, originalWindow);
            }
        }
    }
}
