package week1.day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

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
	  	//click on phone number tab
	  	driver.findElementByXPath("//span[text()='Phone']").click();
	  	//Enter phone number
	  	driver.findElementByName("phoneNumber").sendKeys("12345");
	  	//click on find leads button
	  	driver.findElementByXPath("//button[text()='Find Leads']").click();
	  	//click on first resulting lead
	  	Thread.sleep(3000);
		//get lead name
	  	String LeadID = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").getText();
	    System.out.println(LeadID);
	  	//LeadName.click();
	  	driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();
	    //get the title of page
	  	String title = driver.getTitle();
	  	//print it in console
	  	System.out.println(title);
	  	//click on Delete link
	  	driver.findElementByLinkText("Delete").click();
	    //click on find leads button
	  	driver.findElementByLinkText("Find Leads").click();
	  	//Enter lead id
	  	driver.findElementByName("id").sendKeys(LeadID);
	  	//click on find leads button
	  	driver.findElementByXPath("//button[text()='Find Leads']").click();
	  	//find no records message
	  	String NoRecord = driver.findElementByXPath("//div[text()='No records to display']").getText();
	  	System.out.println(NoRecord);
	  	//close the browser
	  	driver.close();	    
	    
	    
	}
}
