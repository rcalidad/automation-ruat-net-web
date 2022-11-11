package test.generators.vehiculos.modificarDatosTecnicosOperador;

import main.actions.Log;
import main.tasks.vehiculos.modificarDatosTecnicosOperador.ModificarDatosTecnicosOperador;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class ModificarDatosTecnicosOperadorGen extends BaseGenerator {
    @Test
    public void modificarDatosTecnicosOperador(){
        ModificarDatosTecnicosOperador modificarDatosTecnicosOperador;
        try{
            modificarDatosTecnicosOperador = new ModificarDatosTecnicosOperador();
            modificarDatosTecnicosOperador.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog("Proceso concluido.");
        }catch(Exception exception){
            Log.recordInLog("Proceso inconcluso...");
        }
    }
}
