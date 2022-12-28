package main.ui.actividadesEconomicasUI.empadronamientoUI;

import org.openqa.selenium.By;

public class ReceiveDocumentationUI {
    public static By ttlRecepcionarDocumentacion = By.xpath("//h2[text()='RECEPCIONAR DOCUMENTACION']");
    public static By btnGrabar = By.id("btnSubmit");

    //SRE
    public static By chkFormularioUnicoDeLicenciaDeFuncionamientoRAE01 = By.xpath("//td[normalize-space() = '*FORMULARIO UNICO DE LICENCIA DE FUNCIONAMIENTO (RAE 01)']/following-sibling::td/input");
    public static By chkFotocopiaDocumentoDeIdentidad = By.xpath("//td[normalize-space() = '*FOTOCOPIA DOCUMENTO DE IDENTIDAD']/following-sibling::td/input");
    public static By chkFormularioDeInspeccionDeActividadesEconomicasRAE02 = By.xpath("//td[normalize-space() = '*FORMULARIO DE INSPECCION DE ACTIVIDADES ECONOMICAS (RAE 02)']/following-sibling::td/input");

    //CBA
    //categoria 1 Y 2
    public static By chkFotocopiaCedulaDeIdentidadPersonaNaturalRepresentanteLegal = By.xpath("//td[normalize-space() = '*FOTOCOPIA CEDULA DE IDENTIDAD (PERSONA NATURAL/PERSONA JURIDICA - REPRESENTANTE LEGAL)']/following-sibling::td/input");
    public static By chkOriginalFormularioDeDeclaracionJuradaPersonaNaturalPersonaJuridica = By.xpath("//td[normalize-space() = '*ORIGINAL FORMULARIO DE DECLARACION JURADA (PERSONA NATURAL/PERSONA JURIDICA)']/following-sibling::td/input");
    public static By chkOriginalFormularioUnicoDeRecaudaciones = By.xpath("//td[normalize-space() = '*ORIGINAL FORMULARIO UNICO DE RECAUDACIONES']/following-sibling::td/input");

    //SCZ
    public static By chkDocumentoDeIdentidad = By.xpath("//td[normalize-space() = '*DOCUMENTO DE IDENTIDAD']/following-sibling::td/input"); //EAL

    //EAL
    public static By chkFormularioUnicoFUTAE = By.xpath("//td[normalize-space() = '*FORMULARIO UNICO PARA EL TRAMITE DE LA ACTIVIDAD ECONOMICA (FUTAE)']/following-sibling::td/input");
    public static By chkCarpetaAzul = By.xpath("//td[normalize-space() = '*CARPETA AZUL']/following-sibling::td/input");
    public static By chkNumeroIdentificacionTributaria = By.xpath("//td[normalize-space() = '*NUMERO DE IDENTIFICACION TRIBUTARIA']/following-sibling::td/input");
    public static By chkEscrituraDeConstitucion = By.xpath("//td[normalize-space() = '*ESCRITURA DE CONSTITUCION']/following-sibling::td/input");
}
