package test.generators.vehiculos.transferencia;

import main.actions.Log;
import main.tasks.vehiculos.tansferencia.TransferenciaMain;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class TrnasferenciaNormalGen extends BaseGenerator {
    @Test
    public void transferenciaNormal(){
        TransferenciaMain transferenciaMain;
        try{
            transferenciaMain = new TransferenciaMain();
            transferenciaMain.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog("Proceso concluido.");
        }catch (Exception exception){
            Log.recordInLog("Proceso inconcluso");
        }
    }
}
