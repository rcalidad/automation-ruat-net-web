package main.tasks.inmuebles.commonInm;

import main.actions.GetText;
import main.helpers.common.DateUtility;
import main.tasks.inmuebles.helpersInm.ChangeFrame;
import main.ui.inmueblesUI.commonUI.CabeceraUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.Date;
import java.util.Map;

public class GetDate {
    public static Map<String, String> months = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("ENERO", "01"),
            new AbstractMap.SimpleEntry<>("FEBRERO", "02"),
            new AbstractMap.SimpleEntry<>("MARZO", "03"),
            new AbstractMap.SimpleEntry<>("ABRIL", "04"),
            new AbstractMap.SimpleEntry<>("MAYO", "05"),
            new AbstractMap.SimpleEntry<>("JUNIO", "06"),
            new AbstractMap.SimpleEntry<>("JULIO", "07"),
            new AbstractMap.SimpleEntry<>("AGOSTO", "08"),
            new AbstractMap.SimpleEntry<>("SEPTIEMBRE", "09"),
            new AbstractMap.SimpleEntry<>("OCTUBRE", "10"),
            new AbstractMap.SimpleEntry<>("NOVIEMBRE", "11"),
            new AbstractMap.SimpleEntry<>("DICIEMBRE", "12"));

    public static String ofHeader(WebDriver driver){ // format of literalDate "lunes 23 de enero de 2023"
        //ChangeFrame.toContentFrame(driver);
        WebElement date = driver.findElement(CabeceraUI.fecha);
        String f = date.getText();
        String[] literalDate = GetText.of(driver, CabeceraUI.fecha).split(" ");
        //ChangeFrame.toContentFrame(driver);
        String newDate = literalDate[1] +"/"+ months.get(literalDate[3].toUpperCase()) +"/"+ literalDate[5];
        try {
            Date d = new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
            String fechaNueva = new SimpleDateFormat("dd/MM/yyyy").format(d);
            return fechaNueva;
        }catch (Exception exception){
            return DateUtility.getCurrentDate();
        }
    }
}
