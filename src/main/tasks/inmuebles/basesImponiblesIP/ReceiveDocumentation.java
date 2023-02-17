package main.tasks.inmuebles.basesImponiblesIP;

import com.aventstack.extentreports.ExtentTest;
import main.tasks.inmuebles.commonInm.inicioTramite.StartProcedure;
import main.ui.inmueblesUI.basesImponiblesIpUI.InicioTramiteUI;
import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentation {
    public static void now(WebDriver driver, ExtentTest extentTest){
        IInicioTramiteUI elements = InicioTramiteUI.getInstance();
        StartProcedure.setElementsProcess(elements);
        StartProcedure.checkDocumentsRequired(driver);
        StartProcedure.fillFormsOfDocumentsRequired(driver, extentTest);
        StartProcedure.recordDocumentsOfProcess(driver);
    }
    public static void now(WebDriver driver, ExtentTest extentTest, IInicioTramiteUI elements){
        StartProcedure.setElementsProcess(elements);
        StartProcedure.checkAllDocuments(driver);
        //StartProcedure.checkDocumentsRequired(driver);
        //StartProcedure.fillFormsOfDocumentsRequired(driver, extentTest);
        StartProcedure.recordDocumentsOfProcess(driver);
    }

}
