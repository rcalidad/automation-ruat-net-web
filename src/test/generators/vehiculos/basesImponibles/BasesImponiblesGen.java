package test.generators.vehiculos.basesImponibles;

import main.actions.Log;
import main.tasks.vehiculos.basesImponibles.BasesImponiblesMain;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class BasesImponiblesGen extends BaseGenerator {

    @Test
    public void basesImponibles(){
        BasesImponiblesMain basesImponiblesMain;
        try{
            basesImponiblesMain = new BasesImponiblesMain();
            basesImponiblesMain.run(this.driver, this.wait, this.extentReportBase);
        }catch (Exception exception){
            Log.recordInLog("Proceso sin éxito.");
        }
    }
}
