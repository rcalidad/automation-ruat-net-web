package main.tasks.actividadesEconomicas.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
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
import main.tasks.actividadesEconomicas.commonAEC.confirmProcedure.ConfirmProcedureEmpadronamiento;
import main.tasks.actividadesEconomicas.commonAEC.confirmProcedure.ConfirmProcedureFactory;
import main.tasks.actividadesEconomicas.empadronamiento.receiveDocumentation.LocalReceiveDocumentationFactory;
import main.tasks.actividadesEconomicas.helpersAEC.GeneratorAEC;
import main.tasks.commonTasks.GetDate;
import main.tasks.commonTasks.GetExtension;
import main.tasks.commonTasks.GetNumActivity;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.commonUI.CabeceraUI;
import main.ui.actividadesEconomicasUI.empadronamientoUI.*;
import org.openqa.selenium.WebDriver;

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
        String numActivity;
        numActivity = empadronamientoSimple(this.driverApp, test.get(i), this.usuario, this.municipio, this.razonSocial, this.fechaInicioTributario, this.superficie, this.idContribuyente,
                              this.tipoDocumento, this.areaMunicipio, this.autorizadoPor, i);
        Log.recordInLog("Número de actividad económica asignado: " + numActivity);
    }
    public static String empadronamientoSimple(WebDriver driver, ExtentTest extentTest, String usuario, String municipio, String razonSocial, String fechaInicioTributario,
                                        String superficie, String idContribuyente, String tipoDocumento, String areaMunicipio, String autorizadoPor, int index){
        String numActivity = "";
        try{
            String dateOfSystem = GetDate.ofSystem(driver, CabeceraUI.fecha);
            Log.recordInLog(Constants.DELIMITER_MARK);
            LoadModule.fromMainMenu(driver, ConstantsAEC.EMPADRONAMIENTO_GROUPER, ConstantsAEC.EMPADRONAMIENTO_MODULE);
            String town = GetExtension.ofUsername(usuario);
            LocalReceiveDocumentationFactory.getInstance().executeReceiveDocumentation(driver, town, extentTest);
            Click.on(driver, ReceiveDocumentationUI.btnGrabar);
            VerifyAlert.containsThisText(driver, "seguro");
            Verify.isReady(driver, extentTest, DataActividadEconomicaUI.ttlDatosActividadEconomica);
            DataActividadEconomica.load(driver, razonSocial);
            Verify.isReady(driver, extentTest, TechnicalDataByPeriodUI.ttlDatosTecnicosPorPeriodo);
            TechnicalDataByPeriod.load(driver, extentTest, fechaInicioTributario, superficie);
            Verify.isReady(driver, extentTest, AssignContributorUI.ttlAsignarContribuyente);
            AssignContributor.assign(driver, extentTest, idContribuyente, tipoDocumento);
            Verify.isReady(driver, extentTest, LocationActividadEconomicaUI.ttlUbicacionActividadEconomica);
            LocationActividadEconomica.register(driver, areaMunicipio);
            if (municipio.equals("SANTA CRUZ DE LA SIERRA") || municipio.equals("SUCRE")){
                Verify.isReady(driver, extentTest, AuthorizationUI.ttlAutorizacion);
                Authorization.by(driver, autorizadoPor, dateOfSystem);
            }
            Verify.isReady(driver, extentTest, AdditionalInformationUI.ttlInformacionAdicional);
            AdditionalInformation.emptyRecord(driver);
            Verify.isReady(driver, extentTest, ConfirmRecordUI.ttlConfirmarRegistro);
            ConfirmRecord.withoutObservations(driver);
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "CONFIRMAR TRAMITE");
            String text = ConfirmProcedureEmpadronamiento.now(driver, extentTest, idContribuyente, index + 1, "EMPADRONAMIENTO");
            numActivity = GetNumActivity.ofAText(text);
            //ConfirmProcedureFactory.getInstance().executeConfirmProcedure(driver, extentTest, "Empadronamiento", idContribuyente, i + 1, "EMPADRONAMIENTO");
            //ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "FIN");

        }catch (Exception exception){

        }finally {
            return numActivity;
        }
    }
}
