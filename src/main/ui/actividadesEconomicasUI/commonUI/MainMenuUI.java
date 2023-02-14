/**A
 * @description Representación de elementos HTML relacionados al menú principal del subsistema de Actividades Económicas
 * @date 06/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.actividadesEconomicasUI.commonUI;

import org.openqa.selenium.By;

public class MainMenuUI {

    //---------- MI CUENTA ------------------------
    public static By lnkCambiarContrasenia       = By.linkText("Cambiar Contraseña");
    public static By lnkCerrarSesion            = By.linkText("Cerrar Sesión");
    public static By lnkHistorialNotificaciones = By.linkText("Historial Notificaciones");
    public static By lnkAtencionPersonalizada   = By.linkText("Atención Personalizada");
    public static By lnkActualizaciones         = By.linkText("Actualizaciones");
    public static By lnkAlcaldias               = By.linkText("Alcaldias.ruat.net ");

    //---------- REGISTRO TECNICO -----------------
    public static By lnkEmpadronamiento         = By.linkText("Empadronamiento");
    public static By lnkModificacion            = By.linkText("Modificación");
    public static By lnkBaja                    = By.linkText("Baja ");

    //---------- REGISTRO TRIBUTARIO --------------
    public static By lnkExcenciones             = By.linkText("Exenciones");
    public static By lnkPrescripciones          = By.linkText("Prescripciones");
    public static By lnkMultas                  = By.linkText("Multas");
    public static By lnkCondonacion             = By.linkText("Condonación");
    public static By lnkCompensaciones          = By.linkText("Compensaciones");
    public static By lnkDescuentos              = By.linkText("Descuentos");
    public static By lnkPlanDeCuotas            = By.linkText("Plan de Cuotas");
    public static By lnkComprobantePagoCero     = By.linkText("Comprobante Pago en Cero");

    //---------- REGISTRO ADMINISTRATIVO ----------
    public static By lnkObservados              = By.linkText("Observados");
    public static By lnkCertificaciones         = By.linkText("Certificaciones");
    public static By lnkEmisiones               = By.linkText("Emisiones");
    public static By lnkRegularizacionPropiedad = By.linkText("Regularización de Propiedad");

    //---------- ALMACENES ------------------------
    public static By lnkEntregas                = By.linkText("Entregas");

    //---------- TRAMITES -------------------------
    public static By lnkCancelacion             = By.linkText("Cancelación");
    public static By lnkReimpresionReportes     = By.linkText("Reimpresión Reportes");

    //---------- REPORTES Y CONSULTAS -------------
    public static By lnkReportesConsultas       = By.linkText("Reportes y Consultas");

    //---------- LIQUIDACION ----------------------
    public static By lnkProforma                = By.linkText("Proforma");

    public static By option(String link){
        By optionLink = By.linkText(link);
        return optionLink;
    }
}
