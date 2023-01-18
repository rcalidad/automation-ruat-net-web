package main.ui.inmueblesUI.compensacionesUI;

import main.ui.inmueblesUI.commonUI.interfacesUI.IPeriodTable;
import org.openqa.selenium.By;

public class DetalleSujetosPasivosUI {
    public static By ttlDetalleSujetosPasivos = By.xpath("//h2[text()='Detalle Sujetos Pasivos']");
    public static By btnAceptar = By.name("btnPagar");
    public static IPeriodTable TablaDatosSujetosPasivosInmueble = new TablaDetalleSujetosPasivosUI();
}
