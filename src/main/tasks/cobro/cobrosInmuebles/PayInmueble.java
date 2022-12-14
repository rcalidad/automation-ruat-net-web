package main.tasks.cobro.cobrosInmuebles;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.actions.GetText;
import main.actions.IsDisplayed;
import main.actions.Log;
import main.helpers.common.Inmuebles.ConstantsINM;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.cobro.common.RecordPayment;
import main.tasks.cobro.common.SelectDebts;
import main.tasks.cobro.common.Verify;
import main.ui.cobroUI.commonUI.CommonElementsUI;
import main.ui.cobroUI.pagarInmuebleUI.DebtDetailInmUI;
import main.ui.cobroUI.pagarInmuebleUI.SearchInmuebleUI;
import main.ui.cobroUI.commonUI.RecordPaymentUI;
import org.openqa.selenium.WebDriver;

public class PayInmueble {
    public static void now(WebDriver driver, ExtentTest extentTest, String identifier, String town, String initialYear, String finalYear, String debtType, int numCase, String rubro){
        if (Verify.isReady(driver, extentTest, SearchInmuebleUI.ttlBusquedaInmueble)){
            SearchInmueble.forNumeroInmueble(driver, identifier, town);
            if (Verify.isReady(driver, extentTest, DebtDetailInmUI.ttlDetalleDeudas)){
                if(IsDisplayed.element(driver, DebtDetailInmUI.debtTable)){
                    SelectDebts.ofInmueble(driver, initialYear, finalYear, debtType, rubro);
                    Click.on(driver, DebtDetailInmUI.btnPagar);
                    if (Verify.isReady(driver, extentTest, RecordPaymentUI.ttlRegistrarPagos)){
                        RecordPayment.now(driver, extentTest);
                        if (Verify.isReady(driver, extentTest, CommonElementsUI.ttlNotificacion)){
                            String message = GetText.ifContains(driver, CommonElementsUI.msgNotificacion, "pago");
                            Log.recordInLog(message);
                            FileBuilder.moveAndRenameFile("pago.pdf", "PAGAR", debtType, identifier, ConstantsINM.SUBSYSTEM_ID, numCase);
                        }
                    }
                }else {
                    ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "El objeto tributario tiene observaciones");
                    Log.recordInLog("El objeto tributario tiene observaciones");
                }
            }
        }
    }
}
