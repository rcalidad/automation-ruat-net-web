package main.tasks.cobro.cobroActividadesEconomicas;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.actions.GetText;
import main.actions.IsDisplayed;
import main.actions.Log;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.cobro.common.SelectDebts;
import main.tasks.cobro.common.RecordPayment;
import main.tasks.cobro.common.Verify;
import main.tasks.commonTasks.CloseChildWindows;
import main.ui.cobroUI.commonUI.CommonElementsUI;
import main.ui.cobroUI.commonUI.RecordPaymentUI;
import main.ui.cobroUI.pagarActividadesEconomicasUI.DebtDetailAecUI;
import main.ui.cobroUI.pagarActividadesEconomicasUI.SearchActividadesEconomicasUI;
import org.openqa.selenium.WebDriver;

public class PayActividadEconomica {
    public static void now(WebDriver driver, ExtentTest extentTest, String identifier, String town, String initialYear, String endYear, String debtType, int numCase, String rubro){
        if (Verify.isReady(driver,extentTest, SearchActividadesEconomicasUI.ttlBuscarActividadesEconomicas)){
            //SearchActividadEconomica.forLicencia(driver, identifier, town);
            SearchActividadEconomica.forNumeroActividad(driver, identifier, town);
            if (Verify.isReady(driver, extentTest, DebtDetailAecUI.ttlDetallDeudas)){
                if (IsDisplayed.element(driver, DebtDetailAecUI.debtTable)){
                    SelectDebts.ofActividadEconomica(driver, initialYear, endYear, debtType, rubro);
                    Click.on(driver, DebtDetailAecUI.btnPagar);
                    if (Verify.isReady(driver, extentTest, RecordPaymentUI.txtMontoEfectivo)){
                        String originalWindow = driver.getWindowHandle();
                        RecordPayment.now(driver, extentTest);
                        if(Verify.isReady(driver, extentTest, CommonElementsUI.msgNotificacion)){
                            String message = GetText.ifContains(driver, CommonElementsUI.msgNotificacion, "pago");
                            Log.recordInLog(message);
                            FileBuilder.moveAndRenameFile("pago.pdf", "PAGAR", debtType, identifier, ConstantsAEC.SUBSYSTEM_ID, numCase);
                            CloseChildWindows.now(driver, originalWindow);
                        }
                    }
                } else {
                    ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "El objeto tributario tiene observaciones");
                    Log.recordInLog("El objeto tributario tiene observaciones");
                }
            }
        }
    }
}
