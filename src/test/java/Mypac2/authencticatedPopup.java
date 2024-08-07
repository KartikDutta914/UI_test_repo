package Mypac2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class authencticatedPopup {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
				
		//https://the-internet.herokuapp.com/javascript_alerts - is normal url
		//https://admin:admin@the-internet.herokuapp.com/javascript_alerts -- this will give username and password to the pop up
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		//String text = driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText();		
		String text = driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText();
		if(text.contains("Congratulations"))
		{
			System.out.println("successful login");
		}
		else
		{
			System.out.println("login failed");
		}
		}


	}


