package main.tasks.inmuebles.commonInm.inicioTramite;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

public class ReceiveDocumentationFactory implements IReceiveDocumentationFactory{
    private static ReceiveDocumentationFactory instance = new ReceiveDocumentationFactory();

    public static ReceiveDocumentationFactory getInstance(){
        return instance;
    }
    @Override
    public void executeReceiveDocumentation(WebDriver driver, ExtentTest extentTest, String documentName) {
        try {
            Set<Class<? extends  IDocument>> documentsInterfaces = new Reflections(IDocument.class).getSubTypesOf(IDocument.class);
            for (var documentManager : documentsInterfaces){
                if (documentManager.getName().contains(documentName)){
                    Object object = Class.forName(documentManager.getName()).getConstructor().newInstance();
                    Method methodFill = Class.forName(documentManager.getName()).getDeclaredMethod("fillWithDefaultData", WebDriver.class, ExtentTest.class);
                    methodFill.invoke(object, driver, extentTest);
                }
            }
        }catch (Exception exception){

        }
    }
}
