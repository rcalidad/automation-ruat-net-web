package main.tasks.inmuebles.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.inmuebles.commonInm.SearchTaxpayer;
import main.tasks.inmuebles.commonInm.Verify;
import main.ui.inmueblesUI.commonUI.BuscarContribuyenteUI;
import main.ui.inmueblesUI.commonUI.interfacesUI.IBuscarPersonaUI;
import main.ui.inmueblesUI.empadronamientoUI.AsignarContribuyenteUI;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class RegisterTaxPayer {
    public static void now(WebDriver driver, ExtentTest extentTest, List<String> taxpayers){
        try {
            if(!taxpayers.isEmpty()){
                for (String idTaxpayer : taxpayers) {
                    AssignTaxpayer.add(driver);
                    Verify.elementIsReady(driver, extentTest, BuscarContribuyenteUI.ttlBuscarContribuyente);
                    IBuscarPersonaUI elements = BuscarContribuyenteUI.getInstance();
                    SearchTaxpayer.by(driver, elements, idTaxpayer, "PADRON MUNICIPAL DEL CONTRIBUYENTE");
                    Verify.elementIsReady(driver, extentTest, AsignarContribuyenteUI.ttlAsignarContribuyente);
                }
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Contribuyentes seleccionados.");
                AssignTaxpayer.record(driver);
            }
        }catch (Exception exception){

        }

    }
}
