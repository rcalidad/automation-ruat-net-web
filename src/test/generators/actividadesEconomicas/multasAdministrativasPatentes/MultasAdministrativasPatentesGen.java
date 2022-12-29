package test.generators.actividadesEconomicas.multasAdministrativasPatentes;

import main.actions.Log;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import main.tasks.actividadesEconomicas.multasAdministrativasPatentes.MultasAdministrativasPatentes;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class MultasAdministrativasPatentesGen extends BaseGenerator {
    @Test
    public void multasAdministrativasPatentes(){
        MultasAdministrativasPatentes multasAdministrativasPatentes;
        try {
            multasAdministrativasPatentes = new MultasAdministrativasPatentes();
            multasAdministrativasPatentes.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(Messages.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(Messages.errorTest);
        }
    }
}
