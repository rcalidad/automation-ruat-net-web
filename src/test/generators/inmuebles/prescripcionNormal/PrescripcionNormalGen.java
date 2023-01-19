package test.generators.inmuebles.prescripcionNormal;

import main.actions.Log;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.tasks.inmuebles.prescripcionNormal.PrescripcionNormal;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class PrescripcionNormalGen extends BaseGenerator {
    @Test
    public void prescripcionNormal(){
        PrescripcionNormal prescripcionNormal;
        try{
            prescripcionNormal = new PrescripcionNormal();
            prescripcionNormal.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(MessagesINM.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(MessagesINM.failTest);
        }
    }
}
