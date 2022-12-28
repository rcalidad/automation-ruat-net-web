package main.tasks.actividadesEconomicas.liquidacion;

import main.actions.*;
import main.helpers.common.Constants;
import main.helpers.common.actividadesEconomicas.ConstantsAEC;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.actividadesEconomicas.commonAEC.SearchActivity;
import main.tasks.actividadesEconomicas.commonAEC.SelectDebtsAEC;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.tasks.actividadesEconomicas.helpersAEC.ChangeFrame;
import main.tasks.actividadesEconomicas.helpersAEC.GeneratorAEC;
import main.tasks.actividadesEconomicas.menu.LeftMenu;
import main.tasks.actividadesEconomicas.menu.MainMenu;
import main.ui.actividadesEconomicasUI.commonUI.NotificationsUI;
import main.ui.actividadesEconomicasUI.liquidacionUI.DeudaUI;

public class Proforma extends GeneratorAEC {
    public static final String DEFAULT_REPORT_NAME = "reportePDF.pdf";
    //--- These variables have the same name of columns defined on Excel file.
    protected String operacion;
    protected String detalleDeuda;
    protected String numeroActividadEconomica;
    protected String gestionInicio;
    protected String gestionFin;

    public Proforma(){
        super();
        this.accessExcel = new AccessExcel(ConstantsAEC.GENERATOR_DATA_FILE, ConstantsAEC.PROFORMA_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsAEC.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(this.getClass().getSimpleName().toUpperCase(), ConstantsAEC.SUBSYSTEM_ID);
    }
    @Override
    public String getIdentifier() {
        return numeroActividadEconomica;
    }

    @Override
    public void execute() {
        try {
            Log.recordInLog(Constants.DELIMITER_MARK);
            MainMenu.selectOption(this.driverApp, ConstantsAEC.PROFORMA_GROUPER);
            ChangeFrame.toLeftMenuFromParentFrame(this.driverApp);
            LeftMenu.goTo(this.driverApp, ConstantsAEC.PROFORMA_MODULE);
            ChangeFrame.toContentFromAnotherFrame(this.driverApp);
            SearchActivity.byActivityNumber(this.driverApp, this.numeroActividadEconomica);
            Verify.isReady(this.driverApp, test.get(i), DeudaUI.ttlDetalleDeudas);
            if (!this.operacion.equals("SOLO LIQUIDAR")){
                SelectDebtsAEC.ofActivity(this.driverApp, test.get(i), this.gestionInicio, this.gestionFin, this.detalleDeuda, ConstantsAEC.RUBRO);
                print();
                if (WaitUntilAlert.isPresent(this.driverApp)){
                    String message = DisplayAlert.getText(this.driverApp);
                    if (message.contains("No se ha seleccionado")){
                        DisplayAlert.cancel(this.driverApp);
                    }
                }
                Verify.isReady(this.driverApp, test.get(i), NotificationsUI.ttlNotificacionesPostProforma);
                FileBuilder.moveAndRenameFile(DEFAULT_REPORT_NAME, GiveFormat.ofReportName(this.operacion), this.detalleDeuda, this.numeroActividadEconomica, ConstantsAEC.SUBSYSTEM_ID, i + 1);
            }

        }catch (Exception exception){

        }
    }
    public void print(){
        switch (this.operacion){
            case "PROFORMA DETALLADA":
                Click.on(this.driverApp, DeudaUI.btnProformaDetallada);
                break;
            case "PROFORMA RESUMIDA":
                Click.on(this.driverApp, DeudaUI.proformaResumidaButton);
                break;
            default:
                break;
        }
    }
}
