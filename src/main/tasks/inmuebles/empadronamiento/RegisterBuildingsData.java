package main.tasks.inmuebles.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.empadronamientoUI.DatosConstruccionUI;
import org.openqa.selenium.WebDriver;

public class RegisterBuildingsData {
    public static void now(WebDriver driver, ExtentTest extentTest, int numBuilds, String year, String area){
        try {
            for (int i = 1; i <= numBuilds; i++){
                if (BuildingsData.addBuildingDetails(driver)){
                    Verify.elementIsReady(driver, extentTest, DatosConstruccionUI.ttlDatosConstruccion);
                    BuildingData.addConstructionData(driver, String.valueOf(i), year, year, area, "BUENA", "ZONA 15");
                    BuildingData.record(driver);
                }else {
                    break;
                }
            }
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.INFO, MessagesINM.buildsRegistered);
            BuildingsData.recordData(driver);
        }catch (Exception exception){

        }
    }
}
