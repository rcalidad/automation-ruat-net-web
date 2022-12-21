package test.generators.vehiculos.basesImponibleImt;

import main.actions.Log;
import main.tasks.vehiculos.basesImponiblesIMT.BasesImponiblesImt;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class BasesImponiblesImtGen extends BaseGenerator {
    @Test
    public void basesImponiblesImt(){
        BasesImponiblesImt basesImponiblesImt;
        try{
            basesImponiblesImt = new BasesImponiblesImt();
            basesImponiblesImt.run(this.driver, this.wait, this.extentReportBase);
        }catch (Exception exception){
            Log.recordInLog("Proceso sin éxito.");
        }
    }
}
