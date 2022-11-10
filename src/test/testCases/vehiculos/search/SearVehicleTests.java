package test.testCases.vehiculos.search;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.actions.IsDisplayed;
import main.tasks.vehiculos.commonVeh.LoadModule;
import main.tasks.vehiculos.commonVeh.SearchVehicle;
import main.tasks.vehiculos.login.LoginVehiculos;
import main.tasks.vehiculos.mainMenu.MainMenu;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.commonUI.ValidarCertificadoPropiedadUI;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.BaseTest;

public class SearVehicleTests extends BaseTest {
    ExtentTest extentTest;
    ExtentReports extentReports;
    @Test
    public void testSuccessfulSearchVehicleForPTA(){
        String pta = "941HER";
        String user = "LGUPTA.CBA";
        String password = "L1234567$";
        LoginVehiculos.as(driver, extentReports, extentTest, user, password);
        MainMenu.selectOption(driver, "Modificación Datos Técnicos");
        driver.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(driver, "Modificación Datos Técnicos");
        driver.switchTo().frame(FramesUI.frameNameContenido);
        SearchVehicle.forPTA(driver, pta);
        Assert.assertTrue(IsDisplayed.element(driver, ValidarCertificadoPropiedadUI.ttlModificacionDatosTecnicos, 5));
    }
}
