package main.ui.inmueblesUI.condonacionLeyMunicipal;

import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import org.openqa.selenium.By;

import java.util.List;

public class InicioTramiteUI implements IInicioTramiteUI {
    public static By ttlInicioTramite = By.xpath("//h2[text()='Inicio Tramite']");
    public static By chkDocumentoDeIdentidad = By.xpath("//td[text()='DOCUMENTO DE IDENTIDAD']/following-sibling::td/input");
    public static By btnGrabar = By.id("btnSubmit");

    public static IInicioTramiteUI getInstance(){
        InicioTramiteUI instance = new InicioTramiteUI();
        return instance;
    }
    @Override
    public List<By> getCheckBoxDocumentsRequired() {
        List<By> chkDocuments = List.of(chkDocumentoDeIdentidad);
        return chkDocuments;
    }

    @Override
    public List<By> getLinksDocumentRequired() {
        return null;
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
