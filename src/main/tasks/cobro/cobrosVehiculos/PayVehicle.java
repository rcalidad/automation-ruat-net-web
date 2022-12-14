package main.tasks.cobro.cobrosVehiculos;

import com.aventstack.extentreports.ExtentTest;
import main.actions.GetText;
import main.actions.Log;
import main.helpers.common.vehiculos.ConstantsVEH;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.cobro.common.RecordPayment;
import main.tasks.cobro.common.SelectDebts;
import main.tasks.cobro.common.Verify;
import main.ui.cobroUI.commonUI.CommonElementsUI;
import main.ui.cobroUI.pagosVehiculosUI.DebtDetailUI;
import main.ui.cobroUI.commonUI.RecordPaymentUI;
import main.ui.cobroUI.pagosVehiculosUI.SearchVehicleUI;
import org.openqa.selenium.WebDriver;

public class PayVehicle {
    public static void now(WebDriver driver, ExtentTest extentTest, String identifier, String startYear, String endYear, String debtType, int numCase, String rubro){
        if (Verify.isReady(driver, extentTest, SearchVehicleUI.ttlBuscarVehiculo)){
            SearchVehicle.forPTA(driver, identifier);
            if (Verify.isReady(driver, extentTest, DebtDetailUI.ttlDetalleDeDeudas)){
                //Pay.allDebts(driver, extentTest);
                SelectDebts.ofVehicle(driver, extentTest, startYear, endYear, debtType, rubro);
                if (Verify.isReady(driver, extentTest, RecordPaymentUI.ttlRegistrarPagos)){
                    RecordPayment.now(driver, extentTest);
                    if (Verify.isReady(driver, extentTest, CommonElementsUI.ttlNotificacion)){
                        String message = GetText.ifContains(driver, CommonElementsUI.msgNotificacion, "pago");
                        Log.recordInLog(message);
                        FileBuilder.moveAndRenameFile("pago.pdf", "PAGAR", debtType, identifier, ConstantsVEH.ID_SUBSYSTEM, numCase);
                    }
                }
            }
        }
    }
}
