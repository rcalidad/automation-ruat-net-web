package main.tasks.vehiculos.comprobantePagoEnCero;

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
import main.ui.vehiculosUI.emisionComprobantePagoEnCeroUI.DetalleDeudasUI;
import main.ui.vehiculosUI.emisionComprobantePagoEnCeroUI.NotificacionUI;
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class EmisionComprobantePagoEnCero extends Generator {
    protected String operacion;
    protected String identificador;
    protected String tipoDeuda;
    protected String gestionInicio;
    protected String gestionFin;

    public EmisionComprobantePagoEnCero(){
        super();
        this.accessExcel = new AccessExcel(ConstantsVEH.GENERATOR_DATA_FILE, ConstantsVEH.COMPROBANTE_PAGO_EN_CERO_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsVEH.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsVEH.ID_SUBSYSTEM);
    }
    @Override
    public void start() {
        Log.recordInLog(Constants.END_OF_EXECUTION_MARK);
        MainMenu.selectOption(this.driverApp, ConstantsVEH.COMPROBANTE_PAGO_EN_CERO_GROUPER);
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(this.driverApp, ConstantsVEH.COMPROBANTE_PAGO_EN_CERO_MODULE);
        this.driverApp.switchTo().parentFrame().switchTo().frame(FramesUI.frameNameContenido);
        SearchVehicle.forPTA(this.driverApp, this.identificador);
        if (Verify.isReady(this.driverApp, test.get(i), DetalleDeudasUI.ttlDetallDeudas)){
            SelectDebtsComprobantePagoCero.ofVehicle(this.driverApp, test.get(i), this.gestionInicio, this.gestionFin, this.tipoDeuda, "Vehículos");
            Click.on(this.driverApp, DetalleDeudasUI.btnConsolidar);
            VerifyAlert.containsThisText(this.driverApp, "Confirma");
            if (Verify.isReady(this.driverApp, test.get(i), NotificacionUI.ttlNotificacion)){
                String message = GetText.ifContains(this.driverApp, NotificacionUI.msgNotificacion, "correctamente");
                Log.recordInLog(message);
                FileBuilder.moveAndRenameFile("impresion.pdf", "COMPROBANTE-PAGO-EN-CERO", this.tipoDeuda, this.identificador, ConstantsVEH.ID_SUBSYSTEM, i + 1);
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
