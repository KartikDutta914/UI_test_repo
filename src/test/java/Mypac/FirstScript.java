package Mypac;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstScript {
	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();;
		
		// (1) launching chrome browser
		WebDriver driver = new ChromeDriver();
		
		
		//(2) open url
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().window().maximize(); // Will maximize the browser window
		
		Thread.sleep(5000); // will wait for 5 sec after entering url
		
		//(3)Enter Username 
		driver.findElement(By.name("username")).sendKeys("Admin"); //Locating Username by name attribute and then sending value as Admin
		
		//(4) Enter Password
		//driver.findElement(By.name("password")).sendKeys("admin123"); // Correct Password
		driver.findElement(By.name("password")).sendKeys("admin");  // Passing wrong password
		
		//(5) Clicking Login button - locating it by xpath
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(5000);
		
		//(6) Validating the dashboard Title as "OrangeHRM"
		/*String act_title = driver.getTitle();
		String exp_title = "OrangeHRM";
		if(act_title.equals(exp_title)) {
			System.out.println("test passed");
		}
		else
		{
			System.out.println("Test failed");
		} */
		
		/*(7) Validating Label 
		String act_label = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		String exp_label = "Dashboard";
		if(act_label.equals(exp_label)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test failed");
		} 
		*/
		
		//7.1- Validating Label with handeling exception-
		String act_label = ""; // passing the variable as empty for now
		try {
			act_label = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
			// Now assigning the label text to the variable. If login successfull then it will get Label text, and 
			//If Login unsuccessfull then exception handeled by catch block.
		}
		catch(NoSuchElementException e){
						
		}
		String exp_label = "Dashboard";
		if(act_label.equals(exp_label)) //act_label will take Label text if successfully logged in otherwise it will be empty. And when compared with empty to expected then it will print test failed.
		{
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test failed");
		}
		
		//(7) Closing the browser
		//driver.quit();
	}

}
