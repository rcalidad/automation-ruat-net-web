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
            if ( mensajeAlerta.contains ( "versi�n del Aplicativo no es v�lida" ) )
            {
                GeneratorExcel.takeScreenShotAndAdToHTMLReportGenerator(driver,extendApp, Status.INFO, "version app no valida");
                Log.recordInLog( " ".concat ( mensajeAlerta ) );
                Click.on(driver,LoginUI.btnAceptarModal,5);
                WaitUntilElement.isInvisibleElement(driver,LoginUI.mensajeModal,5);
            }
            else if ( mensajeAlerta.contains ( "C�digo de Error" ) )
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
           /* this.mensajeError.append ( "El aplicativo demor� mas de 1 minuto en el proceso de autentificaci�n." );
            throw new AssertionError ( this.mensajeError.toString ( ) );*/
            System.out.println("registro del error en la base de datos");
        }
        Clear.on(driver, LoginUI.txtUsuario,5);
        Enter.text(driver,LoginUI.txtUsuario, usuario,5);
        Enter.text(driver,LoginUI.txtContrasena,contrasenia,5);
        GeneratorExcel.takeScreenShotAndAdToHTMLReportGenerator(driver,extendApp, Status.INFO, "Proceso de login.");
        Click.on(driver,LoginUI.btnIngresar,5);
        Log.recordInLog ( "Proceso de autentificaci�n: ..." );
        WaitUntilElement.isVisibleElementOr(driver,LoginUI.btnAceptarModal,LoginUI.txtBuscarModulo,5);
        try
        {
            if(IsDisplayed.element(driver,LoginUI.mensajeModal,5))
            {
                GeneratorExcel.takeScreenShotAndAdToHTMLReportGenerator(driver,extendApp, Status.INFO, "Error en el logueo. ");
                mensajeAlerta = GetText.of(driver,LoginUI.mensajeModal,5);
                Click.on(driver,LoginUI.btnAceptarModal,5);
                WaitUntilElement.isInvisibleElement(driver,LoginUI.mensajeModal,5);

                if ( mensajeAlerta.contains ( "Ha expirado el plazo para el cambio de su contrase�a" ) )
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
                    if ( mensajeAlerta.contains ( "cambio de contrase�a se realiz� correctamente" ) )
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
                else if ( mensajeAlerta.contains ( "no se encuentra registrado para el uso de esta aplicaci�n" ) ||
                        mensajeAlerta.contains ( "Usuario y/o Contrase�a es inexistente" ) )
                {
                    GeneratorExcel.takeScreenShotAndAdToHTMLReportGenerator(driver,extendApp, Status.INFO, "No se encuentra registrado para el uso de la aplicaci�n o usuario inexistente");
                    /*this.mensajeError.append ( mensajeAlerta );
                    throw new AssertionError ( this.mensajeError.toString ( ) );*/
                    System.out.println("se adiciona un mensaje de error");
                }
                else if ( mensajeAlerta.contains ( "Error al intentar autentificarse" ) )
                {
                   Log.recordInLog  ( " Se intentar� la autentificaci�n nuevamente con la contrase�a alternativa..." );
                   contrasenia = setNewPasswords.with(contrasenia);
                   authenticate ( driver,extendApp,test, usuario, contrasenia);
                   // throw new AssertionError ( " Dato Usuario o contrase�a incorrecto." );  // Se genera una excepci�n si no funcionan ninguna de los 2 intentos.
                }
            }
            else
            {
                Log.recordInLog ( "Proceso de autentificaci�n: OK." );
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
