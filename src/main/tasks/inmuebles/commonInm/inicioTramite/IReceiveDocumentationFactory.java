package main.tasks.inmuebles.commonInm.inicioTramite;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public interface IReceiveDocumentationFactory {
    void executeReceiveDocumentation(WebDriver driver, ExtentTest extentTest, String documentName);
}
