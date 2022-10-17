package test.generators.actividadesEconomicas.login;

import main.tasks.actividadesEconomicas.login.LoginActividadesEconomicas;
import org.testng.annotations.Test;
import test.base.BaseGenerator;

public class LoginGen extends BaseGenerator {
    @Test
    public void login(){
        LoginActividadesEconomicas login;
        try {
            login = new LoginActividadesEconomicas();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
