package main.tasks.actividadesEconomicas.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.tasks.actividadesEconomicas.commonAEC.SearchTaxpayer;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.ui.actividadesEconomicasUI.commonUI.SearchTaxpayerUI;
import main.ui.actividadesEconomicasUI.empadronamientoUI.AssignContributorUI;
import org.openqa.selenium.WebDriver;

public class AssignContributor {
    public static void assign(WebDriver driver, ExtentTest extentTest, String idNumber, String documentType){
        try {
            Click.on(driver, AssignContributorUI.lnkAdicionar);
            Verify.isReady(driver, extentTest, SearchTaxpayerUI.ttlBusquedaContribuyente);
            SearchTaxpayer.withNextData(driver, idNumber, documentType);
            SearchTaxpayer.associate(driver, extentTest);
            Verify.isReady(driver, extentTest, AssignContributorUI.ttlAsignarContribuyente);
            Click.on(driver, AssignContributorUI.btnAceptar);
        }catch (Exception exception){

        }
    }
}
