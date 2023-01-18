package main.tasks.inmuebles.commonInm.detalleOperacion;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Find;
import main.actions.GetText;
import main.actions.Scroll;
import main.tasks.commonTasks.VerifyYear;
import main.tasks.inmuebles.commonInm.WorkWithABasicTable;
import main.ui.commonElementsUI.IProcedureDetail;
import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DetailsOfProcedure {
    public static void executeOperationOnTable(WebDriver driver, ExtentTest extentTest, IProcedure procedure, IPeriodTable table, Map<String, String> data){
        ExecuteOperationOnTable.to(driver, extentTest, procedure, table, data);
    }
    public static void record(WebDriver driver, IProcedureDetail procedureDetail){
        Scroll.toEndPage(driver);
        Click.on(driver, procedureDetail.getBtnAceptar());
    }
}
