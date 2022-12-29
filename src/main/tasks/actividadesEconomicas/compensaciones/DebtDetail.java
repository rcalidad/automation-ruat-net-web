package main.tasks.actividadesEconomicas.compensaciones;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.tasks.actividadesEconomicas.commonAEC.SelectDebtsAEC;
import main.ui.actividadesEconomicasUI.compensacionesUI.DebtDetailUI;
import org.openqa.selenium.WebDriver;

public class DebtDetail {
    public static void process(WebDriver driver, ExtentTest extentTest, String startYear, String endYear, String debtType, String rubro){
        SelectDebtsAEC.ofActivity(driver, extentTest, startYear, endYear, debtType, rubro, DebtDetailUI.debtsTable);
        Click.on(driver, DebtDetailUI.btnProcesar);
    }
}
