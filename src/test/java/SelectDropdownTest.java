import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDropdownTest extends BaseTest {
    @Test
    public void selectDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id = 'dropdown']")));

        //Не понимаю, как выполнить: "Взять все элементы дроп-дауна и проверить их наличие"

        dropDown.selectByVisibleText("Option 1");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"Option 1", "Не выбрано значение 'Option 1'");

        dropDown.selectByVisibleText("Option 2");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"Option 2", "Не выбрано значение 'Option 2'");

    }
}
