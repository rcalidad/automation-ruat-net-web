package main.tasks.commonTasks;

import main.actions.GetText;
import main.helpers.common.DateUtility;
import main.ui.inmueblesUI.commonUI.CabeceraUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
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

    public static String ofSystem(WebDriver driver, By locator){
        String[] literalDate = GetText.of(driver, locator).split(" ");
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
