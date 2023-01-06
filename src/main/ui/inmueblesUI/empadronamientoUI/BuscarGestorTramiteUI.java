package main.ui.inmueblesUI.empadronamientoUI;

import main.ui.inmueblesUI.commonUI.interfacesUI.IBuscarPersonaUI;
import org.openqa.selenium.By;

public class BuscarGestorTramiteUI implements IBuscarPersonaUI {
    public static By ttlBuscarGestorTramite = By.xpath("//h2[normalize-space()='BUSQUEDA GESTOR TRAMITE']");
    public static By txtNumeroDocumento = By.id("txtNroDocumento");
    public static By txtComplementoNumDocumento = By.id("txtNroComplemento");
    public static By lstTipoDocumento = By.id("cbxTipoDocumento");
    public static By btnBuscar = By.id("btnBuscar");
    public static By btnNuevoGestorTramite = By.id("btnNuevo");
    public static By lnkAsociar = By.linkText("Asociar");

    public static IBuscarPersonaUI getInstance(){
        IBuscarPersonaUI instance = new BuscarGestorTramiteUI();
        return instance;
    }
    @Override
    public By getNroDocumentBox() {
        return txtNumeroDocumento;
    }

    @Override
    public By getNroComplementBox() {
        return txtComplementoNumDocumento;
    }

    @Override
    public By getDocumentTypeList() {
        return lstTipoDocumento;
    }

    @Override
    public By getSearchButton() {
        return btnBuscar;
    }
}
