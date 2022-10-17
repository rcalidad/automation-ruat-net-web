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
    public static final String PROFORMA_DATA_SHEET = "Proforma";
    public static final String ID_SUBSYSTEM = "VEH";
}
