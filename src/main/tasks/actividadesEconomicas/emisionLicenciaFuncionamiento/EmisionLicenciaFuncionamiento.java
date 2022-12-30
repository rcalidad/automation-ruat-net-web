package main.tasks.actividadesEconomicas.emisionLicenciaFuncionamiento;

import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.actions.GetText;
import main.actions.GiveFormat;
import main.actions.Log;
import main.helpers.common.Constants;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.actividadesEconomicas.commonAEC.LoadModule;
import main.tasks.actividadesEconomicas.commonAEC.SearchActivity;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.tasks.actividadesEconomicas.helpersAEC.GeneratorAEC;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import main.ui.actividadesEconomicasUI.emisionLicenciaFuncionamientoUI.NotificationUI;
import main.ui.actividadesEconomicasUI.emisionLicenciaFuncionamientoUI.PrintDocumentUI;

public class EmisionLicenciaFuncionamiento extends GeneratorAEC {
    //These variables have to have the same name of data sheet's columns
    protected String numeroActividadEconomica;
    protected String operacion;

    public EmisionLicenciaFuncionamiento(){
        super();
        this.accessExcel = new AccessExcel(ConstantsAEC.GENERATOR_DATA_FILE, ConstantsAEC.EMISION_LICENCIA_DE_FUNCIONAMIENTO_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsAEC.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsAEC.SUBSYSTEM_ID);
    }

    @Override
    public String getIdentifier() {
        return Messages.testTitleNumEAC + this.numeroActividadEconomica;
    }

    @Override
    public void execute() {
        try {
            Log.recordInLog(Constants.DELIMITER_MARK);
            LoadModule.fromMainMenu(this.driverApp, ConstantsAEC.EMISIONES_GROUPER, ConstantsAEC.EMISION_LICENCIA_FUNCIONAMIENTO_MODULE);
            SearchActivity.byActivityNumber(this.driverApp, this.numeroActividadEconomica);
            Verify.isReady(this.driverApp, test.get(i), PrintDocumentUI.ttlImprimir);
            Click.on(this.driverApp, PrintDocumentUI.btnImprimir); // impresion.pdf
            Verify.isReady(this.driverApp, test.get(i), NotificationUI.ttlNotificacion);
            String message = GetText.ifContains(this.driverApp, NotificationUI.msgNotification, "correcta");
            FileBuilder.moveAndRenameFile("impresion.pdf", "IMPRESION", "LICENCIA", this.numeroActividadEconomica, ConstantsAEC.SUBSYSTEM_ID, i + 1);
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, message);
            Log.recordInLog(message);
        }catch (Exception exception){

        }
    }
}
