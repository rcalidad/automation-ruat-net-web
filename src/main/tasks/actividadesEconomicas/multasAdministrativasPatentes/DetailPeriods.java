package main.tasks.actividadesEconomicas.multasAdministrativasPatentes;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Scroll;
import main.actions.SelectOption;
import main.tasks.actividadesEconomicas.commonAEC.SelectPeriods;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI.AnnulPenaltyUI;
import main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI.DetailPeriodsUI;
import main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI.ModifyPenaltyUI;
import main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI.RegisterPenaltyUI;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;
import java.util.Map;

public class DetailPeriods {
    private static Map<String, String> operations = Map.of("REGISTRAR", "registerPenalty",
                                                    "MODIFICAR", "modifyPenalty",
                                                    "ANULAR", "annulPenalty");
    private static DetailPeriods instance = new DetailPeriods();

    public static DetailPeriods getInstance(){
        return  instance;
    }
    public static void registerOperation(WebDriver driver, ExtentTest extentTest, String penaltyType, String initialYear, String finalYear, String period, String operation, String amount, String date){
        try {
            SelectOption.byText(driver, DetailPeriodsUI.lstTipoMulta, penaltyType);
            Verify.isReady(driver, extentTest, DetailPeriodsUI.tblDetalleGestiones);
            if (period.equals("TODOS")){
                SelectPeriods.ofAllPeriods(driver, operation, DetailPeriodsUI.detailTable);
            }else {
                SelectPeriods.of(driver, initialYear, finalYear, operation, DetailPeriodsUI.detailTable);
            }
            Scroll.toEndPage(driver);
            Click.on(driver, DetailPeriodsUI.btnProcesar);
            Object obj = getInstance();
            Method method = obj.getClass().getDeclaredMethod(operations.get(operation), WebDriver.class, ExtentTest.class, String.class, String.class);
            method.invoke(obj, driver, extentTest, amount, date);
            Verify.isReady(driver, extentTest, DetailPeriodsUI.ttlDetalleGestiones);
            Click.on(driver, DetailPeriodsUI.btnAceptar);
        }catch (Exception exception){

        }

    }

    public static void registerPenalty(WebDriver driver, ExtentTest extentTest, String amount, String date){
        try {
            Verify.isReady(driver, extentTest, RegisterPenaltyUI.ttlRegistrarMulta);
            RegisterPenalty.withDefaultData(driver, amount, date);
        }catch (Exception exception){

        }
    }
    public static void modifyPenalty(WebDriver driver, ExtentTest extentTest, String amount, String date){
        try {
            Verify.isReady(driver, extentTest, ModifyPenaltyUI.ttlModificarMulta);
            ModifyPenalty.withDefaultData(driver, amount);
        }catch (Exception exception){

        }
    }
    public static void annulPenalty(WebDriver driver, ExtentTest extentTest, String amount, String date){
        try {
            Verify.isReady(driver, extentTest, AnnulPenaltyUI.ttlAnularMulta);
            AnnulPenalty.withDefaultData(driver);
        }catch (Exception exception){

        }
    }
}
