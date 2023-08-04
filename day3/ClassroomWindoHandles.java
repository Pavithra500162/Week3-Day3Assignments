package week3.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClassroomWindoHandles {

	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions(); 
		opt.addArguments("--disable-notifications"); 
		ChromeDriver driver = new ChromeDriver(opt); 
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		Set<String> closewind=driver.getWindowHandles();
		List<String> clewin= new ArrayList<String>(closewind);
		driver.switchTo().window(clewin.get(1));
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		driver.switchTo().window(clewin.get(0));
		driver.close();
		driver.quit();
	}

}
