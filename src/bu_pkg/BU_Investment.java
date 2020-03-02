package bu_pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class BU_Investment {

	String result;
	
	 //resultEmail remail=new resultEmail();
	public String InvestmentBU() {
		// TODO Auto-generated method stub

		try
		{
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		String url="https://www.policybazaar.com/life-insurance/investment-plans/";
		driver.get(url);
		String firsturl=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturl);
		//Select Gender= new Select(driver.findElement(By.id("invgender")));
		//Gender.selectByVisibleText("Ms.");
		driver.findElement(By.id("invname")).sendKeys("Test Agent");
		
		Select Country= new Select(driver.findElement(By.id("invCountry")));
		Country.selectByVisibleText("India");
		
		
		driver.findElement(By.id("invmobile")).sendKeys("6767676767");
		
		driver.findElement(By.xpath("//*[@class='invproceednew proceed btnAmpProcess']")).click();
		
		
		 Thread.sleep(6000);
		 
		String secondurl=driver.getCurrentUrl();
		
		 System.out.println("URL after Submit Button click is : " + secondurl);
		 
			if(secondurl.contains("IsMatrixLeadCreated=true")&& secondurl.contains("https://investmentlife.policybazaar.com/"))
			 {
				 System.out.println("Test Pass and Lead created");
				 result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Investment Form is working : Test Pass";
				 Thread.sleep(6000);
				 //driver.quit();
				 
			 }
			else 
				{
				System.out.println(" Test Fail and unable to create lead");
				
				result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Investment Form is not working: Test Fail";
				}
			
			driver.quit();
		}
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		
		return(result);
		
		
	}

}
