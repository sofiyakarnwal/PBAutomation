package bu_pkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BU_Car {
	
	 //resultEmail remail=new resultEmail();
	 String result;
	 String WithoutCarNumResult;
	 String NewCarResult;
	public String CarBU()
	{
		try
		{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		String url="https://www.policybazaar.com/motor-insurance/car-insurance/";
		driver.get(url);
		String firsturl=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturl);
		
		driver.findElement(By.id("carRegistrationNumber")).sendKeys("DL09C6767");
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(60000);
		String secondurl=driver.getCurrentUrl();
		System.out.println("URL after Submit Button click is : " + secondurl);
		 
			if(secondurl.contains("ci.policybazaar.com"))
			 {
				 System.out.println("Test Pass and Form is working");
				 result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Car Form is working : Test Pass";
				 Thread.sleep(1000);
				 
				
				 //driver.quit();
			 }
			else 
			{
				System.out.println(" Test Fail for Car and Form is not working");
				result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Test Fail for Car and Form is not working";
				
			}
			driver.quit();
		}
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		return(result);
	}
	public String CarBULinks()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);	
			
		String urll="https://www.policybazaar.com/motor-insurance/car-insurance/";
		driver.get(urll);
		String firsturll=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturll);
		
		driver.findElement(By.className("do_not")).click();
		Thread.sleep(30000);
		String secondurll=driver.getCurrentUrl();
		 System.out.println("URL after Submit Button click is : " + secondurll);
		 
			if(secondurll.contains("ci.policybazaar.com"))
			 {
				 System.out.println("Test Pass and 'Proceed Without Car Number' Link is working");
				 WithoutCarNumResult="\n"+ "Tested URL: "+ urll+ "\n"+ "Tested Link: Proceed without Car number"+ "\n"+ "URL after Redirection: "+ secondurll+ "\n"+ "Link is working : Test Pass";
				 
				 Thread.sleep(10000);
				 driver.quit();
			 }
			else 
			{
				System.out.println("Test Fail for Car and 'Proceed Without Car Number' Link is not working");
				WithoutCarNumResult="\n"+ "Tested URL: "+ urll+ "\n"+ "Tested Link: Proceed without Car number"+ "\n"+ "URL after Redirection: "+ secondurll+ "\n"+ "Link is working : Test Fail";
				 
				
			}
			driver.quit();
		}
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		return(WithoutCarNumResult);
	}
	public String NewCarBULinks()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			
		String urlll="https://www.policybazaar.com/motor-insurance/car-insurance/";
		driver.get(urlll);
		String firsturlll=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturlll);
		
		driver.findElement(By.className("got_new_car")).click();
		Thread.sleep(30000);
		String secondurlll=driver.getCurrentUrl();
		 System.out.println("URL after Submit Button click is : " + secondurlll);
		 
			if(secondurlll.contains("ci.policybazaar.com"))
			 {
				 System.out.println("Test Pass and 'I have a brand new car' Link is working");
				 NewCarResult="\n"+ "Tested URL: "+ urlll+ "\n"+ "Tested Link: Brand New Car?"+ "\n"+ "URL after Redirection: "+ secondurlll+ "\n"+ "Link is working : Test Pass";
					
				 Thread.sleep(10000);
				 //driver.quit();
			 }
			else 
			{
				System.out.println(" Test Fail for Car and 'I have a brand new car' Link is not working");
				NewCarResult="\n"+ "Tested URL: "+ urlll+ "\n"+ "Tested Link: Brand New Car?"+ "\n"+ "URL after Redirection: "+ secondurlll+ "\n"+ "Link is working : Test Fail";
				
			}
			driver.quit();
		}
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		return(NewCarResult);
	}
	
}
