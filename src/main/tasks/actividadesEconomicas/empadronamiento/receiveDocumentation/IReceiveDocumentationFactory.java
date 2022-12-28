package main.tasks.actividadesEconomicas.empadronamiento.receiveDocumentation;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public interface IReceiveDocumentationFactory {
    void executeReceiveDocumentation(WebDriver driver, String town, ExtentTest extentTest);
}
