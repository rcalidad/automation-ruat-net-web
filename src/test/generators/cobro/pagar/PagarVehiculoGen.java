package test.generators.cobro.pagar;

import main.actions.Log;
import main.tasks.cobro.cobroMain.Cobro;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class PagarVehiculoGen extends BaseGenerator {
    @Test
    public void pagar(){
        Cobro pagar;
        try{
            pagar = new Cobro();
            pagar.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog("Proceso de pago concluido.");
        }catch (Exception exception){
            Log.recordInLog("El proceso de pago no se pudo completar.");
        }
    }
}
