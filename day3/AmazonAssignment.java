package week3.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonAssignment {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 Process",Keys.ENTER);
		String firstmobileprice=driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Mobile price: "+firstmobileprice);
		String firstmobilerating=driver.findElement(By.xpath("//span[@class='a-icon-alt']")).getText();
		System.out.println("Customer Rating: "+firstmobilerating);
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		List<String> winhan = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winhan.get(1));
		File source = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snap/mobile.png");
		FileUtils.copyFile(source,des);
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.className("a-button-input")).click();
		String subtotal=driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		if(firstmobileprice.equals(subtotal))
		{
			System.out.println("price and subtotal are same");
		}
		else
		{
			System.out.println("price and subtotal are not same");
		}
		driver.quit();
	}

}
