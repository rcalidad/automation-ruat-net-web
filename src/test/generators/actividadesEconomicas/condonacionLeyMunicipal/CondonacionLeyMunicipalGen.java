package test.generators.actividadesEconomicas.condonacionLeyMunicipal;

import main.actions.Log;
import main.tasks.actividadesEconomicas.condonacionLeyMunicipal.CondonacionLeyMunicipal;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class CondonacionLeyMunicipalGen extends BaseGenerator {
    @Test
    public void condonacionLeyMunicipal(){
        CondonacionLeyMunicipal condonacionLeyMunicipal;
        try{
            condonacionLeyMunicipal = new CondonacionLeyMunicipal();
            condonacionLeyMunicipal.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(Messages.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(Messages.errorTest);
        }
    }
}
