package main.ui.tasasOtrosIngresosUI.commonUI;

import org.openqa.selenium.By;

public class ValidacionesUI {
    public static By ttlValidaciones = By.xpath("//h1[text()='VALIDACIONES']");
    public static By msgResultadoValidacion = By.xpath("//td[contains(.,'No puede continuar')]");
    public static By lnkAnterior = By.id("lnkanterior");
}
