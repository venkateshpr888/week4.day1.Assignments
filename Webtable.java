package week4.day1.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ReferenceForm;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Array;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Webtable {
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement table = driver.findElement(By.id("table_id"));
		List<WebElement> tabrow = table.findElements(By.tagName("tr"));
		int rowsize = tabrow.size();
		System.out.println("number of rows = "+rowsize);
		List<WebElement> column = tabrow.get(1).findElements(By.tagName("td"));
		int columnsize = column.size();
		System.out.println("number of columns = "+columnsize);
		List<WebElement> per = table.findElements(By.xpath("//*[@id=\"table_id\"]/tbody/tr[2]/td[2]"));
//ArrayList<String> arrayList = new ArrayList<String>();
//	for (int k =1; k <tabrow.size(); k++) {
//		//System.out.println(r1.getText());
//		List<WebElement> currcolumn = tabrow.get(k).findElements(By.tagName("td"));
//		String text2 = currcolumn.get(1).getText();
//	String replace = text2.replace("%","");
//	arrayList.add(replace);
//	}
//		Collections.sort(arrayList);
//		System.out.println(arrayList);
		for (int i =1; i <tabrow.size(); i++) {
			WebElement curRow = tabrow.get(i);
			for (int j = 0; j <column.size(); j++) {
				List<WebElement> curColumn= curRow.findElements(By.tagName("td"));
			if (curColumn.get(j).getText().contains("Learn to interact with Elements")) {
					System.out.println("Progress value of learn to intract with Elements is = "+curColumn.get(1).getText());
		
			}
			}
		
		}
		
		driver.findElement(By.xpath("//*[@id=\"table_id\"]/tbody/tr[4]/td[3]/input")).click();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File file = new File("./Snaps/webTable.jpg");
		FileUtils.copyFile(source, file);
		}
	
	
	}
	
		

