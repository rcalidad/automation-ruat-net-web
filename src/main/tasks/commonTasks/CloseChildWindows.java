package main.tasks.commonTasks;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class CloseChildWindows {
    public static void now(WebDriver driver, String originalWindow){
        //String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while(iterator.hasNext()){
            String ChildWindow = iterator.next();
            if(!originalWindow.equalsIgnoreCase(ChildWindow)){
                driver.switchTo().window(ChildWindow);
                driver.close();
            }
        }
        driver.switchTo().window(originalWindow);
    }
}
