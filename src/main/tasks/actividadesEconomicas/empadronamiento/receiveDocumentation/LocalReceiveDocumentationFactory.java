package main.tasks.actividadesEconomicas.empadronamiento.receiveDocumentation;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Log;
import org.openqa.selenium.WebDriver;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

public class LocalReceiveDocumentationFactory implements IReceiveDocumentationFactory{
    private static LocalReceiveDocumentationFactory instance = new LocalReceiveDocumentationFactory();
    public static LocalReceiveDocumentationFactory getInstance(){
        return instance;
    }

    @Override
    public void executeReceiveDocumentation(WebDriver driver, String town, ExtentTest extentTest) {
        try {
            Set<Class<? extends IReceiveDocumentation>> receiveDocumentationInterfaces = new Reflections(IReceiveDocumentation.class).getSubTypesOf(IReceiveDocumentation.class);
            for (var receiveDocumentationManager:receiveDocumentationInterfaces) {
                if (receiveDocumentationManager.getName().contains(town)){
                    Object obj = Class.forName(receiveDocumentationManager.getName()).getConstructor().newInstance();
                    Method methodSetDriver = Class.forName(receiveDocumentationManager.getName()).getDeclaredMethod("setDriver", WebDriver.class, ExtentTest.class);
                    methodSetDriver.invoke(obj, driver, extentTest);
                    Method methodNow = obj.getClass().getMethod("now");
                    methodNow.invoke(obj);
                    //receiveDocumentationManager.getMethod("setDriver").invoke(obj, driver);
                    //receiveDocumentationManager.getMethod("now").invoke(obj);
                }
            }
        }catch (Exception exception){
            Log.recordInLog("No se pudo ejecutar el méthodo...");
        }

    }

}
