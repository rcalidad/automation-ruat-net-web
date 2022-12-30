package test.generators.actividadesEconomicas.emisionLicenciaFuncionamiento;

import main.actions.Log;
import main.tasks.actividadesEconomicas.emisionLicenciaFuncionamiento.EmisionLicenciaFuncionamiento;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class EmisionLicenciaFuncionamientoGen extends BaseGenerator {
    @Test
    public void emisionLicenciaFuncionamiento(){
        EmisionLicenciaFuncionamiento emisionLicenciaFuncionamiento;
        try {
            emisionLicenciaFuncionamiento = new EmisionLicenciaFuncionamiento();
            emisionLicenciaFuncionamiento.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(Messages.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(Messages.errorTest);
        }
    }
}
