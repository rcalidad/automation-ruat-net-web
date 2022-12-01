package test.generators.vehiculos.modificarDatosSupervisor;

import main.actions.Log;
import main.tasks.vehiculos.modificarDatosSupervisor.ModificarDatosSupervisorMain;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class ModificarDatosSupervisorGen extends BaseGenerator {
    @Test
    public void modificarDatosPorSupervisor(){
        ModificarDatosSupervisorMain modificarDatosSupervisorMain;
        try{
            modificarDatosSupervisorMain = new ModificarDatosSupervisorMain();
            modificarDatosSupervisorMain.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog("Proceso concluido.");
        }catch (Exception exception){
            Log.recordInLog("Proceso inconcluso");
        }
    }
}
