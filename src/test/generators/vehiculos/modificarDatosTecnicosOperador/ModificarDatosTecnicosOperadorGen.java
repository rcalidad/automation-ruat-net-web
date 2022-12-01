package test.generators.vehiculos.modificarDatosTecnicosOperador;

import main.actions.Log;
import main.tasks.vehiculos.modificarDatosTecnicosOperador.ModificarDatosTecnicosOperadorMain;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class ModificarDatosTecnicosOperadorGen extends BaseGenerator {
    @Test
    public void modificarDatosTecnicosOperador(){
        ModificarDatosTecnicosOperadorMain modificarDatosTecnicosOperador;
        try{
            modificarDatosTecnicosOperador = new ModificarDatosTecnicosOperadorMain();
            modificarDatosTecnicosOperador.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog("Proceso concluido.");
        }catch(Exception exception){
            Log.recordInLog("Proceso inconcluso...");
        }
    }
}
