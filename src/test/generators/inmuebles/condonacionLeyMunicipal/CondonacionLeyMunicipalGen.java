package test.generators.inmuebles.condonacionLeyMunicipal;

import main.actions.Log;
import main.tasks.inmuebles.condonacionLeyMunicipal.CondonacionLeyMunicipal;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class CondonacionLeyMunicipalGen extends BaseGenerator {
    @Test
    public void condonacionLeyMunicipal(){
        CondonacionLeyMunicipal condonacionLeyMunicipal;
        try{
            condonacionLeyMunicipal = new CondonacionLeyMunicipal();
            condonacionLeyMunicipal.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(MessagesINM.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(MessagesINM.failTest);
        }
    }
}
