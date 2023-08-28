package Maven_Mini_Project.Spicejet;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;

public class Six_Conformation_Part {
  @Test
  public void testcase() {
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
	  
	    WebDriver driver = null;
		// Click on "Login / Signup" link
		WebElement loginLink = driver.findElement((By) By.id("ctl00_HyperLinkLogin"));
		loginLink.click();

		Object wait;
		// Wait for login modal to appear
		WebElement loginModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginModal")));

		// Fill in email and password
		WebElement emailInput = loginModal.findElement(By.id("ctl00_mainContent_txtlogin"));
		emailInput.sendKeys("Dhanush.Kalai21@gmail.com");

		WebElement passwordInput = loginModal.findElement(By.id("ctl00_mainContent_txtpassword"));
		passwordInput.sendKeys("pass@4321");

		// Click on "Login" button
		WebElement loginButton = loginModal.findElement(By.id("ctl00_mainContent_btnLogin"));
		loginButton.click();

		// Wait for successful login or error message
      
              
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
				departureDateInput.sendKeys("2023-09-01");

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
				departureDateInput.sendKeys("2023-09-01");
				WebElement returnDateInput = driver.findElement(By.id("ctl00_mainContent_view_date2"));
				returnDateInput.sendKeys("2023-09-10");

				// Click on "Search" button for round trip
				searchButton.click();

				
				// Click on "One Way" radio button
				WebElement oneWayRadioButton1 = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
				oneWayRadioButton1.click();

      
               
				// Click on "Search" button
				WebElement searchButton1 = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
				searchButton1.click();

				// Wait for search results
				WebElement selectButton = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//button[contains(@id, 'ControlGroupSelectView_AvailabilityInputSelectView')][1]")));
				// Click on the first select button to choose a flight
				selectButton.click();

				// Submit the booking form

				WebElement continueButton = driver
						.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_ButtonSubmit"));
				continueButton.click();

				// Wait for confirmation page
				wait.until(ExpectedConditions.titleContains("Booking Confirmation"));

				// Verify booking confirmation message
				WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='conf_msg']"));
				String message = confirmationMessage.getText();

				if (message.contains("Booking Successful")) {
					System.out.println("Booking was successful!");
				} else {
					System.out.println("Booking was not successful.");
				}

			}

  @AfterClass
  public void afterClass() {

		WebDriver driver = null;
		// Close the browser
		driver.quit();
	}
  }


