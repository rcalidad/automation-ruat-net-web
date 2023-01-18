package main.tasks.inmuebles.commonInm.detalleOperacion;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Find;
import main.actions.GetText;
import main.tasks.commonTasks.VerifyYear;
import main.tasks.inmuebles.commonInm.WorkWithABasicTable;
import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExecuteOperationOnTable {
    public static void to(WebDriver driver, ExtentTest extentTest, IProcedure procedure, IPeriodTable table, Map<String, String> data){
        List<WebElement> pages;
        try {
            pages = Find.elements(driver, table.getPager());
        }catch (NoSuchElementException noSuchElementException){
            pages = new ArrayList<>();
        }
        int nroPages = pages.size() == 0 ? 1 : pages.size() / 2;
        if (nroPages > 1){
            for (int p = 0; p < nroPages; p++){
                List<WebElement> updatedPager = Find.elements(driver, table.getPager());
                updatedPager.get(p).click();
                exploreTable(driver, extentTest, table, procedure, data);
            }
        }else{
            exploreTable(driver, extentTest, table, procedure, data);
        }
    }
    public static void exploreTable(WebDriver driver, ExtentTest extentTest, IPeriodTable table, IProcedure procedure, Map<String, String> data){
        int numRows = WorkWithABasicTable.getNumOfRows(driver, table);
        for (int row = 2; row <= numRows; row++){
            if (!data.get("detailOfPeriod").equalsIgnoreCase("TODOS")){
                String year = GetText.of(driver, table.getCell(row, 1));
                if (VerifyYear.isIntoYearsRange(year, data.get("initialYear"), data.get("finalYear"))){
                    executeOperation(driver, extentTest, table, procedure,  row, data);
                }
            }else {
                executeOperation(driver, extentTest, table, procedure,  row, data);
            }
        }

    }
    public static void executeOperation(WebDriver driver, ExtentTest extentTest, IPeriodTable table, IProcedure procedure, int row, Map<String, String> data){
        String operation = data.get("operation").toUpperCase();
        if (getIntoOperation(driver, table, operation, row)){
            switch (operation){
                case "REGISTRAR":
                    procedure.register(driver, extentTest, data);
                    break;
                case "MODIFICAR":
                    procedure.modify(driver, extentTest, data);
                    break;
                case "ANULAR":
                    procedure.annul(driver, extentTest, data);
                    break;
                default:
                    break;
            }
        }
    }
    public static boolean getIntoOperation(WebDriver driver, IPeriodTable table, String operation, int row){
        int numColumns = WorkWithABasicTable.getNumOfColumns(driver, table, row);
        for (int y = numColumns; y >= 1; y--){
            String operationAvailable = GetText.of(driver, table.getCell(row, y));
            if (operationAvailable.equalsIgnoreCase(operation)){
                Click.on(driver, table.getCell(row, y));
                return true;
            }
        }
        return false;
    }
}
