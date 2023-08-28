package Maven_Mini_Project.Spicejet;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Second_Login_Part {
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

		WebDriver driver = null;
		// Click on "Login / Signup" link
		WebElement loginLink = driver.findElement((By) By.id("ctl00_HyperLinkLogin"));
		loginLink.click();

		FluentWait<WebDriver> wait = null;
		// Wait for login modal to appear
		WebElement loginModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginModal")));

		// Fill in email and password
		WebElement emailInput = loginModal.findElement(By.id("ctl00_mainContent_txtlogin"));
		emailInput.sendKeys("Dhanush.kalai21@gmail.com");

		WebElement passwordInput = loginModal.findElement(By.id("ctl00_mainContent_txtpassword"));
		passwordInput.sendKeys("pass@4321");

		// Click on "Login" button
		WebElement loginButton = loginModal.findElement(By.id("ctl00_mainContent_btnLogin"));
		loginButton.click();

		
	}

	@AfterClass
	public void afterClass() {

		WebDriver driver = null;
		// Close the browser
		driver.quit();
	}

}
