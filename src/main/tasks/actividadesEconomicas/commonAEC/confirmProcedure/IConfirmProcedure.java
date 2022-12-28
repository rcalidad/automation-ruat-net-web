package main.tasks.actividadesEconomicas.commonAEC.confirmProcedure;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public interface IConfirmProcedure {
    void setDriver(WebDriver driver, ExtentTest extentTest);
    void now(String identifier, int index);
}
