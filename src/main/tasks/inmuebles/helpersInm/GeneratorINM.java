package main.tasks.inmuebles.helpersInm;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.helpers.common.Inmuebles.ConstantsINM;
import main.helpers.dataUtility.ExcelData;
import main.tasks.commonTasks.Generator;
import main.tasks.inmuebles.commonInm.ReturnMainMenu;
import main.tasks.inmuebles.login.LoginInmuebles;
import org.openqa.selenium.WebDriver;

public abstract class GeneratorINM extends Generator {
    public GeneratorINM(){
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
        ReturnMainMenu.fromAModule(this.driverApp);
    }

    @Override
    public void login(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password) {
        LoginInmuebles.authenticate(this.driverApp, extentReports, extentTest, user, password);
    }

    @Override
    public void logout() {

    }

    @Override
    public String setTestCaseName() {
        return getIdentifier();
    }

    @Override
    public boolean isNotLoggedIn() {
        return false;
    }

    @Override
    public String getUser() {
        return ExcelData.getUser(ConstantsINM.GENERATOR_DATA_FILE, this.accessExcel, i);
    }
}
