package main.tasks.vehiculos.modificarDatosTecnicosOperador;

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
import main.tasks.vehiculos.modificacionDatosTecnicos.ModificarDatosTecnicos;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import main.ui.vehiculosUI.modificarDatosTecnicosOperadorUI.SeleccionarModificacionUI;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ModificarDatosTecnicosOperador extends Generator {
    public static final String MODIFICACION_DATOS_TECNICOS_OPERADOR_DATA_SHEET = "ModificarDatosTecnicosOperador";
    public static final String MODIFICACION_DATOS_TECNICOS_GROUPER = "Modificación Datos Técnicos";
    public static final String MODIFICACION_DATOS_TECNICOS_OPERADOR_MODULE = "Modificación Datos Técnicos Operador";
    //---These variables have the same name of columns defined on Excel file.
    protected String operacion;
    protected String identificador;
    protected String servicio;
    protected String fechaInicio;
    protected String fechaFin;

    public ModificarDatosTecnicosOperador(){
        super();
        this.accessExcel = new AccessExcel(ConstantsVEH.GENERATOR_DATA_FILE, MODIFICACION_DATOS_TECNICOS_OPERADOR_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsVEH.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsVEH.ID_SUBSYSTEM);
    }
    public void modifyService(){
        if (ModificarServicio.isReady(this.driverApp, test.get(i))){
            Log.recordInLog("Modificando servicio a: " + this.servicio);
            switch (this.servicio){
                case "PARTICULAR":
                    ModificarServicio.toParticular(this.driverApp, this.fechaInicio, "PARTICULAR");
                    break;
                case "OFICIAL":
                    ModificarServicio.toOfficial(this.driverApp, this.fechaInicio, "OFICIAL");
                    break;
                case "PUBLICO":
                    ModificarServicio.toPublic(this.driverApp, test.get(i), "PUBLICO", this.identificador, this.fechaInicio, this.fechaFin);
                    break;
                default:
                    Log.recordInLog("Servicio no identificado, verifique los datos de entrada....");
                    break;
            }
        }
    }
    public void modifyTaxStartDate(){
        if (ModificarFechaInicioImpuesto.isReady(this.driverApp, test.get(i))){
            ModificarFechaInicioImpuesto.to(this.driverApp, this.fechaInicio);
        }
    }
    @Override
    public void start() {
        Log.recordInLog(Constants.END_OF_EXECUTION_MARK);
        MainMenu.selectOption(this.driverApp, MODIFICACION_DATOS_TECNICOS_GROUPER);
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(this.driverApp, MODIFICACION_DATOS_TECNICOS_OPERADOR_MODULE);
        this.driverApp.switchTo().parentFrame();
        this.driverApp.switchTo().frame(FramesUI.frameNameContenido);
        SearchVehicle.forPTA(this.driverApp, this.identificador);
        if (SeleccionarModificacion.isReady(this.driverApp, test.get(i))){
            SeleccionarModificacion.option(this.driverApp, this.operacion);
            Log.recordInLog("Seleccionando dato a modificar: " + this.operacion + "...");
            try{
                Method methodModify = this.getClass().getMethod(ModificationOption.modificationProcess.get(this.operacion));
                methodModify.invoke(this);
            }catch (NoSuchMethodException noSuchMethodException){
                Log.recordInLog("No se pudo ejecutar el método...");
            }catch (Exception e){
                Log.recordInLog("No se pudo ejecutar el método...");
            }
            if (SeleccionarModificacion.isReady(this.driverApp, test.get(i))){
                Scroll.toEndPage(this.driverApp);
                Click.on(this.driverApp, SeleccionarModificacionUI.btnAceptar);
                if (ConfirmarModificacion.isReady(this.driverApp, test.get(i))){
                    ConfirmarModificacion.now(this.driverApp);
                    if(ConfirmarTramite.isReady(this.driverApp, test.get(i))){
                        ConfirmarTramite.modificaiconDatosPorOperador(this.driverApp, test.get(i),"enviarPDF.pdf", this.operacion, this.identificador, i + 1);
                        returnMainMenu();
                        GetProforma.detailed(this.driverApp, test.get(i), this.identificador, i + 1);
                        Log.recordInLog("Dato modificado...");
                    }else {
                        Log.recordInLog("No fue posible modificar el dato...");
                    }
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
        LoginVehiculos.authenticate(this.driverApp, extentReports, extentTest, user, password);
    }

    @Override
    public void logout() {
        LoginVehiculos.logout(this.driverApp);
    }

    @Override
    public String setTestCaseName() {
        return "Nro. de vehículo ".concat(this.identificador);
    }

    @Override
    public boolean isNotLoggedIn() {
        return !WaitUntilElement.isElementVisible(this.driverApp, MainMenuUI.lnkCerrarSesion);
    }

    @Override
    public String getUser() {
        return ExcelData.getUser(ConstantsVEH.GENERATOR_DATA_FILE, this.accessExcel, i);
    }
}
