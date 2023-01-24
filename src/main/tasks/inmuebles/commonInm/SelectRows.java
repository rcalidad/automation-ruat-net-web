package main.tasks.inmuebles.commonInm;

import main.actions.Click;
import main.actions.GetText;
import main.tasks.commonTasks.VerifyYear;
import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.WebDriver;

public class SelectRows {
    public static void byOperation(WebDriver driver, IPeriodTable table, String operation, String range, String initialYear, String finalYear){
        int numRows = WorkWithABasicTable.getNumOfRows(driver, table);
        int columnOfOperation = WorkWithABasicTable.getColumnOf(driver, table, operation);
        for (int row = 2; row <= numRows; row++){
            String year = GetText.of(driver, table.getCell(row, 1));
            if (!range.equalsIgnoreCase("TODOS")){
                if (VerifyYear.isIntoYearsRange(year, initialYear, finalYear)){
                    Click.on(driver, table.getCell(row, columnOfOperation));
                }
            }else {
                Click.on(driver, table.getCell(row, columnOfOperation));
            }
        }
    }
    public static void byOperationConsideringCombinedCells(WebDriver driver, IPeriodTable table, String operation, String range, String initialYear, String finalYear){
        int numRows = WorkWithABasicTable.getNumOfRows(driver, table);
        int columnOfOperation = WorkWithABasicTable.getColumnOf(driver, table, operation);
        for (int row = 2; row <= numRows; row++){
            if (WorkWithABasicTable.getNumOfColumns(driver, table, row) >= columnOfOperation){
                String year = GetText.of(driver, table.getCell(row, 1));
                if (!range.equalsIgnoreCase("TODOS")){
                    if (VerifyYear.isIntoYearsRange(year, initialYear, finalYear)){
                        Click.on(driver, table.getCell(row, columnOfOperation));
                    }
                }else {
                    Click.on(driver, table.getCell(row, columnOfOperation));
                }
            }
        }
    }
}
