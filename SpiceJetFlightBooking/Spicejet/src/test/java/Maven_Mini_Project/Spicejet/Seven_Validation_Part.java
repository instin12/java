package Maven_Mini_Project.Spicejet;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Seven_Validation_Part {
	@Test
	public void f() {
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

	@BeforeMethod
	public void beforeMethod() {
		// Click on "One Way" radio button
		WebElement oneWayRadioButton = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
		oneWayRadioButton.click();

	}

	@AfterMethod
	public void afterMethod() {
		// Enter origin and destination for one-way trip
		WebElement originInput = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		originInput.sendKeys("SourceCity");

		WebElement destinationInput = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		destinationInput.sendKeys("DestinationCity");

	}

	@BeforeClass
	public void beforeClass() {
		// Select departure date for one-way trip
		WebElement departureDateInput = driver.findElement(By.id("ctl00_mainContent_view_date1"));
		departureDateInput.sendKeys("2023-09-01");
	}

	@AfterClass
	public void afterClass() {
		// Click on "Search" button
		searchButton.click();
	}

	@BeforeTest
	public void beforeTest() {
		// Validate "Check-in" link
		WebElement checkInLink = driver.findElement(By.linkText("Check-in"));
		if (checkInLink.isDisplayed() && checkInLink.isEnabled()) {
			System.out.println("Check-in link is available and enabled.");
		} else {
			System.out.println("Check-in link is not available or enabled.");
		}

		// Validate "Flight status" link
		WebElement flightStatusLink = driver.findElement(By.linkText("Flight status"));
		if (flightStatusLink.isDisplayed() && flightStatusLink.isEnabled()) {
			System.out.println("Flight status link is available and enabled.");
		} else {
			System.out.println("Flight status link is not available or enabled.");
		}
	}

	// Validate "Manage Booking" link
	WebElement manageBookingLink = driver.findElement(By.linkText("Manage Booking"));if(manageBookingLink.isDisplayed()&&manageBookingLink.isEnabled())
	{
		System.out.println("Manage Booking link is available and enabled.");
	}else
	{
		System.out.println("Manage Booking link is not available or enabled.");
	}

  @AfterTest
  public void afterTest() {
	  WebDriver driver = null;
		// Close the browser
		driver.quit();
  }

}
