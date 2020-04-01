package week1.day2;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.findElementById("email").sendKeys("abc@gmail.com");
		driver.findElementById("pass").sendKeys("password");
		driver.findElementById("loginbutton").click();
	}

}
