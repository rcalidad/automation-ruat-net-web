package main.tasks.commonTasks;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.ui.commonElementsUI.DebtDetail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetProforma {
    public static void of(WebDriver driver, 
                          ExtentTest test, 
                          DebtDetail debtDetail, 
                          String operation, 
                          String debt, 
                          String identifier, 
                          String idSubsystem, 
                          String initialYear, 
                          String finalYear,
                          int caseNumber, 
                          String defaultReportName){
        List<WebElement> rowsDebt = driver.findElements(debtDetail.getRow());
        List<WebElement> headerDebt = driver.findElements(debtDetail.getHeader());
        int nroRows = rowsDebt.size();
        int nroColumns = headerDebt.size();
        Log.recordInLog("Ejecutando operación: ".concat(operation));
        if(!operation.equals("SOLO LIQUIDAR")){
            for(int i = 2; i <= nroRows; i++){
                if (checkDebDetails(i, operation,debtDetail, driver, debt)){
                    if (isIntoYearsRange(i, initialYear, finalYear, driver, debtDetail)){
                        Click.on(driver, debtDetail.getCell(i, nroColumns));
                    }
                }
            }
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, test, Status.INFO, "<b>Detalle de deuda: ".concat(debt).concat("</b>"));
            print();
            if(WaitUntilAlert.isPresent(driver)){
                DisplayAlert.toAcept(driver);
            }
            if (FileBuilder.moveFile(defaultReportName)){
                FileBuilder.renameReport(defaultReportName, operation,debt, identifier, idSubsystem, caseNumber);
            }
        }
    }

    private static boolean isIntoYearsRange(int i, String initialYear, String finalYear, WebDriver driver, DebtDetail debtDetail) {
        int startYear = Integer.parseInt(initialYear);
        int endYear = Integer.parseInt(finalYear);
        String year = GetText.of(driver, debtDetail.getCell(i,1));
        if(!year.equals("")){
            if(Integer.parseInt(year) >= startYear && Integer.parseInt(year) <= endYear){
                return true;
            }
        }
        return false;
    }

    private static boolean checkDebDetails(int i, String operation, DebtDetail debtDetail, WebDriver driver, String debt) {
        String debtType = GetText.of(driver, debtDetail.getCell(i, 2));
        boolean sw;
        switch (debt){
            case "PF":
                sw = debtType.contains("PATENTE");
                break;
            case "MI":
                sw = debtType.contains("INCUMPLIMIENTO");
                break;
            case "OP":
                sw = debtType.contains("OMISION");
                break;
            case "RE":
                sw = debtType.contains("RECIBO");
                break;
            default:
                sw = true;
                break;
        }
        return sw;
    }
    private static void print(){}
}
