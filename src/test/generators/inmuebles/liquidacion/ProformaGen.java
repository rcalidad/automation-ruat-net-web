/**
 * @description Generar inmuebles empadronados
 * @date 21/07/2022
 * @author Faustina Chambi Camata
 */

package test.generators.inmuebles.liquidacion;

import main.actions.Log;
import main.tasks.inmuebles.liquidacion.Proforma;
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