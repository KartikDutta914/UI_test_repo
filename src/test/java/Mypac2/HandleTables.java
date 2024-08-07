package Mypac2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleTables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		
		//(1) Finding total number of rows
		List<WebElement> Allrows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println(Allrows.size());
		
		
		// Printing all the rows
		for(WebElement row: Allrows) {
			System.out.println(row.getText());
		}
		
		
		//(2) Finding total number of columns
		List<WebElement> Allcolumns = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		System.out.println(Allcolumns.size());
		
		
		//(3) Read specific row and column
		String SpecificRowColumn = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[3]")).getText();
		
		
		// (4) Read all row and Column
	/*or(int i=2; i<=Allrows.size(); i++){   // Starting row count from 2 since row=1 is the header
			for(int j=1; j<=Allcolumns.size(); j++ ) {
			 String Value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
			 System.out.print(Value+ "  ");
				
				
				
			}
			System.out.println();
		}*/
		
		// (5) Print the Bookname whose Author is Amit-
		/*for(int r=2;r<=rows;r++)
		{
			String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
			
			if(author.equals("Mukesh"))
			{
				String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
				System.out.println(author+"    "+bookname);
			}
			
		}*/
		
		
		// Another Approach--
		for(int i=2; i<=Allrows.size(); i++){   // Starting row count from 2 since row=1 is the header
			for(int j=1; j<=Allcolumns.size(); j++ ) {
			 String Value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
			 if(Value.equals("Amit")) {
				 String BookofAmit = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+(j-1)+"]")).getText();
				 System.out.println(BookofAmit);
			 }
			 
				
				
				
			}
			
		}
		
		
		//6)Find sum of prices for all the books--
		int sum=0;
		for(int i =2; i<=Allrows.size(); i++) {
			String Price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
			sum = sum + Integer.parseInt(Price);
			
			
		}
		System.out.println(sum);
		
		
		
		
		

		
		
		

	}

}
