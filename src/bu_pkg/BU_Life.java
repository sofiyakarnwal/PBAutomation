package bu_pkg;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;

//import java.util.*;

//import javax.activation.*;
/*import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

//import sun.net.smtp.SmtpClient;

//import sun.net.smtp.SmtpClient;

public class BU_Life {
	
	// resultEmail remail=new resultEmail();
	
	String result;
	
	String url="https://www.policybazaar.com/life-insurance/";
	
@Test(priority=1)
	public String LifeBU()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		/*String url="https://www.policybazaar.com/life-insurance/";*/
		
		driver.get(url);
		Thread.sleep(3000);
		String firsturl=driver.getCurrentUrl();
				
		System.out.println("Tested URL is: " + firsturl);
		driver.findElement(By.id("termName")).sendKeys("Test Agent");
				
		/*Select drpDay= new Select(driver.findElement(By.name("termBirthday_birth[day]")));
		drpDay.selectByVisibleText("02");
		Select drpMonth= new Select(driver.findElement(By.name("termBirthday_birth[month]")));
		drpMonth.selectByVisibleText("Feb");
		Select drpYear= new Select(driver.findElement(By.name("termBirthday_birth[year]")));
		drpYear.selectByVisibleText("1999");*/
		
		driver.findElement(By.id("dob")).sendKeys("10/07/1987");
		driver.findElement(By.id("termMobile")).sendKeys("6767676767");
		
		driver.findElement(By.id("btnSubmitTerm")).click();
		
		 Thread.sleep(3000);
		 
		String secondurl=driver.getCurrentUrl();
		 System.out.println("URL after Submit Button click is : " + secondurl);
		 
			if(secondurl.contains("isProgressiveJourney=true") && secondurl.contains("https://termlife.policybazaar.com/"))
			 {
				 System.out.println("Test Pass and Lead created");
				  result= "\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Life Insurance Form is working : Test Pass";
				
				 //remail.sendEmail("Life Insurance Form is working : Test Pass", "Form Testing");
				 Thread.sleep(6000);
				 //driver.quit();
			 }
			else 
			{
				//result="Test Fail";
				System.out.println("Test Fail and unable to create lead");
				//sendEmail("For Life Insurance BU Form :" +result , "Testing");
				//remail.sendEmail("Life Insurance Form is not working: Test Fail", "Form Testing");
				result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Life Insurance Form is not working: Test Fail" ;
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


	

	
	



	

