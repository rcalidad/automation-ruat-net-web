package main.tasks.inmuebles.commonInm;

import main.actions.Find;
import main.actions.WaitUntilElement;
import main.ui.inmueblesUI.commonUI.MainMenuUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoadModule {
    public static void fromMainMenu(WebDriver driver, String grouper, String module){
        WaitUntilElement.isElementVisible(driver, MainMenuUI.groupers);
        List<WebElement> groupers = Find.elements(driver, MainMenuUI.groupers);
        int index = verifyNames(groupers, grouper);
        if (index != -1){
            WebElement element = groupers.get(index);
            element.click();
            List<WebElement> subElements = element.findElements(By.xpath("ul/li"));
            searchModule(subElements, module);
        }
    }

    public static boolean searchModule(List<WebElement> elements, String name){
        int index = verifyNames(elements, name);
        boolean flag;
        if (index == -1){
            flag = false;
            int i = 0;
            while (i < elements.size() && flag != true){
                WebElement element = elements.get(i);
                //element.click();
                List<WebElement> childElements = element.findElements(By.xpath("ul/li"));
                if(!childElements.isEmpty()){
                    element.click();
                    flag = searchModule(childElements, name);
                }
                i++;
            }

        }else{
            WebElement lnkElement = elements.get(index).findElement(By.tagName("a"));
            String link = lnkElement.getText();
            lnkElement.click();
            //elements.get(index).click();
            return true;
        }
        return flag;
    }
    public static int verifyNames(List<WebElement> elements, String name){
        for (int i = 0; i < elements.size(); i++){
            if (elements.get(i).getText().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
}