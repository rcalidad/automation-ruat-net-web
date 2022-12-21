package main.tasks.vehiculos.condonacionLeyMunicipalImt;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.actions.GiveFormat;
import main.actions.Log;
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
import main.ui.vehiculosUI.commonUI.ConfirmarTramiteUI;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.commonUI.ReceiveDocumentationUI;
import main.ui.vehiculosUI.condonacionLeyMunicipalImtUI.DetalleItemsCondonacionUI;
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class CondonacionLeyMunicipalImt extends Generator {
    protected String operacion;
    protected String identificador;

    public CondonacionLeyMunicipalImt(){
        super();
        this.accessExcel = new AccessExcel(ConstantsVEH.GENERATOR_DATA_FILE, ConstantsVEH.CONDONACION_LEY_MUNICIPAL_IMT_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsVEH.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsVEH.ID_SUBSYSTEM);
    }
    @Override
    public void start() {
        Log.recordInLog(Constants.END_OF_EXECUTION_MARK);
        MainMenu.selectOption(this.driverApp, ConstantsVEH.CONDONACION_GROUPER);
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(this.driverApp, ConstantsVEH.CONDONACION_LEY_MUNICIPAL_IMT_MODULE);
        this.driverApp.switchTo().parentFrame().switchTo().frame(FramesUI.frameNameContenido);
        SearchVehicle.forPTA(this.driverApp, this.identificador);
        if(Verify.isReady(this.driverApp, test.get(i), ReceiveDocumentationUI.ttlRecepcionarDocumentacion)){
            ReceiveDocumentation.toCondonationMunicipalLaw(this.driverApp);
            if (Verify.isReady(this.driverApp, test.get(i), DetalleItemsCondonacionUI.ttlDetalleItemsCondonacion)){
                boolean somethingWasSelected = DetalleItemsCondonacionImt.selectAll(this.driverApp, this.operacion);
                if (somethingWasSelected){
                    ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "Filas seleccionadas");
                    if (this.operacion.equals("REGISTRAR")){
                        RegistrarCondonacionImt.now(this.driverApp);
                    }else if (this.operacion.equals("ANULAR")){
                        AnularCondonacionImt.now(this.driverApp, this.operacion, test.get(i));
                    }
                    if (Verify.isReady(this.driverApp, test.get(i), DetalleItemsCondonacionUI.ttlDetalleItemsCondonacion)){
                        Click.on(this.driverApp, DetalleItemsCondonacionUI.btnAceptar);
                        Verify.isLoading(this.driverApp, 360);
                        if(Verify.isReady(this.driverApp, test.get(i), ConfirmarTramiteUI.ttlConfirmarTramite)){
                            ConfirmarTramite.toConsolidacionLeyMunicipal(this.driverApp, test.get(i), "enviarPDF.pdf", this.operacion, this.identificador, i + 1);
                        }
                    }
                }else {
                    ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.SKIP, "No existe la columna " + this.operacion);
                    Log.recordInLog("No existe la columna " + this.operacion);
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
        return !Verify.isReady(this.driverApp, test.get(i), MainMenuUI.lnkCerrarSesion);
    }

    @Override
    public String getUser() {
        return ExcelData.getUser(ConstantsVEH.GENERATOR_DATA_FILE, this.accessExcel, i);
    }
}
