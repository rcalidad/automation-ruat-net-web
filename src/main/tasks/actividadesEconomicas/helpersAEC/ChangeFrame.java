package main.tasks.actividadesEconomicas.helpersAEC;

import main.ui.actividadesEconomicasUI.commonUI.FramesUI;
import org.openqa.selenium.WebDriver;

public class ChangeFrame {
    public static void toParentFrame(WebDriver driver){
        driver.switchTo().parentFrame();
    }
    public static void toLeftMenuFromParentFrame(WebDriver driver){
        driver.switchTo().frame(FramesUI.frameNameMenuLateral);
    }
    public static void toLeftMenuFromAnotherFrame(WebDriver driver){
        toParentFrame(driver);
        driver.switchTo().frame(FramesUI.frameNameMenuLateral);
    }
    public static void toContentFromParentFrame(WebDriver driver){
        driver.switchTo().frame(FramesUI.frameNameContenido);
    }
    public static void toContentFromAnotherFrame(WebDriver driver){
        toParentFrame(driver);
        driver.switchTo().frame(FramesUI.frameNameContenido);
    }
    public static void toHeaderFromParentFrame(WebDriver driver){
        driver.switchTo().frame(FramesUI.frameNameCabecera);
    }
    public static void toHeaderFromAnotherFrame(WebDriver driver){
        toParentFrame(driver);
        driver.switchTo().frame(FramesUI.frameNameCabecera);
    }
}
