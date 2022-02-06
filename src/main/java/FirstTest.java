import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test
    public void checkMobilePayment() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://next.privat24.ua/mobile");

        /**
         *
         * Объявление переменных
         *
         * */

        By phone = By.xpath("//input[@data-qa-node='phone-number']");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        By cardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By name = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By surname = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        By submit = By.xpath("//button[@data-qa-node='submit']");
        By cardNumberFrom = By.xpath("//td[@data-qa-node='card']");

        /**
         *
         * Тестовый сценарий: заполнение тестовыми данными
         *
         * */

        driver.findElement(phone).sendKeys("973486294");
        driver.findElement(amount).sendKeys("50");
        driver.findElement(cardFrom).sendKeys("4558032855841715");
        driver.findElement(expDate).sendKeys("0223");
        driver.findElement(cvv).sendKeys("902");
        Thread.sleep(2000);
        driver.findElement(name).sendKeys("Luis");
        driver.findElement(surname).sendKeys("Myers");
        driver.findElement(submit).click();

        /**
         *
         * проверка данных на странице корзина
         *
         * */
        By payAmount = By.xpath("//div[@data-qa-node='amount']");
        System.out.println(driver.findElement(payAmount).getText());

        By commission = By.xpath("//span[@data-qa-node='commission']");
        System.out.print(driver.findElement(commission).getText());

        By commissionCurrency = By.xpath("//span[@data-qa-node='commission-currency']");
        System.out.println(driver.findElement(commissionCurrency).getText());

        By purpose = By.xpath("//div[@data-qa-node='details']");
        System.out.println(driver.findElement(purpose).getText());

        By payee = By.xpath("//span[@data-qa-node='nameB']");
        System.out.println(driver.findElement(payee).getText());

        Assert.assertEquals("4558 **** **** 1715", driver.findElement(cardNumberFrom).getText());
        Assert.assertEquals("50 UAH", driver.findElement(payAmount).getText());
        Assert.assertEquals("2", driver.findElement(commission).getText());
        Assert.assertEquals(" UAH", driver.findElement(commissionCurrency).getText());
        Assert.assertEquals("Поповнення телефону. На номер +380973486294", driver.findElement(purpose).getText());
        Assert.assertEquals("Kyivstar Ukraine", driver.findElement(payee).getText());

    }

}
