package main.tasks.vehiculos.commonVeh;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Enter;
import main.ui.vehiculosUI.commonUI.RecordMinuteUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RecordMinute {
    public static Map<String, By> currencies = Map.of("DOLARES", RecordMinuteUI.rbtDolares, "BOLIVIANOS", RecordMinuteUI.rbtBolivianos, "UFV", RecordMinuteUI.rbtUfvs);
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, RecordMinuteUI.ttlRegistrarMinuta);
    }
    public static void with(WebDriver driver, String date, String amount, String currency){
        Enter.dateByElementId(driver, RecordMinuteUI.txtFechaMinuta, date);
        Enter.dateByElementId(driver, RecordMinuteUI.txtVerificacionFechaMinuta, date);
        Enter.text(driver, RecordMinuteUI.txtMontoMinuta, amount);
        Enter.text(driver, RecordMinuteUI.txtVerificacionMmontoMinuta, amount);
        Click.on(driver, currencies.get(currency));
        Click.on(driver, RecordMinuteUI.btnAceptar);
    }
}
