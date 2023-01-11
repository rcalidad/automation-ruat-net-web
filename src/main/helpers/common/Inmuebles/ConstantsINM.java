/**
 * @description Se definen constantes comunes generales.
 * @date 24/02/2022
 * @autor Faustina Chambi
 */

package main.helpers.common.Inmuebles;

import java.security.PublicKey;

public class ConstantsINM
{
	public static final String INM_PROJECT_DIRECTORY = System.getProperty("user.dir").replace('\\', '/') + "/";     
	public static final String GENERATOR_DATA_FILE = "generators/inmuebles/DataPageGenerator.xls";
	public static final String TESTS_DATA_FILE = "testCases/inmuebles/DatosPrueba.xls";
	public static final String DISABLED_ATTRIBUTE = "disabled";
	public static final String SUBSYSTEM_ID = "INM";

	//DATA SHEET
	public static final String EMPADRONAMIENTO_DATA_SHEET = "Empadronamiento";
	public static final String PROFORMA_DATA_SHEET = "Proforma";
	public static final String CONDONACION_LEY_MUNICIPAL_DATA_SHEET = "CondonacionLeyMunicipal";
	public static final String AUTOAVALUO_DATA_SHEET = "Autoavaluo";

	//GROUPERS
	public static final String REGISTRO_TECNICO_GROUPER = "REGISTRO TECNICO";
	public static final String REGISTRO_TRIBUTARIO_GROUPER = "REGISTRO TRIBUTARIO";


	//MODULES
	public static final String EMPADRONAMIENTO_PROPIEDAD_UNICA_MODULE = "Propiedad Única";
	public static final String CONDONACION_LEY_MUNICIPAL_MODULE = "Condonaciones Ley Municipal";
	public static final String AUTOAVALUO_MODULE = "Autoavalúos";

	/*public static final String  TIPO_PROPIEDAD_UNICA                                     = "PROPIEDAD ÚNICA";
	public static final String  TIPO_PROPIEDAD_ACCIONES_DERECHOS                         = "PROPIEDAD ACCIONES DERECHOS";
	public static final String  AREA_URBANO                                              = "URBANO";
	public static final String  AREA_RURAL                                               = "RURAL";
	public static final String  CLASE_VIVIENDA_UNIFAMILIAR                               = "VIVIENDA UNIFAMILIAR";
	public static final String  CLASE_PROPIEDAD_HORIZONTAL                               = "PROPIEDAD HORIZONTAL";
	public static final String  CLASE_PROPIEDAD_AGRARIA                                  = "PROPIEDAD AGRARIA";

	
	public static final String  VISTA_CONFIRMAR_TRAMITE                                  = "CONFIRMAR TRAMITE";
	public static final String  VISTA_DATOS_CONSTRUCCIONES                               = "DATOS CONSTRUCCIONES";
	public static final String  VISTA_REGISTRO_DATOS_TECNICOS                            = "REGISTRO DATOS TECNICOS";
	
	public static final String  SUPERFICIE_TERRENO                                       = "500";
	public static final String  SUPERFICIE_CONSTRUCCION_PROPIEDAD_HORIZONTAL             = "500";
	public static final String  SUPERFICIE_CONSTRUCCION_VIVIENDA_UNIFAMILIAR             = "500";
	public static final String  SUPERFICIE_AREA_COMUN_PROPIEDAD_HORIZONTAL               = "300";
	public static final String  SUPERFICIE_CONSTRUCCION_ADICIONAL                        = "100";
	public static final String  SUPERFICIE_TERRENO_CONDOMINIO                            = "100";
	public static final String  SUPERFICIE_CONSTRUCCION_CONDOMINIO                       = "200";
	public static final String  INCLINACION_PLANO                                        = "PLANO";
	public static final String  DOCUMENTO_PADRON_MUNICIPAL_CONTRIBUYENTE                 = "PADRON MUNICIPAL DEL CONTRIBUYENTE";
	
	public static final String  CONTENIDO_AREA_TEXTO                                     = "PRUEBAS DE CONTROL CALIDAD";
	public static final String 	CONTENIDO_AUTORIDAD_RESPONSABLE				             = "ATM";
	public static final String  NOMBRE_APELLIDO_GESTOR_TRAMITE                           = "OPERADOR";
	public static final String  CONTENIDO_NUMERO_DOCUMENTO                               = "14567";
	public static final String  CONTENIDO_AUTORIZADO_POR                                 = "PRUEBAS";
	public static final String  CONTENIDO_CARGO                                          = "INSPECTOR DE CALIDAD DE SOFTWARE";
	public static final String  NOMBRE_NOTARIO                                           = "NOTARIO DE PRUEBA";
	public static final String  FECHA_NACIMIENTO                                         = "01/01/1970";
	public static final String  DIRECCION                                                = "AV. BOLIVIA No. 12345";
	public static final String  NOMBRE_EDIFICIO                                          = "ABC";
	public static final String  ATRIBUTO_LONGITUD_MAXIMA                                 = "maxlength";
	public static final String  ATRIBUTO_CSS_CLASE                                       = "class";

	public static final String  ATRIBUTO_TIPO                                            = "type";
	public static final String  ATRIBUTO_ROWSPAN                                         = "rowspan";
	public static final String  PATH_COLUMNA_TITULO                                      = "th";
	public static final String  PATH_COLUMNA                                             = "td";
	public static final String  ETIQUETA_ENLACE                                          = "a";
	public static final String  ETIQUETA_ENTRADA                                         = "input";
	public static final String  ETIQUETA_COMBO                                           = "select";
	public static final String  ETIQUETA_SPAN                                            = "span";
	public static final String  PATH_FORMULARIO                                          = "/form";
	public static final String  TIPO_BOTON_RADIO                                         = "radio";
	public static final String  TIPO_CASILLA_VERIFICACION                                = "checkbox";
	public static final boolean PERMITIR_EMPADRONAMIENTO_MASIVO                          = false;
	public static final int     NUMERO_INMUEBLES_EMPADRONAMIENTO_MASIVO                  = 800;

	public static final String  PARAMETRO_PROPIEDAD_ACCIONES_DERECHOS                    = "PROPIEDAD ACCIONES DERECHOS";
	public static final String  PARAMETRO_NUMERO_INMUEBLE                                = "NÚMERO INMUEBLE";
	public static final String  PARAMETRO_NUMERO_PROPIEDADES_A_PROCESAR                  = "PROPIEDADES A PROCESAR"; 
	public static final String  PARAMETRO_GESTION_INICIO                                 = "GESTIÓN INICIO";
	public static final String  PARAMETRO_GESTION_FIN                                    = "GESTIÓN FIN";
	public static final String  PARAMETRO_OPERACION                                      = "OPERACIÓN";
	public static final String  PARAMETRO_CASO_PRUEBA                                    = "CASO DE PRUEBA";
	public static final String  PARAMETRO_USUARIO                                        = "USUARIO";
	public static final String  PARAMETRO_FECHA_APLICACION                               = "FECHA APLICACIÓN";
	public static final String  PARAMETRO_GESTION 										 = "GESTIÓN";
	public static final String  PARAMETRO_MODULO										 = "MÓDULO";
	public static final String  PARAMETRO_ACCION_INICIO                                  = "ACCIÓN INICIO";			
	public static final String  PARAMETRO_ACCION_FIN                                     = "ACCIÓN FIN";			
	public static final String  PARAMETRO_FLUJO                                          = "FLUJO";					
	public static final String  OPERACION_PROPIEDAD_UNICA                                = "PROPIEDAD ÚNICA";
	public static final String  OPERACION_PROPIEDAD_ACCIONES_DERECHOS                    = "ACCIONES Y DERECHOS";
	public static final String  OPERACION_REGISTRAR                                      = "Registrar";
	public static final String  OPERACION_ANULAR                                         = "Anular";
	public static final String  OPCION_TODAS                                             = "TODAS";					
	
	public static final String  NOMBRE_FORM_VISTA_UBICACION_INMUEBLE_REGISTRAR_SOLICITUD = "frmRegistrar";
	public static final String  NOMBRE_FORM_VISTA_DATOS_ADICIONALES                      = "frmDatoAdicional";
	public static final String  NOMBRE_FORM_DEFINICION_INMUEBLE                          = "frmInmueble";
	public static final String  NOMBRE_FORM_VISTA_DATOS_CODIGO_CATASTRAL                 = "frmCodificacion";
	public static final String  NOMBRE_FORM_VISTA_DATOS_TERRENO                          = "frmTerreno";
	public static final String  NOMBRE_FORM_VISTA_DATOS_CONSTRUCCIONES                   = "frmConstrucciones";*/
	
	
}
