package week4.day1.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait_TextChange {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement findElement = driver.findElement(By.xpath("//*[@id=\"btn\"]"));
    webDriverWait.until(ExpectedConditions.textToBePresentInElement(findElement, "Click ME!"));
    String text = driver.findElement(By.xpath("//*[@id=\"btn\"]")).getText();
    System.out.println("After wait button changed to "+text);
    driver.findElement(By.xpath("//*[@id=\"btn\"]")).click();
    Alert alert = driver.switchTo().alert();
    String text2 = alert.getText();
    System.out.println("Text in the Alert is "+text2);
    alert.accept();
    File source = driver.getScreenshotAs(OutputType.FILE);
	File file = new File("./Snaps/img3.jpg");
	FileUtils.copyFile(source, file);
	
	}

}
