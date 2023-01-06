package main.ui.inmueblesUI.empadronamientoUI;

import org.openqa.selenium.By;

public class DatosConstruccionesUI {
    public static By ttlDatosConstrucciones = By.xpath("//h2[normalize-space()='DATOS CONSTRUCCIONES']");
    //DETALLE CONSTRUCCIONES
    public static By lnkAdicionarDetalleConstrucciones = By.xpath("//div[@id='divConst']//a[text()='Adicionar']");
    public static By lnkModificarDetalleConstrucciones = By.xpath("//div[@id='divConst']//a[text()='Modificar']");
    public static By lnkExcluirDetalleConstrucciones = By.xpath("//div[@id='divConst']//a[text()='Excluir']");


    //DETALLE AREAS COMUNES
    public static By lnkAdicionarDetalleAreasComunes = By.xpath("//div[@id='divAreasCom']//a[text()='Adicionar']");

    public static By btnAceptar = By.id("btnAceptar");
}
