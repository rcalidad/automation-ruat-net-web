package main.ui.inmueblesUI.commonUI;

import main.ui.inmueblesUI.commonUI.interfacesUI.IBuscarPersonaUI;
import org.openqa.selenium.By;

public class BuscarContribuyenteUI implements IBuscarPersonaUI {
    public static By ttlBuscarContribuyente = By.xpath("//h2[normalize-space()='BUSCAR CONTRIBUYENTE']");
    public static By txtNumeroDocumento = By.id("txtNumeroDocumento");
    public static By txtComplementoNumDocumento = By.id("txtNroComplemento");
    public static By lstTipoDocumento = By.id("cbxTipoDocumento");
    public static By btnBuscar = By.name("btnBuscar");

    public static IBuscarPersonaUI getInstance(){
        IBuscarPersonaUI instance = new BuscarContribuyenteUI();
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
