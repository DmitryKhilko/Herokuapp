import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyInputsFieldTest extends BaseTest{

    @Test
    public void VerifyInputs10() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputsField = driver.findElement(By.xpath("//input[@type = 'number']"));
        for(int i = 0; i < 10; i++){
            inputsField.sendKeys(Keys.ARROW_UP);
        }
        Assert.assertEquals(inputsField.getAttribute("value"), "10", "В поле ввода не введена цифра 10");
    }

    @Test
    public void VerifyInputs3() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputsField = driver.findElement(By.xpath("//input[@type = 'number']"));
        inputsField.sendKeys("10");
        for(int i = 0; i < 7; i++){
            inputsField.sendKeys(Keys.ARROW_DOWN);
        }
        Assert.assertEquals(inputsField.getAttribute("value"), "3", "В поле ввода не введена цифра 3");
    }

    //Негативный тест
    @Test
    public void VerifyInputsLetters() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputsField = driver.findElement(By.xpath("//input[@type = 'number']"));
        inputsField.sendKeys("Проверка ввода");
        Assert.assertEquals(inputsField.getAttribute("value"), "Проверка ввода", "В поле ввода не введена фраза 'Проверка ввода'");
    }
}
