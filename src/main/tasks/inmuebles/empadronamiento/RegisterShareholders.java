package main.tasks.inmuebles.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import main.tasks.inmuebles.commonInm.SearchTaxpayer;
import main.tasks.inmuebles.commonInm.Verify;
import main.ui.inmueblesUI.commonUI.BuscarContribuyenteUI;
import main.ui.inmueblesUI.commonUI.interfacesUI.IBuscarPersonaUI;
import main.ui.inmueblesUI.empadronamientoUI.AsignarAccionistasUI;
import main.ui.inmueblesUI.empadronamientoUI.DatosAccionistasUI;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class RegisterShareholders {
    public static void withSamePercentage(WebDriver driver, ExtentTest extentTest, List<String> numShareholders){
        try {
            for (String idShareholder : numShareholders) {
                ShareholdersData.addShareholder(driver);
                Verify.elementIsReady(driver, extentTest, AsignarAccionistasUI.ttlAsignarAccionistas);
                AssignShareholder.addShareholder(driver);
                IBuscarPersonaUI elements = BuscarContribuyenteUI.getInstance();
                SearchTaxpayer.by(driver, elements, idShareholder, "PADRON MUNICIPAL DEL CONTRIBUYENTE");
                Verify.elementIsReady(driver, extentTest, AsignarAccionistasUI.ttlAsignarAccionistas);
                AssignShareholder.recordData(driver);
                Verify.elementIsReady(driver, extentTest, DatosAccionistasUI.ttlDatosAccionistas);
            }
            ShareholdersData.assignPercentage(driver);
            ShareholdersData.recordData(driver);
        }catch (Exception exception){

        }
    }
}
