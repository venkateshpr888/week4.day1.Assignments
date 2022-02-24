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

public class ExplicitWait_Appear {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/appear.html");
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement until = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn")));
		boolean displayed = until.isDisplayed();
		if (displayed==true) {
			System.out.println("Button Appeared");
		} else {
			System.out.println("Button Appeared");

		}
		System.out.println("Text in the Button = "+until.getText());
		File source = driver.getScreenshotAs(OutputType.FILE);
		File file = new File("./Snaps/img2.jpg");
		FileUtils.copyFile(source, file);
		
		
	}
	
	

}
