package test.generators.inmuebles.basesImponiblesIP;

import main.actions.Log;
import main.tasks.inmuebles.basesImponiblesIP.BasesImponiblesIp;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class BasesImponiblesIPGen extends BaseGenerator {
    @Test
    public void basesImponiblesIP(){
        BasesImponiblesIp basesImponiblesIP;
        try {
            basesImponiblesIP = new BasesImponiblesIp();
            basesImponiblesIP.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(MessagesINM.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(MessagesINM.failTest);
        }
    }
}
