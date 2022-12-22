package main.tasks.actividadesEconomicas.helpersAEC;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.dataUtility.ExcelData;
import main.tasks.actividadesEconomicas.login.LoginActividadesEconomicas;
import main.tasks.commonTasks.Generator;
import main.ui.actividadesEconomicasUI.commonUI.FramesUI;
import main.ui.actividadesEconomicasUI.commonUI.LeftMenuUI;
import org.openqa.selenium.WebDriver;

public abstract class GeneratorAEC extends Generator {
    public GeneratorAEC(){
        super();
    }
    public abstract String getIdentifier();
    public abstract void execute();
    @Override
    public void start() {
        execute();
    }

    @Override
    public void returnMainMenu() {
        this.driverApp.switchTo().parentFrame();
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        Click.on(this.driverApp, LeftMenuUI.lnkMenuPrincipal);
        this.driverApp.switchTo().parentFrame();
    }

    @Override
    public void login(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password) {
        LoginActividadesEconomicas.as(driver, extentReports, extentTest, user, password);
    }

    @Override
    public void logout() {
        LoginActividadesEconomicas.logout(this.driverApp);
    }

    @Override
    public String setTestCaseName() {
        return "Nro. de Actividad Económica ".concat(getIdentifier());
    }

    @Override
    public boolean isNotLoggedIn() {
        return LoginActividadesEconomicas.loginFailed;
    }

    @Override
    public String getUser() {
        return ExcelData.getUser(ConstantsAEC.GENERATOR_DATA_FILE,this.accessExcel,i);
    }
}
