package main.helpers.factoryBrowser;

import main.actions.LogTime;
import main.helpers.common.Constants;
import main.helpers.fileUtility.FileBuilder;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firefox implements IBrowser{

    protected FirefoxProfile profile;
    protected FirefoxOptions firefoxOptions;
    protected WebDriverWait wait;
    protected Actions actions;
    public WebDriver driver;
    @Override
    public void startDriver() {
        LogTime.start();
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, Constants.GECKO_DRIVER);
    }
    @Override
    public void configBrowser() {
        String downloadDirectory = FileBuilder.getPathTemporalDirectory().replace('/', '\\') + "\\";
        startDriver();
        this.profile = new FirefoxProfile();  //configuración Proxy y directorio de descargas.
        this.profile.setPreference("network.proxy.type", 1);
        this.profile.setPreference("network.proxy.socks", "172.21.24.40");
        this.profile.setPreference("network.proxy.socks_port", 3128);
        this.profile.setPreference("network.proxy.no_proxies_on", "*.ruat.gob.bo, 127.0.0.1, *.ruat.net.bo, *.ruat.net");

        this.profile.setPreference("browser.download.folderList", 2);
        this.profile.setPreference("browser.download.manager.showWhenStarting",false);
        this.profile.setPreference("browser.download.dir", downloadDirectory);
        this.profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
        this.profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
        this.profile.setPreference("browser.download.manager.useWindow", false);
        this.profile.setPreference("plugin.scan.plid.all",false);
        this.profile.setPreference("plugin.scan.Acrobat","99.0");
        this.profile.setPreference("pdfjs.enabledCache.state",false);
        this.profile.setPreference("pdfjs.disabled",true);

        this.firefoxOptions = new FirefoxOptions();
        this.firefoxOptions.setProfile(this.profile);
        this.firefoxOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        this.firefoxOptions.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
    }
    @Override
    public WebDriver create() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, Constants.LOGS_DIRECTORY.concat(Constants.LOG_GECKODRIVER_FILE));
        configBrowser();
        this.driver = new FirefoxDriver(this.firefoxOptions);
        return driver;
    }

}
