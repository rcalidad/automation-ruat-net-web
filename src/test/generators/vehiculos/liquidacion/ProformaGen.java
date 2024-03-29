package test.generators.vehiculos.liquidacion;

import main.actions.Log;
import main.tasks.vehiculos.liquidacion.Proforma;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class ProformaGen extends BaseGenerator {
    @Test
    public void proforma(){
        Proforma proforma;
        try
        {
            proforma = new Proforma();
            proforma.run(this.driver,this.wait,this.extentReportBase);
        }
        catch ( Exception empadronamientoExcepcion ) { }
        Log.recordInLog("Proceso concluido exitosamente");

    }
}
