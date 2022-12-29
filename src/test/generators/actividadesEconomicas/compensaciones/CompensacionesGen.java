package test.generators.actividadesEconomicas.compensaciones;

import main.actions.Log;
import main.tasks.actividadesEconomicas.compensaciones.Compensaciones;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class CompensacionesGen extends BaseGenerator {
    @Test
    public void compensaciones(){
        Compensaciones compensaciones;
        try{
            compensaciones = new Compensaciones();
            compensaciones.run(this.driver, this.wait, this.extentReportBase);
            Log.recordInLog(Messages.successfulTest);
        }catch (Exception exception){
            Log.recordInLog(Messages.errorTest);
        }
    }
}
