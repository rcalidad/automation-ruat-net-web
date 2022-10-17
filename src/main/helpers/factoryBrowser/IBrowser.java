package main.helpers.factoryBrowser;

import org.openqa.selenium.WebDriver;

public interface IBrowser {
    void startDriver();
    void configBrowser();
    WebDriver create();
}
