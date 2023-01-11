package test.generators.inmuebles.autoavaluos;

import main.actions.Log;
import main.tasks.inmuebles.autoavaluos.Autoavaluos;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class AutoavaluosGen extends BaseGenerator {
    @Test
    public void autoavaluo(){
        Autoavaluos autoavaluos;
        try {
            autoavaluos = new Autoavaluos();
            autoavaluos.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(MessagesINM.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(MessagesINM.failTest);
        }
    }
}
