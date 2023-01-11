package main.ui.inmueblesUI.autoavaluosUI;

import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class InicioTramiteUI implements IInicioTramiteUI {
    public static By ttlInicioTramite = By.xpath("//h2[text()='Inicio Tramite']");
    public static By chkDocumentoDeIdentidad = By.xpath("//td[text()='DOCUMENTO DE IDENTIDAD']/following-sibling::td/input");
    public static By btnGrabar = By.id("btnSubmit");

    public static IInicioTramiteUI getInstance() {
        IInicioTramiteUI instance = new InicioTramiteUI();
        return instance;
    }
    @Override
    public List<By> getCheckBoxDocumentsRequired() {
        List<By> chkDocuments = List.of(chkDocumentoDeIdentidad);
        return chkDocuments;
    }

    @Override
    public List<By> getLinksDocumentRequired() {
        List<By> lnkDocuments = new ArrayList<>();
        return lnkDocuments;
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
