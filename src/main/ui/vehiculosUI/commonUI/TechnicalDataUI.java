package main.ui.vehiculosUI.commonUI;

import org.openqa.selenium.By;

public class TechnicalDataUI {
    //MODIFICACION DE DATOS TÉCNICOS
    public static By ttlDatosTecnicos = By.xpath("//h2[text()='DATOS TECNICOS']");
    public static By txtNumeroMotor = By.xpath("(//div[@id='ventana']//td[contains(.,'Número Motor')]//input)[1]");
    public static By txtCilindrada = By.xpath("(//div[@id='ventana']//td[contains(.,'Número Motor')]//input)[2]");
    public static By lstTraccion = By.xpath("(//div[@id='ventana']//td[contains(.,'Número Motor')]//select)[1]");
    public static By msgTraccion = By.xpath("(//div[@id='ventana']//td[contains(.,'Número Motor')]//select)[1]/following-sibling::span[1]");
    public static By txtNumeroRuedas = By.xpath("(//div[@id='ventana']//td[contains(.,'Número Motor')]//input)[3]");
    public static By chkTurbo = By.xpath("//input[@type='checkbox']");
    public static By btnAceptar = By.name("btnValidar");
    public static By btnRestablecer = By.name("btnRestablecer");
}
