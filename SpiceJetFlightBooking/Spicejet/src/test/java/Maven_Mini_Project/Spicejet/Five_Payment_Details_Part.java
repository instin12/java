package Maven_Mini_Project.Spicejet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Five_Payment_Details_Part {
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
		FluentWait<WebDriver> wait = null;
		// Wait for search results
		WebElement selectButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[contains(@id, 'ControlGroupSelectView_AvailabilityInputSelectView')][1]")));

		// Click on the first select button to choose a flight
		selectButton.click();

		// Wait for page to load
		wait.until(ExpectedConditions.titleContains("Passenger Details"));

		// Fill out passenger details
		WebElement firstNameInput = driver
				.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TEXTBOXFIRSTNAME_0"));
		firstNameInput.sendKeys("Dhanush");

		WebElement lastNameInput = driver
				.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TEXTBOXLASTNAME_0"));
		lastNameInput.sendKeys("Kalai");
		WebElement genderDropdown = driver.findElement(
				By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_PassengerView_DropDownListTitle_0"));
		Select genderSelect = new Select(genderDropdown);
		genderSelect.selectByValue("MR");

		WebElement dobInput = driver
				.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TEXTBOXDATEOFBIRTH_0"));
		dobInput.sendKeys("1997-08-10");

		// Fill out contact information

		// Fill out payment details
		WebElement cardNumberInput = driver
				.findElement(By.id("CONTROLGROUPPAYMENT_PaymentInputViewPaymentView_TextBoxCreditCardNumber"));
		cardNumberInput.sendKeys("4321567890123456");

		WebElement expiryMonthDropdown = driver
				.findElement(By.id("CONTROLGROUPPAYMENT_PaymentInputViewPaymentView_DropDownListExpirationMonth"));
		Select expiryMonthSelect = new Select(expiryMonthDropdown);
		expiryMonthSelect.selectByValue("11");
		WebElement expiryYearDropdown = driver
				.findElement(By.id("CONTROLGROUPPAYMENT_PaymentInputViewPaymentView_DropDownListExpirationYear"));
		Select expiryYearSelect = new Select(expiryYearDropdown);
		expiryYearSelect.selectByValue("2028");

		WebElement cvvInput = driver
				.findElement(By.id("CONTROLGROUPPAYMENT_PaymentInputViewPaymentView_TextBoxCardCVV"));
		cvvInput.sendKeys("981");

		// Submit the booking form
		WebElement continueButton = driver
				.findElement(By.id("CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_ButtonSubmit"));
		continueButton.click();

		// Wait for confirmation page

	}

	@AfterClass
	public void afterClass() {
		WebDriver driver = null;
		// Close the browser
		driver.quit();
	}

}
