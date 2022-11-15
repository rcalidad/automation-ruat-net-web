package main.tasks.vehiculos.liquidacion;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.actions.*;
import main.helpers.common.Constants;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.common.vehiculos.ConstantsVEH;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.commonTasks.Generator;
//import main.tasks.vehiculos.commonVeh.Generator;
import main.tasks.vehiculos.login.LoginVehiculos;
import main.tasks.vehiculos.mainMenu.MainMenu;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.commonUI.LeftMenuUI;
import main.ui.vehiculosUI.liquidacionUI.DeudaUI;
import main.ui.vehiculosUI.liquidacionUI.ProformaUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Proforma extends Generator {
    public static final String PROFORMA_DATA_SHEET = "Proforma";
    public static final String PROFORMA_MODULE = "Proforma";
    public static final String PROFORMA_NAME = "enviarPDF.pdf";
    private String operation;
    //--- These variables have the same name of columns defined on Excel file.
    protected String operacion;
    protected String detalleDeuda;
    protected String identificador;
    protected String gestionInicio;
    protected String gestionFin;

    public Proforma() {
        super ( );
        this.accessExcel = new AccessExcel(ConstantsVEH.GENERATOR_DATA_FILE, ConstantsVEH.PROFORMA_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsVEH.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(PROFORMA_MODULE.toUpperCase(), ConstantsVEH.ID_SUBSYSTEM);
    }
    public void start(){
        Log.recordInLog(Constants.END_OF_EXECUTION_MARK);
        MainMenu.selectOption(this.driverApp, PROFORMA_MODULE);
        searchVehiculo();
        getProforma();
    }
    public void searchVehiculo(){
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        Click.on(this.driverApp, ProformaUI.lnkProformaVehiculo);
        this.driverApp.switchTo().defaultContent();
        this.driverApp.switchTo().frame(FramesUI.frameNameContenido);
        Log.recordInLog("Identificador de Vehículo: ".concat(this.identificador));
        Enter.text(this.driverApp, ProformaUI.txtIdentificador, this.identificador);
        Click.on(this.driverApp, ProformaUI.rbtPlacaPta);
        Click.on(this.driverApp, ProformaUI.btnBuscar);
        if (IsDisplayed.element(this.driverApp, ProformaUI.imgEnProgreso)){
            WaitUntilElement.isInvisibleElement(this.driverApp, ProformaUI.imgEnProgreso);
        }
        if (IsPresent.elements(this.driverApp, ProformaUI.btnContinuar)){
            Click.on(this.driverApp, ProformaUI.btnContinuar);
        }
        if (IsDisplayed.element(this.driverApp, ProformaUI.imgEnProgreso)){
            WaitUntilElement.isInvisibleElement(this.driverApp, ProformaUI.imgEnProgreso);
        }
    }
    public void getProforma(){
        List<WebElement> rowsDeuda = this.driverApp.findElements(DeudaUI.filas);
        List<WebElement> headerDeuda = this.driverApp.findElements(DeudaUI.cabecera);
        int rowsNumber = rowsDeuda.size();
        int columnsNumber = headerDeuda.size();
        if(!this.operacion.equals("SOLO LIQUIDAR")){
            for (int row = 2; row <= rowsNumber; row = row + 1){
                if(verifyDebtDetail(row)){
                    if(verifyYearRange(row)){
                        Click.on(this.driverApp, DeudaUI.getCell(row, columnsNumber));
                    }
                }
            }
            print();
            if (WaitUntilAlert.isPresent(this.driverApp)){
                DisplayAlert.toAcept(this.driverApp);
            }
            if (FileBuilder.moveFile(PROFORMA_NAME)){
                FileBuilder.renameReport(PROFORMA_NAME, this.operation, this.detalleDeuda, this.identificador, ConstantsVEH.ID_SUBSYSTEM, i + 1);
            }
        }
    }
    public boolean verifyDebtDetail(int i){
        String debtType = GetText.of(this.driverApp, DeudaUI.getCell(i, 2));
        boolean sw;
        switch (this.detalleDeuda){
            case "IP":
                sw = debtType.contains("PROPIEDAD");
                break;
            case "MI":
                sw = debtType.contains("FORMALES IPVA");
                break;
            case "MP":
                sw = debtType.contains("OMISION DE PAGO IPVA");
                break;
            case "RE":
                sw = debtType.contains("RECIBO");
                break;
            case "IM":
                sw = debtType.contains("TRANSFERENCIAS");
                break;
            case "MF":
                sw = debtType.contains("FORMALES IMT");
                break;
            case "MT":
                sw = debtType.contains("OMISION DE PAGO IMT");
                break;
            default:
                sw = true;
                break;
        }
        return sw;
    }
    public boolean verifyYearRange(int i){
        int startYear = Integer.parseInt(this.gestionInicio);
        int endYear = Integer.parseInt(this.gestionFin);
        String year = GetText.of(this.driverApp, DeudaUI.getCell(i, 1));
        if (!year.equals("")){
            if (Integer.parseInt(year) >= startYear && Integer.parseInt(year) <= endYear){
                return true;
            }
        }
        return false;
    }
    public void print(){
        switch (this.operacion){
            case "PROFORMA DETALLADA":
                this.operation = "DETALLADA";
                Click.on(this.driverApp, DeudaUI.btnProformaDetallada);
                break;
            case "PROFORMA RESUMIDA":
                this.operation = "RESUMIDA";
                Click.on(this.driverApp, DeudaUI.proformaResumidaButton);
                break;
            default:
                this.operation = "noProforma";
                break;
        }
    }
    public void returnMainMenu(){
        this.driverApp.switchTo().parentFrame();
        this.driverApp.switchTo().frame(FramesUI.frameNameMenuLateral);
        Click.on(this.driverApp, LeftMenuUI.lnkMenuPrincipal);
        this.driverApp.switchTo().parentFrame();
    }

    @Override
    public void login(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password) {
        LoginVehiculos.authenticate(driver, extentReports, extentTest, user, password);
        //LoginVehiculos.as(driver, extentReports, extentTest, user, password);
    }

    @Override
    public void logout() {

    }

    @Override
    public String setTestCaseName() {
        return "Nro. de vehiculo ".concat(this.identificador);
    }

    @Override
    public boolean isNotLoggedIn() {
        return false;
    }

    @Override
    public String getUser() {
        return ExcelData.getUser(ConstantsVEH.GENERATOR_DATA_FILE, this.accessExcel, i);
    }
}
