package test.generators.vehiculos.compensaciones;

import main.actions.Log;
import main.tasks.vehiculos.compensaciones.Compensaciones;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class CompensacionesGen extends BaseGenerator {
    @Test
    public void compensaciones(){
        Compensaciones compensaciones;
        try {
            compensaciones = new Compensaciones();
            compensaciones.run(this.driver, this.wait, this.extentReportBase);
        }catch (Exception exception){
            Log.recordInLog("Proceso sin éxito...");
        }
    }
}
