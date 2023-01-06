package main.ui.inmueblesUI.empadronamientoUI;

import org.openqa.selenium.By;

import java.util.Map;

public class DefinicionInmuebleUI {
    public static By ttlDefinicionInmueble = By.xpath("//h2[normalize-space()='DEFINICION INMUEBLE']");
    public static By txtCodigoCatastral = By.id("txtCodigocatastral"); //lpz, cba
    public static By rbtFormato = By.id("rdoFormato"); //scz
    public static By rbtCoordenadas = By.id("rdoCoordenadas"); //scz
    public static By rbtUrbano = By.id("rbtUrbano");
    public static By rbtRural = By.id("rbtRural");
    public static By lstClaseInmueble = By.xpath("//div[@id='divClases']/select");
    public static By rbtSi = By.id("rbtCondominioSi"); //scz
    public static By rbtNo = By.id("rbtCondominioNo"); //scz
    public static By btnAceptar = By.id("btnAceptar");

    public static Map<String, By> tipoCodigoCatastral = Map.of("FORMATO", rbtFormato, "COORDENADAS", rbtCoordenadas);
    public static Map<String, By> area = Map.of("URBANO", rbtUrbano, "RURAL", rbtRural);
    public static Map<String, By> inmuebleEnCondominio = Map.of("SI", rbtSi, "NO", rbtNo);
}
