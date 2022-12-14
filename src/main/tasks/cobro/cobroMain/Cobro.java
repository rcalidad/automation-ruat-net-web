package main.tasks.cobro.cobroMain;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.actions.Log;
import main.actions.WaitUntilElement;
import main.helpers.common.Constants;
import main.helpers.common.cobro.CobroOptions;
import main.helpers.common.cobro.ConstantsCOB;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.cobro.cobroActividadesEconomicas.PayActividadEconomica;
import main.tasks.cobro.cobroTasasOtrosIngresos.PayTasaOtrosIngresos;
import main.tasks.cobro.cobrosInmuebles.PayInmueble;
import main.tasks.cobro.cobrosVehiculos.PayVehicle;
import main.tasks.cobro.common.LoadModule;
import main.tasks.cobro.common.ReturnMainMenu;
import main.tasks.cobro.login.LoginCobro;
import main.tasks.cobro.loteoActividadesEconomicas.LoteoActividadesEconomicas;
import main.tasks.cobro.loteoInmuebles.LoteoInmuebles;
import main.tasks.cobro.loteoTasasOtrosIngresos.LoteoTasasOtrosIngresos;
import main.tasks.cobro.loteoVehiculos.LoteoVehiculos;
import main.tasks.commonTasks.Generator;
import main.ui.cobroUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;

public class Cobro extends Generator {
    protected String identificador;
    protected String operacion;
    protected String rubro;
    protected String entidad;
    protected String gestionInicio;
    protected String gestionFin;
    protected String tipoDeuda;
    protected String tipoTasa;

    public Cobro(){
        super();
        this.accessExcel = new AccessExcel(ConstantsCOB.GENERATOR_DATA_FILE, ConstantsCOB.PAGAR_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsCOB.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(this.getClass().getSimpleName(), ConstantsCOB.ID_SUBSYSTEM);
    }
    public void pagarVehiculo(){
        PayVehicle.now(this.driverApp, test.get(i), this.identificador, this.gestionInicio, this.gestionFin, this.tipoDeuda, i + 1, this.rubro);
    }
    public void loteoVehiculo(){
        LoteoVehiculos.now(this.driverApp, test.get(i), i + 1);
    }
    public void pagarInmueble(){
        PayInmueble.now(this.driverApp, test.get(i), this.identificador, this.entidad, this.gestionInicio, this.gestionFin, this.tipoDeuda, i + 1, this.rubro);
    }
    public void loteoInmueble(){
        LoteoInmuebles.now(this.driverApp, test.get(i), i + 1);
    }
    public void pagarActividadEconomica(){
        PayActividadEconomica.now(this.driverApp, test.get(i), this.identificador, this.entidad, this.gestionInicio, this.gestionFin, this.tipoDeuda, i + 1, this.rubro);
    }
    public void loteoActividadEconomica(){
        LoteoActividadesEconomicas.now(this.driverApp, test.get(i), i + 1);
    }
    public void pagarTasasOtrosIngresos(){
        PayTasaOtrosIngresos.now(this.driverApp, test.get(i), this.identificador, this.entidad, this.gestionInicio, this.gestionFin, this.tipoDeuda, i + 1, this.rubro, this.tipoTasa);
    }
    public void loteoTasasOtrosIngresos(){
        LoteoTasasOtrosIngresos.now(this.driverApp, test.get(i), i + 1);
    }

    @Override
    public void start() {
        Log.recordInLog(Constants.DELIMITER_MARK);
        Log.recordInLog("Cargando módulo...");
        LoadModule.fromMainMenu(this.driverApp, this.rubro, this.operacion);
        Log.recordInLog("Iniciando el proceso de " + this.operacion + " en el rubro " + this.rubro);
        try{
            Method method = this.getClass().getMethod(CobroOptions.operations.get(this.rubro).get(this.operacion));
            method.invoke(this);
        }catch(NoSuchMethodException noSuchMethodException){
            Log.recordInLog("No se encontró el método " + CobroOptions.operations.get(this.rubro).get(this.operacion));
        }catch (Exception exception){
            Log.recordInLog("No se pudo ejecutar el método " + CobroOptions.operations.get(this.rubro).get(this.operacion));
        }
    }

    @Override
    public void returnMainMenu() {
        ReturnMainMenu.fromAModule(this.driverApp);
    }

    @Override
    public void login(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password) {
        LoginCobro.authenticate(driver, extentReports, extentTest, user, password);
    }

    @Override
    public void logout() {
        LoginCobro.logout(this.driverApp);
    }

    @Override
    public String setTestCaseName() {
        return ConstantsCOB.testCaseNameHtmlReportCOB.concat(this.identificador).concat(" ").concat(this.rubro).concat(" ").concat(this.tipoTasa);
    }

    @Override
    public boolean isNotLoggedIn() {
        return !WaitUntilElement.isElementVisible(this.driverApp, MainMenuUI.lnkCerrarSesion);
    }

    @Override
    public String getUser() {
        String user = ExcelData.getUser(ConstantsCOB.GENERATOR_DATA_FILE, this.accessExcel, i);
        String[] usernameParts = user.split("\\.");
        return usernameParts[0];
    }
}
