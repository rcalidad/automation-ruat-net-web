package main.tasks.inmuebles.modificacionDatosTecnicos;

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
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.helpersInm.ChangeFrame;
import main.tasks.inmuebles.helpersInm.GeneratorINM;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.commonUI.BusquedaInmuebleUI;

public class ModificacionDatosTecnicos extends GeneratorINM {
    protected String operacion;
    protected String numeroInmueble;

    public ModificacionDatosTecnicos(){
        super();
        this.accessExcel = new AccessExcel(ConstantsINM.GENERATOR_DATA_FILE, ConstantsINM.MODIFICACION_DATOS_TECNICOS_DATA_SHEET);
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
            LoadModule.fromSearcherOfMainMenu(this.driverApp, ConstantsINM.MODIFICACION_DATOS_TECNICOS_MODULE);
            ChangeFrame.toContentFrame(this.driverApp);
            Verify.elementIsReady(this.driverApp, test.get(i), BusquedaInmuebleUI.ttlBusquedaInmueble);
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "INFO");
        }catch (Exception exception){

        }
    }
}
