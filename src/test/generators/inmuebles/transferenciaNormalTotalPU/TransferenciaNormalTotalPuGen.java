package test.generators.inmuebles.transferenciaNormalTotalPU;

import main.actions.Log;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.tasks.inmuebles.transferenciaNormalTotal.TransferenciaNormalTotalPu;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class TransferenciaNormalTotalPuGen extends BaseGenerator {
    @Test
    public void transferenciaNormalTotal(){
        TransferenciaNormalTotalPu transferenciaNormal;
        try{
            transferenciaNormal = new TransferenciaNormalTotalPu();
            transferenciaNormal.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(MessagesINM.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(MessagesINM.failTest);
        }
    }
}
