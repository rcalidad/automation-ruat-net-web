package main.ui.inmueblesUI.prescripcionNormalUI;

import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InicioTramiteUI implements IInicioTramiteUI {
    public static By ttlInicioTramite = By.xpath("//h2[text()='Inicio Tramite']");
    public static By chkResolucionDePrescripcion = By.xpath("//td[text()='RESOLUCION DE PRESCRIPCION']/following-sibling::td/input");
    public static By chkDocumentoDeIdentidad = By.xpath("//td[text()='DOCUMENTO DE IDENTIDAD']/following-sibling::td/input");
    public static By chkNotaDeSolicitud = By.xpath("//td[text()='NOTA DE SOLICITUD']/following-sibling::td/input");
    public static By btnGrabar = By.id("btnSubmit");

    public static IInicioTramiteUI getInstance(){
        IInicioTramiteUI instance = new InicioTramiteUI();
        return instance;
    }
    @Override
    public List<By> getCheckBoxDocumentsRequired() {
        List<By> chkDocuments = List.of(chkResolucionDePrescripcion, chkDocumentoDeIdentidad, chkNotaDeSolicitud);
        return chkDocuments;
    }

    @Override
    public Map<String, By> getLinksDocumentRequired() {
        Map<String, By> linkDocuments = new HashMap<>();
        return linkDocuments;
    }

    @Override
    public By getLinkRegistrar() {
        return null;
    }

    @Override
    public By getListGestorTramite() {
        return null;
    }

    @Override
    public By getBtnGrabar() {
        return btnGrabar;
    }
}
