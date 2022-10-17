package main.helpers.factoryBrowser;

public class FactoryBrowser {
    public static IBrowser make(String nameBrowser){
        IBrowser browser;
        switch (nameBrowser){
            case "chrome":
                browser = new Chrome();
                break;
            case "firefox":
                browser = new Firefox();
                break;
            default:
                browser = new Firefox();
                break;
        }
        return browser;
    }
}
