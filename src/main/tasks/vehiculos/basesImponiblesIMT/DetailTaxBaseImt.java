package main.tasks.vehiculos.basesImponiblesIMT;

import main.actions.Click;
import main.actions.GetText;
import main.ui.vehiculosUI.basesImponiblesImtUI.DetailTaxBasesImtUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DetailTaxBaseImt {
    public static String getDate(WebDriver driver){
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public static boolean selectOption(WebDriver driver, String option){
        List<WebElement> columns = driver.findElements(DetailTaxBasesImtUI.getColumnsOfDetalleBaseImponibleImtRows(2));
        String availableLink = GetText.of(driver, DetailTaxBasesImtUI.getCellDetalleBaseImponible(2, columns.size()));
        if (availableLink.equals(option)){
            Click.on(driver, DetailTaxBasesImtUI.getCellDetalleBaseImponible(2, columns.size()));
            return true;
        }
        return false;
    }
}
