package main.tasks.vehiculos.compensaciones;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.GetText;
import main.actions.GiveFormat;
import main.actions.Log;
import main.helpers.common.Constants;
import main.helpers.common.vehiculos.ConstantsVEH;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.commonTasks.Generator;
import main.tasks.vehiculos.commonVeh.*;

import main.tasks.vehiculos.login.LoginVehiculos;
import main.tasks.vehiculos.mainMenu.MainMenu;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.commonUI.ReceiveDocumentationUI;
import main.ui.vehiculosUI.compensacionesUI.DatosAutorizacionUI;
import main.ui.vehiculosUI.compensacionesUI.DetalleDeudasUI;
import main.ui.vehiculosUI.compensacionesUI.NotificacionUI;
import main.ui.vehiculosUI.compensacionesUI.VerificacionCompensacionUI;
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Compensaciones extends Generator {
    protected String operacion;
    protected String identificador;
    protected String gestionInicio;
    protected String gestionFin;
    protected String tipoDeuda;
    protected String numeroDocumento;
    protected String fechaDocumento;
    protected String autorizadoPor;
    protected String cargo;
    protected String observaciones;

    public Compensaciones(){
        super();
        this.accessExcel = new AccessExcel(ConstantsVEH.GENERATOR_DATA_FILE, ConstantsVEH.COMPENSACIONES_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsVEH.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsVEH.ID_SUBSYSTEM);
    }
    @Override
    public void start() {
        Log.recordInLog(Constants.END_OF_EXECUTION_MARK);
        MainMenu.selectOption(this.driverApp, ConstantsVEH.COMPENSACIONES_GROUPER);
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(this.driverApp, ConstantsVEH.COMPENSACIONES_MODULE);
        this.driverApp.switchTo().parentFrame().switchTo().frame(FramesUI.frameNameContenido);
        SearchVehicle.forPTA(this.driverApp, this.identificador);
        if (Verify.isReady(this.driverApp, test.get(i), ReceiveDocumentationUI.ttlRecepcionarDocumentacion)){
            ReceiveDocumentation.toCompensaciones(this.driverApp);
            if (Verify.isReady(this.driverApp, test.get(i), DatosAutorizacionUI.ttlDatosAutorizacion)){
                RegisterAuthorizationData.now(this.driverApp, this.numeroDocumento, this.fechaDocumento, this.autorizadoPor, this.cargo, this.observaciones);
                if (Verify.isReady(this.driverApp, test.get(i), DetalleDeudasUI.ttlDetallDeudas)){
                    SelectCompensationDebts.ofVehicle(this.driverApp, test.get(i), this.gestionInicio, this.gestionFin, this.tipoDeuda, "Vehículos");
                    Click.on(this.driverApp, DetalleDeudasUI.btnProcesar);
                    if (Verify.isReady(this.driverApp, test.get(i), VerificacionCompensacionUI.ttlVerificacionCompensacion)){
                        VerificarCompensacion.now(this.driverApp);
                        if (Verify.isReady(this.driverApp, test.get(i), NotificacionUI.ttlNotificacion)){
                            String message = GetText.ifContains(this.driverApp, NotificacionUI.msgNotificacion, "correctamente");
                            Log.recordInLog(message);
                            FileBuilder.moveAndRenameFile("impresion.pdf", "COMPENSACION", this.tipoDeuda, this.identificador, ConstantsVEH.ID_SUBSYSTEM, i + 1);
                        }
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
