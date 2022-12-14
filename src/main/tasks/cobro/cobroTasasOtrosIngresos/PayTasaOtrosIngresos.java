package main.tasks.cobro.cobroTasasOtrosIngresos;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.common.tasas.ConstantsTOI;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.cobro.common.RecordPayment;
import main.tasks.cobro.common.SelectDebts;
import main.tasks.cobro.common.Verify;
import main.tasks.tasas.common.DebtType;
import main.ui.cobroUI.commonUI.CommonElementsUI;
import main.ui.cobroUI.commonUI.RecordPaymentUI;
import main.ui.cobroUI.pagarTasasOtrosIngresos.DebtDetailToiUI;
import main.ui.cobroUI.pagarTasasOtrosIngresos.SearchTasasOtrosIngresosUI;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PayTasaOtrosIngresos {
    public static void now(WebDriver driver, ExtentTest extentTest, String identifier, String town, String initialYear, String finalYear, String debtType, int numCase, String rubro, String tasaType){
        if (Verify.isReady(driver, extentTest, SearchTasasOtrosIngresosUI.ttlBusquedaGeneral)){
            SearchTasaOtroIngreso.forTasaType(driver, identifier, tasaType, town);
            if (Verify.isReady(driver, extentTest, DebtDetailToiUI.ttlDetalleDeudas, 60)){
                if (IsDisplayed.element(driver, DebtDetailToiUI.debtTable) || IsDisplayed.element(driver, DebtDetailToiUI.debtTableTOIM)){
                    if (tasaType.equals("IM") || tasaType.equals("TO")){
                        Scroll.toEndPage(driver);
                        Click.on(driver, DebtDetailToiUI.btnPagarTOIM);
                    }else{
                        List<WebElement> pages;
                        int nroDebtsChecked = 0;
                        try{
                            pages = driver.findElements(DebtDetailToiUI.paginador);
                        }catch (NoSuchElementException noSuchElementException){
                            pages = new ArrayList<>();
                        }
                        int nroPages = pages.size() == 0 ? 1 : pages.size() / 2;
                        String firstDebt = driver.findElement(DebtDetailToiUI.getCell(2,3)).getText();
                        boolean isThereOtherConcepts = false;
                        for (String concept : DebtType.otherConcepts){
                            if (firstDebt.contains(concept)){
                                Scroll.toEndPage(driver);
                                Click.on(driver, DebtDetailToiUI.btnPagar);
                                isThereOtherConcepts = true;
                                break;
                            }
                        }
                        if (!isThereOtherConcepts) {
                            if (nroPages > 1){
                                for (int p = 0; p < nroPages; p++){
                                    List<WebElement> page = pages = driver.findElements(DebtDetailToiUI.paginador);
                                    page.get(p).click();
                                    Scroll.toEndPage(driver);
                                    if (tasaType.equals("AR")){
                                        if (nroDebtsChecked < 10){
                                            nroDebtsChecked = SelectDebts.ofTasasArbitrios(driver, debtType, rubro, nroDebtsChecked);
                                        }else {
                                            break;
                                        }
                                    }else {
                                        SelectDebts.ofTasasOtrosIngresos(driver, initialYear, finalYear, debtType, rubro);
                                    }
                                }
                            }else {
                                Scroll.toEndPage(driver);
                                SelectDebts.ofTasasOtrosIngresos(driver, initialYear, finalYear, debtType, rubro);
                            }
                            Scroll.toEndPage(driver);
                            Click.on(driver, DebtDetailToiUI.btnPagar);
                        }
                    }
                    if (Verify.isReady(driver, extentTest, RecordPaymentUI.txtMontoEfectivo)){
                        RecordPayment.now(driver, extentTest);
                        if (Verify.isReady(driver, extentTest, CommonElementsUI.ttlNotificacion, 70)){
                            String message;
                            if (tasaType.equals("TO") || tasaType.equals("IM")){
                                message = GetText.ifContains(driver, CommonElementsUI.msgNotificacion, "pago");
                            }else {
                                message = GetText.ifContains(driver, CommonElementsUI.msgNotificacionTasas, "pago");
                            }
                            Log.recordInLog(message);
                            FileBuilder.moveAndRenameFile("pago.pdf", "PAGAR", debtType, identifier, ConstantsTOI.SUBSYSTEM_ID, numCase);
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
