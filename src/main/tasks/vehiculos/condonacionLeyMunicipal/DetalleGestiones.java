package main.tasks.vehiculos.condonacionLeyMunicipal;

import main.actions.*;
import main.tasks.commonTasks.VerifyYear;
import main.ui.vehiculosUI.condonacionLeyMunicipalUI.DetalleGestionesUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DetalleGestiones {
    public static void selectRows(WebDriver driver, String initialYear, String finalYear, String concept, String percentage, String operation){
        List<WebElement> rows = driver.findElements(DetalleGestionesUI.getRows());
        int operationColumn = getColumnOf(driver, operation);
        int registerColumn = getColumnOf(driver, "REGISTRAR");
        if (operationColumn != 0){
            for (int x = 2; x <= rows.size(); x++){
                if (VerifyYear.isIntoYearsRange(GetText.of(driver, DetalleGestionesUI.getCell(x,DetalleGestionesUI.getColumnOfYear())), initialYear, finalYear)){
                    if (GetText.of(driver, DetalleGestionesUI.getCell(x, DetalleGestionesUI.getColumnOfConcepto())).equals(concept)){
                        if (IsClickable.element(driver, DetalleGestionesUI.getCheckbox(x, operationColumn))){
                            SelectOption.byText(driver, DetalleGestionesUI.getSelectPorcentaje(x), percentage);
                        }
                        check(driver, x, operationColumn);
                    }else {
                        if (registerColumn != 0){
                            uncheck(driver, x, registerColumn);
                        }
                    }
                }else {
                    if (registerColumn != 0){
                        uncheck(driver, x, registerColumn);
                    }
                }
            }
        }
    }
    public static boolean selectAll(WebDriver driver, String operation){
        List<WebElement> rows = driver.findElements(DetalleGestionesUI.getRows());
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
    public static void check(WebDriver driver, int x, int y){
        if(!isChecked(driver, x, y)){
            Click.on(driver,DetalleGestionesUI.getCell(x, y));
        }
    }
    public static void uncheck(WebDriver driver, int x, int y){
        if (isChecked(driver, x, y)){
            Click.on(driver,DetalleGestionesUI.getCell(x, y));
        }
    }
    public static boolean isChecked(WebDriver driver, int x, int y){
        if (IsPresent.elements(driver, DetalleGestionesUI.getCheckbox(x, y))){
            if(IsChecked.element(driver, DetalleGestionesUI.getCheckbox(x, y))){
                return true;
            }
        }
        return false;
    }
    public static int getColumnOf(WebDriver driver, String column){
        List<WebElement> header = Find.elements(driver, DetalleGestionesUI.getHeader());
        for (int x = 0; x < header.size(); x++){
            String text = header.get(x).getText().toUpperCase();
            if (text.equals(column.toUpperCase())){
                return x + 1;
            }
        }
        return 0;
    }

}
