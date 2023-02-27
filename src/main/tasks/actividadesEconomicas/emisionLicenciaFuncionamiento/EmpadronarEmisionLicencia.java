package main.tasks.actividadesEconomicas.emisionLicenciaFuncionamiento;

import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.actions.GetText;
import main.actions.GiveFormat;
import main.actions.Log;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.actividadesEconomicas.commonAEC.LoadModule;
import main.tasks.actividadesEconomicas.commonAEC.SearchActivity;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.tasks.actividadesEconomicas.empadronamiento.Empadronamiento;
import main.tasks.actividadesEconomicas.helpersAEC.GeneratorAEC;
import main.ui.actividadesEconomicasUI.emisionLicenciaFuncionamientoUI.NotificationUI;
import main.ui.actividadesEconomicasUI.emisionLicenciaFuncionamientoUI.PrintDocumentUI;

public class EmpadronarEmisionLicencia extends GeneratorAEC {
    protected String razonSocial;
    protected String fechaInicioTributario;
    protected String zonaTributaria;
    protected String superficie;
    protected String rubro;
    protected String idContribuyente;
    protected String tipoDocumento;
    protected String areaMunicipio;
    protected String autorizadoPor;

    public EmpadronarEmisionLicencia(){
        super();
        this.accessExcel = new AccessExcel(ConstantsAEC.GENERATOR_DATA_FILE, ConstantsAEC.EMPADRONAMIENTO_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsAEC.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsAEC.SUBSYSTEM_ID);
    }
    @Override
    public String getIdentifier() {
        return "Empadronamiento: " + this.idContribuyente + " " + this.razonSocial;
    }

    @Override
    public void execute() {
        try{
            String numActivity= "";
            numActivity = Empadronamiento.empadronamientoSimple(this.driverApp, test.get(i), this.usuario, this.municipio, this.razonSocial, this.fechaInicioTributario, this.superficie, this.idContribuyente, this.tipoDocumento, this.areaMunicipio, this.autorizadoPor, i);
            Log.recordInLog("Número de actividad económica asignado: " + numActivity);
            if (!numActivity.equals("")){
                returnMainMenu();
                LoadModule.fromMainMenu(this.driverApp, ConstantsAEC.EMISIONES_GROUPER, ConstantsAEC.EMISION_LICENCIA_FUNCIONAMIENTO_MODULE);
                SearchActivity.byActivityNumber(this.driverApp, numActivity);
                Verify.isReady(this.driverApp, test.get(i), PrintDocumentUI.ttlImprimir);
                Click.on(this.driverApp, PrintDocumentUI.btnImprimir); // impresion.pdf
                Verify.isReady(this.driverApp, test.get(i), NotificationUI.ttlNotificacion);
                String message = GetText.ifContains(this.driverApp, NotificationUI.msgNotification, "correcta");
                FileBuilder.moveAndRenameFile("impresion.pdf", "IMPRESION", "LICENCIA", numActivity, ConstantsAEC.SUBSYSTEM_ID, i + 1);
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, message);
                Log.recordInLog(message);
            }
        }catch (Exception exception){

        }
    }
}
