package main.ui.inmueblesUI.empadronamientoUI;

import org.openqa.selenium.By;

public class DatosTerrenoUI {
    public static By ttlDatosTerreno = By.xpath("//h2[normalize-space()='DATOS TERRENO']");
    //DATOS TERRENO
    public static By txtGestion = By.id("txtGestion");
    public static By txtSuperficie = By.id("txtSuperficie");
    public static By rbtHa = By.id("rbtha");
    public static By rbtM2 = By.id("rbtm2");
    public static By lstTaxArea = By.id("cbxZonaTributaria");
    public static By lstInclinacion = By.id("cbxInclinacion");
    public static By lstMaterialVia = By.id("cbxMaterialVia");
    public static By lstInclinacionTerreno = By.id("cbxInclinacionTerreno");

    //SERVICIOS
    public static By chkTodosLosServicios = By.id("chkTodos");
    public static By chkAgua = By.id("chkagua");
    public static By chkAlcantarillado = By.id("chkalcantarillado");
    public static By chkTelefono = By.id("chktelefono");
    public static By chkLuz = By.id("chkluz");
    public static By chkGasDomiciliario = By.id("chkgas_domiciliario");

    public static By btnLimpiar = By.id("btnLimpiar");
    public static By btnAceptar = By.id("btnAceptar");
}
