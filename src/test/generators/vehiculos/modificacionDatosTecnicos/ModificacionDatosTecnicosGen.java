package test.generators.vehiculos.modificacionDatosTecnicos;

import main.actions.Log;
import main.tasks.vehiculos.modificacionDatosTecnicos.ModificarDatosTecnicos;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class ModificacionDatosTecnicosGen extends BaseGenerator {
    @Test
    public void modificacionDatosTecnicos(){
        ModificarDatosTecnicos modificarDatosTecnicos;
        try{
            modificarDatosTecnicos = new ModificarDatosTecnicos();
            modificarDatosTecnicos.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog("Proceso concluido exitosamente.");
        }catch (Exception exception){
            Log.recordInLog("Proceso sin éxito.");
        }
    }
}
