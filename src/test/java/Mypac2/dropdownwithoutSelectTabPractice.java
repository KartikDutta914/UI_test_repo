package Mypac2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdownwithoutSelectTabPractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.findElement(By.xpath("//select[@id='country-list']")).click();
		
		List<WebElement> getCountries = driver.findElements(By.xpath("//select[@name='country']//option"));
		System.out.println("Total number of states: " + getCountries.size() );
		
		// Selecting value from the list
		for(int i=0;i<getCountries.size();i++){
			System.out.println(getCountries.get(i).getText());
			if(getCountries.get(i).getText().equals("India")) {
				getCountries.get(i).click();
			}
		}
		

	}

}
