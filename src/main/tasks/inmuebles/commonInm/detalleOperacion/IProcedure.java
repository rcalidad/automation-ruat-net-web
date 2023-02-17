package main.tasks.inmuebles.commonInm.detalleOperacion;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public interface IProcedure {
    void register(WebDriver driver, ExtentTest extentTest, Map<String, String> data, String year);
    void modify(WebDriver driver, ExtentTest extentTest, Map<String, String> data);
    void annul(WebDriver driver, ExtentTest extentTest, Map<String, String> data);
}
