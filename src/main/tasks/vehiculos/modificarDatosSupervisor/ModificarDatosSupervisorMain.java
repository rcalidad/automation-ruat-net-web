package main.tasks.vehiculos.modificarDatosSupervisor;

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
import main.ui.vehiculosUI.commonUI.SeleccionarModificacionUI;
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;

public class ModificarDatosSupervisorMain extends Generator {
    //---These variables have the same name of columns defined on Excel file.
    protected String operacion;
    protected String identificador;
    protected String cilindradaAdicional;
    protected String traccion;
    protected String montoMinutaAdicional;

    public ModificarDatosSupervisorMain(){
        super();
        this.accessExcel = new AccessExcel(ConstantsVEH.GENERATOR_DATA_FILE, ConstantsVEH.MODIFICACION_DATOS_SUPERVISOR_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsVEH.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsVEH.ID_SUBSYSTEM);
    }
    public void modifyTechnicalData(){
        if (ModifyTechnicalData.isReady(this.driverApp)){
            ModifyTechnicalData.cilindrada(this.driverApp, test.get(i), this.operacion, this.cilindradaAdicional, this.traccion);
        }
    }
    public void modifyMinuteData(){
        if(ModifyMinuteData.isReady(this.driverApp, test.get(i))){
            ModifyMinuteData.addAmount(this.driverApp, test.get(i), this.montoMinutaAdicional, this.operacion);
        }
    }

    @Override
    public void start() {
        Log.recordInLog(Constants.END_OF_EXECUTION_MARK);
        MainMenu.selectOption(this.driverApp, ConstantsVEH.MODIFICACION_DATOS_TECNICOS_GROUPER);
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(this.driverApp, ConstantsVEH.MODIFICACION_DATOS_SUPERVISOR_MODULE);
        this.driverApp.switchTo().parentFrame();
        this.driverApp.switchTo().frame(FramesUI.frameNameContenido);
        SearchVehicle.forPTA(this.driverApp, this.identificador);
        if (ReceiveDocumentation.isReady(this.driverApp, test.get(i))){
            ReceiveDocumentation.toModifyDataBySupervisor(this.driverApp);
            if(SeleccionarModificacion.isReady(this.driverApp, test.get(i))){
                SeleccionarModificacion.option(this.driverApp, this.operacion);
                Log.recordInLog("Seleccionando tipo de modificación: " + this.operacion);
                try{
                    Method methodModify = this.getClass().getMethod(ModificationOption.modificationProcess.get(this.operacion));
                    methodModify.invoke(this);
                }catch (NoSuchMethodException noSuchMethodException){
                    Log.recordInLog("No se pudo ejecutar el método...");
                }catch (Exception e){
                    Log.recordInLog("No se pudo ejecutar el método...");
                }
            }
            if (SeleccionarModificacion.isReady(this.driverApp, test.get(i))){
                Scroll.toEndPage(this.driverApp);
                if(IsPresent.elements(this.driverApp, SeleccionarModificacionUI.btnAceptar)){
                    Click.on(this.driverApp, SeleccionarModificacionUI.btnAceptar);
                    if(ConfirmarModificacion.isReady(this.driverApp, test.get(i))){
                        ConfirmarModificacion.now(this.driverApp);
                        if(ConfirmarTramite.isReady(this.driverApp, test.get(i))){
                            ConfirmarTramite.grabar(this.driverApp, test.get(i),"enviarPDF.pdf", this.operacion, this.identificador, i + 1);
                            returnMainMenu();
                            GetProforma.detailed(this.driverApp, test.get(i), this.identificador, i + 1);
                        }
                    }
                }else{
                    ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.SKIP, "No se hizo ningún cambio en los datos de la minuta..." );
                    Log.recordInLog("No se hizo ningún cambio en los datos de la minuta...");
                }
            }
        }
    }

    @Override
    public void returnMainMenu() {
        ReturnMainMenu.fromAModule(this.driverApp);
    }

    @Override
    public void login(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password) {
        LoginVehiculos.authenticate(driver, extentReports, extentTest, user, password);
    }

    @Override
    public void logout() {
        LoginVehiculos.logout(this.driverApp);
    }

    @Override
    public String setTestCaseName() {
        return ConstantsVEH.testCaseNameHtmlReportVEH.concat(this.identificador);
    }

    @Override
    public boolean isNotLoggedIn() {
        //return !WaitUntilElement.isElementVisible(this.driverApp, MainMenuUI.lnkCerrarSesion);
        return !Verify.isReady(this.driverApp, test.get(i), MainMenuUI.lnkCerrarSesion);
    }

    @Override
    public String getUser() {
        return ExcelData.getUser(ConstantsVEH.GENERATOR_DATA_FILE, this.accessExcel, i);
    }
}
