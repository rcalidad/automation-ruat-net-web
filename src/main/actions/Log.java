package main.actions;

import main.helpers.common.CommonComponent;
import main.helpers.common.Constants;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Log {

    static String  fechaHoraInicio;
    static long    tiempoInicioTotal;
    static long    tiempoInicioTest;

    public static void onEnvironment(String modulo, String url){
        recordInLog("*************************************************************************");
        recordInLog("                       ".concat(modulo));
        recordInLog("*************************************************************************");
        recordInLog("Ambiente: ".concat(url));
        fechaHoraInicio   = new SimpleDateFormat(Constants.DATE_TIME_MASK).format(Calendar.getInstance().getTime());
        Log.recordInLog("Fecha: ".concat(fechaHoraInicio));
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, Constants.GECKO_DRIVER);
    }
    public static void recordInLog(String msgLog)
    {
        File log      = new File(Constants.PROJECTS_DIRECTORY.concat("logs/").concat(Constants.LOG_FILE));
        BufferedWriter escritor = null;

        try
        {
            escritor = new BufferedWriter(new FileWriter(log, true));
            msgLog   = CommonComponent.getCurrentDateTime().concat(": ").concat(msgLog);
            if(msgLog.contains("\n"))
            {
                escritor.newLine();
                escritor.write(msgLog.replaceAll("\n", ""));
            }
            else
                escritor.write(msgLog);

            escritor.newLine();
            escritor.close();
            System.out.println(msgLog);
        }
        catch (IOException archivoNoEncontradoExcepcion)
        {
            //throw new AssertionFailedError("ERROR: I/O - Archivo no encontrado o no es posible leer/escribir en él.");
        }
    }
    public static void endInLog(String msgLog) {
        recordInLog("Proceso concluido: ".concat(msgLog));
        recordInLog(Constants.END_OF_EXECUTION_MARK);
    }
}
