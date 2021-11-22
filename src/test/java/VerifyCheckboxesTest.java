import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VerifyCheckboxesTest extends BaseTest {

    @Test
    public void verifyCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
        Assert.assertFalse(checkBoxes.get(0).isSelected(), "Первый чекбокс установлен");

        if (!checkBoxes.get(0).isSelected()) {
            checkBoxes.get(0).click();
            Assert.assertTrue(checkBoxes.get(0).isSelected(), "Первый чекбокс не установлен");
        }

        Assert.assertTrue(checkBoxes.get(1).isSelected(), "Второй чекбокс не установлен");

        if (checkBoxes.get(1).isSelected()) {
            checkBoxes.get(1).click();
            Assert.assertFalse(checkBoxes.get(1).isSelected(), "Первый чекбокс установлен");
        }
    }
}
