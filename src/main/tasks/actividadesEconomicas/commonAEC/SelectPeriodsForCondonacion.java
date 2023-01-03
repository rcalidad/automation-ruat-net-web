package main.tasks.actividadesEconomicas.commonAEC;

import main.actions.Click;
import main.actions.Find;
import main.actions.IsChecked;
import main.actions.IsPresent;
import main.ui.actividadesEconomicasUI.commonUI.periodDetailTableUI.IPeriodDetailTable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectPeriodsForCondonacion {
    public static boolean isChecked(WebDriver driver, IPeriodDetailTable table, int x, int y){
        try {
            WebElement element = driver.findElement(table.getCellOfTable(x, y)).findElement(By.xpath("//input"));
            if (element.isSelected()){
                return true;
            }
            return false;
        }catch (NoSuchElementException noSuchElementException){
            return false;
        }
    }
    public static void check(WebDriver driver, IPeriodDetailTable table, int x, int y){
        if(!isChecked(driver, table, x, y)){
            Click.on(driver, table.getCellOfTable(x, y));
        }
    }
    public static void uncheck(WebDriver driver, IPeriodDetailTable table, int x, int y){
        if (isChecked(driver, table, x, y)){
            Click.on(driver, table.getCellOfTable(x, y));
        }
    }
    public static int getNumColumnOf(WebDriver driver, IPeriodDetailTable table, String columnName){
        List<WebElement> header = Find.elements(driver, table.getHeader());
        for(int x = 0; x < header.size(); x++){
            String text = header.get(x).getText();
            if (text.equalsIgnoreCase(columnName)){
                return x + 1;
            }
        }
        return 0;
    }
    public static boolean selectAll(WebDriver driver, IPeriodDetailTable table, String operation){
        List<WebElement> rows = Find.elements(driver, table.getRowsOfTable());
        int operationColumn = getNumColumnOf(driver, table, operation);
        if (operationColumn != 0){
            if (operation.equalsIgnoreCase("ANULAR")){
                int registerColumn = getNumColumnOf(driver, table, "REGISTRAR");
                if (registerColumn != 0){
                    for (int x = 2; x <= rows.size(); x++){
                        check(driver, table, x, operationColumn);
                        uncheck(driver, table, x, registerColumn);
                    }
                    return true;
                }
                return false;
            }
            return true;
        }
        return  false;
    }
}
