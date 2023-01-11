package main.tasks.inmuebles.autoavaluos;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Find;
import main.actions.GetText;
import main.tasks.commonTasks.VerifyYear;
import main.tasks.inmuebles.commonInm.Verify;
import main.ui.inmueblesUI.autoavaluosUI.AnularAutoavaluoUI;
import main.ui.inmueblesUI.autoavaluosUI.DetalleAutoavaluosUI;
import main.ui.inmueblesUI.autoavaluosUI.RegistrarAutoavaluoUI;
import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SelectPeriodsOfTable {
    public static void to(WebDriver driver, ExtentTest extentTest,
                          IPeriodTable table, String operation,
                          String initialYear, String finalYear,
                          String detailOfPeriod, String amount,
                          String date, String observation){
        List<WebElement> pages;
        int nroDebtsChecked = 0;
        try{
            pages = driver.findElements(table.getPager());
        }catch (NoSuchElementException noSuchElementException){
            pages = new ArrayList<>();
        }
        int nroPages = pages.size() == 0 ? 1 : pages.size() / 2;
        for (int p = 0; p < nroPages; p++){
            List<WebElement> updatedPager = driver.findElements(table.getPager());
            updatedPager.get(p).click();
            executeOperationOnTable(driver, extentTest, table, initialYear, finalYear, detailOfPeriod, operation, amount, date, observation);
        }

    }

    public static void executeOperationOnTable(WebDriver driver, ExtentTest extentTest,
                                               IPeriodTable table, String initialYear,
                                               String finalYear, String detailOfPeriod,
                                               String operation, String amount,
                                               String date, String observation){
        try {
            List<WebElement> rows = driver.findElements(table.getRows());
            for (int row = 2; row <= rows.size(); row++){
                if(!detailOfPeriod.equalsIgnoreCase("TODOS")){
                    String year = GetText.of(driver, table.getCell(row, 1));
                    if (VerifyYear.isIntoYearsRange(year, initialYear, finalYear)){
                        executeOperation(driver, extentTest, table, operation, row, amount, date, observation);
                        //Verify.elementIsReady(driver, extentTest, DetalleAutoavaluosUI.ttlDetalleAutoavaluos);
                    }
                }else {
                    executeOperation(driver, extentTest, table, operation, row, amount, date, observation);
                    //Verify.elementIsReady(driver, extentTest, DetalleAutoavaluosUI.ttlDetalleAutoavaluos);
                }
            }
        }catch (Exception exception){

        }
    }
    public static boolean getIntoOperation(WebDriver driver, IPeriodTable table, String operation, int row){
        List<WebElement> columns = Find.elements(driver, table.getColumns(row));
        String operationAvailable = GetText.of(driver, table.getCell(row, columns.size()));
        if (operationAvailable.equalsIgnoreCase(operation)){
            Click.on(driver, table.getCell(row, columns.size()));
            return true;
        }
        operationAvailable = GetText.of(driver, table.getCell(row, columns.size() - 1));
        if (operationAvailable.equalsIgnoreCase(operation)){
            Click.on(driver, table.getCell(row, columns.size() - 1));
            return true;
        }
        return false;
    }
    public static void executeOperation(WebDriver driver, ExtentTest extentTest, IPeriodTable table, String operation, int row, String amount, String date, String observation){
        try{
            if (getIntoOperation(driver, table, operation, row)){
                if (operation.equalsIgnoreCase("Registrar")){
                    registerSelfAssessment(driver, extentTest, amount, date);
                }else if (operation.equalsIgnoreCase("Anular")){
                    annulSelfAssessment(driver, extentTest, observation);
                }
                Verify.elementIsReady(driver, extentTest, DetalleAutoavaluosUI.ttlDetalleAutoavaluos);
            }
        }catch (Exception exception){

        }
    }
    public static void registerSelfAssessment(WebDriver driver, ExtentTest extentTest, String amount, String date){
        try {
            Verify.elementIsReady(driver, extentTest, RegistrarAutoavaluoUI.ttlRegistrarAutoavaluo);
            RegisterSelfAssessment.withoutObservation(driver, amount, date);
        }catch (Exception exception){

        }
    }
    public static void annulSelfAssessment(WebDriver driver, ExtentTest extentTest, String observation){
        try {
            Verify.elementIsReady(driver, extentTest, AnularAutoavaluoUI.ttlAnularAutoavaluo);
            AnnulSelfAssessment.now(driver, observation);
        }catch (Exception exception){

        }
    }
}
