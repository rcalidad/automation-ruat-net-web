package main.tasks.inmuebles.helpersInm;

import main.ui.inmueblesUI.commonUI.FramesINM;
import org.openqa.selenium.WebDriver;

public class ChangeFrame {
    public static void toParentFrame(WebDriver driver){
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }
    public static void toContentFrame(WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(FramesINM.contentFrame);
    }
}
