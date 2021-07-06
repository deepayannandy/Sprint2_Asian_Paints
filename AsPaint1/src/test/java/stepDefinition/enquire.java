package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class enquire {
	String baseUrl="https://www.asianpaints.com/";
	static WebDriver driver;

	@Given("the user is on the home page of Asian Paints")
	public void the_user_is_on_the_home_page_of_Asian_Paints() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deenandy\\Desktop\\Officework\\Selenium\\driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		System.out.println("Asian Paints home page loaded");
	}
	@When("user enter valid Name as {string}")
	public void user_enter_valid_Name_as(String string) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 400)"); 
		driver.findElement(By.id("enquire-name")).sendKeys(string);
	}

	@When("user enter valid Email as {string}")
	public void user_enter_valid_Email_as(String string) {
		driver.findElement(By.id("enquire-email")).sendKeys(string);
	}

	@When("user enter valid Mobile no. as {string}")
	public void user_enter_valid_Mobile_no_as(String string) {
		driver.findElement(By.id("enquire-mobile")).sendKeys(string);
	}

	@When("user enter valid Pin as {string}")
	public void user_enter_valid_Pin_as(String string) {
		driver.findElement(By.id("enquire-pincode")).sendKeys(string);
	}

	@When("user click on the Enqure NOW button")
	public void user_click_on_the_Enqure_NOW_button() {
		driver.findElement(By.xpath("//button[@class=\"ctaText enquireForm--step-1-submit track_form_submit\"]")).click();
	}

	@Then("user should able to see the Thank you message")
	public void user_should_able_to_see_the_Thank_you_message() throws InterruptedException{
		Thread.sleep(2000);
		String data= driver.findElement(By.xpath("//div[@class=\"thank-you-message\"]")).getText(); 
		System.out.println("#############################################################");
		System.out.println(data);
		System.out.println("#############################################################");
	}

	@Then("user closes browser")
	public void user_closes_browser() {
		driver.quit();
		System.out.println("Browser Closed");

	}

	@When("user enter invalid Name as {string}")
	public void user_enter_invalid_Name_as(String string) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 400)"); 
		driver.findElement(By.id("enquire-name")).sendKeys(string);
	}

	@When("user enter invalid Email as {string}")
	public void user_enter_invalid_Email_as(String string) {
		driver.findElement(By.id("enquire-email")).sendKeys(string);
	}

	@When("user enter invalid Mobile no. as {string}")
	public void user_enter_invalid_Mobile_no_as(String string) {
		driver.findElement(By.id("enquire-mobile")).sendKeys(string);
	}

	@When("user enter invalid Pin as {string}")
	public void user_enter_invalid_Pin_as(String string) {
		driver.findElement(By.id("enquire-pincode")).sendKeys(string);
	}



	@Then("user should able to see the Error you message")
	public void user_should_able_to_see_the_Error_you_message() throws InterruptedException {
		Thread.sleep(2000);
		String error_name=driver.findElement(By.xpath("//input[@id='enquire-name']/following-sibling::div")).getText();
		String error_email=driver.findElement(By.xpath("//input[@id='enquire-email']/following-sibling::div")).getText();
		String error_mobile=driver.findElement(By.xpath("//input[@id='enquire-mobile']/following-sibling::div")).getText();
		String error_pin=driver.findElement(By.xpath("//input[@id='enquire-pincode']/following-sibling::div")).getText();
		
		System.out.println("#############################################################");
		System.out.println(error_name+" "+error_email+" "+error_mobile+" "+error_pin);
		System.out.println("#############################################################");
	}

}
