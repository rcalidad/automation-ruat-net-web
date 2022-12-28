package main.tasks.actividadesEconomicas.empadronamiento.receiveDocumentation;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public interface IReceiveDocumentation {
    void setDriver(WebDriver driver, ExtentTest extentTest);
    void now();
}
