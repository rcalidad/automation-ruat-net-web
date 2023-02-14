/**A
 * @description Representaci�n de elementos HTML relacionados al men� principal del subsistema de Actividades Econ�micas
 * @date 06/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.actividadesEconomicasUI.commonUI;

import org.openqa.selenium.By;

public class MainMenuUI {

    //---------- MI CUENTA ------------------------
    public static By lnkCambiarContrasenia       = By.linkText("Cambiar Contrase�a");
    public static By lnkCerrarSesion            = By.linkText("Cerrar Sesi�n");
    public static By lnkHistorialNotificaciones = By.linkText("Historial Notificaciones");
    public static By lnkAtencionPersonalizada   = By.linkText("Atenci�n Personalizada");
    public static By lnkActualizaciones         = By.linkText("Actualizaciones");
    public static By lnkAlcaldias               = By.linkText("Alcaldias.ruat.net ");

    //---------- REGISTRO TECNICO -----------------
    public static By lnkEmpadronamiento         = By.linkText("Empadronamiento");
    public static By lnkModificacion            = By.linkText("Modificaci�n");
    public static By lnkBaja                    = By.linkText("Baja ");

    //---------- REGISTRO TRIBUTARIO --------------
    public static By lnkExcenciones             = By.linkText("Exenciones");
    public static By lnkPrescripciones          = By.linkText("Prescripciones");
    public static By lnkMultas                  = By.linkText("Multas");
    public static By lnkCondonacion             = By.linkText("Condonaci�n");
    public static By lnkCompensaciones          = By.linkText("Compensaciones");
    public static By lnkDescuentos              = By.linkText("Descuentos");
    public static By lnkPlanDeCuotas            = By.linkText("Plan de Cuotas");
    public static By lnkComprobantePagoCero     = By.linkText("Comprobante Pago en Cero");

    //---------- REGISTRO ADMINISTRATIVO ----------
    public static By lnkObservados              = By.linkText("Observados");
    public static By lnkCertificaciones         = By.linkText("Certificaciones");
    public static By lnkEmisiones               = By.linkText("Emisiones");
    public static By lnkRegularizacionPropiedad = By.linkText("Regularizaci�n de Propiedad");

    //---------- ALMACENES ------------------------
    public static By lnkEntregas                = By.linkText("Entregas");

    //---------- TRAMITES -------------------------
    public static By lnkCancelacion             = By.linkText("Cancelaci�n");
    public static By lnkReimpresionReportes     = By.linkText("Reimpresi�n Reportes");

    //---------- REPORTES Y CONSULTAS -------------
    public static By lnkReportesConsultas       = By.linkText("Reportes y Consultas");

    //---------- LIQUIDACION ----------------------
    public static By lnkProforma                = By.linkText("Proforma");

    public static By option(String link){
        By optionLink = By.linkText(link);
        return optionLink;
    }
}
