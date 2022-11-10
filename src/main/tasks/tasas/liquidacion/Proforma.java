package main.tasks.tasas.liquidacion;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.common.tasas.ConstantsTOI;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.commonTasks.Generator;
import main.tasks.tasas.common.DebtType;
import main.tasks.tasas.common.OperationType;
import main.tasks.tasas.common.StartModule;
import main.tasks.tasas.common.TasaType;
import main.tasks.tasas.login.LoginTasas;
import main.ui.tasasOtrosIngresosUI.commonUI.CommonElementsUI;
import main.ui.tasasOtrosIngresosUI.commonUI.ValidacionesUI;
import main.ui.tasasOtrosIngresosUI.liquidacionUI.DeudaUI;
import main.ui.tasasOtrosIngresosUI.liquidacionUI.ProformaUI;
import main.ui.tasasOtrosIngresosUI.loginUI.LoginUI;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Proforma extends Generator {
    public static final String MODULO_PROFORMA = "Proforma";
    public static final String DEFAULT_REPORT_NAME = "reportePDF.pdf";
    private String operation;
    //--- These variables have the same name of columns defined on Excel file.
    protected String operacion;
    protected String detalleDeuda;
    protected String numeroTasa;
    protected String tipoTasa;
    protected String gestionInicio;
    protected String gestionFin;

    public Proforma(){
        super();
        this.accessExcel = new AccessExcel(ConstantsTOI.GENERATOR_DATA_FILE, ConstantsTOI.PROFORMA_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsTOI.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(this.getClass().getSimpleName().toUpperCase(), ConstantsTOI.SUBSYSTEM_ID);
    }
    public boolean searchIdentifier(ExtentTest extentTest){
        WaitUntilElement.isVisibleElement(this.driverApp, ProformaUI.txtIdentificador);
        Enter.text(this.driverApp, ProformaUI.txtIdentificador, this.numeroTasa);
        Click.on(this.driverApp, TasaType.tasaType.get(this.tipoTasa));
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, extentTest, Status.INFO, "Tasa seleccionada.");
        Click.on(this.driverApp, ProformaUI.btnBuscar);
        WaitUntilElement.isVisibleElementOr(this.driverApp, DeudaUI.ttlProforma, ValidacionesUI.ttlValidaciones);
        if(IsDisplayed.element(this.driverApp, ValidacionesUI.msgResultadoValidacion)){
            Log.recordInLog("No es posible obtener la proforma, restricción de validaciones.");
            return false;
        }
        return true;
    }
    public boolean isIntoRangeOfYears(int row){
        String year = this.driverApp.findElement(DeudaUI.getCell(row, 2)).getText();
        String yearAux;
        String[] parts = year.split("/");
        yearAux = parts[parts.length - 1];
        int intYear = yearAux.equals("") ? 0 : Integer.parseInt(yearAux);
        return intYear >= Integer.parseInt(this.gestionInicio) && intYear <= Integer.parseInt(this.gestionFin);
    }
    public boolean isDebtRequired(int row){
        String debtDetail = this.driverApp.findElement(DeudaUI.getCell(row, 3)).getText();
        if (this.detalleDeuda.equals(DebtType.all)){
            return true;
        }
        return debtDetail.contains(DebtType.debtType.get(this.detalleDeuda.concat(this.tipoTasa)));
    }
    public void checkDebt(int row, int column){
        int nro = Integer.parseInt(this.driverApp.findElement(DeudaUI.getCell(row, 1)).getText());
        //Click.on(this.driverApp, DeudaUI.getCell(row, column));
        WebElement chkBox= this.driverApp.findElement(DeudaUI.getCheckBox(nro - 1));
        Scroll.toElement(this.driverApp, chkBox);
        chkBox.click();
        WaitUntilElement.isSelected(this.driverApp, chkBox);
    }
    public int verifyDebtTable(){
        int nroDebtsChecked = 0;
        List<WebElement> rowsDeuda = this.driverApp.findElements(DeudaUI.rowsDebtTable);
        List<WebElement> headerDeuda = this.driverApp.findElements(DeudaUI.headerDebtTable);
        int nroRows = rowsDeuda.size();
        int nroColumns = headerDeuda.size();
        for (int i = 2; i <= nroRows; i++){
            if (isIntoRangeOfYears(i)){
                if (isDebtRequired(i)){
                    checkDebt(i, nroColumns);
                    nroDebtsChecked ++;
                }
            }
        }
        return nroDebtsChecked;
    }
    public void getProforma(){
        if (FileBuilder.moveFile(DEFAULT_REPORT_NAME)){
            FileBuilder.renameReport(DEFAULT_REPORT_NAME, this.operacion, this.detalleDeuda, this.numeroTasa, ConstantsTOI.SUBSYSTEM_ID, i + 1);
        }
    }
    public void runOperationWithoutCheckingDebtsTable(){
        Scroll.toElement(this.driverApp, OperationType.operationType.get(this.operacion));
        Click.on(this.driverApp, OperationType.operationType.get(this.operacion));
        if(WaitUntilAlert.isPresent(this.driverApp)){
            DisplayAlert.toAcept(this.driverApp);
            getProforma();
        }
        closeChildWindows(this.driverApp);
    }
    public void executeOperation(){
        if(!this.operacion.equals(OperationType.soloLiquidar)){
            if (this.tipoTasa.equals("IM") || this.tipoTasa.equals("TO")){
                runOperationWithoutCheckingDebtsTable();
            }
            else{
                List<WebElement> pages;
                int nroDebtsChecked = 0;
                try{
                    pages = this.driverApp.findElements(DeudaUI.paginador);
                }catch(NoSuchElementException noSuchElementException){
                    pages = new ArrayList<>();
                }
                int nroPages = pages.size() == 0 ? 1 : pages.size() / 2;
                String firstDebt = this.driverApp.findElement(DeudaUI.getCell(2,3 )).getText();
                boolean isThereOtherConcepts = false;
                for (String concept: DebtType.otherConcepts) {
                    if (firstDebt.contains(concept)){
                        runOperationWithoutCheckingDebtsTable();
                        isThereOtherConcepts = true;
                        break;
                    }
                }
                if(!isThereOtherConcepts){
                    if (nroPages > 1){
                        for (int p = 0 ; p < nroPages; p++){
                            pages.get(p).click();
                            nroDebtsChecked = nroDebtsChecked + verifyDebtTable();
                        }
                    }else{
                        nroDebtsChecked = nroDebtsChecked + verifyDebtTable();
                    }
                    if (nroDebtsChecked > 0){
                        Scroll.toElement(this.driverApp, OperationType.operationType.get(this.operacion));
                        Click.on(this.driverApp, OperationType.operationType.get(this.operacion));
                        closeChildWindows(this.driverApp);
                        getProforma();
                    }else {
                        Log.recordInLog("No hay coincidencia en tipo de deuda en el periodo especificado.");
                    }
                }
            }
        }
    }
    @Override
    public void start() {
        StartModule.loadProforma(this.driverApp, "Proforma");
        this.driverApp.switchTo().frame(CommonElementsUI.iframeContenido);
        if(searchIdentifier(test.get(i))){
            executeOperation();
        }
        this.driverApp.switchTo().defaultContent();
    }
    public void closeChildWindows(WebDriver driver){
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while(iterator.hasNext()){
            String ChildWindow = iterator.next();
            if(!mainWindowHandle.equalsIgnoreCase(ChildWindow)){
                driver.switchTo().window(ChildWindow);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindowHandle);
    }

    @Override
    public void returnMainMenu() {
        //this.driverApp.switchTo().defaultContent();
        Scroll.toTopPage(this.driverApp);
        WaitUntilElement.isVisibleElement(this.driverApp, CommonElementsUI.logoAplicacion);
        Click.on(this.driverApp, CommonElementsUI.logoAplicacion);
    }

    @Override
    public void login(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password) {
        LoginTasas.authenticate(driver, extentReports, extentTest, user, password);
    }

    @Override
    public void logout() {
        if(IsPresent.elements(driverApp, LoginUI.lnkMiCuenta)){
            Scroll.toTopPage(this.driverApp);
        }
        if (IsDisplayed.element(driverApp, LoginUI.lnkMiCuenta)){
            Click.on(driverApp, LoginUI.lnkMiCuenta);
            Click.on(driverApp, LoginUI.lnkCerrarSesion);
            Click.on(driverApp, LoginUI.btnSiModal, 1);
            //driverApp.manage().deleteAllCookies();
            driverApp.manage().deleteCookieNamed("JSESSIONID");
        }
    }

    @Override
    public String setTestCaseName() {
        return "Nro. de tasa ".concat(this.numeroTasa);
    }

    @Override
    public boolean isNotLoggedIn() {
        return false;
    }

    @Override
    public String getUser() {
        return ExcelData.getUser(ConstantsTOI.GENERATOR_DATA_FILE,this.accessExcel,i);
    }
}
