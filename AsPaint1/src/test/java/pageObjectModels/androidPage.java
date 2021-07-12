package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class androidPage {
	public WebDriver driver;
	@CacheLookup
	@FindBy(xpath="//div[@class='logoImagesLinks track_android']/a") WebElement downloadAndroidButton;
	public androidPage(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void downloadAndroidApp() {
		downloadAndroidButton.click();
	}
	public  String verifyPlayStorePage() throws InterruptedException {
		Thread.sleep(4000);
		String window_titel= driver.getTitle();
		System.out.println("#############################################################");
		System.out.println(window_titel);
		System.out.println("#############################################################");
		return window_titel;
	}
}
