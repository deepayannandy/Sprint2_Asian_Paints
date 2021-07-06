package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class mobileNumber {
	WebDriver driver= enquire.driver;
	@When("user click on the Get Link button")
	public void user_click_on_the_Get_Link_button() {
		driver.findElement(By.xpath("//button[@class='ctaText send-download-app-link track_download_app']")).click();
		
	}

	@When("user enter a valid mobile number as {string}")
	public void user_enter_a_valid_mobile_number_as(String string) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 2500)"); 
		driver.findElement(By.xpath("//input[@id='paintingAppMobile']")).sendKeys(string);
	}

	@Then("user should get a message as {string}")
	public void user_should_get_a_message_as(String string) throws InterruptedException {
		Thread.sleep(5000);
		try {
		String successmessage= driver.findElement(By.xpath("//div[@class='mobile-success-message']/span")).getText(); 
		System.out.println("#############################################################");
		System.out.println(successmessage);
		System.out.println("#############################################################");
		}
		catch(Exception e){
			String error_message= driver.findElement(By.xpath("//div[@class='form-global form-text-input textInputWrap textInputWrap__login-mobile form-global--error form-text-input--error']/div[2]")).getText(); 
			System.out.println("#############################################################");
			System.out.println(error_message);
			System.out.println("#############################################################");
		}
		
		
	}


}
