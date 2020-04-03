package week1.day5;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch URL:
		driver.navigate().to("https://acme-test.uipath.com/account/login");
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Enter UserName (kumar.testleaf@gmail.com)
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		// and TAB
		driver.findElementById("email").sendKeys(Keys.TAB);
		//enter passowrd
		driver.findElementById("password").sendKeys("leaf@12");
		//Click Login
		driver.findElementById("buttonLogin").click();
		//Thread.sleep(3000);
		//Mouse over on Vendors
		WebElement ele = driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		//Click on Search for Vendor
		driver.findElementByLinkText("Search for Vendor").click();
		// Enter Vendor name as Blue Lagoon
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		//Click on search
		driver.findElementById("buttonSearch").click();
		//Get the country name
		String country = driver.findElementByXPath("//td[text()='France']").getText();
		//print it in console
		System.out.println(country);
		//logout
		driver.findElementByLinkText("Log Out").click();
		//close the browser
		driver.close();
				

	}

}
