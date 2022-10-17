package test.testCases;

import main.actions.Log;
import test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test
	public void LoginTestUNO() {
		
		//Arrange
		String usuario = "AALCAZAR.LPZ";
		String pasword = "NNB";
		// parametros de entrada o variables
		
		//Act
		//LoginInmuebles.as(webDriver, usuario,pasword);
		//Assert.assertTrue(false);
		//Assert.assertTrue(MenuPrincipal.isVisible(webDriver));

		//Assert

		//MenuPrincipal.enterProforma(webDriver);
		//CommonComponent//.RecordInLog("se encuentra en la pagina principal");

		

	}

	@Test
	public void LoginTestDOS() {

		//Arrange
		String usuario = "AALCAZAR.LPZ";
		String pasword = "NNB";
		// parametros de entrada o variables

		//Act

		//LoginInmuebles.as(webDriver, usuario,pasword);

		//Assert

		// Assert.true(condicion,esperado);
		Assert.assertTrue(false);
		Log.recordInLog(" prueba del registro del assert: ...OK");


	}

}
