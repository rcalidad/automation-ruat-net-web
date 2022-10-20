package main.tasks.commonTasks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.actions.DisplayAlert;
import main.actions.Log;
import main.actions.LogTime;
import main.helpers.common.Constants;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Generator {
    protected String url;
    protected boolean useTestData; //usar excel de casos de prueba
    protected WebDriver driverApp;
    protected WebDriverWait wait;
    protected StringBuilder errorMessage;
    protected ExtentReports extentReport;
    protected ArrayList< String > namesReportFiles;
    protected AccessExcel accessExcel;
    //--- These variables have the same name of columns defined on Excel file.
    protected String password;
    protected String usuario;
    protected String municipio;

    public Generator() {
        this.useTestData = false;
        this.errorMessage = new StringBuilder(" ERROR: ");
        this.namesReportFiles = new ArrayList<>();
    }

    //VARIABLES PARA REPORTES GENERADOS EN CADA EJECUCION run()
    public static List<ExtentTest> test = new ArrayList<>();
    public static int i=0;
    public  <E extends main.tasks.actividadesEconomicas.commonAec.Generator> void run(WebDriver driver, WebDriverWait wait, ExtentReports extentReport){
        String currentTown  = "";
        String beforeTown = "";
        int quantityCases = this.accessExcel.getNroDatosPrueba();
        this.extentReport = extentReport;
        for(int row_i = 0; row_i < quantityCases; row_i ++)
        {
            try
            {
                ExcelData.load(row_i, this.accessExcel, this);
                test.add( this.extentReport.createTest(this.setTestCaseName()).assignAuthor("T - " + row_i));
                currentTown = this.municipio;
                beforeTown = ExcelData.getBeforeTown(this.accessExcel, row_i);
                i = row_i;
                if(!currentTown.equals(beforeTown) || loggedIn())
                {
                    this.logout();
                    this.driverApp = driver;
                    this.wait = wait;
                    this.usuario = ExcelData.getUser(ConstantsAEC.GENERATOR_DATA_FILE,this.accessExcel,row_i);
                    this.password = ExcelData.getPassword(this.usuario);
                    this.initApplication(this.url, this.usuario, this.password);
                }
                this.start();
            }
            catch(AssertionError flowFault)
            {
                processFail(flowFault);
            }
            catch(Exception generarExcepcion)
            {
                //procesarExcepcionInmuebles(generarExcepcion);
            }
            finally
            {
                try
                {
                    returnMainMenu( );
                }
                catch ( Exception generarExcepcion ) { }
            }
        }
        Log.recordInLog(Constants.DELIMITER_MARK);
        LogTime.end();
        Log.endInLog(" Módulo (".concat(this.getClass().getSimpleName().toUpperCase().concat(")")));
        this.extentReport.flush();
        if (this.driverApp != null){
            this.driverApp.quit();
        }
    }
    public void initApplication(String url, String user, String password) throws Exception {
        openApplication(url);
        Log.onEnvironment( this.getClass().getSimpleName().toUpperCase(), url);
        login(this.driverApp, extentReport, test.get(i), user, password);
    }
    protected void openApplication(String url){
        Set<String> windows = null;
        this.driverApp.get(url);  // Abre el navegador y redirige a una URL.
        this.wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        Log.recordInLog("Tiempo Inicialización (navegador): ".concat(LogTime.timeElapsed()));
        windows = this.driverApp.getWindowHandles();
        this.driverApp.switchTo().window(windows.toArray()[0].toString());
        Log.recordInLog("Abriendo aplicación...");
        this.driverApp.manage().window().maximize();
    }
    public void processFail ( AssertionError flowFault ){
        Log.recordInLog( flowFault.getMessage ( ).replaceAll ( "\n", " " ) );
        if ( isAlertPresent( ) )
        {
            DisplayAlert.toAcept(this.driverApp);
        }
        this.errorMessage.delete ( 8, this.errorMessage.length ( ) );
    }
    public boolean isAlertPresent(){
        try
        {
            this.driverApp.switchTo().alert();
            return true;
        }
        catch(NoSuchElementException noSuchElementException)
        {
            return false;
        }
        catch(NoAlertPresentException noAlertPresentException)
        {
            return false;
        }
    }
    public abstract void start();
    public abstract void returnMainMenu();
    public abstract void login(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password);
    public abstract void logout();
    public abstract String setTestCaseName();
    public abstract boolean loggedIn();
}
