package main.ui.inmueblesUI.empadronamientoUI;

import main.actions.Click;
import org.openqa.selenium.By;

import java.util.Map;

public class UbicacionInmuebleUI {
    public static By ttlUbicacinInmueble = By.xpath("//h2[normalize-space()='UBICACION INMUEBLE']");
    //DATOS UBICACION
    public static By lstMacroDistrito = By.xpath("//th[text()='Macro Distrito']/following-sibling::td/select");
    public static By lstDistrito = By.xpath("//th[text()='Distrito']/following-sibling::td/select");
    public static By lstZonaBarrio = By.xpath("//th[text()='Zona/Barrio']/following-sibling::td/select");
    public static By lstZonaComunidad = By.xpath("//th[text()='Zona/Comunidad']/following-sibling::td/select");
    public static By lstTipoLugar = By.xpath("//th[text()='Tipo Lugar']/following-sibling::td/select");
    public static By lstNombreLugar = By.xpath("//th[text()='Nombre Lugar']/following-sibling::td/select");
    public static By txtNumeroPuerta = By.id("txtNroPuerta");
    public static By chkSinNumero = By.id("chksinNumero");
    public static By txtDireccionDescriptiva = By.id("txaDireccionDescriptiva");

    //DATOS EDIFICIO
    public static By txtNombreEdificio = By.id("txtNombreedificio");
    public static By txtBloque = By.id("txtBloque");
    public static By txtPiso = By.id("txtPiso");
    public static By lstTipoUnidadFuncional = By.id("cbxTipoUnidadFuncional");
    public static By txtNumeroUnidadFuncional = By.id("txtNroUnidadFuncional");
    public static By txtCodigoMatriz = By.id("txtCodigoMatriz");

    //DATOS ADICIONALES
    public static By txtNumeroMedidorLuz = By.id("txtNumeroMedidorLuz");
    public static By chkSinDato = By.id("chkSinDato");
    public static By rbtSi = By.id("rbtDomicilioGeorefSi");
    public static By rbtNo = By.id("rbtDomicilioGeorefNo");
    public static By btnLimpiar = By.id("btnLimpiar");
    public static By btnAceptar = By.id("btnGrabar");

    public static Map<String, By> domicilioGeoreferenciado = Map.of("SI", rbtSi, "NO", rbtNo);

}
