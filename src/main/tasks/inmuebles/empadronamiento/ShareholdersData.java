package main.tasks.inmuebles.empadronamiento;

import main.actions.Click;
import main.actions.Enter;
import main.actions.Find;
import main.actions.IsDisplayed;
import main.ui.inmueblesUI.empadronamientoUI.DatosAccionistasUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShareholdersData {
    public static void addShareholder(WebDriver driver){
        if (IsDisplayed.element(driver, DatosAccionistasUI.lnkAdicionarAccionista)){
            Click.on(driver, DatosAccionistasUI.lnkAdicionarAccionista);
        }
    }
    public static void assignPercentage(WebDriver driver){
        List<WebElement> rowsShareholderData = Find.elements(driver, DatosAccionistasUI.getRows());
        int numShareholders;
        if (IsDisplayed.element(driver, DatosAccionistasUI.lnkAdicionarAccionista)){
            numShareholders = rowsShareholderData.size() - 2;
        }else{
            numShareholders = rowsShareholderData.size() - 1;
        }
        if (numShareholders > 0){
            int percentage = 100 / numShareholders;
            int percentageColumn = getNumColumnOf(driver, "Porcentaje (%)");
            if (percentageColumn >= 0){
                for (int i = 2; i <= numShareholders; i++){
                    Enter.text(driver, DatosAccionistasUI.getInput(i, percentageColumn), String.valueOf(percentage));
                }
                Enter.text(driver, DatosAccionistasUI.getInput(numShareholders + 1, percentageColumn), String.valueOf(100 - (percentage * (numShareholders - 1))));
            }
        }
    }
    public static int getNumColumnOf(WebDriver driver, String columnName){
        List<WebElement> header = Find.elements(driver, DatosAccionistasUI.getTableHeader());
        for (int i = 0; i < header.size(); i++){
            if (header.get(i).getText().equalsIgnoreCase(columnName)){
                return i + 1;
            }
        }
        return -1;
    }
    public static void recordData(WebDriver driver){
        Click.on(driver, DatosAccionistasUI.btnAceptar);
    }
}
