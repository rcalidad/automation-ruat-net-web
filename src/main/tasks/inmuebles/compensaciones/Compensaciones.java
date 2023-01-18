package main.tasks.inmuebles.compensaciones;

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
import main.tasks.inmuebles.commonInm.LoadModule;
import main.tasks.inmuebles.commonInm.SearchEstate;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.empadronamiento.ConfirmProcedure;
import main.tasks.inmuebles.helpersInm.ChangeFrame;
import main.tasks.inmuebles.helpersInm.GeneratorINM;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.autoavaluosUI.RegistrarSolicitudUI;
import main.ui.inmueblesUI.commonUI.BusquedaInmuebleUI;
import main.ui.inmueblesUI.compensacionesUI.ConfirmarRegistroUI;
import main.ui.inmueblesUI.compensacionesUI.DetalleDeudasUI;
import main.ui.inmueblesUI.compensacionesUI.InicioTramiteUI;
import main.ui.inmueblesUI.compensacionesUI.PropietarioAccionesDerechosUI;
import main.ui.inmueblesUI.empadronamientoUI.ConfirmarTramiteUI;

public class Compensaciones extends GeneratorINM {
    protected String operacion;
    protected String numeroInmueble;
    protected String fechaSolicitud;
    protected String gestionInicio;
    protected String gestionFin;
    protected String tipoDeuda;

    public Compensaciones(){
        super();
        this.accessExcel = new AccessExcel(ConstantsINM.GENERATOR_DATA_FILE, ConstantsINM.COMPENSACIONES_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsINM.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsINM.SUBSYSTEM_ID);
    }
    @Override
    public String getIdentifier() {
        return MessagesINM.testIdentifier + this.numeroInmueble;
    }

    @Override
    public void execute() {
        try {
            Log.recordInLog(Constants.DELIMITER_MARK);
            LoadModule.fromMainMenu(this.driverApp, ConstantsINM.REGISTRO_TRIBUTARIO_GROUPER, ConstantsINM.COMPENSACIONES_MODULE);
            ChangeFrame.toContentFrame(this.driverApp);
            Verify.elementIsReady(this.driverApp, test.get(i), BusquedaInmuebleUI.ttlBusquedaInmueble);
            SearchEstate.byNumeroInmueble(this.driverApp, this.numeroInmueble);
            Verify.partialObservations(this.driverApp, test.get(i));
            if (IsDisplayed.element(this.driverApp, PropietarioAccionesDerechosUI.tablaPropietarios)){
                SelectShareholder.firstWithFiscalCredit(this.driverApp, test.get(i));
            }
            Verify.elementIsReady(this.driverApp, test.get(i), InicioTramiteUI.ttlInicioTramite);
            ReceiveDocumentation.now(this.driverApp, InicioTramiteUI.getInstance());
            Verify.elementIsReady(this.driverApp, test.get(i), RegistrarSolicitudUI.ttlRegistrarSolicitud);
            RegisterRequest.withDefaultData(this.driverApp, this.fechaSolicitud);
            if (DetailTaxpayers.verify(this.driverApp)){
                DetailTaxpayers.selectFirstWithTaxCredit(this.driverApp);
                DetailTaxpayers.accept(this.driverApp);
            }
            Verify.elementIsReady(this.driverApp, test.get(i), DetalleDeudasUI.ttlDetalleDeudas);
            DebtDetail.process(this.driverApp, test.get(i), this.gestionInicio, this.gestionFin, this.tipoDeuda, ConstantsINM.RUBRO);
            Verify.elementIsReady(this.driverApp, test.get(i), ConfirmarRegistroUI.ttlConfirmarRegistro);
            ConfirmRegistration.now(this.driverApp);
            Verify.elementIsReady(this.driverApp, test.get(i), ConfirmarTramiteUI.ttlConfirmarTramite);
            ConfirmProcedure.toCompensacion(this.driverApp, "reportePDF.pdf", this.operacion, this.numeroInmueble, i + 1);
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "INFO");
        }catch (Exception exception){

        }
    }
}
