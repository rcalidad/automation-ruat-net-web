package test.generators.inmuebles.empadronamiento;

import main.tasks.inmuebles.empadronamiento.Empadronamiento;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class EmpadronamientoGen extends BaseGenerator {
    @Test
    public void empadronamiento(){
        Empadronamiento empadronamiento;
        try {
            empadronamiento = new Empadronamiento();
            empadronamiento.run(this.driver, this.wait, this.extentReportBase);
        }catch (Exception exception){

        }
    }
}
