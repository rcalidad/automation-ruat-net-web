package main.tasks.inmuebles.transferenciaNormalTotal;

import com.aventstack.extentreports.Status;
import main.actions.GiveFormat;
import main.actions.Log;
import main.helpers.common.Constants;
import main.helpers.common.Inmuebles.ConstantsINM;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.inmuebles.commonInm.GetDate;
import main.tasks.inmuebles.commonInm.LoadModule;
import main.tasks.inmuebles.commonInm.SearchEstate;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.helpersInm.ChangeFrame;
import main.tasks.inmuebles.helpersInm.GeneratorINM;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.commonUI.BusquedaInmuebleUI;
import main.ui.inmueblesUI.transferenciaTotalPU.InicioTramiteUI;
import main.ui.inmueblesUI.transferenciaTotalPU.RegistrarMinutaUI;

public class TransferenciaNormalTotalPu extends GeneratorINM {
    protected String operacion;
    protected String numeroInmueble;
    protected String tipoTransferencia;
    protected String fechaMinuta;
    protected String montoMinuta;
    protected String tipoMoneda;

    public TransferenciaNormalTotalPu(){
        super();
        this.accessExcel = new AccessExcel(ConstantsINM.GENERATOR_DATA_FILE, ConstantsINM.TRANSFERENCIA_NORMAL_TOTAL_PU_DATA_SHEET);
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
            ConstantsINM.systemDate = GetDate.ofHeader(this.driverApp);
            LoadModule.fromSearcherOfMainMenuAndSubGrouper(this.driverApp, ConstantsINM.TRANSFERENCIA_NORMAL_PROPIEDAD_UNICA_TN_SUBGROUPER, ConstantsINM.TRANSFERENCIA_NORMAL_TOTAL_MODULE);
            ChangeFrame.toContentFrame(this.driverApp);
            Verify.elementIsReady(this.driverApp, test.get(i), BusquedaInmuebleUI.ttlBusquedaInmueble);
            SearchEstate.byNumeroInmueble(this.driverApp, this.numeroInmueble);
            Verify.elementIsReady(this.driverApp, test.get(i), InicioTramiteUI.ttlInicioTramite);
            ReceiveDocumentation.now(this.driverApp, InicioTramiteUI.getInstance());
            Verify.partialObservations(this.driverApp, test.get(i));
            Verify.elementIsReady(this.driverApp, test.get(i), RegistrarMinutaUI.ttlRegistrarMinuta);
            RecordMinute.fillFormWithDefaultData(this.driverApp, this.tipoTransferencia, this.montoMinuta, this.tipoMoneda, this.fechaMinuta);
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "INFO");
        }catch (Exception exception){

        }
    }
}
