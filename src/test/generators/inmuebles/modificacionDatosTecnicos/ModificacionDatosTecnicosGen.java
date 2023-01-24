package test.generators.inmuebles.modificacionDatosTecnicos;

import main.actions.Log;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.tasks.inmuebles.modificacionDatosTecnicos.ModificacionDatosTecnicos;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class ModificacionDatosTecnicosGen extends BaseGenerator {
    @Test
    public void modificacionDatosTecnicos(){
        ModificacionDatosTecnicos modificacionDatosTecnicos;
        try {
            modificacionDatosTecnicos = new ModificacionDatosTecnicos();
            modificacionDatosTecnicos.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(MessagesINM.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(MessagesINM.failTest);
        }
    }
}
