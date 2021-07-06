package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class androidApp {
	WebDriver driver= enquire.driver;
	@When("user scroll down to the Design and color app section")
	public void user_scroll_down_to_the_Design_and_color_app_section() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 2400)"); 
	}

	@When("user click on the Get it on Google Play button")
	public void user_click_on_the_Get_it_on_Google_Play_button() {
		driver.findElement(By.xpath("//div[@class='logoImagesLinks track_android']/a")).click();
	}

	@Then("user should be redirected to Color with Asian paint-Wall paint app- Apps on Google Playstore page")
	public void user_should_be_redirected_to_Color_with_Asian_paint_Wall_paint_app_Apps_on_Google_Playstore_page() throws InterruptedException {
		Thread.sleep(4000);
		String window_titel= driver.getTitle();
		System.out.println("#############################################################");
		System.out.println(window_titel);
		System.out.println("#############################################################");
	}
}
