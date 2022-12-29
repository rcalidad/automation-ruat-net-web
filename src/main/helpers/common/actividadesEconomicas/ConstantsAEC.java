/**
 * @description: Clase que define las constantes relacionadas al subsistema de Actividades Económicas.
 * @author Sol Maria Condori Ticona
 * Fecha: 29/09/2022
 */

package main.helpers.common.actividadesEconomicas;

public class ConstantsAEC {
    public static final String AEC_PROJECT_DIRECTORY = System.getProperty("user.dir").replace('\\', '/') + "/";
    public static final String GENERATOR_DATA_FILE = "generators/actividadesEconomicas/DataPageGeneratorAEC.xls";
    public static final String TESTS_DATA_FILE = "testCases/actividadesEconomicas/DatosPrueba.xls";
    public static final String DISABLED_ATTRIBUTE = "disabled";
    public static final String SUBSYSTEM_ID = "AEC";
    public static final String RUBRO = "Actividades económicas";
    public static final String MENU_DATA_SHEET = "MENU";

    //DATA SHEETS
    public static final String PROFORMA_DATA_SHEET = "Proforma";
    public static final String AUXILIARY_DATA_SHEET = "datosAuxiliares";
    public static final String EMPADRONAMIENTO_DATA_SHEET = "Empadronamiento";
    public static final String MULTA_ADMINISTRATIVA_PATENTES_DATA_SHEET = "MultaAdministrativaPatentes";
    public static final String COMPENSACIONES_DATA_SHEET = "Compensaciones";

    //GROUPER
    public static final String PROFORMA_GROUPER = "Proforma";
    public static final String EMPADRONAMIENTO_GROUPER = "Empadronamiento";
    public static final String CONDONACION_GROUPER = "Condonación";
    public static final String MULTAS_GROUPER = "Multas";
    public static final String REPORTES_Y_CONSULTAS_GROUPER = "Reportes y Consultas";
    public static final String COMPENSACIONES_GROUPER = "Compensaciones";
    public static final String EMISIONES_GROUPER = "Emisiones";

    //MODULE
    public static final String PROFORMA_MODULE = "Proforma";
    public static final String EMPADRONAMIENTO_MODULE = "Empadronamiento";
    public static final String MULTAS_ADMINISTRATIVAS_PATENTES_MODULE = "Multas Administrativas Patentes";
    public static final String COMPENSACIONES_MODULE = "Compensaciones";
}
