package main.ui.actividadesEconomicasUI.empadronamientoUI;

import org.openqa.selenium.By;

public class SelectionCriteriaRequiredDocumentsUI {
    public static By ttlSeleccionCriteriosDocumentosRequeridos = By.xpath("//h2[text()='SELECCION CRITERIOS DOCUMENTOS REQUERIDOS']");
    public static By btnAceptar = By.name("btnAceptar");

    //CBA
    public static By lstCategoria = By.xpath("//td/select");  //categoria: 1 y 2

    //EAL
    public static By rbtNatural = By.xpath("//input[@value='NA']");
    public static By rbtJuridico =By.xpath("//input[@value='JU']");
    public static By chkInspeccion = By.id("chkInspeccion");
}
