package Mypac2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		WebElement frame4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		
		//Switching to frame1:
		 driver.switchTo().frame(frame1);		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("First Frame");
		driver.switchTo().defaultContent();
		
		
		//Switch To frame2
		driver.switchTo().frame(frame2);	
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Second Frame");
		driver.switchTo().defaultContent();
		
		//Switch to frame3
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Third Frame");
		
		// switching to inner iframe inside frame3
		driver.switchTo().frame(0); // since in frame 3 we only have one iframe so we can use index to locate this, no need to use other attributes
		driver.findElement(By.xpath("//div[@class='o3Dpx']//div[@class='AB7Lab Id5V1']")).click();
		driver.findElement(By.xpath("//div[@class='Y6Myld']//div[@class='uHMk6b fsHoPb']")).click();
		driver.findElement(By.xpath("//span[@class='vRMGwf oJeWuf']")).click();
		List<WebElement> dropdownoptions =  driver.findElements(By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']//span"));
		for(WebElement opts: dropdownoptions) {
			System.out.println(opts.getText());
			if(opts.getText().contains("Well")) {
				opts.click();
				
			}
		}
		
		
		WebElement NextButton = driver.findElement(By.xpath("//span[normalize-space()='Next']"));
		NextButton.click();
		Thread.sleep(5);
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("Hi, I am writing short note");
		driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']")).sendKeys("Hi, I am Kartik Dutta and I am writing long note");
		driver.findElement(By.xpath("//span[normalize-space()='Submit']")).click();
		String heading = driver.findElement(By.cssSelector("div.pdLVYe")).getText();
		if(heading.contains("Form Filling Demo Page")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test failed");
		}
		
		
		

	}

}
