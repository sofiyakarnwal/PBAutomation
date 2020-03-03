package bu_pkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BU_Tw {
	
	 //resultEmail remail=new resultEmail();
	String result;
	String WithoutBikeNumResult;
	String NewBikeResult;
	public String TwBU()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);	
			
		String url="https://www.policybazaar.com/motor-insurance/two-wheeler-insurance/";
		driver.get(url);
		String firsturl=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturl);
		
		driver.findElement(By.id("twoWheelerRegistrationNumber")).sendKeys("DL09C6167");
		driver.findElement(By.id("btntwSubmit")).click();
		Thread.sleep(50000);
		String secondurl=driver.getCurrentUrl();
		 System.out.println("URL after Submit Button click is : " + secondurl);
		 
			if(secondurl.contains("twowheeler.policybazaar.com"))
			 {
				 System.out.println("Test Pass and Form is working");
				 result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Two Wheeler Form is working : Test Pass";
				 Thread.sleep(10000);
				 //remail.sendEmail("Two Wheeler Form is working : Test Pass", "Form Testing");
				// driver.quit();
			 }
			else 
			{
				System.out.println(" Test Fail for TW and Form is not working");
				result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Two Wheeler Form is not working: Test Fail";
				
				//remail.sendEmail("Two Wheeler Form is not working: Test Fail", "Form Testing");
			}
			driver.quit();
		}
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		return(result);
	}
	public String TwBULinks()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);	
			
		String urll="https://www.policybazaar.com/motor-insurance/two-wheeler-insurance/";
		driver.get(urll);
		String firsturll=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturll);
		
		driver.findElement(By.linkText("Proceed without bike number")).click();
		Thread.sleep(30000);
		String secondurll=driver.getCurrentUrl();
		 System.out.println("URL after Submit Button click is : " + secondurll);
		 
			if(secondurll.contains("twowheeler.policybazaar.com"))
			 {
				 System.out.println("Test Pass and Link is working");
				 WithoutBikeNumResult="\n"+ "Tested URL: "+ urll+ "\n"+ "Tested Link: Proceed without bike number"+ "\n"+ "URL after Redirection: "+ secondurll+ "\n"+ "Link is working : Test Pass";
				 Thread.sleep(10000);
				// driver.quit();
			 }
			else 
			{
				System.out.println("Test Fail for TW and Link is not working");
				WithoutBikeNumResult="\n"+ "Tested URL: "+ urll+ "\n"+ "Tested Link: Proceed without bike number"+ "\n"+ "URL after Redirection: "+ secondurll+ "\n"+ "Link is not working : Test Fail";
			}
			driver.quit();
		}
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		return(WithoutBikeNumResult);
	
	}
	
	public String NewTwBULinks()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);	
			
		String urll="https://www.policybazaar.com/motor-insurance/two-wheeler-insurance/";
		driver.get(urll);
		String firsturll=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturll);
		
		driver.findElement(By.linkText("Brand new Bike? Click here")).click();
		Thread.sleep(30000);
		String secondurll=driver.getCurrentUrl();
		 System.out.println("URL after Submit Button click is : " + secondurll);
		 
			if(secondurll.contains("twowheeler.policybazaar.com"))
			 {
				 System.out.println("Test Pass and Link is working");
				 NewBikeResult="\n"+ "Tested URL: "+ urll+ "\n"+ "Tested Link: Brand New Bike?"+ "\n"+ "URL after Redirection: "+ secondurll+ "\n"+ "Link is working : Test Pass";
				 Thread.sleep(10000);
				 //driver.quit();
			 }
			else 
			{
				System.out.println(" Test Fail for New TW and Link is not working");
				NewBikeResult="\n"+ "Tested URL: "+ urll+ "\n"+ "Tested Link: Brand New Bike?"+ "\n"+ "URL after Redirection: "+ secondurll+ "\n"+ "Link is not working : Test Fail";
			}
			driver.quit();
		}
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		return(NewBikeResult);
	}

}
