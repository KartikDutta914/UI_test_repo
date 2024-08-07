package Mypac2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class alertWithInputBox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Alert alertwindow=mywait.until(ExpectedConditions.alertIsPresent());
		alertwindow.sendKeys("Welcome to selenium");
		alertwindow.dismiss();
		String resultcheck = driver.findElement(By.xpath("//p[@id='result']")).getText();
		if(resultcheck.contains("Welcome to selenium")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Fail");
		}


	}

}
