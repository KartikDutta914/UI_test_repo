package Mypac2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handleAlert {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		//Alert alertwindow = driver.switchTo().alert();  // This can cause syc. problem sometimes, so we will use Explicit Wait in this case
		
		Alert alertwindow=mywait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alertwindow.getText());
		//alertwindow.accept(); // this will close alert window using ok button
		  alertwindow.dismiss();  // close alert window by using cancel button
    
	}

}
