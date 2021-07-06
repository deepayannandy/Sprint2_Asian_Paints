package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class iosApp {
	WebDriver driver= enquire.driver;
	@When("user click on the Download on the App Store button")
	public void user_click_on_the_Download_on_the_App_Store_button() {
		driver.findElement(By.xpath("//div[@class='logoImagesLinks track_ios']/a")).click();

	}

	@Then("user should be redirected to Color with Asian paint on the App Store page")
	public void user_should_be_redirected_to_Color_with_Asian_paint_on_the_App_Store_page() throws InterruptedException {
		Thread.sleep(4000);
		String window_titel= driver.getTitle();
		System.out.println("#############################################################");
		System.out.println(window_titel);
		System.out.println("#############################################################");
	}

}
