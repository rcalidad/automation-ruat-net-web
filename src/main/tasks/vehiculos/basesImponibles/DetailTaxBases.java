package main.tasks.vehiculos.basesImponibles;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.actions.GetText;
import main.actions.Log;
import main.actions.Scroll;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.basesImponiblesUI.DetailTaxBasesUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DetailTaxBases {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, DetailTaxBasesUI.ttlDetalleBasesImponibles);
    }
    public static int getRowOfYear(WebDriver driver, ExtentTest extentTest, String searchedYear){
        List<WebElement> rows = driver.findElements(DetailTaxBasesUI.filas);
        for (int r = 2; r < rows.size(); r++){
            String year = GetText.of(driver, DetailTaxBasesUI.getCell(r, 1));
            if (year.equals(searchedYear)){
                return r;
            }
        }
        return 0;
    }
    public static boolean isPresentRegistrar(WebDriver driver, int row){
        List<WebElement> columns = driver.findElements(DetailTaxBasesUI.columnas);
        String registrar = GetText.of(driver, DetailTaxBasesUI.getCell(row, columns.size() - 1));
        return registrar.equals("Registrar");
    }
    public static boolean isPresentAnnul(WebDriver driver, int row){
        List<WebElement> columns = driver.findElements(DetailTaxBasesUI.columnas);
        String registrar = GetText.of(driver, DetailTaxBasesUI.getCell(row, columns.size()));
        return registrar.equals("Anular");
    }
    public static void register(WebDriver driver, ExtentTest extentTest, String year){
        Scroll.toEndPage(driver);
        List<WebElement> columns = driver.findElements(DetailTaxBasesUI.columnas);
        int row = getRowOfYear(driver, extentTest, year);
        if(row > 1 && isPresentRegistrar(driver, row)){
            Click.on(driver, DetailTaxBasesUI.getCell(row, columns.size() - 1));
        }else{
            Log.recordInLog("No es posible continuar, la gestión no se encuentra disponible o no se tiene la opción registrar.");
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "Gestión no disponible o no se tiene la opción registrar.");
        }
    }
    public static void annul(WebDriver driver, ExtentTest extentTest, String year){
        Scroll.toEndPage(driver);
        List<WebElement> columns = driver.findElements(DetailTaxBasesUI.columnas);
        int row = getRowOfYear(driver, extentTest, year);
        if(row > 1 && isPresentAnnul(driver, row)){
            Click.on(driver, DetailTaxBasesUI.getCell(row, columns.size()));
        }else{
            Log.recordInLog("No es posible continuar, la gestión no se encuentra disponible o no se tiene la opción anular.");
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "Gestión no disponible o no se tiene la opción anular.");
        }
    }
}
