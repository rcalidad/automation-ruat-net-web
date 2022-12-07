package main.tasks.vehiculos.basesImponibles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
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
import main.ui.vehiculosUI.basesImponiblesUI.DetailTaxBasesUI;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class BasesImponiblesMain extends Generator {
    //---These variables have the same name of columns defined on Excel file.
    protected String identificador;
    protected String operacion;
    protected String gestion;
    protected String baseImponible;

    public BasesImponiblesMain(){
        super();
        this.accessExcel = new AccessExcel(ConstantsVEH.GENERATOR_DATA_FILE, ConstantsVEH.BASES_IMPOSIBLES_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsVEH.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsVEH.ID_SUBSYSTEM);
    }
    public boolean registerTaxBase(){
        SearchVehicle.forPTA(this.driverApp, this.identificador);
        if(ReceiveDocumentation.isReady(this.driverApp, test.get(i))){
            ReceiveDocumentation.toTaxBases(this.driverApp);
            if (DetailTaxBases.isReady(this.driverApp, test.get(i))){
                DetailTaxBases.register(this.driverApp, test.get(i), this.gestion);
                if(RegisterTaxBase.isReady(this.driverApp, test.get(i))){
                    RegisterTaxBase.register(this.driverApp, test.get(i), this.gestion, this.baseImponible, this.identificador);
                    if (DetailTaxBases.isReady(this.driverApp, test.get(i))){
                        Click.on(this.driverApp, DetailTaxBasesUI.btnAceptar);
                        if (ConfirmarTramite.isReady(this.driverApp, test.get(i))){
                            ConfirmarTramite.toTaxBases(this.driverApp, test.get(i), "enviarPDF.pdf", this.operacion, this.identificador, i + 1);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    @Override
    public void start() {
        Log.recordInLog(Constants.END_OF_EXECUTION_MARK);
        MainMenu.selectOption(this.driverApp, ConstantsVEH.BASES_IMPONIBLES_GROUPER);
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(this.driverApp, ConstantsVEH.BASES_IMPONIBLES_MODULE);
        this.driverApp.switchTo().parentFrame();
        this.driverApp.switchTo().frame(FramesUI.frameNameContenido);

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
