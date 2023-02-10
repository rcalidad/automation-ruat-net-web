package main.tasks.inmuebles.transferenciaNormalTotal;

import main.actions.*;
import main.ui.inmueblesUI.transferenciaTotalPU.RegistrarMinutaUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RecordMinute {

    public static void fillFormWithDefaultData(WebDriver driver, String transferenceType, String amountMinute, String typeOfCurrency, String dateMinute){
        Scroll.toElementOnTheMiddle(driver, driver.findElement(RegistrarMinutaUI.lstTipoTransferencia));
        //SelectOption.nonEmptyRandomValue(driver, RegistrarMinutaUI.lstTipoTransferencia);
        SelectOption.byText(driver, RegistrarMinutaUI.lstTipoTransferencia, transferenceType);
        Scroll.toEndPage(driver);
        Enter.text(driver, RegistrarMinutaUI.txtFechaMinuta, dateMinute);
        Enter.text(driver, RegistrarMinutaUI.txtVerificacionFechaMinuta, dateMinute);
        Enter.text(driver, RegistrarMinutaUI.txtMontoMinuta, amountMinute);
        Enter.text(driver, RegistrarMinutaUI.txtVerificacionMontoMinuta, amountMinute);
        Scroll.toEndPage(driver);
        Click.on(driver, RegistrarMinutaUI.currency.get(typeOfCurrency.toUpperCase()));
        Click.on(driver, RegistrarMinutaUI.btnAceptar);
    }
}
