package main.tasks.inmuebles.compensaciones;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Scroll;
import main.tasks.inmuebles.commonInm.SelectDebtsINM;
import main.ui.inmueblesUI.compensacionesUI.DetalleDeudasUI;
import org.openqa.selenium.WebDriver;

public class DebtDetail {
    public static void process(WebDriver driver, ExtentTest extentTest, String startYear, String endYear, String debtType, String rubro){
        Scroll.toElement(driver, DetalleDeudasUI.table);
        SelectDebtsINM.ofEstate(driver, extentTest, startYear, endYear, debtType, rubro, DetalleDeudasUI.tablaDatosDeudas);
        Scroll.toEndPage(driver);
        Click.on(driver, DetalleDeudasUI.btnProcesar);

    }
}
