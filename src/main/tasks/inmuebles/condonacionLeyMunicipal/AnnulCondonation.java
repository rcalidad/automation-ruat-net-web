package main.tasks.inmuebles.condonacionLeyMunicipal;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Enter;
import main.actions.Scroll;
import main.actions.WaitUntilElement;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.vehiculosUI.condonacionLeyMunicipalUI.ModificarCondonacionUI;
import org.openqa.selenium.WebDriver;

public class AnnulCondonation {
    public static void fromModification(WebDriver driver, ExtentTest extentTest){
        try {
            Verify.elementIsReady(driver, extentTest, ModificarCondonacionUI.ttlAnularRegistroCondonacion);
            Scroll.toEndPage(driver);
            Enter.text(driver, ModificarCondonacionUI.txtObservaciones, MessagesINM.testText);
            WaitUntilElement.isClikeableOf(driver, ModificarCondonacionUI.btnGrabar);
            Scroll.toEndPage(driver);
            Click.on(driver, ModificarCondonacionUI.btnGrabar);
            if (VerifyAlert.containsThisText(driver, "seguro")){
                VerifyAlert.containsThisText(driver, "correctamente");
            }
        }catch (Exception exception){

        }
    }
}
