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
        String title = giveTitleFormat(modulo);
        recordInLog("*************************************************************************");
        recordInLog("                       ".concat(title));
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
        String title = giveTitleFormat(msgLog);
        recordInLog("Proceso concluido: ".concat("Módulo - ").concat(title));
        recordInLog(Constants.END_OF_EXECUTION_MARK);
    }
    public static String giveTitleFormat(String title){  //title: ModificarDatos -> MODIFICAR-DATOS
        char charsArray[] = title.toCharArray();
        String newTitle="";
        int j = 0;
        for (int i = 0; i < charsArray.length; i++){
            if (Character.isUpperCase(charsArray[i])){
                if (i != 0){
                    newTitle = newTitle + title.substring(j,i) + "-";
                    j = i;
                }
            }
        }
        newTitle = newTitle + title.substring(j,title.length());
        return newTitle.toUpperCase();
    }
}
