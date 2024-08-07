package Mypac2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkoxes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3.org/WAI/ARIA/apg/patterns/checkbox/examples/checkbox-mixed/");
		
		// Selecting one specific checkbox
		driver.findElement(By.xpath("//input[@id='cond1']")).click();
		
		// Selecting all checkboxes
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']")); // getting all the checkbox elements in a list container using findElements
		System.out.println(checkBoxes.size()); // printing total number of checkbox elements
		
		/*for(int i =0; i<checkBoxes.size(); i++) {
			checkBox.get(i).click();
		}*/
		
		
		// Using enhanced for loop doing same
		/*for(WebElement check:checkBoxes)
		{
			if(!check.isSelected()) {
				check.click();
				
			}
			
			
		}*/
		
		
		
		
		//Selecting two values from last
		// Formula: starting index = Total number of index - number of checkboxes u want to select from last
		// Ex: suppose I want to access last 3 checkboxes out of 5 checkboxes then: 5-3 = 2 is the starting index
		for(int i = 2; i<checkBoxes.size();i++) {
			checkBoxes.get(i).click();
		}
		
		
	}

}
