package main.tasks.cobro.common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.commonTasks.VerifyDebtType;
import main.tasks.commonTasks.VerifyYear;
import main.ui.cobroUI.pagarActividadesEconomicasUI.DebtDetailAecUI;
import main.ui.cobroUI.pagarInmuebleUI.DebtDetailInmUI;
import main.ui.cobroUI.pagarTasasOtrosIngresos.DebtDetailToiUI;
import main.ui.cobroUI.pagosVehiculosUI.DebtDetailUI;
import main.ui.commonElementsUI.DebtTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectDebts {
    public static void ofVehicle(WebDriver driver, ExtentTest extentTest, String startYear, String endYear, String debtType, String rubro){
        DebtDetailUI debtTable = new DebtDetailUI();
        selectDebts(driver, startYear, endYear, debtType, debtTable, rubro);
        Click.on(driver, DebtDetailUI.btnPagar);
        if (WaitUntilAlert.isPresent(driver, 1)){
            String message = "No hay deudas seleccionadas. Es posible que las deudas no coincidan con el criterio de búsqueda...";
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.FAIL, message);
            Log.recordInLog(message);
            DisplayAlert.toAcept(driver);
        }
    }
    public static void ofInmueble(WebDriver driver, String startYear, String endYear, String debtType, String rubro){
        DebtDetailInmUI debtTable = new DebtDetailInmUI();
        selectDebts(driver, startYear, endYear, debtType, debtTable, rubro);
    }
    public static void ofActividadEconomica(WebDriver driver, String startYear, String endYear, String debtType, String rubro){
        DebtDetailAecUI debtTable = new DebtDetailAecUI();
        selectDebts(driver, startYear, endYear, debtType, debtTable, rubro);
    }
    public static void ofTasasOtrosIngresos(WebDriver driver, String startYear, String endYear, String debType, String rubro){
        DebtDetailToiUI debTable = new DebtDetailToiUI();
        selectDebts(driver, startYear, endYear, debType, debTable, rubro);
    }
    public static int ofTasasArbitrios(WebDriver driver, String debtType, String rubro, int debtsSelected){
        int debtsChecked = debtsSelected;
        DebtDetailToiUI debTable = new DebtDetailToiUI();
        debtsChecked = selectDebtsNoMoreThanTen(driver, debtType, debTable, rubro, debtsChecked);
        return debtsChecked;
    }
    public static void allDebts(WebDriver driver, ExtentTest extentTest){
        List<WebElement> rows = driver.findElements(DebtDetailUI.debtTableRows);
        for (int r = 2; r <= rows.size(); r++){
            List<WebElement> columns = driver.findElements(DebtDetailUI.getColumns(r));
            Click.on(driver, DebtDetailUI.getCell(r, columns.size()));
        }
        Click.on(driver, DebtDetailUI.btnPagar);
        if (WaitUntilAlert.isPresent(driver, 1)){
            String message = "No hay deudas seleccionadas. Es posible que las deudas no coincidan con el criterio de búsqueda...";
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.FAIL, message);
            Log.recordInLog(message);
            DisplayAlert.toAcept(driver);
        }
    }

    public static void selectDebts(WebDriver driver, String startYear, String endYear, String debtType, DebtTable debtTable, String rubro){
        List<WebElement> rows = driver.findElements(debtTable.getRowsOfTable());
        for (int r = 2; r <= rows.size(); r++){
            List<WebElement> columns = driver.findElements(debtTable.getColumnsOfARow(r));
            if (debtType.equals("TODOS")){
                Click.on(driver, debtTable.getCellOfTable(r, columns.size()));
            }else {
                String debtDetail = GetText.of(driver, debtTable.getCellOfTable(r, debtTable.getColumnOfDebt()));
                if (VerifyDebtType.to(rubro, debtType, debtDetail)){
                    String year = GetText.of(driver, debtTable.getCellOfTable(r, debtTable.getColumnOfYear()));
                    if (VerifyDebtType.isNecessaryVerifyYear(debtType)){
                        if (VerifyYear.isIntoYearsRange(year, startYear, endYear)){
                            Click.on(driver, debtTable.getCellOfTable(r, columns.size()));
                        }
                    }else {
                        if(year.equals("") || year.equals("N/A")){
                            Click.on(driver, debtTable.getCellOfTable(r, columns.size()));
                        }
                    }
                }
            }
        }
    }
    public static int selectDebtsNoMoreThanTen(WebDriver driver, String debtType, DebtTable debtTable, String rubro, int debtsChecked){
        int debts = debtsChecked;
        List<WebElement> rows = driver.findElements(debtTable.getRowsOfTable());
        for (int r = 2; r <= rows.size(); r++){
            List<WebElement> columns = driver.findElements(debtTable.getColumnsOfARow(r));
            if (debts < 10){
                if (debtType.equals("TODOS")){
                    Click.on(driver, debtTable.getCellOfTable(r, columns.size()));
                    debts++;
                }else {
                    String debtDetail = GetText.of(driver, debtTable.getCellOfTable(r, debtTable.getColumnOfDebt()));
                    if (VerifyDebtType.to(rubro, debtType, debtDetail)){
                        Click.on(driver, debtTable.getCellOfTable(r, columns.size()));
                        debts++;
                    }
                }
            }else {
                break;
            }
        }
        return debts;
    }
    public static void allIP(WebDriver driver, ExtentTest extentTest){
        List<WebElement> rows = driver.findElements(DebtDetailUI.debtTableRows);
        for (int r = 2; r <= rows.size(); r++){
            List<WebElement> columns = driver.findElements(DebtDetailUI.getColumns(r));
            if (GetText.of(driver, DebtDetailUI.getCell(r, 2)).contains("IMPUESTO")){
                Click.on(driver, DebtDetailUI.getCell(r, columns.size()));
            }
        }
        Click.on(driver, DebtDetailUI.btnPagar);
        if (WaitUntilAlert.isPresent(driver, 1)){
            String message = "No hay deudas seleccionadas. Es posible que las deudas no coincidan con el criterio de búsqueda...";
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.FAIL, message);
            Log.recordInLog(message);
            DisplayAlert.toAcept(driver);
        }
    }
}
