package Maven_Mini_Project.Spicejet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Third_Search_Flight_Part {
	@Test
	public void testCase() {
		WebDriver driver = new ChromeDriver();
		System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\ELCOT\\Desktop\\SEL\\chromedriver.exe");
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
        WebDriver driver =null;
		// Click on "One Way" radio button
		WebElement oneWayRadioButton = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
		oneWayRadioButton.click();

		// Enter origin and destination for one-way trip
		WebElement originInput = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		originInput.sendKeys("SourceCity");

		WebElement destinationInput = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		destinationInput.sendKeys("DestinationCity");

		// Select departure date for one-way trip
		WebElement departureDateInput = driver.findElement(By.id("ctl00_mainContent_view_date1"));
		departureDateInput.sendKeys("2023-09-10");

		// Click on "Search" button
		WebElement searchButton = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
		searchButton.click();

		// Handle search results

		// Clear the form for round trip search
		originInput.clear();
		destinationInput.clear();

		// Click on "Round Trip" radio button
		WebElement roundTripRadioButton = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		roundTripRadioButton.click();

		// Enter origin and destination for round trip
		originInput.sendKeys("SourceCity");
		destinationInput.sendKeys("DestinationCity");

		// Select departure and return dates for round trip
		departureDateInput.sendKeys("2023-09-10");
		WebElement returnDateInput = driver.findElement(By.id("ctl00_mainContent_view_date2"));
		returnDateInput.sendKeys("2023-09-10");

		// Click on "Search" button for round trip
		searchButton.click();

		
	}

	@AfterClass
	public void afterClass() {
		WebDriver driver =null;
		// Close the browser
		driver.quit();
	}

}
