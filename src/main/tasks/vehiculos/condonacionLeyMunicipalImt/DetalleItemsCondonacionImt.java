package main.tasks.vehiculos.condonacionLeyMunicipalImt;

import main.actions.Click;
import main.actions.Find;
import main.actions.IsChecked;
import main.actions.IsPresent;
import main.ui.vehiculosUI.condonacionLeyMunicipalImtUI.DetalleItemsCondonacionUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DetalleItemsCondonacionImt {
    public static boolean isChecked(WebDriver driver, int x, int y){
        if (IsPresent.elements(driver, DetalleItemsCondonacionUI.getCheckbox(x, y))){
            if(IsChecked.element(driver, DetalleItemsCondonacionUI.getCheckbox(x, y))){
                return true;
            }
        }
        return false;
    }
    public static int getColumnOf(WebDriver driver, String column){
        List<WebElement> header = Find.elements(driver, DetalleItemsCondonacionUI.getHeader());
        for (int x = 0; x < header.size(); x++){
            String text = header.get(x).getText().toUpperCase();
            if (text.equals(column.toUpperCase())){
                return x + 1;
            }
        }
        return 0;
    }
    public static void check(WebDriver driver, int x, int y){
        if(!isChecked(driver, x, y)){
            Click.on(driver,DetalleItemsCondonacionUI.getCell(x, y));
        }
    }
    public static void uncheck(WebDriver driver, int x, int y){
        if (isChecked(driver, x, y)){
            Click.on(driver,DetalleItemsCondonacionUI.getCell(x, y));
        }
    }
    public static boolean selectAll(WebDriver driver, String operation){
        List<WebElement> rows = driver.findElements(DetalleItemsCondonacionUI.getRows());
        int operationColumn = getColumnOf(driver, operation);
        if(operationColumn != 0){
            if (operation.equals("ANULAR")){
                int registerColumn = getColumnOf(driver, "REGISTRAR");
                if (operationColumn != 0 && registerColumn != 0){
                    for (int x = 2; x <= rows.size(); x++){
                        check(driver, x, operationColumn);
                        uncheck(driver, x, registerColumn);
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }
}
