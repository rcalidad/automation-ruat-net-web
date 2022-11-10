package main.tasks.actividadesEconomicas.liquidacion;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.common.Constants;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.commonTasks.Generator;
import main.tasks.actividadesEconomicas.login.LoginActividadesEconomicas;
import main.tasks.actividadesEconomicas.mainMenu.MainMenu;
import main.ui.actividadesEconomicasUI.commonUI.FramesUI;
import main.ui.actividadesEconomicasUI.commonUI.LeftMenuUI;
import main.ui.actividadesEconomicasUI.liquidacionUI.DeudaUI;
import main.ui.actividadesEconomicasUI.liquidacionUI.ProformaUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Proforma extends Generator {
    public static final String MODULO_PROFORMA = "Proforma";
    public static final String DEFAULT_REPORT_NAME = "reportePDF.pdf";
    private String operation;
    //--- These variables have the same name of columns defined on Excel file.
    protected String operacion;
    protected String detalleDeuda;
    protected String numeroActividadEconomica;
    protected String gestionInicio;
    protected String gestionFin;

    public Proforma ( )
    {
        super ( );
        this.accessExcel = new AccessExcel(ConstantsAEC.GENERATOR_DATA_FILE, ConstantsAEC.PROFORMA_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsAEC.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(this.getClass().getSimpleName().toUpperCase(), ConstantsAEC.SUBSYSTEM_ID);
    }
    public void start(){
        Log.recordInLog(Constants.DELIMITER_MARK);
        MainMenu.selectOption(this.driverApp, MODULO_PROFORMA);
        searchActivity();
        getProforma();
    }
    public void returnMainMenu(){
        this.driverApp.switchTo().parentFrame();
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        Click.on(this.driverApp, LeftMenuUI.lnkMenuPrincipal);
        this.driverApp.switchTo().parentFrame();
    }

    public void searchActivity(){
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        Click.on(this.driverApp, ProformaUI.lnkProforma);
        this.driverApp.switchTo().defaultContent();
        this.driverApp.switchTo().frame(FramesUI.frameNameContenido);
        Log.recordInLog("Nro. Actividad Economica: ".concat(numeroActividadEconomica));
        Enter.text(this.driverApp, ProformaUI.txtIdentificador, numeroActividadEconomica);
        Click.on(this.driverApp, ProformaUI.rbtNumeroActividad);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, this.test.get(i), Status.INFO, "<b>BUSQUEDA ACTIVIDAD ECONOMICA</b>");
        //Generator.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, this.extentReport, Status.INFO, "<b>BUSQUEDA ACTIVIDAD ECONOMICA</b>");
        Click.on(this.driverApp, ProformaUI.btnBuscar);
        if(IsDisplayed.element(this.driverApp, ProformaUI.imgEnProgreso)){
            WaitUntilElement.isInvisibleElement(this.driverApp, ProformaUI.imgEnProgreso);
        }
        if(IsPresent.elements(this.driverApp, ProformaUI.btnContinuar)){
            Click.on(this.driverApp, ProformaUI.btnContinuar);
        }
    }

    public void getProforma(){
        List<WebElement> rowsDeuda = this.driverApp.findElements(DeudaUI.filas);
        List<WebElement> headerDeuda = this.driverApp.findElements(DeudaUI.cabecera);
        int numberOfRows = rowsDeuda.size();
        int numberOfColumns = headerDeuda.size();
        Log.recordInLog("Ejecutando operación: ".concat(this.operacion));
        if(!this.operacion.equals("SOLO LIQUIDAR")){
            for (int i = 2; i <= numberOfRows; i++){
                if(checkDebtDetails(i)){
                    if (isIntoYearsRange(i)){
                        Click.on(this.driverApp, DeudaUI.getCell(i, numberOfColumns));
                    }
                }
            }
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, this.test.get(i), Status.INFO, "<b>Detalle de deuda: ".concat(this.detalleDeuda).concat("</b>"));
            //Generator.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, this.extentReport, Status.INFO, "<b>Detalle de deuda: ".concat(this.detalleDeuda).concat("</b>"));
            print();
            if (WaitUntilAlert.isPresent(this.driverApp)){
                DisplayAlert.toAcept(this.driverApp);
            }
            if (FileBuilder.moveFile(DEFAULT_REPORT_NAME)){
                FileBuilder.renameReport(DEFAULT_REPORT_NAME, this.operation, this.detalleDeuda, this.numeroActividadEconomica, ConstantsAEC.SUBSYSTEM_ID, i + 1);
            }
        }

    }
    public boolean isIntoYearsRange(int i){
        int startYear = Integer.parseInt(this.gestionInicio);
        int finalYear = Integer.parseInt(this.gestionFin);
        String year = GetText.of(this.driverApp, DeudaUI.getCell(i,1));
        if(!year.equals("")){
            if(Integer.parseInt(year) >= startYear && Integer.parseInt(year) <= finalYear){
                return true;
            }
        }
        return false;
    }
    public boolean checkDebtDetails(int i){
        String debtType = GetText.of(this.driverApp, DeudaUI.getCell(i, 2));
        boolean sw;
        switch (this.detalleDeuda){
            case "PF":
                sw = debtType.contains("PATENTE");
                break;
            case "MI":
                sw = debtType.contains("INCUMPLIMIENTO");
                break;
            case "OP":
                sw = debtType.contains("OMISION");
                break;
            case "RE":
                sw = debtType.contains("RECIBO");
                break;
            default:
                sw = true;
                break;
        }
        return sw;
    }
    public void print(){
        switch (this.operacion){
            case "PROFORMA DETALLADA":
                this.operation = "DETALLADA";
                Click.on(this.driverApp, DeudaUI.btnProformaDetallada);
                break;
            case "PROFORMA RESUMIDA":
                this.operation = "RESUMIDA";
                Click.on(this.driverApp, DeudaUI.proformaResumidaButton);
                break;
            default:
                break;
        }
    }
    public void executeOperation(){
        switch (this.operacion){
            case "PROFORMA DETALLADA":
                this.operation = "DETALLADA";
                Click.on(this.driverApp, DeudaUI.btnProformaDetallada);
                break;
            case "PROFORMA RESUMIDA":
                this.operation = "RESUMIDA";
                Click.on(this.driverApp, DeudaUI.proformaResumidaButton);
                break;
            default:
                this.operation = "noProforma";
                break;
        }
    }
    public String setTestCaseName(){
        return "Nro. de Actividad Económica ".concat(this.numeroActividadEconomica);
    }
    public void logout(){
        LoginActividadesEconomicas.logout(this.driverApp);
    }
    public void login(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password){
        LoginActividadesEconomicas.as(driver, extentReports, extentTest, user, password);
    }
    public boolean isNotLoggedIn(){
        return LoginActividadesEconomicas.loginFailed;
    }

    @Override
    public String getUser() {
        return ExcelData.getUser(ConstantsAEC.GENERATOR_DATA_FILE,this.accessExcel,i);
    }
}
