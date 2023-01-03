package main.tasks.actividadesEconomicas.condonacionLeyMunicipal;

import com.aventstack.extentreports.Status;
import main.actions.Click;
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
import main.tasks.actividadesEconomicas.commonAEC.confirmProcedure.ConfirmProcedureFactory;
import main.tasks.actividadesEconomicas.helpersAEC.GeneratorAEC;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import main.ui.actividadesEconomicasUI.condonacionLeyMunicipalUI.DetailPeriodsUI;
import main.ui.actividadesEconomicasUI.condonacionLeyMunicipalUI.ReceiveDocumentationUI;

public class CondonacionLeyMunicipal extends GeneratorAEC {
    protected String numeroActividadEconomica;
    protected String operacion;
    protected String observacion;
    public CondonacionLeyMunicipal(){
        super();
        this.accessExcel = new AccessExcel(ConstantsAEC.GENERATOR_DATA_FILE, ConstantsAEC.CONDONACION_LEY_MUNICIPAL_DATA_SHEET);
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
            LoadModule.fromMainMenu(this.driverApp, ConstantsAEC.CONDONACION_GROUPER, ConstantsAEC.CONDONACION_LEY_MUNICIPAL_MODULE);
            SearchActivity.byActivityNumber(this.driverApp, this.numeroActividadEconomica);
            Verify.isReady(this.driverApp, test.get(i), ReceiveDocumentationUI.ttlRecepcionarDocumentacion);
            ReceiveDocumentation.withoutData(this.driverApp);
            Verify.isReady(this.driverApp, test.get(i), DetailPeriodsUI.ttlDetalleGestiones);
            DetailPeriods.processNow(this.driverApp, test.get(i), this.operacion, this.observacion);
            Verify.isReady(this.driverApp, test.get(i), DetailPeriodsUI.ttlDetalleGestiones);
            Click.on(this.driverApp, DetailPeriodsUI.btnAceptar);
            ConfirmProcedureFactory.getInstance().executeConfirmProcedure(this.driverApp, test.get(i), "MultasAdministrativasPatentes", this.numeroActividadEconomica, i + 1, this.operacion);
            //ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "INFO");
        }catch (Exception exception){

        }
    }
}
