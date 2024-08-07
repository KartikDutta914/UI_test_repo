package Mypac2;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handelPaginationTables {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php");
		Thread.sleep(20);
		
		//Login
		WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(30000);
		
		//driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		/*if(driver.findElement(By.xpath("//span[normalize-space()='Verify you are human']")).isDisplayed()) {
			Thread.sleep(10);
			driver.findElement(By.xpath("//label[@class='ctp-checkbox-label']//input[@type='checkbox']")).click();
		}
		else {
			
		}*/
		
		if(driver.findElement(By.xpath("//button[@id='button-admin']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		
		
		// Click on Customers-> customers table
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		//Capture the total number of pages
		String text=  driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		int totalpages = Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Page")-1));
		
		
		// Now clicking on pages--
		for(int p=2;p<=5; p++) {
			
			if(totalpages>1) {
				/*WebElement Activepage =*/  driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+p+"]")).click();
				
				//System.out.println("Active Page: "+ Activepage.getText());
				//Activepage.click();
				Thread.sleep(2000);
			}
			
			
			int rows =  driver.findElements(By.xpath("//div[@id='customer']//tbody//tr")).size();
			int columns =  driver.findElements(By.xpath("//div[@id='customer']//thead//td[contains(@class,'text-start')]")).size();
			for(int i=1;i<= rows; i++) {
				for(int j=1; j<=columns; j++) {
					WebElement data =  driver.findElement(By.xpath("//div[@id='customer']//tbody//tr["+i+"]//td["+j+"]"));
					System.out.println(data);
				}
				
			}
			
		}
		

	}

}
