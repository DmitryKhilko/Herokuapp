import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElementsTest extends BaseTest{

    @Test
    public void addRemoveElements(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement cmdAddElement = driver.findElement(By.xpath("//button[@onclick = 'addElement()']"));
        cmdAddElement.click();
        cmdAddElement.click();
        List<WebElement> cmdDelete = driver.findElements(By.xpath("//button[@onclick = 'deleteElement()']"));
        Assert.assertEquals(cmdDelete.size(),2,"Количество элементов не равно 2");

        cmdDelete.get(1).click();
        cmdDelete = driver.findElements(By.xpath("//button[@onclick = 'deleteElement()']"));
        Assert.assertEquals(cmdDelete.size(),1,"Количество элементов не равно 1");
    }
}
