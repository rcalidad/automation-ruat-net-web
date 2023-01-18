package main.tasks.inmuebles.compensaciones;

import com.aventstack.extentreports.ExtentTest;
import main.actions.*;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.commonInm.WorkWithABasicTable;
import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import main.ui.inmueblesUI.compensacionesUI.DetalleSujetosPasivosUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DetailTaxpayers {
    public static boolean verify(WebDriver driver){
        Verify.verifyIfIsDisplayedProgressBar(driver);
        if (IsDisplayed.element(driver, DetalleSujetosPasivosUI.ttlDetalleSujetosPasivos)){
            return true;
        }
        return false;
    }
    public static void selectFirstWithTaxCredit(WebDriver driver){
        IPeriodTable table = DetalleSujetosPasivosUI.TablaDatosSujetosPasivosInmueble;
        int rows = WorkWithABasicTable.getNumOfRows(driver, table);
        int columnAvailableAmount = WorkWithABasicTable.getColumnOf(driver, table, "Monto Disponible (Bs)");
        if (columnAvailableAmount > 0){
            for (int x = 2; x <= rows; x++){
                String text = GetText.of(driver, table.getCell(x, columnAvailableAmount));
                boolean isNumeric = (text != null && text.matches("[0-9]+"));
                if (isNumeric){
                    Click.on(driver, table.getCell(x, columnAvailableAmount + 1));
                    break;
                }
            }
        }

    }
    public static void accept(WebDriver driver){
        Scroll.toEndPage(driver);
        Click.on(driver, DetalleSujetosPasivosUI.btnAceptar);
    }
}
