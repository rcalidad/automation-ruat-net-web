package main.tasks.inmuebles.commonInm;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Log;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.cobro.common.SelectDebts;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.commonElementsUI.DebtTable;
import org.openqa.selenium.WebDriver;

public class SelectDebtsINM {
    public static void ofEstate(WebDriver driver, ExtentTest extentTest, String startYear, String endYear, String debtType, String rubro, DebtTable table){
        SelectDebts.selectDebts(driver, startYear, endYear, debtType, table, rubro);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, MessagesINM.selectedItems);
        Log.recordInLog(MessagesINM.selectedItems);
    }
}
