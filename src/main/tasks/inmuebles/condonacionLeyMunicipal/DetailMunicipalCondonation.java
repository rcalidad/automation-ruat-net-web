package main.tasks.inmuebles.condonacionLeyMunicipal;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.inmuebles.commonInm.SelectRows;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.commonInm.detalleOperacion.ExecuteOperationOnTable;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import main.ui.inmueblesUI.condonacionLeyMunicipalUI.DetalleCondonacionUI;
import org.openqa.selenium.WebDriver;

public class DetailMunicipalCondonation {
    public static void selectMunicipalLaw(WebDriver driver, String municipalLaw){
        SelectOption.byText(driver, DetalleCondonacionUI.lstLeyMunicipal, municipalLaw);
        //Click.on(driver, DetalleCondonacionUI.btnAceptar);
    }
    public static boolean selectOperation(WebDriver driver, ExtentTest extentTest, IPeriodTable table, int row, String operation){
        if (IsPresent.elements(driver, DetalleCondonacionUI.tblDatosCondonacion)){
            boolean isGetIntoOperation = ExecuteOperationOnTable.getIntoOperation(driver, table, operation, row);
            Verify.partialObservations(driver, extentTest);
            if (isGetIntoOperation == false){
                isGetIntoOperation = ExecuteOperationOnTable.getIntoOperation(driver, table, "Modificar", row);
                Verify.partialObservations(driver, extentTest);
            }
            return isGetIntoOperation;
        }
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, MessagesINM.operationUnavailable);
        return false;
    }
    public static void selectCondonation(WebDriver driver, ExtentTest extentTest, IPeriodTable table, String operation, String range, String initialYear, String finalYear){
        if (IsPresent.elements(driver, DetalleCondonacionUI.tblDetalleCondonacion)){
            Scroll.toElement(driver, DetalleCondonacionUI.tblDetalleCondonacion);
            SelectRows.byOperationConsideringCombinedCells(driver, table, operation, range, initialYear, finalYear);
        }
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, MessagesINM.selectedItems);
    }
    public static void process(WebDriver driver, ExtentTest extentTest, String operation){
        Scroll.toEndPage(driver);
        if (IsDisplayed.element(driver, DetalleCondonacionUI.btnProcesar)){
            Click.on(driver, DetalleCondonacionUI.btnProcesar);
            Verify.partialObservations(driver, extentTest);
            switch (operation){
                case "REGISTRAR":
                    RegisterCondonation.now(driver);
                    break;
                case "MODIFICAR":
                    AnnulCondonation.fromModification(driver, extentTest);
                    break;
                case "ANULAR":
                    AnnulCondonation.fromModification(driver, extentTest);
                    //procedure.annul(driver, extentTest, data);
                    break;
                default:
                    break;
            }
        }
    }
    public static void record(WebDriver driver){
        Scroll.toEndPage(driver);
        if (IsDisplayed.element(driver, DetalleCondonacionUI.btnAceptar)){
            Click.on(driver, DetalleCondonacionUI.btnAceptar);
        }
    }
}
