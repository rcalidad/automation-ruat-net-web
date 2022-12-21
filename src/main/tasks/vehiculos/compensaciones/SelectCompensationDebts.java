package main.tasks.vehiculos.compensaciones;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.cobro.common.SelectDebts;
import main.ui.vehiculosUI.compensacionesUI.DetalleDeudasUI;
import org.openqa.selenium.WebDriver;

public class SelectCompensationDebts {
    public static void ofVehicle(WebDriver driver, ExtentTest extentTest, String startYear, String endYear, String debtType, String rubro){
        DetalleDeudasUI debtTable = new DetalleDeudasUI();
        SelectDebts.selectDebts(driver, startYear, endYear, debtType, debtTable, rubro);
        ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.INFO, "Deudas seleccionadas");
    }
}
