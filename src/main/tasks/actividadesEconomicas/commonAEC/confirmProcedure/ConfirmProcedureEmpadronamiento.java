package main.tasks.actividadesEconomicas.commonAEC.confirmProcedure;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.GetText;
import main.actions.WaitUntilElement;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.common.vehiculos.ConstantsVEH;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.empadronamientoUI.ConfirmProcedureUI;
import main.ui.actividadesEconomicasUI.empadronamientoUI.ConfirmRecordUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmProcedureEmpadronamiento implements IConfirmProcedure{
    private WebDriver localDriver;
    private ExtentTest localExtentTest;

    public ConfirmProcedureEmpadronamiento(){

    }
    public static boolean getReport(WebDriver driver, String originalFilename, String operation, String identifier, int index, By locator){
        //WaitUntilElement.isClikeableOf(driver, locator);
        //Click.on(driver, locator);
        return FileBuilder.moveAndRenameFile(originalFilename, operation, GetText.ofValue(driver, locator).trim(), identifier, ConstantsAEC.SUBSYSTEM_ID, index);
    }
    @Override
    public void setDriver(WebDriver driver, ExtentTest extentTest) {
        this.localDriver = driver;
        this.localExtentTest = extentTest;
    }

    @Override
    public void now(String identifier, int index) {
        try {
            Verify.isReady(localDriver, localExtentTest, ConfirmProcedureUI.ttlConfirmarTramite);
            Click.on(localDriver, ConfirmProcedureUI.btnVistaPrevia); //reportePDF.pdf
            getReport(localDriver, "reportePDF.pdf", "EMPADRONAMIENTO", identifier, index, ConfirmProcedureUI.btnVistaPrevia);
            WaitUntilElement.isClikeableOf(localDriver, ConfirmProcedureUI.btnGrabar);
            Click.on(localDriver, ConfirmProcedureUI.btnGrabar);
            VerifyAlert.containsThisText(localDriver, "correctamente");
            WaitUntilElement.isClikeableOf(localDriver, ConfirmProcedureUI.btnGenerarReporte);
            Click.on(localDriver, ConfirmProcedureUI.btnGenerarReporte); //reportePDF.pdf
            getReport(localDriver, "reportePDF.pdf", "EMPADRONAMIENTO", identifier, index, ConfirmProcedureUI.btnGenerarReporte);
            Click.on(localDriver, ConfirmProcedureUI.btnSalir);
        }catch (Exception exception){

        }
    }
}
