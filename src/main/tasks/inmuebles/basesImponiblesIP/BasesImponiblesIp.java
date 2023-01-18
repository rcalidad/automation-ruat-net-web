package main.tasks.inmuebles.basesImponiblesIP;

import com.aventstack.extentreports.Status;
import main.actions.GiveFormat;
import main.actions.Log;
import main.helpers.common.Constants;
import main.helpers.common.Inmuebles.ConstantsINM;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.inmuebles.autoavaluos.RegisterRequest;
import main.tasks.inmuebles.commonInm.*;
import main.tasks.inmuebles.commonInm.detalleOperacion.DetailsOfProcedure;
import main.tasks.inmuebles.empadronamiento.ConfirmProcedure;
import main.tasks.inmuebles.helpersInm.ChangeFrame;
import main.tasks.inmuebles.helpersInm.GeneratorINM;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.autoavaluosUI.RegistrarSolicitudUI;
import main.ui.inmueblesUI.basesImponiblesIpUI.DetalleBasesImponiblesUI;
import main.ui.inmueblesUI.basesImponiblesIpUI.InicioTramiteUI;
import main.ui.inmueblesUI.commonUI.BusquedaInmuebleUI;
import main.ui.inmueblesUI.empadronamientoUI.ConfirmarTramiteUI;

import java.util.HashMap;
import java.util.Map;

public class BasesImponiblesIp extends GeneratorINM {
    protected String operacion;
    protected String numeroInmueble;
    protected String baseImponible;
    protected String gestion;

    public BasesImponiblesIp(){
        super();
        this.accessExcel = new AccessExcel(ConstantsINM.GENERATOR_DATA_FILE, ConstantsINM.BASES_IMPONIBLES_IP_DATA_SHEET);
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
            LoadModule.fromSearcherOfMainMenu(this.driverApp, ConstantsINM.BASES_IMPONIBLES_IP_MODULE);
            ChangeFrame.toContentFrame(this.driverApp);
            Verify.elementIsReady(this.driverApp, test.get(i), BusquedaInmuebleUI.ttlBusquedaInmueble);
            SearchEstate.byNumeroInmueble(this.driverApp, this.numeroInmueble);
            Verify.partialObservations(this.driverApp, test.get(i));
            Verify.elementIsReady(this.driverApp, test.get(i), InicioTramiteUI.ttlInicioTramite);
            ReceiveDocumentation.now(this.driverApp, test.get(i));
            Verify.elementIsReady(this.driverApp, test.get(i), RegistrarSolicitudUI.ttlRegistrarSolicitud);
            RegisterRequest.withDefaultData(this.driverApp, ConstantsINM.systemDate);
            Verify.elementIsReady(this.driverApp, test.get(i), DetalleBasesImponiblesUI.ttlDetalleBasesImponibles);
            Map<String, String> data = new HashMap<>();
            //DATOS REQUERIDOS OBLIGATORIOS
            data.put("detailOfPeriod", "POR RANGO");
            data.put("initialYear", this.gestion);
            data.put("finalYear", this.gestion);
            data.put("operation", this.operacion);
            //DATOS QUE CAMBIAN DE ACUERDO A REQUERIMIENTO
            data.put("baseImponible", this.baseImponible);
            RegisterOperation.now(this.driverApp, test.get(i), data);
            Verify.elementIsReady(this.driverApp, test.get(i), ConfirmarTramiteUI.ttlConfirmarTramite);
            ConfirmProcedure.toBasesImponibles(this.driverApp, "reportePDF.pdf", this.operacion, this.numeroInmueble, i + 1);
            //DetailsOfProcedure.record(this.driverApp, DetalleBasesImponiblesUI.getInstance());
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "INFO");
        }catch (Exception exception){

        }
    }
}
