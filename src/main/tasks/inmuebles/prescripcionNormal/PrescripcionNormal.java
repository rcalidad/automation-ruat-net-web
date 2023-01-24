package main.tasks.inmuebles.prescripcionNormal;

import com.aventstack.extentreports.Status;
import main.actions.GiveFormat;
import main.actions.IsDisplayed;
import main.actions.Log;
import main.helpers.common.Constants;
import main.helpers.common.Inmuebles.ConstantsINM;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.inmuebles.autoavaluos.RegisterRequest;
import main.tasks.inmuebles.commonInm.GetDate;
import main.tasks.inmuebles.commonInm.LoadModule;
import main.tasks.inmuebles.commonInm.SearchEstate;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.compensaciones.SelectShareholder;
import main.tasks.inmuebles.empadronamiento.ConfirmProcedure;
import main.tasks.inmuebles.helpersInm.ChangeFrame;
import main.tasks.inmuebles.helpersInm.GeneratorINM;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.autoavaluosUI.RegistrarSolicitudUI;
import main.ui.inmueblesUI.commonUI.BusquedaInmuebleUI;
import main.ui.inmueblesUI.compensacionesUI.PropietarioAccionesDerechosUI;
import main.ui.inmueblesUI.empadronamientoUI.ConfirmarTramiteUI;
import main.ui.inmueblesUI.prescripcionNormalUI.DetalleGestionesUI;
import main.ui.inmueblesUI.prescripcionNormalUI.InicioTramiteUI;

public class PrescripcionNormal extends GeneratorINM {
    protected String operacion;
    protected String numeroInmueble;
    protected String rango;
    protected String gestionInicial;
    protected String gestionFinal;

    public PrescripcionNormal(){
        super();
        this.accessExcel = new AccessExcel(ConstantsINM.GENERATOR_DATA_FILE, ConstantsINM.PRESCRIPCION_NORMAL_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsINM.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsINM.SUBSYSTEM_ID);
    }

    @Override
    public String getIdentifier() {
        return MessagesINM.testIdentifier + this.numeroInmueble;
    }

    @Override
    public void execute() {
        try{
            Log.recordInLog(Constants.DELIMITER_MARK);
            ConstantsINM.systemDate = GetDate.ofHeader(this.driverApp);
            LoadModule.fromSearcherOfMainMenu(this.driverApp, ConstantsINM.PRESCRIPCIONES_MODULE);
            ChangeFrame.toContentFrame(this.driverApp);
            Verify.elementIsReady(this.driverApp, test.get(i), BusquedaInmuebleUI.ttlBusquedaInmueble);
            SearchEstate.byNumeroInmueble(this.driverApp, this.numeroInmueble);
            if (IsDisplayed.element(this.driverApp, PropietarioAccionesDerechosUI.tablaPropietarios)){
                SelectShareholder.firstWhoCanContinue(this.driverApp, test.get(i));
            }
            Verify.elementIsReady(this.driverApp, test.get(i), InicioTramiteUI.ttlInicioTramite);
            ReceiveDocumentation.now(this.driverApp);
            Verify.elementIsReady(this.driverApp, test.get(i), RegistrarSolicitudUI.ttlRegistrarSolicitud);
            RegisterRequest.withDefaultData(this.driverApp, ConstantsINM.systemDate);
            Verify.elementIsReady(this.driverApp, test.get(i), DetalleGestionesUI.ttlDetalleDeudas);
            ProcessPrescription.byOperation(this.driverApp, this.operacion, this.rango, this.gestionInicial, this.gestionFinal);
            selectOperation(this.operacion);
            Verify.elementIsReady(this.driverApp, test.get(i), DetalleGestionesUI.ttlDetalleDeudas);
            ProcessPrescription.recordOperation(this.driverApp);
            Verify.elementIsReady(this.driverApp, test.get(i), ConfirmarTramiteUI.ttlConfirmarTramite);
            ConfirmProcedure.toCompensacion(this.driverApp, "reportePDF.pdf", this.operacion, this.numeroInmueble, i + 1);
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "INFO");
        }catch (Exception exception){

        }
    }
    public void selectOperation(String operation){
        switch (operation.toUpperCase()){
            case "REGISTRAR":
                RegisterPrescription.now(this.driverApp, test.get(i), MessagesINM.testText);
                break;
            case "ANULAR":
                AnnulPrescription.now(this.driverApp, test.get(i), MessagesINM.testText);
                break;
            default:
                break;
        }
    }
}
