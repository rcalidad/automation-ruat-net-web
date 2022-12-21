package main.tasks.vehiculos.commonVeh;

import main.actions.DisplayAlert;
import main.actions.WaitUntilAlert;
import org.openqa.selenium.WebDriver;

public class VerifyAlert {
    public static boolean containsThisText(WebDriver driver, String textMatcher){
        if (WaitUntilAlert.isPresent(driver)){
            String message = DisplayAlert.getText(driver);
            if (message.contains(textMatcher)){
                DisplayAlert.toAcept(driver);
                return true;
            }
        }
        return false;
    }
}
