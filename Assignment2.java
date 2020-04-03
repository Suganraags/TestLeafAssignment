package week1.day5;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch URL:
		driver.navigate().to("https://www.redbus.in/");
		driver.manage().window().maximize();
		//Enter 'from' place as 'Chennai'
		driver.findElementById("src").sendKeys("Chennai");
		Thread.sleep(5000);
		driver.findElementById("src").sendKeys(Keys.TAB);
		//Enter 'from' place as ''Bangalore'
		driver.findElementById("dest").sendKeys("Bangalore");
		Thread.sleep(5000);
		driver.findElementById("dest").sendKeys(Keys.TAB);
		//Pick onward date as 30th
		driver.findElementByXPath("(//td[text()='30'])[2]").click();
		//Click on 'Search Buses'
		driver.findElementById("search_btn").click();
		Thread.sleep(3000);
		//Check 'After 6 pm' under 'DEPARTURE TIME'
		driver.findElementByXPath("(//label[@class='cbox-label'])[4]").click();
		Thread.sleep(2000);
		//Check 'Sleeper' under 'BUS TYPE'
		driver.findElementByXPath("//label[@title='SLEEPER']").click();
		Thread.sleep(2000);
		//Click on 'Seats Available' to sort
		driver.findElementByXPath("(//div[contains(@class,'w-15 fl')]//a)[2]").click();
		//close the browser
		driver.close();
		
		

	}

}
