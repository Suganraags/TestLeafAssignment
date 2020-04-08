package week2.day1;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafgroundsWebElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Image.html");
		//get all images
		List<WebElement> allImages = driver.findElementsByTagName("img");
		//get the total number os images
		int imageSize = allImages.size();
		//print the number
		System.out.println(imageSize);
		//allImages.get(imageSize-1).sendKeys(Keys.ENTER);
		//click on the last image
		allImages.get(imageSize-1).click();
		//get the Title of the navigated page
		System.out.println(driver.getTitle());
		//go to radio buttons page
		driver.get("http://www.leafground.com/pages/radio.html");
		//get all the radio buttons
		List<WebElement> allRadioButtons = driver.findElementsByXPath("//input[@type='radio']");
		//get number of radio buttons
		int radioButtonSize = allRadioButtons.size();
		//print number of radio buttons
		System.out.println(radioButtonSize);
		//go to checkboxes page
		driver.get("http://www.leafground.com/pages/checkbox.html");
		//get all checkboxes
		List<WebElement> allcheckbox = driver.findElementsByXPath("//input[@type='checkbox']");
		//get total number of checkboxes
		int totalCheckbox = allcheckbox.size();
		//print the size
		System.out.println(totalCheckbox);
		//uncheck 'Selenium' and 'I am not checked' boxes
		//driver.findElementByXPath("//div[text()='Selenium']").click();
		//driver.findElementByXPath("//div[text()='I am Selected']").click();
		//iterate and click
		for (WebElement webElement : allcheckbox) {
			
				webElement.click();
		}
		
	}

}
