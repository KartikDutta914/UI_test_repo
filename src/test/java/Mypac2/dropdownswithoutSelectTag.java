package Mypac2;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdownswithoutSelectTag {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click(); 
		
		List<WebElement> getOptions = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		
		System.out.println("Total number of option is "+ getOptions.size());
		for(WebElement option: getOptions) {
			System.out.println(option.getText());
			if(option.getText().equals("Java") || option.getText().equals("Python")){
				option.click();
				
			}
		}
		

	}

}
