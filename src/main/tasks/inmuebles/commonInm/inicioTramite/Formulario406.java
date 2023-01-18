package main.tasks.inmuebles.commonInm.inicioTramite;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Enter;
import main.helpers.common.Inmuebles.ConstantsINM;
import main.tasks.inmuebles.commonInm.GetDate;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.basesImponiblesIpUI.RegistroDetalleDocumentoUI;
import org.openqa.selenium.WebDriver;

public class Formulario406 implements IDocument{

    public Formulario406(){

    }
    public void fillWithDefaultData(WebDriver driver, ExtentTest extentTest){
        try {
            Verify.elementIsReady(driver, extentTest, RegistroDetalleDocumentoUI.ttlRegistroDetalleDocumento);
            Enter.text(driver, RegistroDetalleDocumentoUI.txtAutoridadEmisora, MessagesINM.defaultName);
            //Enter.text(driver, RegistroDetalleDocumentoUI.txtFechaDocumento, GetDate.ofHeader(driver));
            Enter.text(driver, RegistroDetalleDocumentoUI.txtFechaDocumento, ConstantsINM.systemDate);
            Enter.text(driver, RegistroDetalleDocumentoUI.txtNumeroSerie, MessagesINM.defaultNumSerieAlfanumerico);
            Enter.text(driver, RegistroDetalleDocumentoUI.txtNumeroFojas, MessagesINM.defaultNumFojas);
            Click.on(driver, RegistroDetalleDocumentoUI.rbtAmbas);
            Enter.text(driver, RegistroDetalleDocumentoUI.txtObservaciones, MessagesINM.testText);
            Click.on(driver, RegistroDetalleDocumentoUI.btnAceptar);
        }catch (Exception exception){

        }
    }
}
