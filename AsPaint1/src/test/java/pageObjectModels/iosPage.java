package pageObjectModels;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iosPage {
	public WebDriver driver;
	@CacheLookup
	@FindBy(xpath="//div[@class='logoImagesLinks track_ios']/a") WebElement downloadIosButton;
	
	public iosPage(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public  void scrollToColorsapp() {
		System.out.println("Scroll down");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 2400)"); 
	}
	public  void clickDownloadIosApp() {
		downloadIosButton.click();
	}
	public  void verifyAppStorePage() throws InterruptedException {
		Thread.sleep(4000);
		String window_titel= driver.getTitle();
		System.out.println("#############################################################");
		System.out.println(window_titel);
		System.out.println("#############################################################");
	}
}
