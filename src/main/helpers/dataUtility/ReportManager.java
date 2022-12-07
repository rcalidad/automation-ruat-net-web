package main.helpers.dataUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class ReportManager {
    public static ExtentReports extentReport;
    private static String filePath = "";
    private static String reportName;

    private static ConcurrentHashMap extentTestMap = new ConcurrentHashMap();
    private static ReportManager instance;

    private ReportManager() throws Exception {
        createExtentReportInstance();
    }


    public static ReportManager getInstance(){
        if (instance == null){
            //synchronized block to remove overhead
            synchronized (ReportManager.class){
                if (instance == null){
                    try {
                        // if instance is null, initialize
                        instance = new ReportManager();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }

    public ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public ExtentTest startTest(String testName) {
        ExtentTest test = extentReport.createTest(testName);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public void flush() {
        extentReport.flush();
    }

    private void createExtentReportInstance() throws Exception {

        if (filePath.equals("")) {
            throw new Exception("Necesita llamar al metodo Init para crear un Objeto Reporte");
        }

        createReportPath();
        extentReport = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(filePath);
        htmlReporter.config().setDocumentTitle("Reporte de Automatización " + reportName);
        htmlReporter.config().setReportName(reportName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setTimeStampFormat("EEEE, dd MMMM , yyyy, hh:mm a '('zzz')'");

        extentReport.attachReporter(htmlReporter);
    }

    public static void createReportPath() {
        new File(filePath).mkdirs();
    }

    public static void init(String reportPath, String reportName) throws Exception {
        if (extentReport == null) {
            filePath = reportPath;
            ReportManager.reportName = reportName;
        } else {
            throw new Exception("ExtentReports is already initialized");
        }
    }
    public static void createExtentReportInstanceGenerator() throws Exception {

        if (filePath.equals("")) {
            throw new Exception("Necesita llamar al metodo Init para crear un Objeto Reporte");
        }

        createReportPath();
        extentReport = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(filePath);
        htmlReporter.config().setDocumentTitle("Reporte Automatizacion ");
        htmlReporter.config().setReportName("Reporte Automatizacion");
        //htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTheme(Theme.DARK);
        //htmlReporter.config().setEncoding("UTF-16");
        //htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setTimeStampFormat("dd.MMMM.yyyy HH:mm:ss a");
        //htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        //htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        extentReport.attachReporter(htmlReporter);
    }
}

