package main.ui.actividadesEconomicasUI.empadronamientoUI;

import org.openqa.selenium.By;

import java.util.Map;

public class LocationActividadEconomicaUI {
    public static By ttlUbicacionActividadEconomica = By.xpath("//h2[text()='UBICACION ACTIVIDAD ECONOMICA']");
    public static By rbtUrbano = By.id("rbtUrbano");
    public static By rbtRural = By.id("rbtRural");
    public static By lstZona = By.xpath("//th[text()='Zona']/following-sibling::td/select");
    public static By lstUnidadVecinal = By.xpath("//th[text()='Unidad Vecinal']/following-sibling::td/select");
    public static By lstBarrio = By.xpath("//th[text()='Barrio']/following-sibling::td/select");
    public static By lstManzano = By.xpath("//th[text()='Manzano']/following-sibling::td/select");
    public static By lstTipoLugar = By.xpath("//th[text()='Tipo Lugar']/following-sibling::td/select");
    public static By lstNombreLugar = By.xpath("//th[text()='Nombre Lugar']/following-sibling::td/select");
    public static By txtNumeroPuerta = By.id("txtNroPuerta");
    public static By chkSinNumeroPuerta = By.id("chksinNumero");
    public static By btnAceptar = By.id("btnSubmit");

    public static By lstDatosUbicacionActividad = By.xpath("//th[contains(.,'*')]/following-sibling::td/select");
    public static Map<String, By> municipalArea = Map.of("URBANO", rbtUrbano, "RURAL", rbtRural);
}
