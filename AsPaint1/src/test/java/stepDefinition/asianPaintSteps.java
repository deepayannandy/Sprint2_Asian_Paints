package stepDefinition;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModels.androidPage;
import pageObjectModels.enquirePage;
import pageObjectModels.exploreStorePage;
import pageObjectModels.iosPage;
import pageObjectModels.mobileNumberPage;

public class asianPaintSteps {
	WebDriver driver;
	enquirePage enquirePageWebElements;
	iosPage iosPageWebElements;
	androidPage androidPageWebElements;
	exploreStorePage exploreStorePageWebElement;
	mobileNumberPage mobileNumberPageWebElement;
	String baseUrl="https://www.asianpaints.com";
	
	@Before
	public void lanchApplication()
	{     
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		
		  System.out.println("before senario");
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\deenandy\\Desktop\\Officework\\Selenium\\driver\\chromedriver.exe");
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
	@After
	public void closeApplication() {
		driver.quit();
	}
	
	@Given("the user is on the home page of Asian Paints")
	public void the_user_is_on_the_home_page_of_Asian_Paints() {
		enquirePageWebElements.openPage(baseUrl);
	}
	@When("user enter valid Name as {string}")
	public void user_enter_valid_Name_as(String string) {
		enquirePageWebElements.writeName(string);
	}

	@When("user enter valid Email as {string}")
	public void user_enter_valid_Email_as(String string) {
		enquirePageWebElements.writeEmail(string);
	}

	@When("user enter valid Mobile no. as {string}")
	public void user_enter_valid_Mobile_no_as(String string) {
		enquirePageWebElements.writeMobile(string);
	}

	@When("user enter valid Pin as {string}")
	public void user_enter_valid_Pin_as(String string) {
		enquirePageWebElements.writePincode(string);
	}

	@When("user click on the Enqure NOW button")
	public void user_click_on_the_Enqure_NOW_button() {
		enquirePageWebElements.clickEnquireNow();
	}

	@Then("user should able to see the Thank you message")
	public void user_should_able_to_see_the_Thank_you_message() throws InterruptedException{
		enquirePageWebElements.verifySuccessMessage();
	}

	@Then("user closes browser")
	public void user_closes_browser() {
		enquirePageWebElements.closePage();

	}

	@When("user enter invalid Name as {string}")
	public void user_enter_invalid_Name_as(String string) {
		enquirePageWebElements.writeName(string);
	}

	@When("user enter invalid Email as {string}")
	public void user_enter_invalid_Email_as(String string) {
		enquirePageWebElements.writeEmail(string);
	}

	@When("user enter invalid Mobile no. as {string}")
	public void user_enter_invalid_Mobile_no_as(String string) {
		enquirePageWebElements.writeMobile(string);
	}

	@When("user enter invalid Pin as {string}")
	public void user_enter_invalid_Pin_as(String string) {
		enquirePageWebElements.writePincode(string);
	}

	@Then("user should able to see the Error you message")
	public void user_should_able_to_see_the_Error_you_message() throws InterruptedException {
		enquirePageWebElements.verifyErrorMessages();
	}
	// IosAppDownload
	@When("user click on the Download on the App Store button")
	public void user_click_on_the_Download_on_the_App_Store_button( ) {
		iosPageWebElements.clickDownloadIosApp();
		
	}
	@When("user scroll down to the Design and color app section")
	public void user_scroll_down_to_the_Design_and_color_app_section() {
		iosPageWebElements.scrollToColorsapp();
	}

	@Then("user should be redirected to Color with Asian paint on the App Store page")
	public void user_should_be_redirected_to_Color_with_Asian_paint_on_the_App_Store_page() throws InterruptedException {
		iosPageWebElements.verifyAppStorePage();
	}

	@When("user click on the Get it on Google Play button")
	public void user_click_on_the_Get_it_on_Google_Play_button() {
		androidPageWebElements.downloadAndroidApp();
	}

	@Then("user should be redirected to Color with Asian paint-Wall paint app- Apps on Google Playstore page")
	public void user_should_be_redirected_to_Color_with_Asian_paint_Wall_paint_app_Apps_on_Google_Playstore_page() throws InterruptedException {
		androidPageWebElements.verifyPlayStorePage();
	}
	@When("user scroll down to the Explore Store section")
	public void user_scroll_down_to_the_Explore_Store_section() {
		exploreStorePageWebElement.scrollToExploreStore();
	}

	@When("user enter a valid pin code as {string}")
	public void user_enter_a_valid_pin_code_as(String string) {
		exploreStorePageWebElement.writePinExploreStore(string);
	}
	@When("user click on the Go button")
	public void user_click_on_the_Go_button() {
		exploreStorePageWebElement.clickGo();
	}


	@Then("user should redirected to Store Locator page")
	public void user_should_redirected_to_Store_Locator_page() throws InterruptedException {
		exploreStorePageWebElement.verifyExploreStore();
	}
	@When("user click on the Get Link button")
	public void user_click_on_the_Get_Link_button() {
		mobileNumberPageWebElement.clickGetLink();
		
	}

	@When("user enter a valid mobile number as {string}")
	public void user_enter_a_valid_mobile_number_as(String string) {
		mobileNumberPageWebElement.writeMobileNumber(string);
	}

	@Then("user should get a message as {string}")
	public void user_should_get_a_message_as(String string) throws InterruptedException {
		mobileNumberPageWebElement.verifySms();
	}
}
