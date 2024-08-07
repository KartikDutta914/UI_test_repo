package Mypac2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
		Thread.sleep(5000);
		List<WebElement> drpdwnoptions = driver.findElements(By.xpath("//li[contains(@class,'sbct')]//div[@class='pcTkSc']"));
		for(WebElement option: drpdwnoptions) {
			System.out.println(option.getText());
			if(option.getText().equals("selenium tutorial")) {
				option.click();
				break;
				
			}
		}
		
	}

}
