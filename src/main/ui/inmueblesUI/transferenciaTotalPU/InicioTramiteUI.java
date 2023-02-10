package main.ui.inmueblesUI.transferenciaTotalPU;

import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InicioTramiteUI implements IInicioTramiteUI {
    public static By ttlInicioTramite = By.xpath("//h2[text()='Inicio Tramite']");
    public static By chkCedulaDeIdentidad = By.xpath("//td[text()='CEDULA DE IDENTIDAD']/following-sibling::td/input");
    public static By chkMinutaDeTransferencia = By.xpath("//td[text()='MINUTA DE TRANSFERENCIA']/following-sibling::td/input");
    public static By chkComprobanteDePagoDelIP = By.xpath("//td[text()='COMPROBANTE DE PAGO DEL IP']/following-sibling::td/input");
    public static By btnGrabar = By.id("btnSubmit");

    public static IInicioTramiteUI getInstance(){
        IInicioTramiteUI instance = new InicioTramiteUI();
        return instance;
    }
    @Override
    public List<By> getCheckBoxDocumentsRequired() {
        List<By> chkDocuments = List.of(chkCedulaDeIdentidad, chkMinutaDeTransferencia, chkComprobanteDePagoDelIP);
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
