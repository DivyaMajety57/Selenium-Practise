import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AddingCourseAssignment {

    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();

        driver.get("https://ineuron-courses.vercel.app/login");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        driver.findElement(By.id("email1")).sendKeys("ineuron@ineuron.ai");
        driver.findElement(By.id("password1")).sendKeys("ineuron");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

        //Thread.sleep(5000);

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);



        // Mouse Hover
        Actions action = new Actions(driver);

        WebElement menu = driver.findElement(By.xpath("//span[text()='Manage']"));

        action.moveToElement(menu).perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Manage Courses']")).click();

        WebElement element = driver.findElement(By.xpath("//a[text()='Practise']"));

        action.moveToElement(element).perform();

        System.out.println("Mouse Hover successfull");

        Thread.sleep(2000);


        driver.findElement(By.xpath("//button[text()='Add New Course ']")).click();


        System.out.println("Button clicked successfull");

        //file upload

        WebElement browse = driver.findElement(By.xpath("//input[@id='thumbnail']"));
        //click on ‘Choose file’ to upload the desired file
        browse.sendKeys("/Users/brahmajigaruda/Desktop/pic.png"); //Uploading the file using sendKeys
        System.out.println("File is Uploaded Successfully");

        driver.findElement(By.id("name")).sendKeys("selenium");
        driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Complete selenium course");
        driver.findElement(By.id("instructorNameId")).sendKeys("Mukesh");
        driver.findElement(By.id("price")).sendKeys("8000");
        driver.findElement(By.xpath("//div[text()='Select Category']")).click();
        driver.findElement(By.xpath("//button[text()='Testing']")).click();

        Thread.sleep(5000);
        System.out.println("after sleep");

        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(By.xpath("//button[text()='Save']"));
        je.executeScript("arguments[0].scrollIntoView(true);",button);
        button.click();





    }
}
