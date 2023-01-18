package main.tasks.inmuebles.basesImponiblesIP;

import com.aventstack.extentreports.ExtentTest;
import main.tasks.inmuebles.commonInm.detalleOperacion.DetailsOfProcedure;
import main.ui.inmueblesUI.basesImponiblesIpUI.DetalleBasesImponiblesUI;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterOperation {
    public static void  now(WebDriver driver, ExtentTest extentTest, Map<String, String> data){
        DetailsOfProcedure.executeOperationOnTable(driver, extentTest, ExecuteOperation.getInstance(), DetalleBasesImponiblesUI.tablaDetalleGestiones, data);
        DetailsOfProcedure.record(driver, DetalleBasesImponiblesUI.getInstance());
    }
}
