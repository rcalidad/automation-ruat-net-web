package main.tasks.inmuebles.commonInm.inicioTramite;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public interface IDocument {
    void fillWithDefaultData(WebDriver driver, ExtentTest extentTest);
}
