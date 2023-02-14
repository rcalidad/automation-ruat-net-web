package main.ui.inmueblesUI.empadronamientoUI.inicioTramite;

import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import main.ui.inmueblesUI.empadronamientoUI.InicioTramiteUI;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InicioTramiteDesUI implements IInicioTramiteUI {
    public static By ttlInicioTramite = By.xpath("//h2[text()='Inicio Tramite']");
    public static By chkDocumentoDeIdentidad = By.xpath("//td[text()='DOCUMENTO DE IDENTIDAD']/following-sibling::td/input");
    public static By chkTestimonio = By.xpath("//td[text()='TESTIMONIO']/following-sibling::td/input");
    public static By chkPlanoUbicacion = By.xpath("//td[text()='PLANO DE UBICACION']/following-sibling::td/input");

    public static By lnkRegistrar = By.linkText("Registrar");
    //public static By lstCondicionGestorTramite = By.id("cbxCondicionGT");
    public static By btnGrabar = By.id("btnSubmit");

    public static IInicioTramiteUI getInstance() {
        IInicioTramiteUI instance = new InicioTramiteDesUI();
        return instance;
    }

    @Override
    public List<By> getCheckBoxDocumentsRequired() {
        List<By> chkDocuments = List.of(chkDocumentoDeIdentidad, chkTestimonio, chkPlanoUbicacion);
        return chkDocuments;
    }

    @Override
    public Map<String, By> getLinksDocumentRequired() {
        Map<String, By> lnkDocuments = new HashMap<>();
        return lnkDocuments;
    }

    @Override
    public By getLinkRegistrar() {
        return lnkRegistrar;
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
