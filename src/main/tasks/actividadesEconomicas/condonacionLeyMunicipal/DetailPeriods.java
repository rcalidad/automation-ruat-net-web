package main.tasks.actividadesEconomicas.condonacionLeyMunicipal;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.tasks.actividadesEconomicas.commonAEC.SelectPeriodsForCondonacion;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.condonacionLeyMunicipalUI.AnnulCondonacionUI;
import main.ui.actividadesEconomicasUI.condonacionLeyMunicipalUI.DetailPeriodsUI;
import org.openqa.selenium.WebDriver;

public class DetailPeriods {
    public static void processNow(WebDriver driver, ExtentTest extentTest, String operation, String observation){
        try {
            SelectPeriodsForCondonacion.selectAll(driver, DetailPeriodsUI.tblDetalleGestiones, operation);
            Click.on(driver, DetailPeriodsUI.btnProcesar);
            if(operation.equalsIgnoreCase("ANULAR")){
                annul(driver, extentTest, observation);
            }else if(operation.equalsIgnoreCase("REGISTRAR")){
                register(driver);
            }
        }catch (Exception exception){

        }
    }
    public static void register(WebDriver driver){
        if (VerifyAlert.containsThisText(driver, "Confirma", 15)) {
            VerifyAlert.containsThisText(driver, "correctamente");
        }
    }
    public static void annul(WebDriver driver, ExtentTest extentTest, String observation){
        try {
            Verify.isReady(driver, extentTest, AnnulCondonacionUI.ttlAnularCondonacion);
            AnnulCondonacion.now(driver, observation);
        }catch (Exception exception){

        }
    }
}
