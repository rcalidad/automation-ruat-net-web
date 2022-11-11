package main.tasks.vehiculos.modificarDatosTecnicosOperador;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.GiveFormat;
import main.actions.Log;
import main.actions.WaitUntilElement;
import main.helpers.common.Constants;
import main.helpers.common.vehiculos.ConstantsVEH;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.commonTasks.Generator;
import main.tasks.vehiculos.commonVeh.LoadModule;
import main.tasks.vehiculos.commonVeh.ReturnMainMenu;
import main.tasks.vehiculos.commonVeh.SearchVehicle;
import main.tasks.vehiculos.login.LoginVehiculos;
import main.tasks.vehiculos.mainMenu.MainMenu;
import main.tasks.vehiculos.modificacionDatosTecnicos.ModificarDatosTecnicos;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

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
            if (ModificarServicio.isReady(this.driverApp, test.get(i))){
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
                if (SeleccionarModificacion.isReady(this.driverApp, test.get(i))){
                    Log.recordInLog("Servicio modificado...");
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
