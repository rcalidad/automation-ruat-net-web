package main.ui.inmueblesUI.empadronamientoUI;

import org.openqa.selenium.By;

public class DatosConstruccionUI {
    public static By ttlDatosConstruccion = By.xpath("//h2[normalize-space()='DATOS CONSTRUCCION']");

    //DATOS CONSTRUCCION
    public static By txtBloque = By.id("txtBloque");
    public static By txtGestion = By.id("txtAnioInicioImp");
    public static By txtAnioConstruccion = By.id("txtAnioConstruccion");
    public static By txtSuperficie = By.id("txtSuperficie");
    public static By lstTipoConstruccion = By.xpath("//div[@id='divTipoConstruccion']/select");
    public static By lstZonaTributaria = By.xpath("//div[@id='divZonaTributaria']/select");

    public static By btnLimpiar = By.id("btnLimpiar");
    public static By btnAceptar = By.id("btnAceptar");
}
