package main.tasks.inmuebles.empadronamiento;

import com.aventstack.extentreports.Status;
import main.actions.GiveFormat;
import main.actions.Log;
import main.helpers.common.Constants;
import main.helpers.common.Inmuebles.ConstantsINM;
import main.helpers.dataUtility.AccessExcel;
import main.helpers.dataUtility.ExcelData;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.inmuebles.commonInm.GetTaxpayers;
import main.tasks.inmuebles.commonInm.LoadModule;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.helpersInm.ChangeFrame;
import main.tasks.inmuebles.helpersInm.GeneratorINM;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.empadronamientoUI.*;
import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import main.ui.inmueblesUI.empadronamientoUI.inicioTramite.InicioTramiteDesUI;

import java.lang.reflect.Method;
import java.util.Map;

public class Empadronamiento extends GeneratorINM {
    protected String operacion;
    protected String numeroDocumento;
    protected String tipoDocumento;
    protected String condicionGestorTramite;
    protected String codigoCatastral;
    protected String tipoCodigoCatastral;
    protected String area;
    protected String claseInmueble;
    protected String inmuebleEnCondominio;
    protected String gestionTerreno;
    protected String superficieTerreno;
    protected String numeroConstrucciones;
    protected String cantidadContribuyentesNaturales;
    protected String cantidadContribuyentesJuridicos;
    protected String numeroAcciones;
    protected String cantidadRegistros;
    protected Map<String, String> buildClass = Map.of("PROPIEDAD HORIZONTAL", "registerPropiedadHorizontal",
                                                      "VIVIENDA UNIFAMILIAR", "registerViviendaUnifamiliar",
                                                      "TERRENO", "registerTerreno",
                                                      "PROPIEDAD AGRARIA", "registerPropiedadAgraria");

    public  Empadronamiento(){
        super();
        this.accessExcel = new AccessExcel(ConstantsINM.GENERATOR_DATA_FILE, ConstantsINM.EMPADRONAMIENTO_DATA_SHEET);
        this.url = ExcelData.getUrl(ConstantsINM.GENERATOR_DATA_FILE);
        FileBuilder.newDirectory(GiveFormat.ofTitle(this.getClass().getSimpleName()), ConstantsINM.SUBSYSTEM_ID);
    }
    @Override
    public String getIdentifier() {
        return MessagesINM.testIdentifierEmpadronamiento + this.numeroDocumento;
    }

    @Override
    public void execute() {
        try {
            int cantidad = convertStringToInt(this.cantidadRegistros);
            for (int cant = 1; cant <= cantidad; cant++){
                Log.recordInLog(Constants.DELIMITER_MARK);
                //LoadModule.fromMainMenu(this.driverApp, ConstantsINM.REGISTRO_TECNICO_GROUPER, ConstantsINM.EMPADRONAMIENTO_PROPIEDAD_UNICA_MODULE);
                LoadModule.fromMainMenu(this.driverApp, ConstantsINM.REGISTRO_TECNICO_GROUPER, this.operacion);
                ChangeFrame.toContentFrame(this.driverApp);
                Verify.elementIsReady(this.driverApp, test.get(i), InicioTramiteUI.ttlInicioTramite);
                if (this.municipio.equals("DESAGUADERO")){
                    IInicioTramiteUI objElements = InicioTramiteDesUI.getInstance();
                    ReceiveDocumentation.now(this.driverApp, objElements);
                    Verify.elementIsReady(this.driverApp, test.get(i), DefinicionInmuebleUI.ttlDefinicionInmueble);
                    EstateDefinition.asDes(this.driverApp, this.area, this.claseInmueble);
                }else{
                    IInicioTramiteUI objElements = InicioTramiteUI.getInstance();
                    ReceiveDocumentation.now(this.driverApp, test.get(i), objElements, this.numeroDocumento, this.tipoDocumento, this.condicionGestorTramite);
                    Verify.elementIsReady(this.driverApp, test.get(i), DefinicionInmuebleUI.ttlDefinicionInmueble);
                    EstateDefinition.as(this.driverApp, this.area, this.claseInmueble);
                }
                Verify.elementIsReady(this.driverApp, test.get(i), DatosAdicionalesUI.ttlDatosAdicionales);
                AdditionalData.fillDefaultData(this.driverApp, test.get(i));
                Verify.elementIsReady(this.driverApp, test.get(i), UbicacionInmuebleUI.ttlUbicacinInmueble);
                EstateLocation.defineRandomLocation(this.driverApp, test.get(i));
                Method registerBuild = this.getClass().getMethod(this.buildClass.get(this.claseInmueble));
                registerBuild.invoke(this);
                if (this.operacion.equalsIgnoreCase("Propiedad Única")){
                    Verify.elementIsReady(this.driverApp, test.get(i), AsignarContribuyenteUI.ttlAsignarContribuyente);
                    RegisterTaxPayer.now(this.driverApp, test.get(i), GetTaxpayers.ofTwoTypes(convertStringToInt(cantidadContribuyentesNaturales), convertStringToInt(cantidadContribuyentesJuridicos), this.municipio));
                }else {
                    Verify.elementIsReady(this.driverApp, test.get(i), DatosAccionistasUI.ttlDatosAccionistas);
                    RegisterShareholders.withSamePercentage(this.driverApp, test.get(i), GetTaxpayers.ofTwoTypes(convertStringToInt(numeroAcciones), convertStringToInt(cantidadContribuyentesJuridicos), this.municipio));
                }
                Verify.elementIsReady(this.driverApp, test.get(i), ConfirmarRegistroUI.ttlConfirmarRegistro);
                ConfirmRecord.now(this.driverApp);
                Verify.elementIsReady(this.driverApp, test.get(i), ConfirmarTramiteUI.ttlConfirmarTramite);
                ConfirmProcedure.toEmpadronamiento(this.driverApp, test.get(i), "reportePDF.pdf", "Empadronamiento", this.claseInmueble, i + 1);
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(this.driverApp, test.get(i), Status.INFO, "INFO");
                returnMainMenu();
            }
        }catch (Exception exception){

        }

    }
    //This method have a relation with buildClass variable (Map) to use reflection java
    public void registerViviendaUnifamiliar(){
        try{
            Verify.elementIsReady(this.driverApp, test.get(i), DatosTerrenoUI.ttlDatosTerreno);
            RegisterAreaData.now(this.driverApp, this.gestionTerreno, this.superficieTerreno, convertStringToInt(this.numeroConstrucciones));
            Verify.elementIsReady(this.driverApp, test.get(i), DatosConstruccionesUI.ttlDatosConstrucciones);
            RegisterBuildingsData.now(driverApp, test.get(i), convertStringToInt(this.numeroConstrucciones), this.gestionTerreno, this.superficieTerreno);
        }catch (Exception exception){

        }
    }
    //This method have a relation with buildClass variable (Map) to use reflection java
    public void registerTerreno(){
        try{
            Verify.elementIsReady(this.driverApp, test.get(i), DatosTerrenoUI.ttlDatosTerreno);
            RegisterAreaData.now(this.driverApp, this.gestionTerreno, this.superficieTerreno, 0);
        }catch (Exception exception){

        }
    }
    //This method have a relation with buildClass variable (Map) to use reflection java
    public void registerPropiedadAgraria(){
        try{
            Verify.elementIsReady(this.driverApp, test.get(i), DatosTerrenoUI.ttlDatosTerreno);
            RegisterAreaData.now(this.driverApp, this.gestionTerreno, this.superficieTerreno, convertStringToInt(this.numeroConstrucciones));
            if (convertStringToInt(this.numeroConstrucciones) > 0){
                Verify.elementIsReady(this.driverApp, test.get(i), DatosConstruccionesUI.ttlDatosConstrucciones);
                RegisterBuildingsData.now(driverApp, test.get(i), convertStringToInt(this.numeroConstrucciones), this.gestionTerreno, this.superficieTerreno);
            }
        }catch (Exception exception){

        }
    }
    //This method have a relation with buildClass variable (Map) to use reflection java
    public void registerPropiedadHorizontal(){
        try{
            Verify.elementIsReady(this.driverApp, test.get(i), DatosConstruccionesUI.ttlDatosConstrucciones);
            RegisterBuildingsData.now(driverApp, test.get(i), convertStringToInt(this.numeroConstrucciones), this.gestionTerreno, this.superficieTerreno);
        }catch (Exception exception){

        }
    }
    public static int convertStringToInt(String number){
        int nro;
        try{
            nro = Integer.parseInt(number);
        }catch (NumberFormatException numberFormatException){
            nro = 0;
        }
        return nro;
    }
}
