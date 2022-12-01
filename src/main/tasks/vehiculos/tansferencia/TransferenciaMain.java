package main.tasks.vehiculos.tansferencia;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class TransferenciaMain extends Generator {
    //---These variables have the same name of columns defined on Excel file.
    protected String operacion;
    protected String identificador;
    protected String crpva;
    protected String numeroCopia;
    protected String fechaMinuta;
    protected String montoMinuta;
    protected String tipoMoneda;
    protected String numeroDocumento;
    protected String tipoDocumento;

    public TransferenciaMain(){
        super();
        this.accessExcel = new AccessExcel(ConstantsVEH.GENERATOR_DATA_FILE, ConstantsVEH.TRANSFERENCIA_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsVEH.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsVEH.ID_SUBSYSTEM);
    }

    @Override
    public void start() {
        Log.recordInLog(Constants.END_OF_EXECUTION_MARK);
        MainMenu.selectOption(this.driverApp, ConstantsVEH.TRANSFERENCIAS_GROUPER);
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(this.driverApp, ConstantsVEH.TRANSFERENCIA_NORMAL_MODULE);
        this.driverApp.switchTo().parentFrame();
        this.driverApp.switchTo().frame(FramesUI.frameNameContenido);
        SearchVehicle.forPTA(this.driverApp, this.identificador);
        if (ValidatePropertyCertificate.isReady(this.driverApp, test.get(i))){
            ValidatePropertyCertificate.withData(this.driverApp, this.crpva, this.numeroCopia);
            if (ReceiveDocumentation.isReady(this.driverApp, test.get(i))){
                ReceiveDocumentation.toTransfer(this.driverApp);
                if(RecordMinute.isReady(this.driverApp, test.get(i))){
                    RecordMinute.with(this.driverApp, this.fechaMinuta, this.montoMinuta, this.tipoMoneda);
                    if (AssignProperty.isReady(this.driverApp, test.get(i))){
                        AssignProperty.to(this.driverApp, this.numeroDocumento, this.tipoDocumento);
                        if (ConfirmRegisteredData.isReady(this.driverApp, test.get(i))){
                            ConfirmRegisteredData.now(this.driverApp);
                            if (ConfirmarTramite.isReady(this.driverApp, test.get(i))){
                                ConfirmarTramite.grabar(this.driverApp, test.get(i), "enviarPDF.pdf", this.operacion, this.identificador, i+1);
                                returnMainMenu();
                                GetProforma.detailed(this.driverApp, test.get(i), this.identificador, i + 1);
                            }
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
