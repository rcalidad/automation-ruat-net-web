package main.tasks.cobro.cobrosVehiculos;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.actions.GetText;
import main.actions.Log;
import main.helpers.common.cobro.ConstantsCOB;
import main.helpers.factoryBrowser.FactoryBrowser;
import main.tasks.cobro.common.*;
import main.tasks.cobro.login.LoginCobro;
import main.tasks.cobro.loteoVehiculos.LoteoVehiculos;
import main.ui.cobroUI.commonUI.CommonElementsUI;
import main.ui.cobroUI.commonUI.FramesUI;
import main.ui.cobroUI.mainMenuUI.MainMenuUI;
import main.ui.cobroUI.pagosVehiculosUI.DebtDetailUI;
import main.ui.cobroUI.commonUI.RecordPaymentUI;
import main.ui.cobroUI.pagosVehiculosUI.SearchVehicleUI;
import org.openqa.selenium.WebDriver;

public class PayOneVehicle {
    private WebDriver payDriver;
    String pta;
    String user;
    String password = "C1234567$";
    String url = "https://cobrocalidad.ruat.gob.bo/BancosWeb/Administracion/Autentificacion/index.jsp";
    ExtentReports extentReports;
    ExtentTest extentTest;
    public PayOneVehicle(ExtentTest extentTest, ExtentReports extentReports, String cashierUser){
        payDriver = new FactoryBrowser().make("firefox").create();
        payDriver.get(url);
        payDriver.manage().window().maximize();
        this.extentReports = extentReports;
        this.extentTest = extentTest;
        this.user = cashierUser;
    }
    public void makesAVehicleCharge(String identifier){
        if(loginAs()){
            if (loadModuleFromMainMenu(ConstantsCOB.PAGOS_GROUPER, ConstantsCOB.VEHICULOS_SUB_GROUPER, ConstantsCOB.PAGOS_MODULE)){
                if (collectsAllDebts(identifier)){
                    if (returnMainMenu()){
                        if(loadModuleFromMainMenu(ConstantsCOB.LOTEO_GROUPER, ConstantsCOB.VEHICULOS_SUB_GROUPER, ConstantsCOB.LOTEO_MODULE)){
                            doLoteo();
                        }
                    }
                }
            }

        }
        quitApp();
    }
    public boolean loginAs(){
        LoginCobro.authenticate(payDriver, extentReports, extentTest, user, password);
        boolean flag =Verify.isReady(payDriver, extentTest, MainMenuUI.lnkCerrarSesion);
        return flag;
    }
    public boolean loadModuleFromMainMenu(String grouper, String subGrouper, String module){
        MainMenu.selectOption(payDriver, grouper);
        payDriver.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(payDriver, subGrouper, module);
        payDriver.switchTo().parentFrame();
        payDriver.switchTo().frame(FramesUI.frameNameContenido);
        return Verify.isReady(payDriver, extentTest, SearchVehicleUI.ttlBuscarVehiculo);
    }
    public boolean collectsAllDebts(String identifier){
        SearchVehicle.forPTA(payDriver, identifier);
        if (Verify.isReady(payDriver, extentTest, DebtDetailUI.ttlDetalleDeDeudas)){
            SelectDebts.allDebts(payDriver, extentTest);
            if (Verify.isReady(payDriver, extentTest, RecordPaymentUI.ttlRegistrarPagos)){
                RecordPayment.now(payDriver, extentTest);
                if (Verify.isReady(payDriver, extentTest, CommonElementsUI.ttlNotificacion)){
                    String message = GetText.ifContains(payDriver, CommonElementsUI.msgNotificacion, "pago");
                    Log.recordInLog(message);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean returnMainMenu(){
        ReturnMainMenu.fromAModule(payDriver);
        return Verify.isReady(payDriver, extentTest, MainMenuUI.lnkCerrarSesion);
    }
    public boolean doLoteo(){
        return LoteoVehiculos.toOneVehicleFlow(payDriver);
    }
    public void quitApp(){
        if (payDriver != null){
            payDriver.quit();
        }
    }
    public boolean allDebts(String identifier, ExtentTest extentTest, ExtentReports extentReports){
        LoginCobro.authenticate(payDriver, extentReports, extentTest, user, password);
        boolean flag =Verify.isReady(payDriver, extentTest, MainMenuUI.lnkCerrarSesion);
        MainMenu.selectOption(payDriver, ConstantsCOB.PAGOS_GROUPER);
        payDriver.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(payDriver, ConstantsCOB.VEHICULOS_SUB_GROUPER, ConstantsCOB.PAGOS_MODULE);
        payDriver.switchTo().parentFrame();
        payDriver.switchTo().frame(FramesUI.frameNameContenido);
        SearchVehicle.forPTA(payDriver, identifier);
        if (Verify.isReady(payDriver, extentTest, DebtDetailUI.ttlDetalleDeDeudas)){
            SelectDebts.allDebts(payDriver, extentTest);
            if (Verify.isReady(payDriver, extentTest, RecordPaymentUI.ttlRegistrarPagos)){
                RecordPayment.now(payDriver, extentTest);
                if (Verify.isReady(payDriver, extentTest, CommonElementsUI.ttlNotificacion)){
                    String message = GetText.ifContains(payDriver, CommonElementsUI.msgNotificacion, "pago");
                    Log.recordInLog(message);
                }
            }
        }

        if (payDriver != null){
            payDriver.quit();
        }
        return flag;
    }
}
