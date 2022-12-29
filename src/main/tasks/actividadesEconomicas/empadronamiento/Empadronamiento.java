package main.tasks.actividadesEconomicas.empadronamiento;

import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.actions.Log;
import main.helpers.common.Constants;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.actividadesEconomicas.commonAEC.LoadModule;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.tasks.actividadesEconomicas.commonAEC.confirmProcedure.ConfirmProcedureFactory;
import main.tasks.actividadesEconomicas.empadronamiento.receiveDocumentation.LocalReceiveDocumentationFactory;
import main.tasks.actividadesEconomicas.helpersAEC.GeneratorAEC;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.empadronamientoUI.*;

public class Empadronamiento extends GeneratorAEC {
    protected String razonSocial;
    protected String fechaInicioTributario;
    protected String zonaTributaria;
    protected String superficie;
    protected String rubro;
    protected String subRubro;
    protected String tipoActividad;
    protected String idContribuyente;
    protected String tipoDocumento;
    protected String areaMunicipio;
    protected String autorizadoPor;
    public Empadronamiento(){
        super();
        this.accessExcel = new AccessExcel(ConstantsAEC.GENERATOR_DATA_FILE, ConstantsAEC.EMPADRONAMIENTO_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsAEC.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(this.getClass().getSimpleName().toUpperCase(), ConstantsAEC.SUBSYSTEM_ID);
    }

    @Override
    public String getIdentifier() {
        return "Empadronamiento: " + this.idContribuyente + " " + this.razonSocial;
    }

    @Override
    public void execute() {
        try{
            Log.recordInLog(Constants.DELIMITER_MARK);
            LoadModule.fromMainMenu(this.driverApp, ConstantsAEC.EMPADRONAMIENTO_GROUPER, ConstantsAEC.EMPADRONAMIENTO_MODULE);
            String town = getTown(this.usuario);
            LocalReceiveDocumentationFactory.getInstance().executeReceiveDocumentation(this.driverApp, town, test.get(i));
            Click.on(this.driverApp, ReceiveDocumentationUI.btnGrabar);
            VerifyAlert.containsThisText(this.driverApp, "seguro");
            Verify.isReady(this.driverApp, test.get(i), DataActividadEconomicaUI.ttlDatosActividadEconomica);
            DataActividadEconomica.load(this.driverApp, this.razonSocial);
            Verify.isReady(this.driverApp, test.get(i), TechnicalDataByPeriodUI.ttlDatosTecnicosPorPeriodo);
            TechnicalDataByPeriod.load(this.driverApp, test.get(i), this.fechaInicioTributario, this.zonaTributaria, this.superficie, this.rubro, this.subRubro, this.tipoActividad);
            Verify.isReady(this.driverApp, test.get(i), AssignContributorUI.ttlAsignarContribuyente);
            AssignContributor.assign(this.driverApp, test.get(i), this.idContribuyente, this.tipoDocumento);
            Verify.isReady(this.driverApp, test.get(i), LocationActividadEconomicaUI.ttlUbicacionActividadEconomica);
            LocationActividadEconomica.register(this.driverApp, this.areaMunicipio);
            Verify.isReady(this.driverApp, test.get(i), AuthorizationUI.ttlAutorizacion);
            Authorization.by(this.driverApp, this.autorizadoPor);
            Verify.isReady(this.driverApp, test.get(i), AdditionalInformationUI.ttlInformacionAdicional);
            AdditionalInformation.emptyRecord(this.driverApp);
            Verify.isReady(this.driverApp, test.get(i), ConfirmRecordUI.ttlConfirmarRegistro);
            ConfirmRecord.withoutObservations(this.driverApp);
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "CONFIRMAR TRAMITE");
            ConfirmProcedureFactory.getInstance().executeConfirmProcedure(this.driverApp, test.get(i), "Empadronamiento", this.idContribuyente, i + 1, "EMPADRONAMIENTO");
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "FIN");

        }catch (Exception exception){

        }
    }
    public String getTown(String username){
        String town = username.split("\\.")[1];
        return town;
    }
}
