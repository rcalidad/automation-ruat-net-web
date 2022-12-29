package main.tasks.actividadesEconomicas.commonAEC;

import main.ui.actividadesEconomicasUI.commonUI.periodDetailTableUI.IPeriodsToSanctionTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SetPenaltyAmount {
    public static void with(WebDriver driver, String amount, IPeriodsToSanctionTable sanctionTable){
        List<WebElement> rows = driver.findElements(sanctionTable.getRows());
        for (int i = 2; i <= rows.size(); i++){
            WebElement txtAmount = driver.findElement(sanctionTable.getInputMonto(i));
            txtAmount.clear();
            txtAmount.sendKeys(amount);
        }
    }
}
