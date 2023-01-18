package main.tasks.inmuebles.commonInm;

import main.actions.Find;
import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WorkWithABasicTable {
    public static int getNumOfRows(WebDriver driver, IPeriodTable table){
        List<WebElement> rows = Find.elements(driver, table.getRows());
        return rows.size();
    }
    public static int getNumOfColumns(WebDriver driver, IPeriodTable table, int row){
        List<WebElement> columns = Find.elements(driver, table.getColumns(row));
        return columns.size();
    }
    public static int getColumnOf(WebDriver driver, IPeriodTable table, String columnName){
        List<WebElement> header = Find.elements(driver, table.getHeader());
        for (int y = 0; y < header.size(); y++){
            if (header.get(y).getText().equalsIgnoreCase(columnName)){
                return y + 1;
            }
        }
        return 0;
    }
}
