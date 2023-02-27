package test.generators.actividadesEconomicas.emisionLicenciaFuncionamiento;

import main.actions.Log;
import main.tasks.actividadesEconomicas.emisionLicenciaFuncionamiento.EmpadronarEmisionLicencia;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class EmpadronamientoEmisionLicenciaGen extends BaseGenerator{
    @Test
    public void empadronamientoEmisionLicencia(){
        EmpadronarEmisionLicencia empadronarEmisionLicencia;
        try {
            empadronarEmisionLicencia = new EmpadronarEmisionLicencia();
            empadronarEmisionLicencia.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(Messages.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(Messages.errorTest);
        }
    }
}
