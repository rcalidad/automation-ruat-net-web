package main.tasks.actividadesEconomicas.commonAEC.confirmProcedure;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.GetText;
import main.actions.WaitUntilElement;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI.ConfirmProcedureUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmProcedureMultasAdministrativasPatentes implements IConfirmProcedure{
    private WebDriver localDriver;
    private ExtentTest localExtentTest;

    public ConfirmProcedureMultasAdministrativasPatentes(){

    }
    public static boolean getReport(WebDriver driver, String originalFilename, String operation, String identifier, int index, String btnName){
        String btnNameaux = btnName;
        return FileBuilder.moveAndRenameFile(originalFilename, operation, btnName, identifier, ConstantsAEC.SUBSYSTEM_ID, index);
    }
    @Override
    public void setDriver(WebDriver driver, ExtentTest extentTest) {
        this.localDriver = driver;
        this.localExtentTest = extentTest;
    }

    @Override
    public void now(String identifier, int index, String operation) {
        try {
            Verify.isReady(localDriver, localExtentTest, ConfirmProcedureUI.ttlConfirmarTramite);
            String btnName = GetText.ofValue(localDriver, ConfirmProcedureUI.btnVistaPrevia);
            Click.on(localDriver, ConfirmProcedureUI.btnVistaPrevia); //reportePDF.pdf
            getReport(localDriver, "reportePDF.pdf", operation, identifier, index, btnName);
            WaitUntilElement.isClikeableOf(localDriver, ConfirmProcedureUI.btnGenerarReporte);
            btnName = GetText.ofValue(localDriver, ConfirmProcedureUI.btnGenerarReporte);
            Click.on(localDriver, ConfirmProcedureUI.btnGenerarReporte);
            getReport(localDriver, "reportePDF.pdf", operation, identifier, index, btnName);
            WaitUntilElement.isClikeableOf(localDriver, ConfirmProcedureUI.btnImprimirProforma);
            btnName = GetText.ofValue(localDriver, ConfirmProcedureUI.btnImprimirProforma);
            Click.on(localDriver, ConfirmProcedureUI.btnImprimirProforma); //reportePDF.pdf
            getReport(localDriver, "reportePDF.pdf", operation, identifier, index, btnName);
            WaitUntilElement.isClikeableOf(localDriver, ConfirmProcedureUI.btnSalir);
            Click.on(localDriver, ConfirmProcedureUI.btnSalir);
        }catch (Exception exception){

        }
    }
}
