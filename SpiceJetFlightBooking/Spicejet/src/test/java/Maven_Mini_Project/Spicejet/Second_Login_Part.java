package Maven_Mini_Project.Spicejet;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Second_Login_Part {
	@Test
	public void testCase() {

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

		By driver;
		// Click on "Login / Signup" link
		WebElement loginLink = driver.findElement((SearchContext) By.id("ctl00_HyperLinkLogin"));
		loginLink.click();

		// Wait for login modal to appear
		WebElement loginModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginModal")));

		// Fill in email and password
		WebElement emailInput = loginModal.findElement(By.id("ctl00_mainContent_txtlogin"));
		emailInput.sendKeys("dummy@example.com");

		WebElement passwordInput = loginModal.findElement(By.id("ctl00_mainContent_txtpassword"));
		passwordInput.sendKeys("password123");

		// Click on "Login" button
		WebElement loginButton = loginModal.findElement(By.id("ctl00_mainContent_btnLogin"));
		loginButton.click();

		// Wait for successful login or error message

	}

	@AfterClass
	public void afterClass() {

		WebDriver driver = null;
		// Close the browser
		driver.quit();
	}

}
