package main.tasks.inmuebles.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import main.tasks.inmuebles.commonInm.GetTaxpayers;
import main.tasks.inmuebles.commonInm.SearchTaxpayer;
import main.tasks.inmuebles.commonInm.Verify;
import main.ui.inmueblesUI.commonUI.BuscarContribuyenteUI;
import main.ui.inmueblesUI.commonUI.interfacesUI.IBuscarPersonaUI;
import main.ui.inmueblesUI.empadronamientoUI.AsignarAccionistasUI;
import main.ui.inmueblesUI.empadronamientoUI.DatosAccionistasUI;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class RegisterShareholders {
    public static void withSamePercentage(WebDriver driver, ExtentTest extentTest, List<String> numShareholders, int numShare){
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
    public static void withSamePercentageAndTaxpayers(WebDriver driver, ExtentTest extentTest, int naturalTaxpayer, int legalTaxpayer, int numShareholders, String town){
        try {
            for (int shareholder = 1; shareholder <= numShareholders; shareholder++){
                ShareholdersData.addShareholder(driver);
                Verify.elementIsReady(driver, extentTest, AsignarAccionistasUI.ttlAsignarAccionistas);
                List<String> taxpayers = GetTaxpayers.ofTwoTypes(naturalTaxpayer, legalTaxpayer, town);
                for (String taxpayer: taxpayers) {
                    AssignShareholder.addShareholder(driver);
                    IBuscarPersonaUI elements = BuscarContribuyenteUI.getInstance();
                    SearchTaxpayer.by(driver, elements, taxpayer, "PADRON MUNICIPAL DEL CONTRIBUYENTE");
                    Verify.elementIsReady(driver, extentTest, AsignarAccionistasUI.ttlAsignarAccionistas);
                }
                AssignShareholder.recordData(driver);
                Verify.elementIsReady(driver, extentTest, DatosAccionistasUI.ttlDatosAccionistas);
            }
            ShareholdersData.assignPercentage(driver, numShareholders);
            ShareholdersData.recordData(driver);
        }catch (Exception exception){

        }
    }
}
