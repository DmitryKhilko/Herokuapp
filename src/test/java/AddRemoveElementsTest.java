import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElementsTest extends BaseTest {
    String cmdAddElementLocator = "//button[@onclick = 'addElement()']";
    String cmdDeleteLocator = "//button[@onclick = 'deleteElement()']";

    @Test
    public void addRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement cmdAddElement = driver.findElement(By.xpath(cmdAddElementLocator));
        cmdAddElement.click();
        cmdAddElement.click();
        List<WebElement> cmdDelete = driver.findElements(By.xpath(cmdDeleteLocator));
        Assert.assertEquals(cmdDelete.size(), 2, "Количество элементов не равно 2");

        cmdDelete.get(1).click();
        cmdDelete = driver.findElements(By.xpath(cmdDeleteLocator));
        Assert.assertEquals(cmdDelete.size(), 1, "Количество элементов не равно 1");
    }
}
