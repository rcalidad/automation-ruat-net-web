package main.tasks.cobro.loteoActividadesEconomicas;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.cobro.common.Verify;
import main.ui.cobroUI.loteoUI.LoteoActividadesEconomicasUI;
import org.openqa.selenium.WebDriver;

public class LoteoActividadesEconomicas {
    public static void now(WebDriver driver, ExtentTest extentTest, int numCase){
        if (Verify.isReady(driver, extentTest, LoteoActividadesEconomicasUI.btnImprimir)){
            Click.on(driver, LoteoActividadesEconomicasUI.btnImprimir);
            if (Verify.isReady(driver, extentTest, LoteoActividadesEconomicasUI.msgFinalizo)){
                FileBuilder.moveAndRenameFile("reporte.pdf", "LOTEO", "ACTIVIDADES-ECONOMICAS", "REPORTE", ConstantsAEC.SUBSYSTEM_ID, numCase);
            }
        }
    }
}
