package main.tasks.inmuebles.liquidacion;

import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.actions.Log;
import main.helpers.common.Constants;
import main.helpers.common.Inmuebles.ConstantsINM;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.inmuebles.commonInm.GeneratorExcel;
import main.ui.inmueblesUI.liquidacionUI.ProformaUI;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @description: Clase que realiza el flujo del módulo de proforma, liquida un inmueble, genera la proforma detallada y guarda
 * el reporte en el directorio descargas. Se incluyen 3 posibles operaciones: sólo liquidar, emitir proforma
 * detallada o emitir proforma resumida.
 * @author Faustina Chambi Camata
 * Fecha: 21/07/2022
 */
public class Proforma extends GeneratorExcel {
    public static final String MENU_PROFORMA                = "Proforma";
    public static final String MODULO_PROFORMA              = "Proforma Inmuebles";
    public static final String TIPO_DEUDA_TODOS             = "TODOS";
    public static final String PARAMETRO_DETALLE_DEUDA      = "DETALLE DEUDA";
    public static final String OPERACION_SOLO_LIQUIDAR      = "SÓLO LIQUIDAR";
    public static final String OPERACION_PROFORMA_DETALLADA = "PROFORMA DETALLADA";
    public static final String OPERACION_PROFORMA_RESUMIDA  = "PROFORMA RESUMIDA";
    public static final String DEFAULT_REPORT_NAME = "reportePDF.pdf";

    public Proforma ( )
    {
        super ( );
        this.accessExcel = new AccessExcel(ConstantsINM.GENERATOR_DATA_FILE, ConstantsINM.PROFORMA_DATA_SHEET );
        FileBuilder.newDirectory(this.getClass().getSimpleName().toUpperCase(), ConstantsINM.SUBSYSTEM_ID);
    }
    public void start ( )
    {
        Log.recordInLog("-------------------------------");
        iniciarModulo ( Constants.LIQUIDACION_GROUPER, MENU_PROFORMA, MODULO_PROFORMA );
        busquedaInmueble ( this.numeroInmueble );
        detalleDeudas ( );
    }

    /**
     * Adecuaciones para permitir parametrizar 3 operaciones en proforma. Se agregó el atributo detalleDeuda.
     */
    public void detalleDeudas ( )
    {
        int                 nroTablasDetalleDeudas = 0;
        String              gestion                = "";
        String              pathFilasDatosDeudas   = "";
        String              detalleDeuda           = "";
        boolean             seleccionarGestion     = false;
        boolean             conDeuda               = false;
        boolean             soloLiquida            = true;
        WebElement          checkGestion           = null;
        List< WebElement > filasDatosDeudas       = null;

        esperarVista ( "DETALLE DEUDAS" );
        Log.recordInLog( "Detalle Deudas: ..." );

        if( !this.operacion.equalsIgnoreCase ( OPERACION_SOLO_LIQUIDAR ) )   //11/01/2019
        {
            soloLiquida=false;
            nroTablasDetalleDeudas = this.driverApp.findElements (ProformaUI.pathTables).size ( );
            pathFilasDatosDeudas   = ProformaUI.pathTable.concat ( "[" ).concat ( String.valueOf ( nroTablasDetalleDeudas - 2 ) ).concat ( "]/td/table/tbody/tr" );
            filasDatosDeudas       = this.driverApp.findElements ( ProformaUI.getPathFilasDatosDeudas(pathFilasDatosDeudas) );

            for ( int fila_i = 1; fila_i < filasDatosDeudas.size ( ); fila_i ++ )
            {
                moverScroll ( filasDatosDeudas.get ( fila_i ).findElement ( ProformaUI.moverScroll) );
                gestion      = filasDatosDeudas.get ( fila_i ).findElement ( ProformaUI.gestion).getText ( );
                detalleDeuda = filasDatosDeudas.get ( fila_i ).findElement ( ProformaUI.detalleDeuda).getText ( );
                checkGestion = filasDatosDeudas.get ( fila_i ).findElement ( ProformaUI.checkGestion).findElement ( ProformaUI.checkGestionTag);

                if ( gestion.equals ( "N/A" ) )
                {
                    if ( this.detalleDeuda.equals ( "TODOS" ) ||
                            ( this.detalleDeuda.equals ( "IMT" ) && detalleDeuda.contains("TRANSFERENCIA")) ||
                            ( this.detalleDeuda.equals ( "MIDF (IMT)" ) && detalleDeuda.contains("INCUMPLIMIENTO")) ||
                            ( this.detalleDeuda.equals ( "MOP (IMT)" ) && detalleDeuda.contains("OMISION PAGO")) ||
                            ( this.detalleDeuda.equals ( "MOR" ) && detalleDeuda.contains("OMISION REGISTRO")))
                    {
                        seleccionarGestion = true;
                        conDeuda=true;
                    }
                }
                else
                {
                    if(Integer.parseInt(gestion) >= this.gestionInicio && Integer.parseInt(gestion) <= this.gestionFin)  // haruni aqui al menos una gestion
                    {
                        if(this.detalleDeuda.equals("TODOS") ||
                                (this.detalleDeuda.equals("IP") && detalleDeuda.contains("PROPIEDAD")) ||
                                (this.detalleDeuda.equals("MIDF (IP)") && detalleDeuda.contains("INCUMPLIMIENTO")) ||
                                (this.detalleDeuda.equals("MOP (IP)") && detalleDeuda.contains("OMISION PAGO")))
                        {
                            seleccionarGestion = true;
                            conDeuda= true;
                        }
                    }
                }
                if(seleccionarGestion && cuadroVerificacionHabilitado(checkGestion))
                {
                    checkGestion.click();
                    seleccionarGestion = false;
                }
            }
            moverScroll(this.driverApp.findElement(ProformaUI.btnDetallada));


            if(conDeuda) {  // verificamos si fueron seleccionadas las deudas
                takeScreenShotAndAdToHTMLReportGenerator(driverApp, extentApp,Status.PASS, "<b>DETALLE DEUDAS</b> ("+this.detalleDeuda.toString()+")");

                if (this.operacion.equalsIgnoreCase(OPERACION_PROFORMA_DETALLADA))
                {
                    Click.on(driverApp, ProformaUI.btnDetallada);
                } else if (this.operacion.equalsIgnoreCase(OPERACION_PROFORMA_RESUMIDA)) {
                    Click.on(driverApp, ProformaUI.btnResumida);
                }
                Log.recordInLog("  Generar Proforma: ("+this.detalleDeuda.toString()+")");
                super.esperarDescargaReporte();
                if (FileBuilder.moveFile(DEFAULT_REPORT_NAME)){
                    FileBuilder.renameReport(DEFAULT_REPORT_NAME, this.operacion, this.detalleDeuda, this.numeroInmueble, ConstantsINM.SUBSYSTEM_ID, i + 1);
                }
                Log.recordInLog("  Generar Proforma: OK.");
            }else{
                takeScreenShotAndAdToHTMLReportGenerator(driverApp, extentApp,Status.FAIL, "<b>DETALLE DEUDAS</b> No existe deuda ("+this.detalleDeuda.toString()+")");
                Log.recordInLog( "  No existe la deuda requerida ("+this.detalleDeuda.toString()+")");
            }
        }
        if(soloLiquida){
            takeScreenShotAndAdToHTMLReportGenerator(driverApp, extentApp,Status.PASS, "<b>DETALLE DEUDAS</b> solo liquida("+this.detalleDeuda.toString()+")");
            Log.recordInLog("  Solo Liquida: ("+this.detalleDeuda.toString()+")");
            Log.recordInLog("  Solo Liquida: OK.");
        }
        Log.recordInLog( "Detalle Deudas: OK.");
    }


}
