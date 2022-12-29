package main.tasks.actividadesEconomicas.multasAdministrativasPatentes;

import com.aventstack.extentreports.Status;
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
import main.ui.actividadesEconomicasUI.empadronamientoUI.ConfirmProcedureUI;
import main.ui.actividadesEconomicasUI.empadronamientoUI.ReceiveDocumentationUI;
import main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI.DetailPeriodsUI;

public class MultasAdministrativasPatentes extends GeneratorAEC {
    protected String numeroActividadEconomica;
    protected String tipoMulta;
    protected String operacion;
    protected String gestion;
    protected String gestionInicio;
    protected String gestionFin;
    protected String montoMulta;

    public MultasAdministrativasPatentes(){
        super();
        this.accessExcel = new AccessExcel(ConstantsAEC.GENERATOR_DATA_FILE, ConstantsAEC.MULTA_ADMINISTRATIVA_PATENTES_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsAEC.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsAEC.SUBSYSTEM_ID);
    }
    @Override
    public String getIdentifier() {
        return Messages.testTitleNumEAC + this.numeroActividadEconomica;
    }

    @Override
    public void execute() {
        try{
            Log.recordInLog(Constants.DELIMITER_MARK);
            LoadModule.fromMainMenu(this.driverApp, ConstantsAEC.MULTAS_GROUPER, ConstantsAEC.MULTAS_ADMINISTRATIVAS_PATENTES_MODULE);
            SearchActivity.byActivityNumber(this.driverApp, this.numeroActividadEconomica);
            Verify.isReady(this.driverApp, test.get(i), ReceiveDocumentationUI.ttlRecepcionarDocumentacion);
            ReceiveDocumentation.withoutDocuments(this.driverApp);
            Verify.isReady(this.driverApp, test.get(i), DetailPeriodsUI.ttlDetalleGestiones);
            DetailPeriods.registerOperation(this.driverApp, test.get(i), this.tipoMulta, this.gestionInicio, this.gestionFin, this.gestion, this.operacion, this.montoMulta);
            ConfirmProcedureFactory.getInstance().executeConfirmProcedure(this.driverApp, test.get(i), this.getClass().getSimpleName(), this.numeroActividadEconomica, i + 1, this.operacion);
            //ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO,"GESTIONES SELECCIONADAS");
        }catch (Exception exception){

        }
    }
}
