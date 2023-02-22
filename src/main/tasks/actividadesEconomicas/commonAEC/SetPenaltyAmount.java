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
            String currentAmount = txtAmount.getAttribute("value").trim();
            txtAmount.clear();
            //if (getAmount(currentAmount) == getAmount(amount)){
            //    amount = String.valueOf(getAmount(amount) + 1);
            //}
            txtAmount.sendKeys(amount);
        }
    }
    public static double getAmount(String amount){
        double newAmount = 0;
        try {
            newAmount = Double.parseDouble(amount);
            return newAmount;
        }catch (Exception exception){
            return  newAmount;
        }
    }
}
