package main.tasks.inmuebles.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.GetText;
import main.actions.WaitUntilElement;
import main.helpers.common.Inmuebles.ConstantsINM;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.commonTasks.CloseChildWindows;
import main.tasks.inmuebles.helpersInm.ChangeFrame;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.inmueblesUI.empadronamientoUI.ConfirmarTramiteUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmProcedure {
    public static boolean getReport(WebDriver driver, String originalFilename, String operation, String identifier, int index, By locator){
        WaitUntilElement.isClikeableOf(driver, locator);
        Click.on(driver, locator);
        return FileBuilder.moveAndRenameFile(originalFilename, operation, GetText.ofValue(driver, locator).trim(), identifier, ConstantsINM.SUBSYSTEM_ID, index);
    }
    public static void toEmpadronamiento(WebDriver driver, ExtentTest extentTest, String originalFileName, String operation, String identificador, int index){
        String originalWindow = driver.getWindowHandle();
        getReport(driver, originalFileName, operation, identificador, index, ConfirmarTramiteUI.btnVistaPrevia); //reportePDF.pdf
        CloseChildWindows.now(driver, originalWindow);
        ChangeFrame.toContentFrame(driver);
        WaitUntilElement.isClikeableOf(driver, ConfirmarTramiteUI.btnGrabar);
        Click.on(driver, ConfirmarTramiteUI.btnGrabar);
        VerifyAlert.containsThisText(driver, "correctamente");
        getReport(driver, originalFileName, operation, identificador, index, ConfirmarTramiteUI.btnGenerarReporte); //reportePDF.pdf
        CloseChildWindows.now(driver, originalWindow);
        ChangeFrame.toContentFrame(driver);
        WaitUntilElement.isClikeableOf(driver, ConfirmarTramiteUI.btnSalir);
        Click.on(driver, ConfirmarTramiteUI.btnSalir);
    }
    public static void toAutoevaluo(WebDriver driver, String originalFileName, String operation, String identifier, int index){
        String originalWindow = driver.getWindowHandle();
        getReport(driver, originalFileName, operation, identifier, index, ConfirmarTramiteUI.btnVistaPrevia); //reportePDF.pdf
        CloseChildWindows.now(driver, originalWindow);
        //String window = driver.getWindowHandle();
        //driver.switchTo().window(window);
        ChangeFrame.toContentFrame(driver);

        //originalWindow = driver.getWindowHandle();
        getReport(driver, originalFileName, operation, identifier, index, ConfirmarTramiteUI.btnGenerarReporte); //reportePDF.pdf
        CloseChildWindows.now(driver, originalWindow);
        //window = driver.getWindowHandle();
        //driver.switchTo().window(window);
        ChangeFrame.toContentFrame(driver);
        Click.on(driver, ConfirmarTramiteUI.btnSalir);
    }
    public static void toCompensacion(WebDriver driver, String originalFileName, String operation, String identifier, int index){
        toAutoevaluo(driver, originalFileName, operation, identifier, index);
    }
    public static void toBasesImponibles(WebDriver driver, String originalFileName, String operation, String identifier, int index){
        toAutoevaluo(driver, originalFileName, operation, identifier, index);
    }
}
