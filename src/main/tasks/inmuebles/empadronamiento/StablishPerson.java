package main.tasks.inmuebles.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import main.tasks.inmuebles.commonInm.SearchTaxpayer;
import main.tasks.inmuebles.commonInm.Verify;
import main.ui.inmueblesUI.commonUI.interfacesUI.IBuscarPersonaUI;
import main.ui.inmueblesUI.empadronamientoUI.BuscarGestorTramiteUI;
import org.openqa.selenium.WebDriver;

public class StablishPerson {
    public static void likeProcessManager(WebDriver driver, ExtentTest extentTest, IBuscarPersonaUI object, String numDocument, String documentType){
        try {
            SearchTaxpayer.by(driver, object, numDocument, documentType);
            Verify.elementIsReady(driver, extentTest, BuscarGestorTramiteUI.lnkAsociar);
            SearchManagerProcess.associate(driver);
        }catch (Exception exception){

        }
    }
}
