package week3.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ServiceNowAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		//create obj for chromedriver
		ChromeDriver driver = new ChromeDriver();
		
		//open myntra url
				driver.navigate().to("https://dev92474.service-now.com/");
				//implicit wait
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//maximize window
				driver.manage().window().maximize();
				//switch to frame
				driver.switchTo().frame("gsft_main");
				//input user name
				driver.findElementById("user_name").sendKeys("admin");
				//input password
				driver.findElementById("user_password").sendKeys("India@123");
				//click login
				driver.findElementById("sysverb_login").click();
				//default browser
				driver.switchTo().defaultContent();
				//input in filter navigator
				Thread.sleep(7000);
				driver.findElementByXPath("//input[@id='filter']").sendKeys("Incident",Keys.ENTER);
				//Click on Create new option Under Incident
				driver.findElementByXPath("(//div[text()='Create New'])[1]").click();
				//switch to frame
				driver.switchTo().frame("gsft_main");
				Thread.sleep(4000);
				//get parent window reference id
				String parent = driver.getWindowHandle();
				//get the incident number and store in string
				String IncidentNumber = driver.findElementByXPath("//input[@id='incident.number']").getAttribute("value");
				System.out.println(IncidentNumber);
				
				//Click on the Search Button Available in the Caller Field
				driver.findElementByXPath("//button[@id='lookup.incident.caller_id']").click();

				Thread.sleep(7000);
				//Switch to new Window
				
				List<String> list = new ArrayList<String>(driver.getWindowHandles());

				   driver.switchTo().window(list.get(1));
				   
				
				//Choose First Value Opened in the new Window
				driver.findElementByXPath("(//a[@class='glide_ref_item_link'])[1]").click();
				//Switch to parent window
				driver.switchTo().window(parent);
				//Select the Value as Software in Category Field
				driver.switchTo().frame(0);
				
				WebElement dropdown1 = driver.findElementByXPath("//select[@id='incident.category']");
				Select dd = new Select(dropdown1);
				dd.selectByVisibleText("Software");
				
		
				//Select Email in Sub Category Field
				WebElement dropdown2 = driver.findElementByXPath("//select[@id='incident.subcategory']");
				Select dd1 = new Select(dropdown2);
				dd1.selectByVisibleText("Email");
				
				//Select Walk-in in Contact Type Field
				WebElement dropdown3 = driver.findElementByXPath("//select[@id='incident.contact_type']");
				Select dd3 = new Select(dropdown3);
				dd3.selectByVisibleText("Walk-in");
				
				//Select state as In-Progress 
				WebElement dropdown4 = driver.findElementByXPath("//select[@id='incident.state']");
				Select dd4 = new Select(dropdown4);
				dd4.selectByVisibleText("In Progress");
				
				//Select Urgency as High 
				WebElement dropdown5 = driver.findElementByXPath("//select[@id='incident.urgency']");
				Select dd5 = new Select(dropdown5);
				dd5.selectByVisibleText("1 - High");
				
				//Click on the Search Button Available in the Assignment Group
				driver.findElementByXPath("//button[@id='lookup.incident.assignment_group']").click();
				
				Thread.sleep(7000);
				
				//Switch to new Window				
				List<String> list1 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(list1.get(1));
				
				//Choose Last Residing Value Opened in new Window
				List<WebElement> assignPopElements = driver.findElementsByClassName("glide_ref_item_link");
				int groupsize = assignPopElements.size();
				WebElement lastElement = assignPopElements.get(groupsize-1);
				lastElement.click();
				
				//Switch to parent window
				List<String> list2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(list2.get(0));
				System.out.println(driver.getTitle());
				driver.switchTo().frame("gsft_main");
				
				//Enter Short Description as "Creating Incident For the Purpose of Management"
				driver.findElementById("incident.short_description").sendKeys("Creating Incident For the Purpose of Management");
				
				//Click on the Submit Button
				driver.findElementById("sysverb_insert").click();
				
				//Enter The Incident Number Newly created in Search Field and Press Enter
				driver.findElementByXPath("(//label[text()='Search']//following::input)[1]").sendKeys(IncidentNumber,Keys.ENTER);
				//Click on the newly Created Incident Displayed
				String createdIncident = driver.findElementByXPath("//a[@class='linked formlink']").getText();
				
				//Verify the Incident Number
				if(IncidentNumber.equalsIgnoreCase(createdIncident))
				{
					System.out.println("Same number");
				}
				
				//driver.switchTo().frame("gsft_main");
				//Update Impact as High
				driver.findElementByXPath("//a[@class='linked formlink']").click();
				WebElement dropdown6 = driver.findElementById("incident.impact");
				Select dd6 = new Select(dropdown6);
				dd6.selectByVisibleText("1 - High");
				
				//Update Description as "Successfully Created an incident"
				driver.findElementById("incident.short_description").sendKeys("Successfully Created an incident");
				//Enter Work Notes as "Done Right"
				driver.findElementById("activity-stream-textarea").sendKeys("Done Right");
				//Click on the Update button.
				driver.findElementById("sysverb_update").click();
				//click on Logout
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
				driver.findElementByXPath("//span[text()='System Administrator']").click();
				driver.findElementByXPath("//a[text()='Logout']").click();
				//close the browser
				driver.close();
	}

}
