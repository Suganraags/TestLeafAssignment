package week1.day2;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGrounds {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("Mannar & Co");
		driver.findElementById("createLeadForm_firstName").sendKeys("Suganya");
		driver.findElementById("createLeadForm_lastName").sendKeys("Ragav");
		driver.findElementByName("submitButton").click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
	}

}
