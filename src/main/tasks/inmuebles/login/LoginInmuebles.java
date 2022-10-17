package main.tasks.inmuebles.login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.tasks.inmuebles.commonInm.GeneratorExcel;
import main.ui.inmueblesUI.loginUI.LoginUI;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class LoginInmuebles {

    public static void authenticate (WebDriver driver, ExtentReports extendApp, ExtentTest test , String usuario, String contrasenia )
    {
        String mensajeAlerta = "";
        String codigoError   = "";

        WaitUntilElement.isVisibleElementOr(driver,LoginUI.ventanaModal,LoginUI.txtUsuario,60);
        if(IsDisplayed.element(driver,LoginUI.mensajeModal,5))
        {
            mensajeAlerta = GetText.of(driver,LoginUI.mensajeModal,5);
            if ( mensajeAlerta.contains ( "versión del Aplicativo no es válida" ) )
            {
                GeneratorExcel.takeScreenShotAndAdToHTMLReportGenerator(driver,extendApp, Status.INFO, "version app no valida");
                Log.recordInLog( " ".concat ( mensajeAlerta ) );
                Click.on(driver,LoginUI.btnAceptarModal,5);
                WaitUntilElement.isInvisibleElement(driver,LoginUI.mensajeModal,5);
            }
            else if ( mensajeAlerta.contains ( "Código de Error" ) )
            {
                GeneratorExcel.takeScreenShotAndAdToHTMLReportGenerator(driver,extendApp, Status.INFO, "Codigo de Error");
                //codigoError = mensajeAlerta.substring ( mensajeAlerta.indexOf ( ": " ) + 1 );
                //throw new AssertionError ( procesarErrorAplicativo ( codigoError ) );
                System.out.println("registro del error en la base de datos");
            }
        }
        try
        {
            WaitUntilElement.isVisibleElementOr(driver,LoginUI.txtUsuario,LoginUI.txtContrasena,60);
        }
        catch ( TimeoutException timeoutAuthentication )
        {
           /* this.mensajeError.append ( "El aplicativo demoró mas de 1 minuto en el proceso de autentificación." );
            throw new AssertionError ( this.mensajeError.toString ( ) );*/
            System.out.println("registro del error en la base de datos");
        }
        Clear.on(driver, LoginUI.txtUsuario,5);
        Enter.text(driver,LoginUI.txtUsuario, usuario,5);
        Enter.text(driver,LoginUI.txtContrasena,contrasenia,5);
        GeneratorExcel.takeScreenShotAndAdToHTMLReportGenerator(driver,extendApp, Status.INFO, "Proceso de login.");
        Click.on(driver,LoginUI.btnIngresar,5);
        Log.recordInLog ( "Proceso de autentificación: ..." );
        WaitUntilElement.isVisibleElementOr(driver,LoginUI.btnAceptarModal,LoginUI.txtBuscarModulo,5);
        try
        {
            if(IsDisplayed.element(driver,LoginUI.mensajeModal,5))
            {
                GeneratorExcel.takeScreenShotAndAdToHTMLReportGenerator(driver,extendApp, Status.INFO, "Error en el logueo. ");
                mensajeAlerta = GetText.of(driver,LoginUI.mensajeModal,5);
                Click.on(driver,LoginUI.btnAceptarModal,5);
                WaitUntilElement.isInvisibleElement(driver,LoginUI.mensajeModal,5);

                if ( mensajeAlerta.contains ( "Ha expirado el plazo para el cambio de su contraseña" ) )
                {
                    GeneratorExcel.takeScreenShotAndAdToHTMLReportGenerator(driver,extendApp, Status.INFO, "Ha expirado");
                    WaitUntilElement.isClikeableOf(driver,LoginUI.txtContrasenaActual,5);
                    Enter.text(driver,LoginUI.txtContrasenaActual,contrasenia,5);
                    if ( contrasenia.contains( "8" ) )
                    {
                        //contrasenia = contrasenia.substring ( 0, contrasenia.length ( ) - 1 );
                        contrasenia = setNewPasswords.with(contrasenia);
                    }
                    else
                    {
                        //contrasenia = contrasenia.concat ( "8" );
                        contrasenia = setNewPasswords.with(contrasenia);
                    }
                    Enter.text(driver,LoginUI.txtContrasenaNueva,contrasenia,5);
                    Enter.text(driver,LoginUI.txtConfirmarContrasenaNueva,contrasenia,5);
                    Click.on(driver,LoginUI.btnGrabar,5);
                    WaitUntilElement.isVisibleElement(driver,LoginUI.btnAceptarModal,5);
                    mensajeAlerta = GetText.of(driver,LoginUI.mensajeModal,5);
                    Click.on(driver,LoginUI.btnAceptarModal,5);
                    if ( mensajeAlerta.contains ( "cambio de contraseña se realizó correctamente" ) )
                    {
                        Log.recordInLog( " ".concat ( mensajeAlerta ) );
                    }
                    else
                    {
                        GeneratorExcel.takeScreenShotAndAdToHTMLReportGenerator(driver,extendApp, Status.INFO, "Error en el login");
                        /*this.mensajeError.append ( mensajeAlerta );
                        throw new AssertionError ( this.mensajeError.toString ( ) );*/
                        System.out.println("se adiciona un mensaje de error");
                    }
                }
                else if ( mensajeAlerta.contains ( "no se encuentra registrado para el uso de esta aplicación" ) ||
                        mensajeAlerta.contains ( "Usuario y/o Contraseña es inexistente" ) )
                {
                    GeneratorExcel.takeScreenShotAndAdToHTMLReportGenerator(driver,extendApp, Status.INFO, "No se encuentra registrado para el uso de la aplicación o usuario inexistente");
                    /*this.mensajeError.append ( mensajeAlerta );
                    throw new AssertionError ( this.mensajeError.toString ( ) );*/
                    System.out.println("se adiciona un mensaje de error");
                }
                else if ( mensajeAlerta.contains ( "Error al intentar autentificarse" ) )
                {
                   Log.recordInLog  ( " Se intentará la autentificación nuevamente con la contraseña alternativa..." );
                   contrasenia = setNewPasswords.with(contrasenia);
                   authenticate ( driver,extendApp,test, usuario, contrasenia);
                   // throw new AssertionError ( " Dato Usuario o contraseña incorrecto." );  // Se genera una excepción si no funcionan ninguna de los 2 intentos.
                }
            }
            else
            {
                Log.recordInLog ( "Proceso de autentificación: OK." );
            }
        }
        catch ( TimeoutException tiempoEsperaExcedido )
        {
           /* this.mensajeError.append ( "Tiempo de espera excedido." );
            throw new AssertionError ( this.mensajeError.toString ( ) );*/
            System.out.println("se adiciona un mensaje de error");
        }
    }



}
