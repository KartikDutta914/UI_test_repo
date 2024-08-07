package Mypac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class logintest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// launching URL
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		Thread.sleep(5000);
		
        // Locating user name and clearing it first, after that giving input
		WebElement emailbox= driver.findElement(By.id("Email"));
		emailbox.clear();
		emailbox.sendKeys("admin@yourstore.com");
		
		// Locating password and clearing it first, after that giving input
		WebElement passwordbox= driver.findElement(By.id("Password"));
		passwordbox.clear();
		//passwordbox.sendKeys("admin");  // Correct password
		passwordbox.sendKeys("admin123456788"); // giving wrong password
		
		// Clicking on Login
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		Thread.sleep(7000);
		
		
		// Validating label by handelling exception
		String act_title = "";
		try {
			 act_title = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText();
		}
		catch(NoSuchElementException e)
		{
			
		}
		
		String exp_title = "Dashboard";
		if(act_title.equals(exp_title))
			
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		
		// Finding total number of images in the page- we will use img tag to locate images since it is common for all images
		// total_images is a webelement variable of collection type which stores all the images
		List<WebElement> total_images = driver.findElements(By.tagName("img")); 
		                                                                        
		System.out.println(total_images.size()); // size() method will give total number of images 
		
		
		// Finding total number of links in the page - all links have <a> tag common, so we will use this tag
		List<WebElement> tot_link = driver.findElements(By.tagName("a"));
		System.out.println(tot_link.size());
		
		
		/* Normally we use these locators in selenium- 
		 * ID, name, linkTexr or PartialLinktext , Class name, TagName
		 */
	}

}
