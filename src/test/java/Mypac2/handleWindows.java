package Mypac2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		
		// Capture the window IDs which would be a set 
		Set<String> windowIDs =  driver.getWindowHandles();
		
		
		/*//Approach 1: Using List
		//Now we have to change the set to list to use indexing on the windoe ids
	    List <String>windowidsList=new ArrayList(windowIDs);
	    String parentwindowid=  windowidsList.get(0);
	    String childwindowid = windowidsList.get(1);	
	    
		driver.switchTo().window(childwindowid);
		Thread.sleep(5);
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[2]//a[1]")).click();
		driver.switchTo().window(parentwindowid);*/
		
		
		//Approach 2: using loop
		/*for(String winid: windowIDs) {
			String title=driver.switchTo().window(winid).getTitle();
			if(title.equals("Human Resources Management Software | OrangeHRM")) {
				System.out.println("Second Window"); */
		
		
		//Closing specific window-
		for(String winid: windowIDs) {
			String title=driver.switchTo().window(winid).getTitle();
			if(title.equals("Human Resources Management Software | OrangeHRM")) {
				driver.close();
				
			}
		}

	}

}
