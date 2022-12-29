package main.tasks.actividadesEconomicas.commonAEC;

import main.actions.Click;
import main.actions.GetText;
import main.tasks.commonTasks.VerifyYear;
import main.ui.actividadesEconomicasUI.commonUI.periodDetailTableUI.IPeriodDetailTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectPeriods {
    public static void of(WebDriver driver, String initialYear, String finalYear, String operation, IPeriodDetailTable detailTable){
        int columnOfOperation = getColumnOf(driver, operation, detailTable);
        if(columnOfOperation != 0){
            List<WebElement> rows = driver.findElements(detailTable.getRowsOfTable());
            for (int j = 2; j <= rows.size(); j++){
                String year = GetText.of(driver, detailTable.getCellOfTable(j, detailTable.getColumnOfYear()));
                if (VerifyYear.isIntoYearsRange(year, initialYear, finalYear)){
                    Click.on(driver, detailTable.getCellOfTable(j, columnOfOperation));
                }
            }
        }

    }
    public static void ofAllPeriods(WebDriver driver, String operation, IPeriodDetailTable detailTable){
        int columnOfOperation = getColumnOf(driver, operation, detailTable);
        if(columnOfOperation != 0){
            List<WebElement> rows = driver.findElements(detailTable.getRowsOfTable());
            for (int j = 2; j <= rows.size(); j++){
                Click.on(driver, detailTable.getCellOfTable(j, columnOfOperation));
            }
        }
    }
    public static int getColumnOf(WebDriver driver, String operation, IPeriodDetailTable detailTable){
        List<WebElement> header = driver.findElements(detailTable.getHeader());
        for (int j = 1; j <= header.size(); j++){
            if (header.get(j - 1).getText().equalsIgnoreCase(operation)){
                return j;
            }
        }
        return 0;
    }

}
