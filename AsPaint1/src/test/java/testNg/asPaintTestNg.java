package testNg;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjectModels.androidPage;
import pageObjectModels.enquirePage;
import pageObjectModels.exploreStorePage;
import pageObjectModels.iosPage;
import pageObjectModels.mobileNumberPage;

public class asPaintTestNg {
	WebDriver driver;
	enquirePage enquirePageWebElements;
	iosPage iosPageWebElements;
	androidPage androidPageWebElements;
	exploreStorePage exploreStorePageWebElement;
	mobileNumberPage mobileNumberPageWebElement;
	String Successmsg="Thank you for your interest in Asian Paints Safe Painting Service. We will get in touch with you shortly to schedule a visit by an expert.\n"
			+ "\n"
			+ "Are you looking for home interiors ? Get tailor made designs from Beautiful Homes Service by Asian Paints. Visit Beautiful Homes Service to sign up for a design consultation."; 
  
  @BeforeMethod
  public void beforeTest() throws IOException {
		Properties properties = new Properties();
		FileInputStream inputstream = new FileInputStream("src\\test\\resources\\properties\\asianPaint.properties");
		properties.load(inputstream);
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		
		  System.out.println("before senario");
		  System.setProperty("webdriver.chrome.driver",properties.getProperty("chromeDriverPath"));
		  String baseUrl=properties.getProperty("baseUrl");
		  driver =new ChromeDriver(options);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.get(baseUrl); 
		  enquirePageWebElements=new enquirePage(driver);
		  iosPageWebElements = new iosPage(driver);
		  androidPageWebElements = new androidPage(driver);
		  exploreStorePageWebElement =new exploreStorePage(driver);
		  mobileNumberPageWebElement =new mobileNumberPage(driver);
  }
  //Method 1: Test Enquire form using valid Details
  @Test (priority= 1)
  public void EnquireFormWithValidData() throws InterruptedException {
	  String Successmsg="Thank you for your interest in Asian Paints Safe Painting Service. We will get in touch with you shortly to schedule a visit by an expert.\n"
				+ "\n"
				+ "Are you looking for home interiors ? Get tailor made designs from Beautiful Homes Service by Asian Paints. Visit Beautiful Homes Service to sign up for a design consultation."; 
	  enquirePageWebElements.writeName("Deepayan Tester");
	  enquirePageWebElements.writeEmail("tester@tester.com");
	  enquirePageWebElements.writeMobile("1234567890");
	  enquirePageWebElements.writePincode("731403");
	  enquirePageWebElements.clickEnquireNow();
	  AssertJUnit.assertEquals(Successmsg,enquirePageWebElements.verifySuccessMessage());
	  
  }
//Method 2: Test Enquire form using invalid name
  @Test (priority= 2)
  public void EnquireFormWithInvalidName() throws InterruptedException {
	  enquirePageWebElements.writeName("De@");
	  enquirePageWebElements.writeEmail("tester@tester.com");
	  enquirePageWebElements.writeMobile("1234567890");
	  enquirePageWebElements.writePincode("731403");
	  enquirePageWebElements.clickEnquireNow();
	  AssertJUnit.assertEquals("Username is not valid",enquirePageWebElements.verifyErrorMessages());
	  
  }
//Method 3: Test Enquire form using invalid email
  @Test (priority= 3)
  public void EnquireFormWithInvalidEmail() throws InterruptedException {
	  enquirePageWebElements.writeName("Deepayan Tester");
	  enquirePageWebElements.writeEmail("testertester.com");
	  enquirePageWebElements.writeMobile("1234567890");
	  enquirePageWebElements.writePincode("731403");
	  enquirePageWebElements.clickEnquireNow();
	  AssertJUnit.assertEquals("Email is invalid",enquirePageWebElements.verifyErrorMessages());
	  
  }
//Method 4: Test Enquire form using invalid mobile
  @Test (priority= 4)
  public void EnquireFormWithInvalidMobile() throws InterruptedException {
	  enquirePageWebElements.writeName("Deepayan Tester");
	  enquirePageWebElements.writeEmail("tester@tester.com");
	  enquirePageWebElements.writeMobile("123456789");
	  enquirePageWebElements.writePincode("731403");
	  enquirePageWebElements.clickEnquireNow();
	  AssertJUnit.assertEquals("Phone number is invalid",enquirePageWebElements.verifyErrorMessages());
	  
  }
//Method 5: Test Enquire form using invalid pincode
  @Test (priority= 5)
  public void EnquireFormWithInvalidPincode() throws InterruptedException {
	  enquirePageWebElements.writeName("Deepayan Tester");
	  enquirePageWebElements.writeEmail("tester@tester.com");
	  enquirePageWebElements.writeMobile("1234567890");
	  enquirePageWebElements.writePincode("7314");
	  enquirePageWebElements.clickEnquireNow();
	  AssertJUnit.assertEquals("Enter a valid 6 digit Zip Code",enquirePageWebElements.verifyErrorMessages());
	  
  }

  @AfterMethod
  public void afterTest() {
	  driver.quit();
  }

  @BeforeSuite
  public void beforeSuite() {
	  
  }

}
