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
    public static final String MENU_DATA_SHEET = "MENU";
    public static final String PROFORMA_DATA_SHEET = "Proforma";
    public static final String AUXILIARY_DATA_SHEET = "datosAuxiliares";
}
