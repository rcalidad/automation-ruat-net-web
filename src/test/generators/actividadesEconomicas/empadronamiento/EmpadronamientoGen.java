package test.generators.actividadesEconomicas.empadronamiento;

import main.actions.Log;
import main.tasks.actividadesEconomicas.empadronamiento.Empadronamiento;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class EmpadronamientoGen extends BaseGenerator {
    @Test
    public void empadronamiento(){
        Empadronamiento empadronamiento;
        try{
            empadronamiento = new Empadronamiento();
            empadronamiento.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(Messages.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(Messages.errorTest);
        }
    }
}
