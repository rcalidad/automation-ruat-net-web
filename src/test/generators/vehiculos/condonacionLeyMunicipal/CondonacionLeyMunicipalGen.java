package test.generators.vehiculos.condonacionLeyMunicipal;

import main.actions.Log;
import main.tasks.vehiculos.condonacionLeyMunicipal.CondonacionLeyMunicipal;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class CondonacionLeyMunicipalGen extends BaseGenerator {
    @Test
    public void condonacionLeyMunicipalGen(){
        CondonacionLeyMunicipal condonacionLeyMunicipal;
        try {
            condonacionLeyMunicipal = new CondonacionLeyMunicipal();
            condonacionLeyMunicipal.run(this.driver, this.wait, this.extentReportBase);
        }catch (Exception exception){
            Log.recordInLog("Proceso sin éxito.");
        }
    }
}
