package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLeads {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("websriver.driver.chromedriver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//open leaftaps.com
		driver.navigate().to("http://leaftaps.com/opentaps/control/main");
		//implicit wait
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//enter user name & password
	    driver.findElementByXPath("//input[@id='username']").sendKeys("DemoSalesManager");
	    driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
	    //click login button
	    driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
	    //click CRM link
	    driver.findElementByXPath("//div[@for='crmsfa']/a").click();
	    //click on leads tab
	  	driver.findElementByXPath("(//div[@class='x-panel-tc'])[2]//a").click();
	  	//click find leads link
	  	driver.findElementByXPath("//a[text()='Find Leads']").click();
	  	//click on FirstName field and enter name
	  	driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Babu");
	  	//click on find leads button
	  	driver.findElementByXPath("//button[text()='Find Leads']").click();
	  	//click on first resulting lead
	  	Thread.sleep(3000);
		//LeadName.click();
	  	driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
	  	
	  	//get the title of page
	  	String title = driver.getTitle();
	  	//print it in console
	  	System.out.println(title);
	  	//click on edit link
	  	driver.findElementByXPath("//a[text()='Edit']").click();
	  	//Clear old value
	  	driver.findElementByXPath("(//input[@name='companyName'])[2]").clear();
	  	//Enter company name
	  	driver.findElementByXPath("(//input[@name='companyName'])[2]").sendKeys("JackAndJill");
	  	//click on update button
	  	driver.findElementByXPath("(//input[@name='submitButton'])[1]").click();
	  	//get the changed name
	  	String changedname = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
	  	if(changedname.contains("JackAndJill"))
	  	{
	  	System.out.println(changedname);
	  	}
	  	//close the browser
	  	driver.close();	    

	}

}
