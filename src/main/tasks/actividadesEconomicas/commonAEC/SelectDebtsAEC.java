package main.tasks.actividadesEconomicas.commonAEC;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Log;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import main.tasks.cobro.common.SelectDebts;
import main.ui.actividadesEconomicasUI.liquidacionUI.DeudaUI;
import main.ui.commonElementsUI.DebtTable;
import org.openqa.selenium.WebDriver;

public class SelectDebtsAEC {
    public static void ofActivity(WebDriver driver, ExtentTest extentTest, String startYear, String endYear, String debtType, String rubro){
        DeudaUI debtTable = new DeudaUI();
        SelectDebts.selectDebts(driver, startYear, endYear, debtType, debtTable, rubro);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, Messages.selectedItems);
        Log.recordInLog(Messages.selectedItems);
    }
    public static void ofActivity(WebDriver driver, ExtentTest extentTest, String startYear, String endYear, String debtType, String rubro, DebtTable debtTable){
        SelectDebts.selectDebts(driver, startYear, endYear, debtType, debtTable, rubro);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, Messages.selectedItems);
        Log.recordInLog(Messages.selectedItems);
    }
}
