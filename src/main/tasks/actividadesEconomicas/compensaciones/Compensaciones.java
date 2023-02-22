package main.tasks.actividadesEconomicas.compensaciones;

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
import main.tasks.actividadesEconomicas.empadronamiento.Authorization;
import main.tasks.actividadesEconomicas.helpersAEC.GeneratorAEC;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import main.ui.actividadesEconomicasUI.commonUI.MainMenuUI;
import main.ui.actividadesEconomicasUI.compensacionesUI.DebtDetailUI;
import main.ui.actividadesEconomicasUI.compensacionesUI.NotificationUI;
import main.ui.actividadesEconomicasUI.compensacionesUI.VerifyCompensationUI;
import main.ui.actividadesEconomicasUI.empadronamientoUI.AuthorizationUI;

public class Compensaciones extends GeneratorAEC {
    //These variables have to have the same name of data sheet's columns
    protected String numeroActividadEconomica;
    protected String operacion;
    protected String gestionInicio;
    protected String gestionFin;
    protected String tipoDeuda;
    protected String numeroDocumento;
    protected String fechaDocumento;
    protected String autorizadoPor;
    protected String cargo;
    protected String observaciones;

    public Compensaciones(){
        super();
        this.accessExcel = new AccessExcel(ConstantsAEC.GENERATOR_DATA_FILE, ConstantsAEC.COMPENSACIONES_DATA_SHEET);
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
            //Verify.isReady(this.driverApp, test.get(i), MainMenuUI.lnkCerrarSesion);
            LoadModule.fromMainMenu(this.driverApp, ConstantsAEC.COMPENSACIONES_GROUPER, ConstantsAEC.COMPENSACIONES_MODULE);
            SearchActivity.byActivityNumber(this.driverApp, this.numeroActividadEconomica);
            Verify.isReady(this.driverApp, test.get(i), AuthorizationUI.ttlAutorizacion);
            Authorization.by(this.driverApp, this.autorizadoPor, this.fechaDocumento);
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "INFO");
            Verify.isReady(this.driverApp, test.get(i), DebtDetailUI.ttlDetalleDeudas);
            DebtDetail.process(this.driverApp, test.get(i), this.gestionInicio, this.gestionFin, this.tipoDeuda, ConstantsAEC.RUBRO);
            Verify.isReady(this.driverApp, test.get(i), VerifyCompensationUI.ttlVerificacionCompensacion);
            VerifyCompensation.now(this.driverApp, test.get(i));
            Verify.isReady(this.driverApp, test.get(i), NotificationUI.ttlNotification);
            Notification.process(this.driverApp, this.operacion, this.tipoDeuda, this.numeroActividadEconomica, i + 1);
        }catch (Exception exception){

        }
    }
}
