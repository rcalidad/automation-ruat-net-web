/**
 * @description Se definen constantes comunes generales de Inmuebles.
 * @date 24/02/2022
 * @author Faustina Chambi
 */

package main.helpers.common;

import java.io.File;

public class Constants 
{
	public static final int     TIME_OUT                                                 = 60;	
	public static final String PROJECTS_DIRECTORY = System.getProperty("user.dir").replace('\\', '/') + "/";
	public static final String  GECKO_DRIVER = "./resource/geckodriver.exe";
	public static final String FIREFOX_PROFILE_DIRECTORY = System.getProperty("user.home").replace('\\', '/') + "/AppData/Roaming/Mozilla/Firefox/Profiles/" +
														   new File(new File(System.getProperty("user.home") + "/AppData/Roaming/Mozilla/Firefox/Profiles/").list()[0]).getName();
	public static final String REPORTS_DIRECTORY = System.getProperty("user.home").replace('\\', '/') + "/Downloads/";
	public static final String LOGS_DIRECTORY = "./logs/";
	public static final String LOG_FILE = "log.log";
	public static final String LOG_GECKODRIVER_FILE = "logGecko.log";

	public static final String SUBSYSTEM_INMUEBLES = "INMUEBLES";
	public static final String SUBSYSTEM_VEHICULOS = "VEHICULOS";
	public static final String SUBSYSTEM_ACTIVIDADES_ECONOMICAS = "ACTIVIDADES_ECONOMICAS";
	public static final String SUBSYSTEM_TASAS = "TASAS";

	public static final String ENVIRONMENT_DATA_SHEET = "AMBIENTE";
	public static final String AUXILIARY_DATA_SHEET = "datosAuxiliares";
	public static final String TAXPAYER_DATA_SHEET = "ContribuyentesPMC";
	public static final String USUARIO_PARAMETER = "USUARIO";
	public static final String MUNICIPIO_PARAMETER = "MUNICIPIO";
	public static final String ABREVIACION_MUNICIPIO_PARAMETER = "ABREVIACION";
	public static final String DEFAULT_PART_OF_PASSWORD = "1234567$";
	public static final String END_OF_EXECUTION_MARK = "=========================================================================";
	public static final String DELIMITER_MARK = "-------------------------------------------------------------------------";
	public static final String ERROR_APP_MARK = "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";				//ATINM-97 (AP-057/2018)
	public static final String LIQUIDACION_GROUPER = "LIQUIDACION";
	public static final String  REGISTRO_TECNICO_GROUPER                              = "REGISTRO TECNICO";
	public static final String  REGISTRO_TRIBURARIO_GROUPER                           = "REGISTRO TRIBUTARIO";
	public static final String  REGISTRO_ADMINISTRATIVO_GROUPER                       = "REGISTRO ADMINISTRATIVO";
	public static final String  TRAMITES_GROUPER                                      = "TRAMITES";
	public static final String  REPORTES_CONSULTAS_GROUPER                            = "REPORTES Y CONSULTAS";
	
	public static final String  TIPO_CONTRIBUYENTE_NATURAL                               = "NATURAL";
	public static final String  TIPO_CONTRIBUYENTE_JURIDICO                              = "JURÍDICO";
	public static final String  PARAMETRO_TIPO_CONTRIBUYENTE                             = "TIPO CONTRIBUYENTE";

	//Se debe considerar si corresponde que existan estas constantes en este archivo (47 - 53)
	public static final String  ID_NAME_BOTON_ACEPTAR                                    = "btnAceptar";
	public static final String  ENLACE_ADICIONAR                                         = "Adicionar";
	public static final String  ENLACE_ANTERIOR                                          = "Anterior";
	public static final String  ENLACE_REGISTRAR                                         = "Registrar";
	public static final String  ENLACE_MODIFICAR                                         = "Modificar";
	public static final String  ENLACE_ANULAR                                            = "Anular";
	public static final String  ENLACE_ASOCIAR                                           = "Asociar";

	//Localizadores no son comunes a todos los subsistemas, no debería ir como elemento común (56 - 62)
	public static final String  PATH_VALIDACIONES                                        = "//*[@id='ventana']/table/tbody/tr[4]/td";
	public static final String  PATH_TITULO_VISTA                                        = "//*[@id='ventana']/form/table/tbody/tr[1]/td/h2";
	public static final String  PATH_VISTA_DATOS_COD_CATASTRAL                           = "/html/body/div[2]/form/table/tbody/tr[1]/td/div[1]/h2";
	public static final String  PATH_ERROR_404                                           = "/html/body/font/table[1]/tbody/tr/td/font/h2";
	public static final String  PATH_FORMULARIO                                          = "/form";

	public static final String  TIPO_LOCALIZADOR_ID                                      = "id";
	public static final String  TIPO_LOCALIZADOR_NAME                                    = "name";
	public static final String  TIPO_LOCALIZADOR_XPATH                                   = "xpath";
	public static final String  TIPO_LOCALIZADOR_LINK_TEXT                               = "linkText";
	public static final String  TIPO_LOCALIZADOR_CSS_SELECTOR                            = "cssSelector";
	public static final String  SELECTOR_CSS_CODIGO_ERROR                                = "span.error";
	
	public static final String DATE_TIME_MASK = "dd/MM/yyyy HH:mm:ss.SSS";
	public static final String DATE_MASK = "dd/MM/yyyy";
	public static final String REPORT_WINDOW_TITLE = "RUAT.NET";

	/*
	public static final String  CADENA_CONEXION_MITUDS                                   = "jdbc:oracle:thin:@mituds.ruat.gob.bo:1535:RDIS";
	public static final String  CADENA_CONEXION_IMPUDS                                   = "jdbc:oracle:thin:@impuds.ruat.gob.bo:1533:RDIS";
	public static final String  CADENA_CONEXION_CONUDS                                   = "jdbc:oracle:thin:@conuds.ruat.gob.bo:1537:INTEGUDS";
	public static final String  USUARIO_BASE_DATOS                                       = "HERRAMIENTASCALIDAD";
	public static final String  CONTRASENIA_BASE_DATOS                                   = "h123";*/
}
