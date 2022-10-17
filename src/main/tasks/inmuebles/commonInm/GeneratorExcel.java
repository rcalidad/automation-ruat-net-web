/**
 * @description Clase para iniciar el aplicativo con el Excel
 * @author Faustina Chambi Camata
 * @date 21/07/2022
 * */

package main.tasks.inmuebles.commonInm;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.common.*;
import main.helpers.common.Inmuebles.ConstantsINM;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.inmuebles.login.LoginInmuebles;
import main.ui.inmueblesUI.commonUI.GeneratorExcelUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class GeneratorExcel {
    protected String               url; //url de acceso
    protected String               app; //Aplicativo Inmuebles, Vehículos, Gestión de Usuarios, etc.
    protected String               municipio;
    protected String               usuario;
    protected String password;
    protected boolean              usarDatosAmbienteTest; //usar excel de casos prueba
    protected WebDriver            driverApp;
    protected WebDriverWait        wait;
    protected AccessExcel accessExcel;
    protected StringBuilder        mensajeError;
    protected String               operacion;
    protected ExtentReports        extentApp;
    protected String               numeroInmueble;
    protected String detalleDeuda;
    protected int    gestionInicio;
    protected int    gestionFin;
    protected int                  numeroAccion;
    protected boolean              accionesYDerechos;
    protected String               accionInicio;
    protected String               accionFin;
    protected ArrayList < String > nombresArchivoReportes;

    public GeneratorExcel() {
        this.usarDatosAmbienteTest      = false;
        this.mensajeError               = new StringBuilder(" ERROR: ");
        this.nombresArchivoReportes     = new ArrayList<String>();
        this.accionesYDerechos          = false;
        this.url = ExcelData.getUrl(ConstantsINM.GENERATOR_DATA_FILE);
    }
    protected void openApplication(String url)
    {
        Set<String> windows = null;
        this.driverApp.get(url);                      // Abre el navegador y redirige a una URL.
        this.wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        Log.recordInLog("Tiempo Inicialización (navegador): ".concat(LogTime.timeElapsed()));                                                                         //.concat(getTiempoTranscurrido(this.tiempoInicioTotal)));
        windows = this.driverApp.getWindowHandles();
        this.driverApp.switchTo().window(windows.toArray()[0].toString());
        Log.recordInLog("Abriendo aplicación...");
        this.driverApp.manage().window().maximize();
    }
    //ExtentReports extentApp;
    public static List<ExtentTest> test = new ArrayList<ExtentTest>();
    public static int i=0;
    public  <E extends GeneratorExcel> void run(WebDriver driver, WebDriverWait wait, ExtentReports extentReport){
        String      currentTown        = "";
        String      beforeTown      = "";
        int casesNumber = this.accessExcel.getNroDatosPrueba();
        extentApp = extentReport;
        for(int fila_i = 0; fila_i < casesNumber; fila_i ++)
        {
            try
            {
                ExcelData.load(fila_i, this.accessExcel, this);
                test.add( extentApp.createTest("Nro. Inmueble ".concat(this.numeroInmueble)).assignAuthor("T - " + fila_i));
                currentTown = this.municipio;
                beforeTown      = ExcelData.getBeforeTown(this.accessExcel, fila_i);
                i = fila_i;
                if(!currentTown.equals(beforeTown))
                {
                    this.driverApp = driver;
                    this.wait = wait;
                    this.usuario = ExcelData.getUser(ConstantsINM.GENERATOR_DATA_FILE, this.accessExcel, fila_i);
                    this.password = ExcelData.getPassword(this.usuario);
                    this.initApplication(this.url, this.usuario, this.password);
                }
                this.start();
            }
            catch(AssertionError falloFlujo)
            {
                processFail(falloFlujo);
            }
            catch(Exception generarExcepcion)
            {
                //procesarExcepcionInmuebles(generarExcepcion);
            }
            finally
            {
               try
                {
                    volverMenuPrincipal ( );
                }
                catch ( Exception generarExcepcion ) { }
            }
        }

        Log.recordInLog(Constants.DELIMITER_MARK);
        LogTime.end();
        Log.endInLog(" Módulo (".concat(this.getClass().getSimpleName().toUpperCase().concat(")")));
        extentApp.flush();
        if (this.driverApp != null){
            this.driverApp.quit();
        }
    }
    public void volverMenuPrincipal()
    {
        final String ID_LOGO_APLICATIVO = "logo-aplicacion";

        this.driverApp.switchTo().parentFrame(); // haruni
        WaitUntilElement.isVisibleElement(this.driverApp,GeneratorExcelUI.idLogoAplicativo);
        //this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_LOGO_APLICATIVO)));
        //if (this.driver.findElement(By.id(ID_LOGO_APLICATIVO)).isSelected())
        //{
        Click.on(this.driverApp,GeneratorExcelUI.idLogoAplicativo);
        //this.driverApp.findElement(By.id(ID_LOGO_APLICATIVO)).click();
        //}
        WaitUntilElement.isVisibleElement(this.driverApp,GeneratorExcelUI.idLogoAplicativo);
        //this.wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ID_LOGO_APLICATIVO)));

        this.driverApp.switchTo().defaultContent(); // haruni
    }

    public void initApplication(String url, String user, String password) throws Exception {
        openApplication(url);
        Log.onEnvironment( this.getClass().getSimpleName().toUpperCase(), url);
        LoginInmuebles.authenticate(driverApp, extentApp, test.get(i), user, password);
    }
    /**
     * Método procesarFallo(): Registra en log y en consola el fallo ocurrido, reinicia la variable mensajeError y se vuelve al menú
     * principal.
     * @param flowFault
     */
    public void processFail ( AssertionError flowFault )
    {
        Log.recordInLog( flowFault.getMessage ( ).replaceAll ( "\n", " " ) );
        if ( isAlertPresent( ) )
        {
            DisplayAlert.toAcept(this.driverApp);
            //this.driverApp.switchTo ( ).alert ( ).accept ( );  // haruni
        }
        this.mensajeError.delete ( 8, this.mensajeError.length ( ) );
    }
    public boolean isAlertPresent()
    {
        try
        {
            this.driverApp.switchTo().alert();
            return true;
        }
        catch(NoSuchElementException noEncuentraAlertaExcepcion)
        {
            return false;
        }
        catch(NoAlertPresentException alertNoPresenteExcepcion)
        {
            return false;
        }
    }
    public void iniciarModulo ( String subsistema, String menu, String modulo )
    {
       /* final String PATH_OPCIONES_SUBSISTEMA = "//*[@id='menu-lista']/ul/li";
        final String ID_IFRAME_PRINCIPAL      = "ifrm-contenido";
        final String ID_VENTANA_MODAL         = "modal_window";
        final String ID_MENSAJE_MODAL         = "mensaje-modal";*/

        String              rutaModulo                = "";
        String              pathOpcionesMenu          = "";
        String              pathOpcionesModulo        = "";
        String              pathOpcionesModuloDetalle = "";
        String              prefijoModulo             = "";
        boolean             subsistemaEncontrado      = false;
        boolean             opcionMenuEncontrado      = false;
        boolean             opcionModuloEncontrado    = false;
        List < WebElement > opcionesSubsistema        = null;
        List < WebElement > opcionesMenu              = null;
        List < WebElement > opcionesModulo            = null;
        List < WebElement > opcionesModuloDetalle     = null;

        /*this.wait.until ( ExpectedConditions.or (
                ExpectedConditions.presenceOfAllElementsLocatedBy ( By.xpath ( PATH_OPCIONES_SUBSISTEMA ) ),
                ExpectedConditions.visibilityOfElementLocated ( By.id ( ID_VENTANA_MODAL ) ) ) );*/

        WaitUntilElement.isVisibleElementOr(this.driverApp,GeneratorExcelUI.pathOpcionesSubsistema,GeneratorExcelUI.idVentanaModal);

        //if ( !this.driverApp.findElement ( By.id ( ID_VENTANA_MODAL ) ).isDisplayed ( ) )
        if(!IsDisplayed.element(this.driverApp,GeneratorExcelUI.idVentanaModal))
        {
            //opcionesSubsistema = this.driverApp.findElements ( By.xpath ( PATH_OPCIONES_SUBSISTEMA ) );
            opcionesSubsistema = Find.elements(this.driverApp,GeneratorExcelUI.pathOpcionesSubsistema);
            pathOpcionesMenu   = GeneratorExcelUI.stringPathOpcionesSubsistema.concat ( "[" );

            if ( modulo.contains( menu ) )
            {
                rutaModulo = CommonComponent.getTitleFormatString( modulo );
            }
            else
            {
                rutaModulo = menu.concat ( " " ).concat ( CommonComponent.getTitleFormatString( modulo ) );
            }

           Log.recordInLog("Iniciando módulo ".concat ( rutaModulo ).concat ( ": ..." ) );

            for ( int subsistema_i = 0; subsistema_i < opcionesSubsistema.size ( ); subsistema_i ++ )
            {
                if ( opcionesSubsistema.get ( subsistema_i ).getText ( ).equals ( subsistema ) )
                {
                    opcionesSubsistema.get ( subsistema_i ).click ( );
                    subsistemaEncontrado = true;
                    pathOpcionesMenu     = pathOpcionesMenu.concat ( String.valueOf ( subsistema_i + 1 ) ).concat ( "]/ul/li" );
                    opcionesMenu         = this.wait.until ( ExpectedConditions.presenceOfAllElementsLocatedBy (
                            By.xpath ( pathOpcionesMenu ) ) );

                    for ( int opcion_j = 0; opcion_j < opcionesMenu.size ( ); opcion_j ++ )
                    {
                        if ( opcionesMenu.get ( opcion_j ).getText ( ).equals ( menu ) )
                        {
                            opcionesMenu.get ( opcion_j ).click ( );
                            opcionMenuEncontrado = true;
                            pathOpcionesModulo   = pathOpcionesMenu.concat ( "[" ).concat ( String.valueOf ( opcion_j + 1 ) )
                                    .concat ( "]/ul/li" );

                            this.wait.until (
                                    ExpectedConditions.or (
                                            ExpectedConditions.presenceOfAllElementsLocatedBy ( By.xpath ( pathOpcionesModulo ) ),
                                            ExpectedConditions.attributeContains (
                                                    opcionesMenu.get ( opcion_j ).findElement ( By.tagName ( "a" ) ),
                                                    "class", "enlace" ) ) );

                            //WaitUntilElement.presenceOfAllElementsLocatedBy(this.driverApp,);

                            ( ( JavascriptExecutor ) this.driverApp ).executeScript (
                                    "arguments [ 0 ].scrollIntoView ( true );",
                                    opcionesMenu.get ( opcion_j ) );

                            opcionesModulo = this.driverApp.findElements ( By.xpath ( pathOpcionesModulo ) );

                            if ( opcionesModulo.size ( ) > 0 )
                            {
                                if ( modulo.contains ( " - " ) )
                                {
                                    prefijoModulo = modulo.substring ( 0, modulo.indexOf ( " -" ) );
                                    modulo        = modulo.substring ( modulo.indexOf ( "- " ) + 2 );
                                }

                                for ( int modulo_k = 0; modulo_k < opcionesModulo.size ( ); modulo_k ++ )
                                {
                                    if ( opcionesModulo.get ( modulo_k ).getText ( ).equalsIgnoreCase ( prefijoModulo ) )
                                    {
                                        opcionesModulo.get ( modulo_k ).click ( );
                                        pathOpcionesModuloDetalle = pathOpcionesModulo.concat ( "[" )
                                                .concat ( String.valueOf ( modulo_k + 1 ) )
                                                .concat( "]/ul/li" );

                                        /*opcionesModuloDetalle = this.wait.until (
                                                ExpectedConditions.presenceOfAllElementsLocatedBy (
                                                        By.xpath ( pathOpcionesModuloDetalle ) ) );*/

                                        opcionesModuloDetalle= WaitUntilElement.presenceOfAllElementsLocatedBy(this.driverApp,pathOpcionesModuloDetalle);

                                        for ( WebElement moduloDetalle_l: opcionesModuloDetalle )
                                        {
                                            if ( moduloDetalle_l.getText ( ).equalsIgnoreCase ( modulo ) )
                                            {
                                                moduloDetalle_l.findElement ( By.tagName ( "a" ) ).click ( );
                                                opcionModuloEncontrado = true;
                                                break;
                                            }
                                        }

                                        if ( opcionModuloEncontrado )
                                        {
                                            break;
                                        }
                                    }
                                    else
                                    {
                                        if ( opcionesModulo.get ( modulo_k ).getText ( ).equalsIgnoreCase ( modulo ) )
                                        {
                                            opcionesModulo.get ( modulo_k ).findElement ( By.tagName ( "a" ) ).click ( );
                                            opcionModuloEncontrado = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            else
                            {
                                opcionesMenu.get ( opcion_j ).findElement ( By.tagName ( "a" ) ).click ( );
                                opcionModuloEncontrado = true;
                            }
                            break;
                        }
                    }
                    break;
                }
            }

            if ( !subsistemaEncontrado )
            {
                this.mensajeError.append ( "Subsistema " ).append ( subsistema ).append ( " no encontrado." );
                throw new AssertionError ( this.mensajeError.toString ( ) );
            }
            else if ( !opcionMenuEncontrado )
            {
                this.mensajeError.append ( "Opción " ).append ( menu ).append ( " no encontrado." );
                throw new AssertionError ( this.mensajeError.toString ( ) );
            }
            else if ( !opcionModuloEncontrado )
            {
                this.mensajeError.append ( "Módulo " ).append ( modulo ).append ( " no encontrado." );
                throw new AssertionError ( this.mensajeError.toString ( ) );
            }

           /* this.wait.until ( ExpectedConditions.frameToBeAvailableAndSwitchToIt (
                    this.driverApp.findElement ( By.id ( ID_IFRAME_PRINCIPAL ) ) ) );*/

           WaitUntilElement.frameToBeAvailableAndSwitchToIt(this.driverApp,GeneratorExcelUI.idIframePrincipal);
           Log.recordInLog ( "Iniciando módulo ".concat ( rutaModulo ).concat ( ": OK." ) );
        }
        else
        {
            /*this.mensajeError.append ( this.driverApp.findElement ( By.id ( ID_MENSAJE_MODAL ) ).getText ( ) )
                    .append ( " Se perdió la sesión." );*/
            this.mensajeError.append(GetText.of(this.driverApp,GeneratorExcelUI.idMensajeModal)).append("Se perdió la sesión.");

            throw new AssertionError ( this.mensajeError.toString ( ) );
        }
    }
    public void busquedaInmueble ( String numeroInmueble )
    {
       /* final String ID_CAMPO_IDENTIFICADOR   = "txtIdentificador";
        final String ID_RADIO_NUMERO_INMUEBLE = "rbtCriterioNIM";*/

        String mensajeAlerta = "";

        //this.wait.until ( ExpectedConditions.visibilityOfElementLocated ( By.id ( ID_CAMPO_IDENTIFICADOR ) ) ).sendKeys ( numeroInmueble );
        SendKeys.text(this.driverApp,GeneratorExcelUI.txtIdentificador,numeroInmueble);
        Log.recordInLog( "Búsqueda Inmueble: ..." );
        Log.recordInLog(  " Número Inmueble: ".concat ( numeroInmueble ).concat ( " ( " ).concat ( this.municipio ).concat ( " )" ) );
        //this.driverApp.findElement ( By.id ( ID_RADIO_NUMERO_INMUEBLE ) ).click ( );
        Click.on(this.driverApp,GeneratorExcelUI.rbtNumeroInmueble);
        takeScreenShotAndAdToHTMLReportGenerator(driverApp, extentApp,Status.PASS, "<b>BUSQUEDA INMUEBLE</b>");
        //this.driverApp.findElement ( By.id ( Constants.ID_NAME_BOTON_ACEPTAR ) ).click ( );
        Click.on(this.driverApp,GeneratorExcelUI.btnAceptar);

        try
        {
            /*this.wait.until ( ExpectedConditions.or ( ExpectedConditions.alertIsPresent ( ),
                    ExpectedConditions.visibilityOfElementLocated ( By.xpath ( Constants.PATH_TITULO_VISTA ) ),
                    ExpectedConditions.visibilityOfElementLocated ( By.xpath ( Constants.PATH_TITULO_VISTA.replaceAll ( "/form", "" ) ) ) ) );*/

            WaitUntilElement.isVisibleElementPlusAlertOr(this.driverApp,GeneratorExcelUI.pathTituloVista,GeneratorExcelUI.pathTituloVistaSinForm);
        }
        catch ( UnhandledAlertException alertExcepcion ) { }

        if( isAlertPresent( ) )
        {
            //mensajeAlerta = this.driverApp.switchTo ( ).alert ( ).getText ( );
            mensajeAlerta = DisplayAlert.getText(this.driverApp);
           // takeScreenShotAndAdToHTMLReportGenerator(driverApp, extentApp,Status.FAIL, mensajeAlerta.toString());
            if( mensajeAlerta.equalsIgnoreCase ( "No se recuperaron inmuebles para el criterio de búsqueda." )     ||
                    mensajeAlerta.equalsIgnoreCase ( "No existen trámites asociados al inmueble seleccionado." )       ||
                    mensajeAlerta.equalsIgnoreCase ( "No se pueden fusionar las clases de los inmuebles ingresados." ) ||
                    mensajeAlerta.equalsIgnoreCase ( "El inmueble no tiene deuda en cero pendiente para procesar." ) )
            {
                //this.driverApp.switchTo ( ).alert ( ).accept ( );
                DisplayAlert.toAcept(this.driverApp);
                this.mensajeError.append ( mensajeAlerta );
                throw new AssertionError ( this.mensajeError.toString ( ) );
            }
        }

        if( !isAlertPresent( ) && getTituloVista ( ) .contains ( "BUSQUEDA INMUEBLE" ) )
        {
            if ( esAccionesDerechos ( ) )
            {
                this.accionesYDerechos = true;

                seleccionarPropiedad( this.numeroAccion );
            }
            else //Para casos con registros históricos: Baja, Fraccionado, Fusionado, Cambio de Propiedad.
            {
                try
                {
                    seleccionarPropiedad ( 1 );
                }
                catch ( AssertionError noExistePropiedadActiva )
                {
                    this.mensajeError.delete ( 8, this.mensajeError.length ( ) );
                    this.driverApp.findElement ( By.linkText ( "Seleccionar" ) ).click ( );
                }
            }
        }
        Log.recordInLog(  "Búsqueda Inmueble: OK." );
    }
    public String getTituloVista ( )
    {
        final String NOMBRE_VISTA_GENERICO = "SIN_TITULO";

        String nombreVista = "";

        //if ( elementoWebEstaPresente ( Constants.TIPO_LOCALIZADOR_XPATH, Constants.PATH_TITULO_VISTA ) )
        if(IsPresent.elements(this.driverApp,GeneratorExcelUI.pathTituloVista))
        {
            //nombreVista = this.driverApp.findElement ( By.xpath(Constants.PATH_TITULO_VISTA)).getText();
            nombreVista = GetText.of(this.driverApp,GeneratorExcelUI.pathTituloVista);
        }
        //else if ( elementoWebEstaPresente ( Constants.TIPO_LOCALIZADOR_XPATH, Constants.PATH_TITULO_VISTA.replaceAll(Constants.PATH_FORMULARIO, "") ) )
        else if(IsPresent.elements(this.driverApp,GeneratorExcelUI.pathTituloVistaSinForm))
        {
            //nombreVista = this.driverApp.findElement(By.xpath(Constants.PATH_TITULO_VISTA.replaceAll(Constants.PATH_FORMULARIO, ""))).getText();
            nombreVista = GetText.of(this.driverApp,GeneratorExcelUI.pathTituloVistaSinForm);
        }
        //else if ( elementoWebEstaPresente ( Constants.TIPO_LOCALIZADOR_XPATH, Constants.PATH_VISTA_DATOS_COD_CATASTRAL ) )
        else if(IsPresent.elements(this.driverApp,GeneratorExcelUI.pathVistaDatosCodCatastral))
        {
            //nombreVista = this.driverApp.findElement ( By.xpath( Constants.PATH_VISTA_DATOS_COD_CATASTRAL ) ).getText();
            nombreVista = GetText.of(this.driverApp,GeneratorExcelUI.pathVistaDatosCodCatastral);
        }
        else
        {
            nombreVista = NOMBRE_VISTA_GENERICO;
        }

        return nombreVista.replaceAll("\n"," ");
    }
    public boolean elementoWebEstaPresente(String locatorType, String locator)
    {
        boolean isPresent = false;

        switch(locatorType)
        {
            case Constants.TIPO_LOCALIZADOR_ID	         : isPresent = this.driverApp.findElements(By.id(locator)).size() > 0; break;
            case Constants.TIPO_LOCALIZADOR_NAME         : isPresent = this.driverApp.findElements(By.name(locator)).size() > 0; break;
            case Constants.TIPO_LOCALIZADOR_XPATH        : isPresent = this.driverApp.findElements(By.xpath(locator)).size() > 0; break;
            case Constants.TIPO_LOCALIZADOR_LINK_TEXT    : isPresent = this.driverApp.findElements(By.linkText(locator)).size() > 0; break;
            case Constants.TIPO_LOCALIZADOR_CSS_SELECTOR : isPresent = this.driverApp.findElements(By.cssSelector(locator)).size() > 0; break;
        }
        return isPresent;
    }
    public boolean esAccionesDerechos ( )
    {
        final String PATH_BASE_PROPIEDADES = "/html/body/div[2]/form/table/tbody/tr[3]/td/table/tbody/tr";

        int                 nroColumnas        = 0;
        int                 propiedad_i        = 1;
        int                 pagina_i           = 0;
        int                 nroFilasResultados = 0;
        String              estado             = "";
        String              propietario        = "";
        boolean             esAccionesDerechos = false;
        boolean             existePaginacion   = false;
        List < WebElement > filasPropiedades   = null;
        List < WebElement > paginacion         = null;

        nroFilasResultados = this.driverApp.findElements ( By.xpath ( PATH_BASE_PROPIEDADES ) ).size ( );

        if ( nroFilasResultados > 1 ) //Existe paginación
        {
            existePaginacion   = true;
            paginacion         = this.driverApp.findElements ( By.xpath( PATH_BASE_PROPIEDADES.concat ( String.valueOf ( nroFilasResultados ) ).concat ( "]/td/a" ) ) );
            nroFilasResultados = nroFilasResultados - 1;
        }

        filasPropiedades = this.driverApp.findElements ( By.xpath ( PATH_BASE_PROPIEDADES.concat ( "[" ).concat ( String.valueOf ( nroFilasResultados ) ).concat ( "]/td/table/tbody/tr" ) ) );

        do
        {
            nroColumnas = filasPropiedades.get ( propiedad_i ).findElements ( By.xpath ( "td" ) ).size ( );
            estado      = filasPropiedades.get ( propiedad_i ).findElement ( By.xpath ( "td[".concat ( String.valueOf ( nroColumnas - 1 ) ).concat ( "]" ) ) ).getText ( );
            propietario = filasPropiedades.get ( propiedad_i ).findElement ( By.xpath ( "td[".concat ( String.valueOf ( nroColumnas - 3 ) ).concat ( "]" ) ) ).getText ( );

            if ( estado.equalsIgnoreCase ( "ACTIVO" ) || estado.equalsIgnoreCase ( "EN TRANSFERENCIA" ) )
            {
                if ( propietario.contains( "%" ) )
                {
                    esAccionesDerechos = true;
                    break;
                }
            }
            propiedad_i ++;

            if ( existePaginacion )
            {
                if ( pagina_i < paginacion.size ( ) )
                {
                    paginacion.get( pagina_i ++).click ( );
                }
                else
                {
                    break;
                }
                propiedad_i = 1;
            }
            else
            {
                if ( propiedad_i >= filasPropiedades.size ( ) )
                {
                    break;
                }
            }

        } while ( true );

        return esAccionesDerechos;
    }
    public void seleccionarPropiedad ( int numeroPropiedad )
    {
        final String PATH_BASE_PROPIEDADES = "/html/body/div[2]/form/table/tbody/tr[3]/td/table/tbody/tr";

        int                 propiedad_i         = 1;
        int                 pagina_i            = 0;
        int                 nroPropiedadActiva  = 0;
        int                 nroColumnas         = 0;
        int                 nroFilasResultados  = 0;
        String              estado              = "";
        String              propietario         = "";
        boolean             existePaginacion    = false;
        boolean             propiedadEncontrada = false;
        List < WebElement > filasPropiedades    = null;
        List < WebElement > paginacion          = null;

        nroFilasResultados = this.driverApp.findElements ( By.xpath ( PATH_BASE_PROPIEDADES ) ).size ( );

        if ( nroFilasResultados > 1 ) //Existe paginación
        {
            existePaginacion   = true;
            paginacion         = this.driverApp.findElements ( By.xpath( PATH_BASE_PROPIEDADES.concat ( String.valueOf ( nroFilasResultados ) ).concat ( "]/td/a" ) ) );
            nroFilasResultados = nroFilasResultados - 1;
        }

        filasPropiedades = this.driverApp.findElements ( By.xpath ( PATH_BASE_PROPIEDADES.concat ( "[" ).concat ( String.valueOf ( nroFilasResultados ) ).concat ( "]/td/table/tbody/tr" ) ) );

        do
        {
            nroColumnas = filasPropiedades.get ( propiedad_i ).findElements ( By.xpath ( "td" ) ).size ( );
            estado      = filasPropiedades.get ( propiedad_i ).findElement ( By.xpath ( "td[".concat ( String.valueOf ( nroColumnas - 1 ) ).concat ( "]" ) ) ).getText ( );
            propietario = filasPropiedades.get ( propiedad_i ).findElement ( By.xpath ( "td[".concat ( String.valueOf ( nroColumnas - 3 ) ).concat ( "]" ) ) ).getText ( );

            if ( estado.equalsIgnoreCase ( "ACTIVO" ) || estado.equalsIgnoreCase ( "EN TRANSFERENCIA" ) )
            {
                nroPropiedadActiva ++;

                if ( nroPropiedadActiva == numeroPropiedad )
                {
                    propiedadEncontrada = true;
                    //ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driverApp, Status.INFO, "Propiedades");
                    Log.recordInLog( " Evaluando Propiedad -> ".concat ( String.valueOf ( numeroPropiedad ) ).concat ( ": " ).concat ( propietario.replaceAll ( "\n", " " ) ) );
                    filasPropiedades.get ( propiedad_i ).findElement ( By.xpath ( "td[".concat ( String.valueOf ( nroColumnas ) ).concat ( "]" ) ) ).findElement ( By.linkText ( "Seleccionar" ) ).click ( );

                    try
                    {
                        this.wait.until ( ExpectedConditions.or ( ExpectedConditions.alertIsPresent ( ),
                                ExpectedConditions.visibilityOfElementLocated ( By.xpath ( Constants.PATH_TITULO_VISTA ) ),
                                ExpectedConditions.visibilityOfElementLocated ( By.xpath ( Constants.PATH_TITULO_VISTA.replaceAll ( "/form", "" ) ) ) ) );
                    }
                    catch ( UnhandledAlertException alertaExcepcion ) { }

                    break;
                }
            }
            propiedad_i ++;

            if ( existePaginacion )
            {
                if ( pagina_i < paginacion.size ( ) )
                {
                    paginacion.get( pagina_i ++).click ( );
                }
                else
                {
                    break;
                }
                propiedad_i = 1;
            }
            else
            {
                if ( propiedad_i >= filasPropiedades.size ( ) )
                {
                    break;
                }
            }

        } while ( true );

        if ( !propiedadEncontrada )
        {
            //ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driverApp, Status.INFO, "No válido");
            this.mensajeError.append ( "La propiedad: " ).append ( numeroPropiedad ).append( " no se encuentra en estado válido." );
            throw new AssertionError ( this.mensajeError.toString ( ) );
        }
    }
    public boolean esperarVista ( String tituloVista )
    {
        this.wait.until ( ExpectedConditions.or ( ExpectedConditions.textToBe ( By.xpath ( Constants.PATH_TITULO_VISTA ), tituloVista ),
                ExpectedConditions.textToBe ( By.xpath ( Constants.PATH_TITULO_VISTA.replaceAll ( "/form", "" ) ), tituloVista ),
                ExpectedConditions.visibilityOfElementLocated ( By.xpath( Constants.PATH_TITULO_VISTA ) ),
                ExpectedConditions.visibilityOfElementLocated ( By.xpath ( Constants.PATH_VALIDACIONES ) ),
                ExpectedConditions.visibilityOfElementLocated ( By.xpath( Constants.PATH_VISTA_DATOS_COD_CATASTRAL ) ),
                ExpectedConditions.visibilityOfElementLocated ( By.cssSelector ( Constants.SELECTOR_CSS_CODIGO_ERROR ) ),
                ExpectedConditions.textToBe ( By.xpath ( "/html/body/h1" ), "Page Flow Error - Unresolvable Forward" ) ) );

        if ( getTituloVista ( ).equalsIgnoreCase( tituloVista ) )
        {
            return true;
        }
        else
        {
            if ( this.driverApp.findElements ( By.xpath ( Constants.PATH_VALIDACIONES ) ).size ( ) > 0 &&
                    getTituloVista ( ).equalsIgnoreCase( "VALIDACIONES" ) )
            {
                this.mensajeError.append ( this.driverApp.findElement ( By.xpath ( Constants.PATH_VALIDACIONES ) ).getText ( ) );
                throw new AssertionError ( this.mensajeError.toString ( ) );
            }

            if ( this.driverApp.findElements ( By.xpath ( "/html/body/h1" ) ).size() > 0 &&
                    this.driverApp.findElement ( By.xpath ( "/html/body/h1" ) ).getText().equalsIgnoreCase( "Page Flow Error - Unresolvable Forward" ))
            {
                this.mensajeError.append ( this.driverApp.findElement ( By.xpath ( "/html/body/h1" ) ).getText() );
                throw new AssertionError ( this.mensajeError.toString ( ) );
            }

            if ( this.driverApp.findElements ( By.cssSelector ( Constants.SELECTOR_CSS_CODIGO_ERROR ) ).size ( ) > 0)
            {
                throw new AssertionError ( procesarErrorAplicativo ( ) );
            }

            return false;
        }
    }
    /**
     * Función que devuelve el mensaje de código de error del aplicativo, y además, realiza conexión con Base de Datos y obtiene la
     * descripción del error, devolviendo todo en una cadena de texto.
     * @return errorAplicativo
     */
    public String procesarErrorAplicativo ( )
    {
        String codigoError      = "";
        String descripcionError = "";

        codigoError      = this.driverApp.findElement ( By.cssSelector ( Constants.SELECTOR_CSS_CODIGO_ERROR ) ).getText ( );
        codigoError      = codigoError.substring ( codigoError.indexOf ( ":" ) + 2, codigoError.indexOf ( "en la" ) - 1 );
        descripcionError = procesarErrorAplicativo ( codigoError );

        return descripcionError;
    }
    public String procesarErrorAplicativo ( String codigoError )
    {
       // AccesoBaseDatos                            objBaseDatos     = new AccesoBaseDatos ( );
        StringBuilder                              descripcionError = new StringBuilder ( );
        Hashtable < String, ArrayList < String > > consultaError    = new Hashtable < String, ArrayList < String > > ( );

        descripcionError.append ( "ERROR APLICATIVO:\n" ).append ( Constants.ERROR_APP_MARK)
                .append ( "\n " ).append ( codigoError );

       // consultaError = objBaseDatos.getConsultaBD ( ConsultasSQL.getErrorInmuebles ( codigoError ) );

        descripcionError.append ( "\n Descripción Error:\n " ).append ( consultaError.get ( "DESCRIPCION" ).get ( 0 ) )
                .append ( Constants.ERROR_APP_MARK);

        return descripcionError.toString ( );
    }
    /**
     * Creado: efigueredo	Fecha: 01/08/2019
     * Método esperarDescargaReporte ( ): espera a que se despliegue la ventana del reporte y luego esta sea cerrada.
     */
    public void esperarDescargaReporte ( )
    {
        Set < String > ventanas = null;

        this.wait.until ( ExpectedConditions.numberOfWindowsToBe ( 2 ) );
        ventanas = this.driverApp.getWindowHandles ( );
        this.driverApp.switchTo ( ).window ( ventanas.toArray ( ) [ ventanas.toArray ( ).length - 1 ].toString ( ) );
        this.wait.until (ExpectedConditions.titleIs(Constants.REPORT_WINDOW_TITLE));
        this.driverApp.close ( );
        this.driverApp.switchTo ( ).window ( ventanas.toArray ( ) [ ventanas.toArray ( ).length - 2 ].toString ( ) );
    }
    public void moverScroll(WebElement elemento)
    {
        int posicionY;

        posicionY = elemento.getLocation().getY() - 20;
        ((JavascriptExecutor) this.driverApp).executeScript("scroll(0, ".concat(String.valueOf(posicionY)).concat(")"));
    }
    public boolean cuadroVerificacionHabilitado(WebElement cuadroVerificacion)
    {
        if(cuadroVerificacion.getAttribute(ConstantsINM.DISABLED_ATTRIBUTE) == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void takeScreenShotAndAdToHTMLReportGenerator(WebDriver webDriver,ExtentReports extent, Status stat, String details){
        String imageBase64 = ScreenShotHelper.takeScreenShot(webDriver);
        try {
            switch (stat.toString()){
                case "Fail" :
                    test.get(i).log(Status.FAIL,"TEST CON FALLA: ".concat(details), MediaEntityBuilder.createScreenCaptureFromBase64String(imageBase64).build()  );
                    break;
                case "Skip" :
                    test.get(i).log(Status.SKIP,"TEST OMITIDA: ".concat(details), MediaEntityBuilder.createScreenCaptureFromBase64String(imageBase64).build()  );
                    break;
                case "Pass":
                    test.get(i).log(Status.PASS,"TEST EXITOSO: ".concat(details), MediaEntityBuilder.createScreenCaptureFromBase64String(imageBase64).build()  );
                    break;
                case "Info" :
                    test.get(i).log(Status.INFO,"TEST INFORMATIVO: ".concat(details), MediaEntityBuilder.createScreenCaptureFromBase64String(imageBase64).build()  );
                    break;
                default:
                    test.get(i).log(Status.FAIL,"TEST CON FALLA: ".concat(details), MediaEntityBuilder.createScreenCaptureFromBase64String(imageBase64).build()  );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return operacion
     */
    public String getOperacion()
    {
        return operacion;
    }

    /**
     * @param operacion to set
     */
    public void setOperacion(String operacion)
    {
        this.operacion = operacion;
    }
    /**
     * @return numeroInmueble
     */
    public String getNumeroInmueble()
    {
        return numeroInmueble;
    }

    /**
     * @param numeroInmueble
     */
    public void setNumeroInmueble(String numeroInmueble)
    {
        this.numeroInmueble = numeroInmueble;
    }

    /**
     * @return numeroAccion
     */
    public int getNumeroAccion ( )
    {
        return this.numeroAccion;
    }

    /**
     * @param numeroAccion
     */
    public void setNumeroAccion ( int numeroAccion )
    {
        this.numeroAccion = numeroAccion;
    }

    /**
     * @return accionInicio
     */
    public String getAccionInicio()
    {
        return accionInicio;
    }
    public String getApp() {
        return this.app;
    }
    public void setApp(String app) {
        this.app = app;
    }

    public void start(){
    }

}
