package week4.day1.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortTable {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/sorttable.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement table = driver.findElement(By.id("table_id"));
		List<WebElement> tabrow = table.findElements(By.tagName("tr"));
	//	System.out.println(tabrow.size());
List<WebElement> column = tabrow.get(1).findElements(By.tagName("td"));
//System.out.println(column.size());
ArrayList<String> arrayList = new ArrayList<String>();
System.out.println("Before clicking ");
for (int i = 1; i < tabrow.size(); i++) {
	List<WebElement> currColumn = tabrow.get(i).findElements(By.tagName("td"));
	String text = currColumn.get(1).getText();
	System.out.println(text);
	arrayList.add(text);
}
Collections.sort(arrayList);
System.out.println("After sorting = "+arrayList);	
driver.findElement(By.xpath("//*[@id=\"table_id\"]/thead/tr/th[2]")).click();
ArrayList<String> arrayList1 = new ArrayList<String>();
System.out.println("After clicking ");
Thread.sleep(3000);
for (int j = 1; j < tabrow.size(); j++) {
	List<WebElement> currColumn1 = tabrow.get(j).findElements(By.tagName("td"));
	String text1 = currColumn1.get(1).getText();
	System.out.println(text1);
	arrayList1.add(text1);
	}
if (arrayList.equals(arrayList1)) {
	System.out.println("Column under Name header Sorted");
} else {
	System.out.println("Column under Name header NOT Sorted");

}
File source = driver.getScreenshotAs(OutputType.FILE);
File file = new File("./Snaps/sortedTable.jpg");
FileUtils.copyFile(source, file);

	}
	}
