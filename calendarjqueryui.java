package restApi;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testnew {


	public static void main(String[] args) throws IOException, InterruptedException {
		
	//	use System.getProperty("user.dir"); donot hardcode
 
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("#datepicker")).click();
		int year_select = 10000;
		String month = "Octoberr";
		String value = month +" "+year_select;
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-datepicker-title")));
 		
		 while(!(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().equals(value)))
		 {
			 
			 String year = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
				year=year.split(" ")[1];
			int yyyy = Integer.valueOf(year);	
			if(yyyy<=year_select)
			{
				driver.findElement(By.xpath("//*[text()='Next']")).click();
			}
			else {
				System.out.println("breaking loop check extered month year correct format");
				break;
			}
			 
		 }
			 
					List<WebElement> ele =driver.findElements(By.cssSelector(".ui-state-default"));
				for(WebElement e  :ele)
				{
					if(e.getText().equals("28"))
					{
						e.click();
						break;
						
					}
				}
				
		
		
		driver.switchTo().defaultContent();
 
		
		
		
		
	}
	
	
}
