/**
 * @description: Clase que define las constantes relacionadas al subsistema de Vehículos.
 * @author Sol Maria Condori Ticona
 * Fecha: 13/10/2022
 */

package main.helpers.common.vehiculos;

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

    //GROUPERS
    public static final String MODIFICACION_DATOS_TECNICOS_GROUPER = "Modificación Datos Técnicos";
    public static final String TRANSFERENCIAS_GROUPER = "Transferencias";

    //MODULES
    public static final String MODIFICACION_DATOS_TECNICOS_OPERADOR_MODULE = "Modificación Datos Técnicos Operador";
    public static final String MODIFICACION_DATOS_SUPERVISOR_MODULE = "Modificación Datos por Supervisor";
    public static final String TRANSFERENCIA_NORMAL_MODULE = "Transferencia Normal";

    //TITLES
    public static final String testCaseNameHtmlReportVEH = "Nro. de vehículo: ";
}
