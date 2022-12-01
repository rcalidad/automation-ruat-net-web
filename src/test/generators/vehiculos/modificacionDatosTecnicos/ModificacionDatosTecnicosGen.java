package test.generators.vehiculos.modificacionDatosTecnicos;

import main.actions.Log;
import main.tasks.vehiculos.modificacionDatosTecnicos.ModificarDatosTecnicosMain;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class ModificacionDatosTecnicosGen extends BaseGenerator {
    @Test
    public void modificacionDatosTecnicos(){
        ModificarDatosTecnicosMain modificarDatosTecnicos;
        try{
            modificarDatosTecnicos = new ModificarDatosTecnicosMain();
            modificarDatosTecnicos.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog("Proceso concluido exitosamente.");
        }catch (Exception exception){
            Log.recordInLog("Proceso sin éxito.");
        }
    }
}
