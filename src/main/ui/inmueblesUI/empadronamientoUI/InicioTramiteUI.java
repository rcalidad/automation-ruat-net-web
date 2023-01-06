package main.ui.inmueblesUI.empadronamientoUI;

import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class InicioTramiteUI implements IInicioTramiteUI {
    public static By ttlInicioTramite = By.xpath("//h2[text()='Inicio Tramite']");
    public static By chkCedulaDeIdentidad = By.xpath("//td[text()='CEDULA DE IDENTIDAD']/following-sibling::td/input");
    public static By lnkRegistrar = By.linkText("Registrar");
    public static By lstCondicionGestorTramite = By.id("cbxCondicionGT");
    public static By btnGrabar = By.id("btnSubmit");

    public static IInicioTramiteUI getInstance() {
        IInicioTramiteUI instance = new InicioTramiteUI();
        return instance;
    }

    @Override
    public List<By> getCheckBoxDocumentsRequired() {
        List<By> chkDocuments = List.of(chkCedulaDeIdentidad);
        return chkDocuments;
    }

    @Override
    public List<By> getLinksDocumentRequired() {
        List<By> lnkDocuments = new ArrayList<>();
        return lnkDocuments;
    }

    @Override
    public By getLinkRegistrar() {
        return lnkRegistrar;
    }

    @Override
    public By getListGestorTramite() {
        return lstCondicionGestorTramite;
    }

    @Override
    public By getBtnGrabar() {
        return btnGrabar;
    }
}
