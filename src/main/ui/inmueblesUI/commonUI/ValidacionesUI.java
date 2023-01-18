package main.ui.inmueblesUI.commonUI;

import org.openqa.selenium.By;

public class ValidacionesUI {
    public static By ttlValidaciones = By.xpath("//h2[text()='VALIDACIONES']");
    public static By msgValidacion = By.xpath("//div[@id='ventana']/table/tbody/tr[4]");
    public static By lnkAnterior = By.linkText("Anterior");
}
