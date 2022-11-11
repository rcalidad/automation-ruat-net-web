package main.tasks.vehiculos.modificarDatosTecnicosOperador;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Enter;
import main.actions.Log;
import main.actions.SelectOption;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.modificarDatosTecnicosOperadorUI.RegistrarTarjetaOperacionUI;
import org.openqa.selenium.WebDriver;

public class RegistrarTarjetaOperacion {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, RegistrarTarjetaOperacionUI.ttlRegistrarTarjetaOperacion);
    }
    public static void fillForm(WebDriver driver, String nroCard, String initialDate, String finalDate){
        Log.recordInLog("Registrando tarjeta de operación...");
        SelectOption.byText(driver, RegistrarTarjetaOperacionUI.txtInstitucionEmisor, "VICEMINISTERIO DE TRANSPORTE");
        SelectOption.waitUntilLoadOptions(driver, RegistrarTarjetaOperacionUI.txtTipoTarjetaOperacion);
        SelectOption.firstOption(driver, RegistrarTarjetaOperacionUI.txtTipoTarjetaOperacion);
        Enter.text(driver, RegistrarTarjetaOperacionUI.txtNombreAutoridadEmisora, "Autoridad");
        Enter.text(driver, RegistrarTarjetaOperacionUI.txtNumeroTarjeta, nroCard);
        //Enter.text(driver, RegistrarTarjetaOperacionUI.txtFechaInicio, initialDate);
        //Enter.text(driver, RegistrarTarjetaOperacionUI.txtFechaFin, finalDate);
        Enter.date(driver, RegistrarTarjetaOperacionUI.txtFechaInicio, initialDate);
        Enter.date(driver, RegistrarTarjetaOperacionUI.txtFechaFin, finalDate);
        Click.on(driver, RegistrarTarjetaOperacionUI.btnAceptar);
    }
}
