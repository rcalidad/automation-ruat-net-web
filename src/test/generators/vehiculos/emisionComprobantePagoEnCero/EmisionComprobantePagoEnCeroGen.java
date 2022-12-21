package test.generators.vehiculos.emisionComprobantePagoEnCero;

import main.actions.Log;
import main.tasks.vehiculos.comprobantePagoEnCero.EmisionComprobantePagoEnCero;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class EmisionComprobantePagoEnCeroGen extends BaseGenerator {
    @Test
    public void emisionComprobantePagoEnCero(){
        EmisionComprobantePagoEnCero emisionComprobantePagoEnCero;
        try{
            emisionComprobantePagoEnCero = new EmisionComprobantePagoEnCero();
            emisionComprobantePagoEnCero.run(this.driver, this.wait, this.extentReportBase);
        }catch (Exception exception){
            Log.recordInLog("Proceso sin éxito...");
        }
    }
}
