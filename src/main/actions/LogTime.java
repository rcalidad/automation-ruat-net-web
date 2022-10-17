package main.actions;

import main.helpers.common.CommonComponent;

public class LogTime {
    static long initialExecTime;

    public static void start(){
        initialExecTime = 0;
        initialExecTime = System.currentTimeMillis();
     }

    public static void end(){
        Log.recordInLog("Tiempo Total de Ejecución: ".concat(CommonComponent.executionTimeFormat(System.currentTimeMillis() - initialExecTime)));
    }
    public static String timeElapsed(){
        return CommonComponent.executionTimeFormat(System.currentTimeMillis() - initialExecTime);
    }
}
