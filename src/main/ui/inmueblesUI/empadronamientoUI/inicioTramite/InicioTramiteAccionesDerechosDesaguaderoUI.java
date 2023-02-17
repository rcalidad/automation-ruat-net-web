package main.ui.inmueblesUI.empadronamientoUI.inicioTramite;

import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import org.openqa.selenium.By;

import java.util.List;

public class InicioTramiteAccionesDerechosDesaguaderoUI extends InicioTramiteDesUI{

    public static By chkDocumentoDeIdentidad = By.xpath("//td[text()='DOCUMENTO DE IDENTIDAD']/following-sibling::td/input");

    public static IInicioTramiteUI getInstance() {
        IInicioTramiteUI instance = new InicioTramiteAccionesDerechosDesaguaderoUI();
        return instance;
    }

    @Override
    public List<By> getCheckBoxDocumentsRequired() {
        List<By> chkDocuments = List.of(chkDocumentoDeIdentidad);
        return chkDocuments;
    }
}
