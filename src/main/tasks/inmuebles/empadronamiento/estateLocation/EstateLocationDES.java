package main.tasks.inmuebles.empadronamiento.estateLocation;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.actions.Enter;
import main.actions.Scroll;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.empadronamientoUI.UbicacionInmuebleUI;
import org.openqa.selenium.WebDriver;

public class EstateLocationDES extends EstateLocationBase {
    public EstateLocationDES() {

    }
    public static EstateLocationDES getInstance(){
        EstateLocationDES object = new EstateLocationDES();
        return object;
    }
    @Override
    public void defineRandomLocation(WebDriver driver, ExtentTest extentTest, String estateType){
        selectRandomOption(driver, UbicacionInmuebleUI.lstDistrito);
        selectRandomOption(driver, UbicacionInmuebleUI.lstZonaComunidad);
        selectRandomOption(driver, UbicacionInmuebleUI.lstTipoLugar);
        selectRandomOption(driver, UbicacionInmuebleUI.lstNombreLugar);
        Click.on(driver, UbicacionInmuebleUI.chkSinNumero);
        Enter.text(driver, UbicacionInmuebleUI.txtDireccionDescriptiva, MessagesINM.testText);
        if (estateType.equalsIgnoreCase("PROPIEDAD HORIZONTAL")){
            defineBuildingData(driver);
        }
        recordData(driver, extentTest);
    }
}
