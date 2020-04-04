package week1.day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("websriver.driver.chromedriver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//open leaftaps.com
		driver.navigate().to("http://leaftaps.com/opentaps/control/main");
		//implicit wait
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//enter user name & password
	    driver.findElementById("username").sendKeys("DemoSalesManager");
	    driver.findElementById("password").sendKeys("crmsfa");
	    //click login button
	    driver.findElementByClassName("decorativeSubmit").click();
	    //click CRM link
	    driver.findElementByLinkText("CRM/SFA").click();
	    //click on leads tab
	  	driver.findElementByLinkText("Leads").click();
	  	//click find leads link
	  	driver.findElementByLinkText("Find Leads").click();
	  	//click on FirstName field and enter name
	  	driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Babu");
	  	//click on find leads button
	  	driver.findElementByXPath("//button[text()='Find Leads']").click();
	  	//click on first resulting lead
	  	Thread.sleep(3000);
		//LeadName.click();
	  	driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();
	  	
	  	//get the title of page
	  	String title = driver.getTitle();
	  	//print it in console
	  	System.out.println(title);
	  	//click on edit link
	  	driver.findElementByLinkText("Edit").click();
	  	//Clear old value
	  	driver.findElementById("updateLeadForm_companyName").clear();
	  	//Enter company name
	  	driver.findElementById("updateLeadForm_companyName").sendKeys("JackAndJill");
	  	//click on update button
	  	driver.findElementByXPath("(//input[@name='submitButton'])[1]").click();
	  	//get the changed name
	  	String changedname = driver.findElementById("viewLead_companyName_sp").getText();
	  	if(changedname.contains("JackAndJill"))
	  	{
	  	System.out.println(changedname);
	  	}
	  	//close the browser
	  	driver.close();	    
	    
	    
	}
}
