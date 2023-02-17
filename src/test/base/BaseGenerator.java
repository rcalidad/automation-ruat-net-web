package test.base;

import com.aventstack.extentreports.ExtentReports;
import main.helpers.common.Constants;
import main.helpers.dataUtility.ReportManager;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import main.helpers.factoryBrowser.FactoryBrowser;

public class BaseGenerator {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions acciones;
    public ExtentReports extentReportBase;
    private String browser = "firefox";

    @BeforeSuite
    public void setUpSuite() throws Exception {
        ScreenShotHelper.setUpSuiteReport();
        this.driver = new FactoryBrowser().make(browser).create();
        this.wait = new WebDriverWait(this.driver, Constants.TIME_OUT);
        this.acciones = new Actions(this.driver);
        try {
            ReportManager.createExtentReportInstanceGenerator();
            extentReportBase = ReportManager.extentReport;
        }catch(Exception generarExcepcion){
            //procesarExcepcionInmuebles(generarExcepcion);
        }
    }

    @AfterSuite
    public static void tearDownSuite(){
        FileBuilder.deleteTemporalDirectory();
    }
}
