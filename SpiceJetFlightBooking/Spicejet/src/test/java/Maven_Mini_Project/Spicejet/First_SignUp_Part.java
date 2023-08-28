package Maven_Mini_Project.Spicejet;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class First_SignUp_Part {
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
	// Fill in member details
      WebElement firstNameInput = driver.findElement(By.id("first-name"));
      firstNameInput.sendKeys("Dhanush");
      
      WebElement lastNameInput = driver.findElement(By.id("last-name"));
      lastNameInput.sendKeys("Kalai");
      
      WebElement emailInput = driver.findElement(By.id("email"));
      emailInput.sendKeys("Dhanush.Kalai21@example.com");
      
      WebElement genderRadio = driver.findElement(By.id("gender-male"));
      genderRadio.click();
      
      // Select date of birth
      Select daySelect = new Select(driver.findElement(By.id("dob-day")));
      daySelect.selectByValue("25");
      
      Select monthSelect = new Select(driver.findElement(By.id("dob-month")));
      monthSelect.selectByValue("6");
      
      Select yearSelect = new Select(driver.findElement(By.id("dob-year")));
      yearSelect.selectByValue("1998");
      
      // Fill in address details
      WebElement addressInput = driver.findElement(By.id("address"));
      addressInput.sendKeys("45,Peter's Street");
      
      WebElement cityInput = driver.findElement(By.id("city"));
      cityInput.sendKeys("New York");
      
      Select stateSelect = new Select(driver.findElement(By.id("state")));
      stateSelect.selectByValue("NY");
      
      WebElement zipInput = driver.findElement(By.id("zip"));
      zipInput.sendKeys("10003");
      
      // Submit the form
      WebElement submitButton = driver.findElement(By.id("submit-button"));
      submitButton.click();
      
      // Verify successful enrollment
    
  }
	  
	@AfterClass
	public void afterClass() {
		 WebDriver driver = null;
		// Close the browser
		driver.quit();
	}

}
