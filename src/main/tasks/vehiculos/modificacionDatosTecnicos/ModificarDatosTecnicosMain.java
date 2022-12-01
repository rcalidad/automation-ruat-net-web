package main.tasks.vehiculos.modificacionDatosTecnicos;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.common.Constants;
import main.helpers.common.vehiculos.ConstantsVEH;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.commonTasks.Generator;
import main.tasks.vehiculos.commonVeh.*;
import main.tasks.vehiculos.login.LoginVehiculos;
import main.tasks.vehiculos.mainMenu.MainMenu;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.commonUI.LeftMenuUI;
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import main.ui.vehiculosUI.modificacionDatosTecnicosUI.TramiteUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModificarDatosTecnicosMain extends Generator {
    public static final String MODIFICACION_DATOS_TECNICOS_DATA_SHEET = "ModificacionDatosTecnicos";
    public static final String MODIFICACION_DATOS_TECNICOS_GROUPER = "Modificación Datos Técnicos";
    public static final String MODIFICACION_DATOS_TECNICOS_MODULE = "Modificación de Datos Técnicos";
    public static final String reporte = "reportePDF.pdf";
    //--- These variables have the same name of columns defined on Excel file.
    protected String operacion;
    protected String identificador;
    protected String crpva;
    protected String numeroCopia;
    protected String cilindrada;
    protected String traccion;
    protected String turbo;

    public ModificarDatosTecnicosMain(){
        super();
        this.accessExcel = new AccessExcel(ConstantsVEH.GENERATOR_DATA_FILE, MODIFICACION_DATOS_TECNICOS_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsVEH.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsVEH.ID_SUBSYSTEM);
    }
    public void getReport(By btnReport){
        Click.on(this.driverApp, btnReport);
        //FileBuilder.moveFile("enviarPDF.pdf");
        //FileBuilder.renameReport("enviarPDF.pdf", this.operacion, GetText.ofValue(this.driverApp, btnReport).trim(), this.identificador, ConstantsVEH.ID_SUBSYSTEM, i + 1);
        FileBuilder.moveAndRenameFile("enviarPDF.pdf", this.operacion, GetText.ofValue(this.driverApp, btnReport).trim(), this.identificador, ConstantsVEH.ID_SUBSYSTEM, i + 1);
        /*try{
            Thread.sleep(1000);
        }catch (Exception exception){}*/

    }
    public void confirmProcedure(){
        getReport(TramiteUI.btnImprimirReporte);
        WaitUntilElement.isClikeableOf(this.driverApp, TramiteUI.btnGrabarModificacion);
        Click.on(this.driverApp, TramiteUI.btnGrabarModificacion);
        WaitUntilAlert.isPresent(this.driverApp);
        DisplayAlert.toAcept(this.driverApp);
        WaitUntilElement.isElementVisible(this.driverApp, TramiteUI.btnImprimirRecibo);
        getReport(TramiteUI.btnImprimirRecibo);
        WaitUntilElement.isClikeableOf(this.driverApp, TramiteUI.btnImprimirProforma);
        getReport(TramiteUI.btnImprimirProforma);
        WaitUntilElement.isClikeableOf(this.driverApp, TramiteUI.btnSalir);
        Click.on(this.driverApp, TramiteUI.btnSalir);
    }


    @Override
    public void start() {
        Log.recordInLog(Constants.END_OF_EXECUTION_MARK);
        MainMenu.selectOption(this.driverApp, MODIFICACION_DATOS_TECNICOS_GROUPER);
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(this.driverApp, MODIFICACION_DATOS_TECNICOS_MODULE);
        this.driverApp.switchTo().defaultContent();
        this.driverApp.switchTo().frame(FramesUI.frameNameContenido);
        SearchVehicle.forPTA(this.driverApp, this.identificador);
        if (ValidatePropertyCertificate.isReady(this.driverApp, test.get(i))){
            ValidatePropertyCertificate.withData(this.driverApp, this.crpva, this.numeroCopia);
            if(ReceiveDocumentation.isReady(this.driverApp, test.get(i))){
                ReceiveDocumentation.toModifyTechnicalData(this.driverApp);
                if (SelectPeriod.isReady(this.driverApp)) {
                    SelectPeriod.toModifyTechnicalData(this.driverApp);
                }else {
                    ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "No se pudo seleccionar el periodo de modificación de datos...");
                    Log.recordInLog("No se pudo seleccionar el periodo de modificación de datos...");
                }
                if(ModifyTechnicalData.isReady(this.driverApp)){
                    ModifyTechnicalData.cilindrada(this.driverApp, test.get(i), this.operacion, this.cilindrada, this.traccion);
                    if (WaitUntilElement.isElementVisible(this.driverApp, TramiteUI.btnImprimirReporte, 2)){
                        confirmProcedure();
                        returnMainMenu();
                        GetProforma.detailed(this.driverApp, test.get(i), this.identificador, i + 1);
                    }else{
                        //ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "Something was wrong modifying technical data...");
                        Log.recordInLog("No se pudo completar la modificación técnica...");
                    }
                }else{
                    ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.SKIP, "No se pudo realizar la modificación técnica...");
                    Log.recordInLog("No se pudo realizar la modificación técnica...");
                }
            }else {
                //ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "Something was wrong validating CRPVA...");
                Log.recordInLog("No se pudo validar el CRPVA...");
            }
        }else{
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.SKIP, "El vehículo tiene alguna observación...");
            Log.recordInLog("El vehículo tiene alguna observación...");
        }
    }

    @Override
    public void returnMainMenu() {
        this.driverApp.switchTo().parentFrame();
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        Scroll.toEndPage(this.driverApp);
        Click.on(this.driverApp, LeftMenuUI.lnkMenuPrincipal);
        this.driverApp.switchTo().parentFrame();
    }

    @Override
    public void login(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password) {
        //LoginVehiculos.as(driver, extentReports, extentTest, user, password);
        LoginVehiculos.authenticate(driver, extentReports, extentTest, user, password);
    }

    @Override
    public void logout() {
        LoginVehiculos.logout(this.driverApp);
    }

    @Override
    public String setTestCaseName() {
        return "Nro. de vehiculo ".concat(this.identificador);
    }

    @Override
    public boolean isNotLoggedIn() {
        boolean flag = WaitUntilElement.isElementVisible(this.driverApp, MainMenuUI.lnkCerrarSesion);
        return !WaitUntilElement.isElementVisible(this.driverApp, MainMenuUI.lnkCerrarSesion);
    }

    @Override
    public String getUser() {
        return ExcelData.getUser(ConstantsVEH.GENERATOR_DATA_FILE, this.accessExcel, i);
    }
}
