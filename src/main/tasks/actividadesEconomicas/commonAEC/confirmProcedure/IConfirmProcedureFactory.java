package main.tasks.actividadesEconomicas.commonAEC.confirmProcedure;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public interface IConfirmProcedureFactory {
    void executeConfirmProcedure(WebDriver driver, ExtentTest extentTest, String procedure, String identifier, int index);
}
