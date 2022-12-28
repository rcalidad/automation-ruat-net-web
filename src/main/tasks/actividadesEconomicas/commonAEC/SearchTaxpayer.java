package main.tasks.actividadesEconomicas.commonAEC;

import com.aventstack.extentreports.ExtentTest;
import main.actions.*;
import main.ui.actividadesEconomicasUI.commonUI.SearchTaxpayerUI;
import org.openqa.selenium.WebDriver;

public class SearchTaxpayer {
    public static void withNextData(WebDriver driver, String idUser, String documentType){
        Clear.on(driver, SearchTaxpayerUI.txtNumeroDocumento, 1);
        Enter.text(driver, SearchTaxpayerUI.txtNumeroDocumento, idUser);
        SelectOption.byText(driver, SearchTaxpayerUI.lstTipoDocumento, documentType);
        Click.on(driver, SearchTaxpayerUI.btnBuscar);
    }
    public static void associate(WebDriver driver, ExtentTest extentTest){
        try {
            Verify.isReady(driver, extentTest, SearchTaxpayerUI.lnkAsociar);
            if (IsClickable.element(driver, SearchTaxpayerUI.lnkAsociar)){
                Click.on(driver, SearchTaxpayerUI.lnkAsociar);
            }
        }catch (Exception exception){}

    }
}
