package Mypac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		/*driver.get("http://automationpractice.com/index.php");  // 1st URL
		Thread.sleep(5000);
		
		
				
		//search box
		driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");
		
		//search button
		driver.findElement(By.name("submit_search")).click();
		
		//link text & partial linktext
		driver.findElement(By.linkText("Printed Chiffon Dress")).click();
		//driver.findElement(By.partialLinkText("Printed Chiffon")).click();
		*/
		
		
		
		//2nd URL : 
		driver.get("https:demo.nopcommerce.com");
	    driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Macbook"); //with cssSelector: tag and id
	    
	    driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Macbook"); // with tag and class
	    
	    driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Macbook"); // with tag and attribute
	    
	    driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("Macbook"); // with tag, class and attribute
		
		

	}

}
