package java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class SeleniumTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private String testName;
    private String password;

    public SeleniumTest(String testName, String password) {
        this.testName = testName;
        this.password = password;
    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\admin\\Documents\\tju\\software test\\实验报告\\第二次实验\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://103.120.226.190/selenium-demo/git-repo";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        Object[][] obj = new Object[2][];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C://Users//admin//Documents//tju//software test//实验报告//第二次实验//Selenium+Lab2020.csv"));
            reader.readLine();
            String line;
            int count = 0;
//            while ((line = reader.readLine()) != null) {
//                String item[] = line.split(",");
//                String stuNum = item[0];
//                String password = item[1];
//                obj[count] = new Object[]{stuNum, password};
//                count++;
//            }
            for(int i=0;i<20;i++){
                line = reader.readLine();
                String item[] = line.split(",");
                String stuNum = item[0];
                String password = item[1];
                obj[count] = new Object[]{stuNum, password};
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Arrays.asList(obj);
    }

    @Test
    public void testMain() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("user_number")).clear();
        driver.findElement(By.name("user_number")).sendKeys(testName);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        assertEquals(this.password, driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code")).getText());
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}