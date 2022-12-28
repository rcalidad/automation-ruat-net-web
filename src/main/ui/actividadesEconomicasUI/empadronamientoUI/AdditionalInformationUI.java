package main.ui.actividadesEconomicasUI.empadronamientoUI;

import org.openqa.selenium.By;

public class AdditionalInformationUI {
    public static By ttlInformacionAdicional = By.xpath("//h2[text()='INFORMACION ADICIONAL']");
    public static By txtTelefono = By.xpath("//th[text()='Teléfono']/following-sibling::td/input");
    public static By txtCelular = By.xpath("//th[text()='Celular']/following-sibling::td/input");
    public static By txtCasillaCorreo = By.xpath("//th[text()='Casilla Correo']/following-sibling::td/input");
    public static By txtCorreoElectronico = By.xpath("//th[text()='Correo Electrónico']/following-sibling::td/input");
    public static By btnAceptar = By.id("btnSubmit");
}
