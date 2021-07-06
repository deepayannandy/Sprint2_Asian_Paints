package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class exploreStore {
	WebDriver driver= enquire.driver;
	@When("user scroll down to the Explore Store section")
	public void user_scroll_down_to_the_Explore_Store_section() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 2800)");
	}

	@When("user enter a valid pin code as {string}")
	public void user_enter_a_valid_pin_code_as(String string) {
		driver.findElement(By.xpath("//input[@id='ctaPincode']")).sendKeys(string);
	}
	@When("user click on the Go button")
	public void user_click_on_the_Go_button() {
		driver.findElement(By.xpath("//button[@class=\'ctaText baseBtn\']")).click();
	}


	@Then("user should redirected to Store Locator page")
	public void user_should_redirected_to_Store_Locator_page() throws InterruptedException {
		Thread.sleep(5000);
		String page_title=driver.getTitle();
		System.out.println("#############################################################");
		System.out.println(page_title);
		System.out.println("#############################################################");
	}

}
