package week1.day4;

import org.openqa.selenium.chrome.ChromeDriver;

public class LeadLink {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("websriver.driver.chromedriver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//open leaftaps.com
		driver.navigate().to("http://leaftaps.com/opentaps/control/main");
		//enter username & password
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
		//click on Email link
		driver.findElementByXPath("//span[text()='Email']").click();
		//enter email address
		driver.findElementByName("emailAddress").sendKeys("babu@testleaf.com");
		//click find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		//select the first result
		String LeadName = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").getText();
		System.out.println(LeadName);
		//click first lead
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();
		//click Duplicate lead
		//driver.findElementByLinkText("Duplicate Lead").click();
		driver.findElementByLinkText("Duplicate Lead").click();
		String title = driver.getTitle();
		System.out.println(title);
		//click create lead
		driver.findElementByName("submitButton").click();
		//check the leadname created
		String LeadName1 = driver.findElementById("viewLead_firstName_sp").getText();
		System.out.println(LeadName1);
		if(LeadName.equals(LeadName1))
		{
			System.out.println("Lead names are same");
		}else
		{
			System.out.println("Lead names are not same");			
		}
		driver.close();	
		

	}

}
