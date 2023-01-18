package main.tasks.inmuebles.basesImponiblesIP;

import com.aventstack.extentreports.ExtentTest;
import main.tasks.inmuebles.commonInm.detalleOperacion.IProcedure;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class ExecuteOperation implements IProcedure {

    public static IProcedure getInstance() {
        IProcedure procedure = new ExecuteOperation();
        return procedure;
    }

    @Override
    public void register(WebDriver driver, ExtentTest extentTest, Map<String, String> data) {
        String taxBase = data.get("baseImponible");
        String year = data.get("initialYear");
        RegisterTaxBase.withSpecificValue(driver, extentTest, taxBase, year);
    }

    @Override
    public void modify(WebDriver driver, ExtentTest extentTest, Map<String, String> data) {

    }

    @Override
    public void annul(WebDriver driver, ExtentTest extentTest, Map<String, String> data) {
        AnnulTaxBase.withDefaultData(driver, extentTest);
    }
}
