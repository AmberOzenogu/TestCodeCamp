import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {

        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //open your chrome browser
        driver = new ChromeDriver();

        //input your Selenium Demo Page URL
        driver.get("https://selenium-blog.herokuapp.com");
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);

        //maximize the browser
        driver.manage().window().maximize();
    }

    @Test (priority = 0)
    public void signupPage() throws InterruptedException {
        //click on Signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Signup page");
        else
            //Fail
            System.out.println("Wrong Signup page");
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void positiveSignup() throws InterruptedException {
        //input your username on username field
        driver.findElement(By.id("user_username")).sendKeys("Zryan12");

        //input email address on email field
        driver.findElement(By.id("user_email")).sendKeys("zryan12@gmail.com");

        //input your password on password field
        driver.findElement(By.id("user_password")).sendKeys("zryann23");

        //click on the signup button
        driver.findElement(By.id("submit")).click();
        String expectedPageTitle = "AlphaBlog";
        String actualPageTitle = driver.getTitle();
        if(actualPageTitle.contains(expectedPageTitle))
            //Pass
            System.out.println("Signup Successful");
        else
            //Fail
            System.out.println("Signup Unsuccessful");
        Thread.sleep(5000);
    }
    @Test (priority = 2)
    public void user1Item() throws InterruptedException {
        //click on User1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct User1 page");
        else
            //Fail
            System.out.println("Wrong User1 page");
        Thread.sleep(10000);
    }
    @Test (priority = 3)
    public void verifyItem() throws InterruptedException {
        //search for an item (12345Using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[35]/div/div/div[1]/a")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/articles/48";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Python page");
        else
            //Fail
            System.out.println("Wrong Python page");
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void logOut() {
        //click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("User was logged out successfully");
        else
            //Fail
            System.out.println("User was not logged out successfully");
    }

    @Test (priority = 5)
    public void SignupWithInvalidUsername() throws InterruptedException {
        //click on Signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        //input your username on username field
        driver.findElement(By.id("user_username")).sendKeys("Ja");

        //input email address on email field
        driver.findElement(By.id("user_email")).sendKeys("jane12min@gmail.com");

        //input your password on password field
        driver.findElement(By.id("user_password")).sendKeys("Jane123");

        //click on the signup button
        driver.findElement(By.id("submit")).click();
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users"))
            //Pass
            System.out.println("User was not signed up successfully");
        else
            //Fail
            System.out.println("User signed up successfully");
        Thread.sleep(3000);
    }

    @Test (priority = 6)
    public void SignupWithInvalidEmail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);

        //input your username on username field
        driver.findElement(By.id("user_username")).sendKeys("jusstce");

        //input email address on email field
        driver.findElement(By.id("user_email")).sendKeys("jomuegmail");

        //input your password on password field
        driver.findElement(By.id("user_password")).sendKeys("Just123");

        //click on the signup button
        driver.findElement(By.id("submit")).click();
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/signup"))
            //Pass
            System.out.println("User was not signed up successfully");
        else
            //Fail
            System.out.println("User signed up successfully");
        Thread.sleep(3000);
    }

    @Test (priority = 7)
    public void SignupWithRegisteredEmail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);

        //input your username on username field
        driver.findElement(By.id("user_username")).sendKeys("Annasue");

        //input email address on email field
        driver.findElement(By.id("user_email")).sendKeys("jomuee1245@gmail.com");

        //input your password on password field
        driver.findElement(By.id("user_password")).sendKeys("Anna123");

        //click on the signup button
        driver.findElement(By.id("submit")).click();
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users"))
            //Pass
            System.out.println("User was not signed up successfully");
        else
            //Fail
            System.out.println("User signed up successfully");
        Thread.sleep(3000);
    }

    @Test (priority = 8)
    public void SignupWithInvalidPassword() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);

        //input your username on username field
        driver.findElement(By.id("user_username")).sendKeys("kibannas5");

        //input email address on email field
        driver.findElement(By.id("user_email")).sendKeys("kibannas5@gmail.com");

        //input your password on password field
        driver.findElement(By.id("user_password")).sendKeys("");

        //click on the signup button
        driver.findElement(By.id("submit")).click();
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users"))
            //Pass
            System.out.println("User was not signed up successfully");
        else
            //Fail
            System.out.println("User signed up successfully");
        Thread.sleep(3000);
    }

    @Test (priority = 9)
    public void SignupWithAllFieldsEmpty() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);

        //input your username on username field
        driver.findElement(By.id("user_username")).sendKeys("");

        //input email address on email field
        driver.findElement(By.id("user_email")).sendKeys("");

        //input your password on password field
        driver.findElement(By.id("user_password")).sendKeys("");

        //click on the signup button
        driver.findElement(By.id("submit")).click();
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users"))
            //Pass
            System.out.println("User was not signed up successfully");
        else
            //Fail
            System.out.println("User signed up successfully");
        Thread.sleep(3000);
    }

    @AfterTest
    public void closeBrowser() {
        //quit the browser
        driver.quit();
    }
}