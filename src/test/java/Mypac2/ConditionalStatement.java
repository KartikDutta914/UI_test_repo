package Mypac2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalStatement {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		// Logo validation using isDisplayed method-
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		boolean logoValidation = logo.isDisplayed();
		System.out.println("Logo is presenet: " + logoValidation);
		
		
		// isEnabled method -
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']")); 
		boolean checkSearchBox = searchBox.isDisplayed();
		System.out.println("The search box is enabled: " + checkSearchBox);
		
		// checking isSelected method on radio buttons-
		WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));
		//Checking before clicking any box
		boolean malebox = male.isSelected(); 
		System.out.println("The check box is selected: " + malebox); // false
		boolean femalebox = female.isSelected(); // false
		System.out.println("The check box is selected: " + femalebox); // false
		
		// After clicking male checkbox-
	    male.click();
	     malebox = male.isSelected(); 
	    System.out.println("The check box is selected: " + malebox); // true
		femalebox = female.isSelected();
		System.out.println("The check box is selected: " + femalebox); // false
		
		// After clicking female checkbox-
		female.click();
		malebox = male.isSelected(); 
		System.out.println("The check box is selected: " + malebox); // false
		femalebox = female.isSelected();
		System.out.println("The check box is selected: " + femalebox); // true
		

	}

}
