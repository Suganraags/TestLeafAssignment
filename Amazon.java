package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.driver.chromedriver","chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//open amazon url
		driver.get("https://www.amazon.in/");
		//add implicit wait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//maximize the window
		driver.manage().window().maximize();
		//search books
		driver.findElementById("twotabsearchtextbox").sendKeys("books");
		//press Enter button
		driver.findElementById("twotabsearchtextbox").sendKeys(Keys.ENTER);
		//driver.findElementByXPath("(//img[@class='s-image'])[2]").click();
		//find book name and print
		String bookName = driver.findElementByXPath("(//span[contains(@class,'a-size-medium a-color-base')])[1]").getText();
		System.out.println(bookName);
		//find author of the book and print
		String authorName = driver.findElementByXPath("(//a[@class='a-size-base a-link-normal'])[1]").getText();
        System.out.println(authorName);
        //find price of the book and print
        String price = driver.findElementByXPath("(//span[@class='a-price-whole'])[1]").getText();
		System.out.println(price);
		//close the browser
		driver.close();
	}

}
