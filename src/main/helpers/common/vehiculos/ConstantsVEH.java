/**
 * @description: Clase que define las constantes relacionadas al subsistema de Veh�culos.
 * @author Sol Maria Condori Ticona
 * Fecha: 13/10/2022
 */

package main.helpers.common.vehiculos;

import java.security.PublicKey;

public class ConstantsVEH {
    public static final String VEH_PROJECT_DIRECTORY = System.getProperty("user.dir").replace('\\', '/') + "/";
    public static final String GENERATOR_DATA_FILE = "generators/vehiculos/DataPageGeneratorVEH.xls";
    public static final String TESTS_DATA_FILE = "testCases/vehiculos/DatosPrueba.xls";
    public static final String DISABLED_ATTRIBUTE = "disabled";
    public static final String ID_SUBSYSTEM = "VEH";

    //DATA SHEET
    public static final String PROFORMA_DATA_SHEET = "Proforma";
    public static final String MODIFICACION_DATOS_SUPERVISOR_DATA_SHEET = "ModificacionDatosSupervisor";
    public static final String MODIFICACION_DATOS_TECNICOS_OPERADOR_DATA_SHEET = "ModificarDatosTecnicosOperador";
    public static final String TRANSFERENCIA_DATA_SHEET = "Transferencia";
    public static final String BASES_IMPOSIBLES_DATA_SHEET = "BasesImponibles";
    public static final String BASES_IMPONIBLES_IMT_DATA_SHEET = "BasesImponiblasImt";
    public static final String CONDONACION_LEY_MUNICIPAL_DATA_SHEET = "CondonacionLeyMunicipal";
    public static final String CONDONACION_LEY_MUNICIPAL_IMT_DATA_SHEET = "CondonacionLeyMunicipalImt";
    public static final String COMPENSACIONES_DATA_SHEET = "Compensaciones";
    public static final String COMPROBANTE_PAGO_EN_CERO_DATA_SHEET = "ComprobantePagoEnCero";

    //GROUPERS
    public static final String MODIFICACION_DATOS_TECNICOS_GROUPER = "Modificaci�n Datos T�cnicos";
    public static final String TRANSFERENCIAS_GROUPER = "Transferencias";
    public static final String BASES_IMPONIBLES_GROUPER = "Bases Imponibles";
    public static final String BASES_IMPONIBLES_IMT_GROUPER = "Base Imponible IMT";
    public static final String CONDONACION_GROUPER = "Condonaci�n";
    public static final String COMPENSACIONES_GROUPER = "Compensaciones";
    public static final String COMPROBANTE_PAGO_EN_CERO_GROUPER = "Emisi�n Comprobante Pago en Cero";

    //MODULES
    public static final String MODIFICACION_DATOS_TECNICOS_OPERADOR_MODULE = "Modificaci�n Datos T�cnicos Operador";
    public static final String MODIFICACION_DATOS_SUPERVISOR_MODULE = "Modificaci�n Datos por Supervisor";
    public static final String TRANSFERENCIA_NORMAL_MODULE = "Transferencia Normal";
    public static final String BASES_IMPONIBLES_MODULE = "Bases Imponibles";
    public static final String BASES_IMPONIBLES_IMT_MODULE = "Registro Base Imponible IMT";
    public static final String CONDONACION_LEY_MUNICIPAL_MODULE = "Condonaci�n Ley Municipal";
    public static final String CONDONACION_LEY_MUNICIPAL_IMT_MODULE = "Condonaci�n Ley Municipal IMT";
    public static final String COMPENSACIONES_MODULE = "Compensaciones";
    public static final String COMPROBANTE_PAGO_EN_CERO_MODULE = "Emisi�n Comprobante Pago en Cero";

    //TITLES
    public static final String testCaseNameHtmlReportVEH = "Nro. de veh�culo: ";
}
