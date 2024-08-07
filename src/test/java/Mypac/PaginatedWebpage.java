package Mypac;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
public class PaginatedWebpage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.seleniumeasy.com/table-pagination-demo.html");
		
		
		
		for(int p=0; p<3;p++) {
			driver.findElement(By.xpath("//a[normalize-space()="+(p+1)+"]")).click();
			Thread.sleep(3000);
		for(int r=1;r<5;r++) {
			
			for(int c=1; c<8;c++) {
				String content = driver.findElement(By.xpath("//div[@class='table-responsive']//tr["+r+"]//td["+c+"]")).getText();
				
				System.out.print(content + "     ");
			}
			System.out.println();
		}


	}

}
}
