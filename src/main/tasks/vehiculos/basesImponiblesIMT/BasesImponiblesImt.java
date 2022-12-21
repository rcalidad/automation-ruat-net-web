package main.tasks.vehiculos.basesImponiblesIMT;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.GiveFormat;
import main.actions.IsDisplayed;
import main.actions.Log;
import main.helpers.common.Constants;
import main.helpers.common.vehiculos.ConstantsVEH;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.cobro.cobrosVehiculos.PayOneVehicle;
import main.tasks.commonTasks.Generator;
import main.tasks.vehiculos.commonVeh.*;
import main.tasks.vehiculos.login.LoginVehiculos;
import main.tasks.vehiculos.mainMenu.MainMenu;
import main.ui.vehiculosUI.basesImponiblesImtUI.AnularBaseImponibleImtUI;
import main.ui.vehiculosUI.basesImponiblesImtUI.DetailTaxBasesImtUI;
import main.ui.vehiculosUI.basesImponiblesImtUI.RegistrarBaseImponibleImtUI;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import main.ui.vehiculosUI.commonUI.ConfirmarTramiteUI;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.commonUI.ReceiveDocumentationUI;
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class BasesImponiblesImt extends Generator {
    //---These variables have the same name of columns defined on Excel file.
    protected String identificador;
    protected String operacion;
    protected String baseImponible;
    protected String cajero;

    public BasesImponiblesImt(){
        super();
        this.accessExcel = new AccessExcel(ConstantsVEH.GENERATOR_DATA_FILE, ConstantsVEH.BASES_IMPONIBLES_IMT_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsVEH.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsVEH.ID_SUBSYSTEM);
    }
    public boolean prepareTaxBase(){
        SearchVehicle.forPTA(this.driverApp, this.identificador);
        if (Verify.isReady(this.driverApp, test.get(i), ReceiveDocumentationUI.ttlRecepcionarDocumentacion)){
            ReceiveDocumentation.toTaxBasesImt(this.driverApp);
            if (Verify.isReady(this.driverApp, test.get(i), DetailTaxBasesImtUI.ttlDetalleBaseImponibleImt)){
                return true;
            }
        }
        return false;
    }
    public boolean registerTaxeBase(String detailOperation, String taxBase){
        boolean isReadyToRegister = prepareTaxBase();
        if (Verify.isReady(this.driverApp, test.get(i), DetailTaxBasesImtUI.ttlDetalleBaseImponibleImt)){
            DetailTaxBaseImt.selectOption(this.driverApp, "Registrar");
            if (Verify.isReady(this.driverApp, test.get(i), RegistrarBaseImponibleImtUI.ttlRegistrarBaseImponibleImt)){
                RegisterTaxBase.now(this.driverApp, taxBase, this.identificador, "Juan Topo");
                if (Verify.isReady(driverApp, test.get(i), DetailTaxBasesImtUI.ttlDetalleBaseImponibleImt)){
                    Click.on(driverApp, DetailTaxBasesImtUI.btnAceptar);
                    if (Verify.isReady(this.driverApp, test.get(i), ConfirmarTramiteUI.ttlConfirmarTramite)){
                        ConfirmarTramite.toTaxBases(this.driverApp, test.get(i), "enviarPDF.pdf", detailOperation, this.identificador, i + 1);
                        if (IsDisplayed.element(this.driverApp, CommonElementsUI.imgFondo)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean annulTaxBase(){
        boolean isReadyToAnnul = prepareTaxBase();
        if (Verify.isReady(this.driverApp, test.get(i), DetailTaxBasesImtUI.ttlDetalleBaseImponibleImt)){
            DetailTaxBaseImt.selectOption(this.driverApp, "Anular");
            if (Verify.isReady(this.driverApp, test.get(i), AnularBaseImponibleImtUI.ttlAnularBaseImponibleImt)){
                AnnulTaxBaseImt.now(this.driverApp, this.identificador);
                if (Verify.isReady(this.driverApp, test.get(i), DetailTaxBasesImtUI.ttlDetalleBaseImponibleImt)){
                    Click.on(this.driverApp, DetailTaxBasesImtUI.btnAceptar);
                    if (Verify.isReady(this.driverApp, test.get(i), ConfirmarTramiteUI.ttlConfirmarTramite)){
                        ConfirmarTramite.toTaxBases(this.driverApp, test.get(i), "enviarPDF.pdf", "ANULAR", this.identificador, i + 1);
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
        MainMenu.selectOption(this.driverApp, ConstantsVEH.BASES_IMPONIBLES_IMT_GROUPER);
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(this.driverApp, ConstantsVEH.BASES_IMPONIBLES_IMT_MODULE);
        this.driverApp.switchTo().parentFrame().switchTo().frame(FramesUI.frameNameContenido);
        boolean isRegisterTaxBaseSuccessful = registerTaxeBase("REGISTRAR-INICIAL", this.baseImponible);
        if (isRegisterTaxBaseSuccessful){
            PayOneVehicle cashier = new PayOneVehicle(test.get(i), this.extentReport, this.cajero, i +1);
            boolean isPaymentSuccessful = cashier.makesAVehicleCharge(this.identificador);
            if (isPaymentSuccessful){
                this.driverApp.switchTo().parentFrame().switchTo().frame(FramesUI.frameNameMenuLateral);
                LoadModule.whichIs(this.driverApp, ConstantsVEH.BASES_IMPONIBLES_IMT_MODULE);
                this.driverApp.switchTo().parentFrame().switchTo().frame(FramesUI.frameNameContenido);
                boolean isAnnulTaxBaseSuccessful = annulTaxBase();
                if (isAnnulTaxBaseSuccessful){
                    this.driverApp.switchTo().parentFrame().switchTo().frame(FramesUI.frameNameMenuLateral);
                    LoadModule.whichIs(this.driverApp, ConstantsVEH.BASES_IMPONIBLES_IMT_MODULE);
                    this.driverApp.switchTo().parentFrame().switchTo().frame(FramesUI.frameNameContenido);
                    int base;
                    try{
                        base = Integer.parseInt(this.baseImponible);
                    }catch (Exception exception){
                        base = 2;
                    }
                    base = this.operacion.equals("SUBIR") ? base * 2 : this.operacion.equals("REDUCIR") ? base / 2 : base;
                    registerTaxeBase("REGISTRAR-RECTIFICATORIO", String.valueOf(base));
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
