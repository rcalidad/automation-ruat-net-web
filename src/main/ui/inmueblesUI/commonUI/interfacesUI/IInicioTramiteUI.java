package main.ui.inmueblesUI.commonUI.interfacesUI;

import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public interface IInicioTramiteUI {
    List<By> getCheckBoxDocumentsRequired();
    Map<String, By> getLinksDocumentRequired();
    By getLinkRegistrar();
    By getListGestorTramite();
    By getBtnGrabar();
}
