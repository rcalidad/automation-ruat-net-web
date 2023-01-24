package main.tasks.inmuebles.condonacionLeyMunicipal;

import com.aventstack.extentreports.ExtentTest;
import main.ui.inmueblesUI.condonacionLeyMunicipalUI.DetalleCondonacionUI;
import org.openqa.selenium.WebDriver;

public class ProcessCondonation {
    public static void now(WebDriver driver, ExtentTest extentTest, String operation, String range, String initialYear, String finalYear, String municipalLaw){
        DetailMunicipalCondonation.selectMunicipalLaw(driver, municipalLaw);
        DetailMunicipalCondonation.selectOperation(driver, extentTest, DetalleCondonacionUI.tablaDatosCondonacion, 2, operation);
        DetailMunicipalCondonation.selectCondonation(driver, extentTest, DetalleCondonacionUI.tablaDetalleCondonacion, operation, range, initialYear, finalYear);
        DetailMunicipalCondonation.process(driver, extentTest, operation);
        DetailMunicipalCondonation.record(driver);
    }
}
