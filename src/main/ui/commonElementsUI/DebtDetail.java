package main.ui.commonElementsUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface DebtDetail {
    public By getRow();
    public By getHeader();
    public By getCell(int i, int j);
}
