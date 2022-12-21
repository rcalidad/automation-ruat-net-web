package test.generators.vehiculos.condonacionLeyMunicipalImt;

import main.actions.Log;
import main.tasks.vehiculos.condonacionLeyMunicipalImt.CondonacionLeyMunicipalImt;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class CondonacionLeyMunicipalImtGen extends BaseGenerator {
    @Test
    public void condonacionLeyMunicipalImt(){
        CondonacionLeyMunicipalImt condonacionLeyMunicipalImt;
        try{
            condonacionLeyMunicipalImt = new CondonacionLeyMunicipalImt();
            condonacionLeyMunicipalImt.run(this.driver, this.wait, this.extentReportBase);
        }catch (Exception exception){
            Log.recordInLog("Proceso sin éxito...");
        }
    }
}
