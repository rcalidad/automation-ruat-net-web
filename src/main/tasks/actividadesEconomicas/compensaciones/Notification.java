package main.tasks.actividadesEconomicas.compensaciones;

import main.actions.GetText;
import main.actions.Log;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.fileUtility.FileBuilder;
import main.ui.actividadesEconomicasUI.compensacionesUI.NotificationUI;
import org.openqa.selenium.WebDriver;

public class Notification {
    public static void process(WebDriver driver, String operation, String debtType, String numActivity, int index){
        String message = GetText.ifContains(driver, NotificationUI.msgNotificacion, "correctamente");
        Log.recordInLog(message);
        FileBuilder.moveAndRenameFile("reportePDF.pdf", operation, debtType, numActivity, ConstantsAEC.SUBSYSTEM_ID, index);
    }
}
