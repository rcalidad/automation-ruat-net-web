package main.tasks.vehiculos.modificarDatosTecnicosOperador;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.DisplayAlert;
import main.actions.Enter;
import main.actions.WaitUntilAlert;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.modificarDatosTecnicosOperadorUI.ModificarFechaInicioImpuestoUI;
import org.openqa.selenium.WebDriver;

public class ModificarFechaInicioImpuesto {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, ModificarFechaInicioImpuestoUI.ttlModificarFechaInicioImpuesto);
    }
    public static void to(WebDriver driver, String newDate){
        Enter.text(driver, ModificarFechaInicioImpuestoUI.txtFechaNueva, newDate);
        Click.on(driver, ModificarFechaInicioImpuestoUI.btnAceptar);
        if (WaitUntilAlert.isPresent(driver)){
            String message = DisplayAlert.getText(driver);
            //La Fecha Inicio Impuestos es menor a la fecha de la póliza de importación (05/05/2022). ¿Desea continuar?
            if (message.contains("¿Desea continuar?")){
                DisplayAlert.toAcept(driver);
            }
        }
    }
}
