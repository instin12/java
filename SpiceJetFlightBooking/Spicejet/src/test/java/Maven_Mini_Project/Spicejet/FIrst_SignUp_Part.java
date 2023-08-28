package Maven_Mini_Project.Spicejet;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class FIrst_SignUp_Part {
	@Test
  public void testcase() {
	  
	  WebDriver driver = new ChromeDriver();
      System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\JESUS\\Downloads\\chromedriver-win32\\chromedriver");
      driver.get("https://spiceclub.spicejet.com/signup");
      
//      driver.get("https://spiceclub.spicejet.com/signup");
      driver.manage().window().maximize();
      
      

	}	  
  
  @BeforeClass
  public void beforeClass() {
	 
	// Fill in member details
      WebElement firstNameInput = driver.findElement(By.id("first-name"));
      firstNameInput.sendKeys("John");
      
      WebElement lastNameInput = driver.findElement(By.id("last-name"));
      lastNameInput.sendKeys("Doe");
      
      WebElement emailInput = driver.findElement(By.id("email"));
      emailInput.sendKeys("john.doe@example.com");
      
      WebElement genderRadio = driver.findElement(By.id("gender-male"));
      genderRadio.click();
      
      // Select date of birth
      Select daySelect = new Select(driver.findElement(By.id("dob-day")));
      daySelect.selectByValue("15");
      
      Select monthSelect = new Select(driver.findElement(By.id("dob-month")));
      monthSelect.selectByValue("3");
      
      Select yearSelect = new Select(driver.findElement(By.id("dob-year")));
      yearSelect.selectByValue("1990");
      
      // Fill in address details
      WebElement addressInput = driver.findElement(By.id("address"));
      addressInput.sendKeys("123 Main Street");
      
      WebElement cityInput = driver.findElement(By.id("city"));
      cityInput.sendKeys("New York");
      
      Select stateSelect = new Select(driver.findElement(By.id("state")));
      stateSelect.selectByValue("NY");
      
      WebElement zipInput = driver.findElement(By.id("zip"));
      zipInput.sendKeys("10001");
      
      // Submit the form
      WebElement submitButton = driver.findElement(By.id("submit-button"));
      submitButton.click();
      
      // Verify successful enrollment
    
  }
	  
	  
  }

	@AfterClass
	public void afterClass() {

		// Close the browser
		driver.quit();
	}

}
