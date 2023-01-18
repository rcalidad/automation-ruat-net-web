package test.generators.inmuebles.compensaciones;

import main.actions.Log;
import main.tasks.inmuebles.compensaciones.Compensaciones;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class CompensacionesGen extends BaseGenerator {
    @Test
    public void compensaciones(){
        Compensaciones compensaciones;
        try {
            compensaciones = new Compensaciones();
            compensaciones.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(MessagesINM.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(MessagesINM.failTest);
        }
    }
}
