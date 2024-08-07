package Mypac;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class redbus {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//span[@class='dateText']")).click();
		String holiday_count =  driver.findElement(By.xpath("//div[@class='holiday_count']")).getText();
		System.out.println(holiday_count);
		WebElement dateInput = driver.findElement(By.xpath("//span[normalize-space()='27']"));
		WebElement dayOfWeekElement = driver.findElement(By.xpath("//div[@class='DayNameTitle__CalendarDays-xcrmj6-0 eQJEgu']"));
		String dayOfWeek = dayOfWeekElement.getText();
		if (dayOfWeek.equals("Saturday") || dayOfWeek.equals("Sunday")) {
            System.out.println("The date falls on a weekend.");
        } else {
            System.out.println("The date does not fall on a weekend.");
        }
	}

}
