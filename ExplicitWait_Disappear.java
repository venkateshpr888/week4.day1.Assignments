package week4.day1.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait_Disappear {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/disapper.html");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Boolean until = webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("btn")));
	
	if(until==true)
	{
		System.out.println("button disappeared"
				+ " \n+"+"learned explicit wait in disappear");
	}
	else
	{
		System.out.println("button NOT disappeared");
	}
	File source = driver.getScreenshotAs(OutputType.FILE);
	File file = new File("./Snaps/img1.jpg");
	FileUtils.copyFile(source, file);
}
}
