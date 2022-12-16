package main.tasks.vehiculos.basesImponibles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.actions.*;
import main.helpers.common.Constants;
import main.helpers.common.cobro.ConstantsCOB;
import main.helpers.common.vehiculos.ConstantsVEH;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.cobro.cobrosVehiculos.PayOneVehicle;
import main.tasks.commonTasks.Generator;
import main.tasks.vehiculos.commonVeh.*;
import main.tasks.vehiculos.login.LoginVehiculos;
import main.tasks.vehiculos.mainMenu.MainMenu;
import main.ui.vehiculosUI.basesImponiblesUI.DetailTaxBasesUI;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class BasesImponiblesMain extends Generator {
    //---These variables have the same name of columns defined on Excel file.
    protected String identificador;
    protected String operacion;
    protected String gestion;
    protected String baseImponible;
    protected String cajero;

    public BasesImponiblesMain(){
        super();
        this.accessExcel = new AccessExcel(ConstantsVEH.GENERATOR_DATA_FILE, ConstantsVEH.BASES_IMPOSIBLES_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsVEH.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsVEH.ID_SUBSYSTEM);
    }
    public boolean prepareTaxBase(){
        SearchVehicle.forPTA(this.driverApp, this.identificador);
        if(ReceiveDocumentation.isReady(this.driverApp, test.get(i))) {
            ReceiveDocumentation.toTaxBases(this.driverApp);
            if (DetailTaxBases.isReady(this.driverApp, test.get(i))) {
                return true;
            }
        }
        return false;
    }
    public boolean registerTaxBase(String newTaxBase, String detail){
        boolean isReadyToRegister = prepareTaxBase();
        if (isReadyToRegister){
            DetailTaxBases.register(this.driverApp, test.get(i), this.gestion);
            if(RegisterTaxBase.isReady(this.driverApp, test.get(i))){
                RegisterTaxBase.register(this.driverApp, test.get(i), this.gestion, newTaxBase, this.identificador);
                if (DetailTaxBases.isReady(this.driverApp, test.get(i))){
                    Scroll.toEndPage(this.driverApp);
                    Click.on(this.driverApp, DetailTaxBasesUI.btnAceptar);
                    if (ConfirmarTramite.isReady(this.driverApp, test.get(i))){
                        ConfirmarTramite.toTaxBases(this.driverApp, test.get(i), "enviarPDF.pdf", detail, this.identificador, i + 1);
                        if (IsDisplayed.element(this.driverApp, CommonElementsUI.imgFondo)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean anullTaxBase(){
        boolean isReadyToAnull = prepareTaxBase();
        if (isReadyToAnull){
            DetailTaxBases.annul(this.driverApp, test.get(i), this.gestion);
            if (AnullTaxBase.isReady(this.driverApp, test.get(i))){
                AnullTaxBase.now(this.driverApp, test.get(i), this.identificador);
                if (DetailTaxBases.isReady(this.driverApp, test.get(i))){
                    Scroll.toEndPage(this.driverApp);
                    Click.on(this.driverApp, DetailTaxBasesUI.btnAceptar);
                    if (ConfirmarTramite.isReady(this.driverApp, test.get(i))){
                        ConfirmarTramite.toTaxBases(this.driverApp, test.get(i), "enviarPDF.pdf", "ANULAR", this.identificador, i +1);
                        if (IsDisplayed.element(this.driverApp, CommonElementsUI.imgFondo)){
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
        boolean isRegisterTaxBaseSuccessful = registerTaxBase(this.baseImponible, "REGISTRAR-INICIAL");
        if (isRegisterTaxBaseSuccessful){
            PayOneVehicle cajero = new PayOneVehicle(test.get(i), this.extentReport, this.cajero, i + 1);
            boolean isPaymentSuccessful = cajero.makesAVehicleCharge(this.identificador);
            if (isPaymentSuccessful){
                this.driverApp.switchTo().parentFrame();
                this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
                LoadModule.whichIs(this.driverApp, ConstantsVEH.BASES_IMPONIBLES_MODULE);
                this.driverApp.switchTo().parentFrame();
                this.driverApp.switchTo().frame(FramesUI.frameNameContenido);
                boolean isAnullTaxBaseSuccessful = anullTaxBase();
                if (isAnullTaxBaseSuccessful){
                    int base;
                    try{
                        base = Integer.parseInt(this.baseImponible);
                    }catch (Exception exception){
                        base = 2;
                    }
                    this.driverApp.switchTo().parentFrame();
                    this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
                    LoadModule.whichIs(this.driverApp, ConstantsVEH.BASES_IMPONIBLES_MODULE);
                    this.driverApp.switchTo().parentFrame();
                    this.driverApp.switchTo().frame(FramesUI.frameNameContenido);
                    base = this.operacion.equals("SUBIR") ? base * 2 : this.operacion.equals("REDUCIR") ? base / 2 : base;
                    registerTaxBase(String.valueOf(base), "REGISTRAR-RECTIFICATORIO");
                    returnMainMenu();
                    GetProforma.detailed(this.driverApp, test.get(i), this.identificador, i +1);
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
