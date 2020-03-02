package bu_pkg;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Claim {
	
	String result;
	public String ClaimReq()
	{
    // resultEmail remail=new resultEmail();
		
	try
		{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();	
		String url="https://www.policybazaar.com/claim/";
		driver.get(url);
		String firsturl=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturl);
		Select Product=new Select(driver.findElement(By.id("product")));
		Product.selectByVisibleText("Term Insurance");
		driver.findElement(By.id("mobile")).sendKeys("7878787878");
		driver.findElement(By.id("name")).sendKeys("Test Agent");
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("remarks")).sendKeys("Hello...Here is the Text Remarks");
		driver.findElement(By.id("btnCallToAction")).click();
		Thread.sleep(6000);
		 
		String secondurl=driver.getCurrentUrl();
		System.out.println("URL after Submit Button click is : " + secondurl);
		 	
		 WebElement msg=driver.findElement(By.xpath("//*[@class='success']"));
	        String text=msg.getText();
	        System.out.println("Messeage is " +text);
		 
		 if(text.contains("Your ticket no. is"))
		 {
		     System.out.println("Test Pass");
		     result="\n"+ "Tested URL: "+ url+ "\n"+ "Message after Submission:  "+ text+ "\n"+ "Claim Form is working: Test Pass";
		 //remail.sendEmail("Claim Form is working: Test Pass", "Form Testing");
		 }
	     else 
	     {
	    	 System.out.println("Test Fail");
	    	 result="\n"+ "Tested URL: "+ url+ "\n"+ "Message after Submission "+ text+ "\n"+ "Claim Form is not working: Test Fail";
		// remail.sendEmail("Claim Form is not working: Test Fail", "Form Testing");
	     }
		}
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
	return(result);
			
		}
	
	public void HealthClaim()
	{
		 resultEmail remail=new resultEmail();
			
			try
				{
				System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
				WebDriver driver= new FirefoxDriver();	
				String url="https://www.policybazaar.com/health-insurance-claim/";
				driver.get(url);
				String firsturl=driver.getCurrentUrl();
				System.out.println("Tested URL is: " + firsturl);
		        driver.findElement(By.id("name")).sendKeys("Test Agent");
		        driver.findElement(By.id("mobile")).sendKeys("6767676767");
		        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		        driver.findElement(By.id("alternateNo")).sendKeys("6786786786");
		        driver.findElement(By.id("policyNo")).sendKeys("PB09871");
		        driver.findElement(By.id("claimId")).sendKeys("0123");
		        driver.findElement(By.id("remarks")).sendKeys("Test Remarks");
		        driver.findElement(By.id("btnCallToAction")).click();
		        
				Thread.sleep(600);
				
				String secondurl=driver.getCurrentUrl();
				System.out.println("URL after Submit Button click is : " + secondurl);
				
				 WebElement msg=driver.findElement(By.xpath("//*[@class='success']"));
			        String text=msg.getText();
			        System.out.println("Messeage is " +text);
				 
				 if(text.contains("Thank you for your enquiry"))
				 {
				     System.out.println("Test Pass");
				 //remail.sendEmail("Health Claim Form is working: Test Pass", "Form Testing");
				 }
			     else 
			     {
			    	 System.out.println("Test Fail");
				 //remail.sendEmail("Health Claim Form is not working: Test Fail", "Form Testing");
			     }
				
				
				
				}
			catch(Exception exc) 
			{
				exc.printStackTrace();
			}
		
	}
	
	public void CarClaim()
	{
		 resultEmail remail=new resultEmail();
			
			try
				{
				System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
				WebDriver driver= new FirefoxDriver();	
				String url="https://www.policybazaar.com/car-insurance-claim/";
				driver.get(url);
				String firsturl=driver.getCurrentUrl();
				System.out.println("Tested URL is: " + firsturl);
		        driver.findElement(By.id("name")).sendKeys("Test Agent");
		        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		        driver.findElement(By.id("mobile")).sendKeys("6767676767");
		        driver.findElement(By.id("btnCallToAction")).click();
		        
				Thread.sleep(6000);
				
				String secondurl=driver.getCurrentUrl();
				System.out.println("URL after Submit Button click is : " + secondurl);
				
				 WebElement msg=driver.findElement(By.xpath("//*[@class='success']"));
			        String text=msg.getText();
			        System.out.println("Messeage is " +text);
				 
				 if(text.contains("Thank you for your enquiry"))
				 {
				     System.out.println("Test Pass");
				
				 }
			     else 
			     {
			    	 System.out.println("Test Fail");
				 
			     }
				
				
				
				}
			catch(Exception exc) 
			{
				exc.printStackTrace();
			}
		
	}
	
	}


