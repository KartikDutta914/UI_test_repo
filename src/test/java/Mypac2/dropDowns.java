package Mypac2;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDowns {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='country-list']"));
		Select countrydropdown = new Select(dropdown);
		
		// Selecting France from the dropdown
		countrydropdown.selectByVisibleText("France");
		
		// Getting all the options in the dropdown-
		List<WebElement> options = countrydropdown.getOptions();
		System.out.println(options.size());
		for(int i=0; i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
		
		
		//Selecting an option from the dropdown
				//drpCountry.selectByVisibleText("USA");
				 //drpCountry.selectByValue("4"); // use this only if value attribute is present for option tag
				//drpCountry.selectByIndex(3); //France
		
		// Total number of options
		List<WebElement> totalOptions= countrydropdown.getOptions();
		System.out.println("total number of options:"+totalOptions.size());
		
		

	}

}
