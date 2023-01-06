package main.ui.inmueblesUI.commonUI.interfacesUI;

import org.openqa.selenium.By;

import java.util.List;

public interface IInicioTramiteUI {
    List<By> getCheckBoxDocumentsRequired();
    List<By> getLinksDocumentRequired();
    By getLinkRegistrar();
    By getListGestorTramite();
    By getBtnGrabar();
}
