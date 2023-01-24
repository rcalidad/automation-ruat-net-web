package main.tasks.inmuebles.compensaciones;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Find;
import main.actions.IsDisplayed;
import main.tasks.inmuebles.commonInm.HandleValidations;
import main.tasks.inmuebles.commonInm.Verify;
import main.ui.inmueblesUI.commonUI.ValidacionesUI;
import main.ui.inmueblesUI.compensacionesUI.InicioTramiteUI;
import main.ui.inmueblesUI.compensacionesUI.PropietarioAccionesDerechosUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectShareholder {
    public static void firstWhoCanContinue(WebDriver driver, ExtentTest extentTest){
        List<WebElement> rows = Find.elements(driver, PropietarioAccionesDerechosUI.getRows());
        for (int row = 2; row <= rows.size(); row++ ){
            List<WebElement> columns = Find.elements(driver, PropietarioAccionesDerechosUI.getColumns(row));
            WebElement link = driver.findElement(PropietarioAccionesDerechosUI.getCell(row, columns.size()));
            link.click();
            Verify.verifyIfIsDisplayedProgressBar(driver);
            Verify.partialObservations(driver, extentTest);
            if (IsDisplayed.element(driver, InicioTramiteUI.ttlInicioTramite)){
                break;
            } else if (IsDisplayed.element(driver, ValidacionesUI.ttlValidaciones)) {
                HandleValidations.takeScreenshot(driver, extentTest);
                HandleValidations.returnBeforeStep(driver);
            }
        }
    }
}
