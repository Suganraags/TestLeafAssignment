package week2.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class myntra {

	public static void main(String[] args) throws InterruptedException {
		//set property
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		//create obj for chromedriver
		ChromeDriver driver = new ChromeDriver();
		//open myntra url
		driver.navigate().to("https://www.myntra.com/");
		//implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		//mouse over on women
		WebElement women = driver.findElementByXPath("(//a[text()='Women'])[1]");
		Actions builder = new Actions(driver);
		builder.moveToElement(women).perform();
		//click on Jackets and Coats
		driver.findElementByLinkText("Jackets & Coats").click();
		//find the total count of Jackets and coats
		String totalCount = driver.findElementByXPath("//h1[text()='Coats & Jackets For Women']/following::span").getText();
		//replace and delete all the text
		String text = totalCount.replaceAll("\\D","");
		//convert the String value into Int
		int TotalCoatsAndJackets = Integer.parseInt(text);
		//print the number
		System.out.println(TotalCoatsAndJackets);
		//get the no of Jackets
		String noOfJackets = driver.findElementByXPath("//label[text()='Jackets']").getText();
		System.out.println(noOfJackets);
		//replace and delete all the text
		String jacket_text = noOfJackets.replaceAll("\\D","");
		//convert the String value into Int
		int countofTotalJackets = Integer.parseInt(jacket_text);
		//get the no of Coats
		String noOfCoats = driver.findElementByXPath("//label[text()='Coats']").getText();
		System.out.println(noOfCoats);
		//replace and delete all the text
		String coat_text = noOfCoats.replaceAll("\\D","");
		//convert the String value into Int
		int countofTotalCoats = Integer.parseInt(coat_text);
		//Sum the total no of Jackets and Coats
		int Total = countofTotalJackets+countofTotalCoats;
		//compare if two values are same
		if(TotalCoatsAndJackets==Total)
		{
			System.out.println("Both numbers are matching");
		}else
		{
			System.out.println("Not matching");
		}
		//Select coats checkbox
		driver.findElementByXPath("//label[text()='Coats']").click();
		//Click + More option under BRAND
		driver.findElementByXPath("//span[text()='Brand']/following-sibling::div[2]").click();
		//click on textbox
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("Mango");
		//click on the checkbox
		driver.findElementByXPath("(//label[text()='MANGO'])[2]").click();
		//close the popup
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		//add sleep
		Thread.sleep(5000);
		//Confirm all the Coats are of brand MANGO
		List<WebElement> brandName = driver.findElementsByXPath("//h3[text()='MANGO']");
		//get the no of items
		int numberofItems = brandName.size();
		//print the number of items
		System.out.println(numberofItems);
		//iterate the brandname and compare
		for (WebElement textBrand : brandName) {
			
			String brandNamefrmMyntra = textBrand.getText();
			if(brandNamefrmMyntra.equals("MANGO"))
			{
				System.out.println("Brand names are same");
				break;
			}
		}
		//Sort by Better Discount
		driver.findElementByXPath("//div[text()='Sort by : ']").click();
		//now click on Better discount
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		//add sleep
		Thread.sleep(3000);
		//Find the price of first displayed item
		List<WebElement> allprices = driver.findElementsByXPath("(//span[@class='product-discountedPrice'])[1]");
		//print the price
		WebElement firstelement = allprices.get(0);
		//get the price in text
		String pricetext = firstelement.getText();
		//replace other text
		String  price = pricetext.replaceAll("\\D","");
		//convert the String value into Int
		int priceoffirstcoat = Integer.parseInt(price);
		//print the price
		System.out.println("Rs." + priceoffirstcoat);
		//mouse over on the first item
		WebElement firstitem = driver.findElementByXPath("(//h3[text()='MANGO'])[1]");
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(firstitem).perform();
		//click on wishlist
		driver.findElementByXPath("(//span[text()='wishlist now'])[1]").click();
		//close browser
		driver.close();		

	}

}
