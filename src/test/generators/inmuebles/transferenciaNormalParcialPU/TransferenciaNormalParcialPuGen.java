package test.generators.inmuebles.transferenciaNormalParcialPU;

import main.actions.Log;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.tasks.inmuebles.transferenciaNormalParcial.TransferenciaNormalParcialPu;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class TransferenciaNormalParcialPuGen extends BaseGenerator {
    @Test
    public void transferenciaNormalParcial(){
        TransferenciaNormalParcialPu tranferenciaParcial;
        try {
            tranferenciaParcial = new TransferenciaNormalParcialPu();
            tranferenciaParcial.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(MessagesINM.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(MessagesINM.failTest);
        }
    }
}
