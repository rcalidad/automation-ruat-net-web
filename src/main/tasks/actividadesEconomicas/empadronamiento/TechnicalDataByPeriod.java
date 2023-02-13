package main.tasks.actividadesEconomicas.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Enter;
import main.actions.Log;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import main.ui.actividadesEconomicasUI.empadronamientoUI.TechnicalDataUI;
import main.ui.actividadesEconomicasUI.empadronamientoUI.TechnicalDataByPeriodUI;
import org.openqa.selenium.WebDriver;

public class TechnicalDataByPeriod {
    public static void load(WebDriver driver, ExtentTest extentTest, String date, String taxZone, String superficie, String rubro, String subRubro, String tipoActividad){
        try {
            Enter.text(driver, TechnicalDataByPeriodUI.txtFechaInicioTributario, date);
            Click.on(driver, TechnicalDataByPeriodUI.lnkAdicionar);
            Verify.isReady(driver, extentTest, TechnicalDataUI.ttlDatosTecnicos);
            TechnicalData.loadWithDefaultData(driver, superficie);
            //TechnicalData.load(driver, taxZone, superficie, rubro, subRubro, tipoActividad);
            Verify.isReady(driver, extentTest, TechnicalDataByPeriodUI.ttlDatosTecnicosPorPeriodo);
            Click.on(driver, TechnicalDataByPeriodUI.btnAceptar);
        }catch (Exception exception){
            Log.recordInLog(Messages.failedValidation);
        }
    }
}
