package main.ui.cobroUI.mainMenuUI;

import org.openqa.selenium.By;

public class LeftMenuUI {
    public static By getOption(String option){
        return By.linkText(option);
    }
}
