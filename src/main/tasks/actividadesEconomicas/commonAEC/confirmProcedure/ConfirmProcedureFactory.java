package main.tasks.actividadesEconomicas.commonAEC.confirmProcedure;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Log;
import org.openqa.selenium.WebDriver;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

public class ConfirmProcedureFactory implements IConfirmProcedureFactory{
    private static ConfirmProcedureFactory instance = new ConfirmProcedureFactory();

    public static ConfirmProcedureFactory getInstance(){
        return instance;
    }
    @Override
    public void executeConfirmProcedure(WebDriver driver, ExtentTest extentTest, String procedure, String identifier, int index) {
        try{
            Set<Class<? extends IConfirmProcedure>> confirmProcedureInterfaces = new Reflections(IConfirmProcedure.class).getSubTypesOf(IConfirmProcedure.class);
            for (var confirmProcedureManager : confirmProcedureInterfaces) {
                if (confirmProcedureManager.getName().contains(procedure)){
                    Object obj = Class.forName(confirmProcedureManager.getName()).getConstructor().newInstance();
                    Method methodSetDriver = Class.forName(confirmProcedureManager.getName()).getDeclaredMethod("setDriver", WebDriver.class, ExtentTest.class);
                    methodSetDriver.invoke(obj, driver, extentTest);
                    //Method methodNow = obj.getClass().getMethod("now");
                    Method methodNow = obj.getClass().getDeclaredMethod("now", String.class, int.class);
                    methodNow.invoke(obj, identifier, index);
                    break;
                }
            }
        }catch (Exception exception){
            Log.recordInLog("No se pudo confirmar el trámite");
        }
    }
}
