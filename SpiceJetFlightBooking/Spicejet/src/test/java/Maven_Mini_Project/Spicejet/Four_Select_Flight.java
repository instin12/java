package Maven_Mini_Project.Spicejet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Four_Select_Flight {
	@Test
	public void testcase() {

		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\JESUS\\Downloads\\chromedriver-win32\\chromedriver");
		driver.get("https://spiceclub.spicejet.com/signup");
		driver.manage().window().maximize();

		// Open SpiceJet website
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();

		// Handle popup if present
		try {
			WebElement popup = driver.findElement(By.id("popup"));
			if (popup.isDisplayed()) {
				popup.click();
			}
		} catch (Exception e) {
			// Popup not present
		}

	}

	@BeforeClass
	public void beforeClass() {

		// Click on "One Way" radio button
		WebElement oneWayRadioButton = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
		oneWayRadioButton.click();

		// Enter origin and destination for one-way trip

		// Enter departure date

		// Click on "Search" button
		WebElement searchButton = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
		searchButton.click();

		// Wait for search results
		WebElement selectButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[contains(@id, 'ControlGroupSelectView_AvailabilityInputSelectView')][1]")));

		// Wait for search results
		WebElement selectButton2 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[contains(@id, 'ControlGroupSelectView_AvailabilityInputSelectView')][1]")));

		// Click on the first select button to choose a flight
		selectButton2.click();

		
	}

	@AfterClass
	public void afterClass() {
		WebDriver driver = null;
		// Close the browser
		driver.quit();
	}

}
