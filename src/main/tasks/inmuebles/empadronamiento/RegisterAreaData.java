package main.tasks.inmuebles.empadronamiento;

import org.openqa.selenium.WebDriver;

public class RegisterAreaData {
    public static void now(WebDriver driver, String year, String area, int numBuilds){
        AreaData.fillAreaData(driver, year, area);
        AreaData.selectAllServices(driver);
        AreaData.recordData(driver, numBuilds);
    }

}
