package pageObjectModels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mobileNumberPage {
	public WebDriver driver;
	@CacheLookup
	@FindBy(xpath="//button[@class='ctaText send-download-app-link track_download_app']") WebElement getLinkButton;
	@FindBy(xpath="//input[@id='paintingAppMobile']") WebElement mobileNumber;
	@FindBy(xpath="//div[@class='mobile-success-message']/span") WebElement sendSuccess;
	@FindBy(xpath="//div[@class='form-global form-text-input textInputWrap textInputWrap__login-mobile form-global--error form-text-input--error']/div[2]") WebElement sendFail;
	
	public mobileNumberPage(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void writeMobileNumber(String mob) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 2500)"); 
		mobileNumber.sendKeys(mob);
	}
	public void clickGetLink() {
		getLinkButton.click();
	}
	public void verifySms() throws InterruptedException {
		Thread.sleep(5000);
		try {
		String successmessage= sendSuccess.getText(); 
		System.out.println("#############################################################");
		System.out.println(successmessage);
		System.out.println("#############################################################");
		}
		catch(Exception e){
			String error_message= sendFail.getText(); 
			System.out.println("#############################################################");
			System.out.println(error_message);
			System.out.println("#############################################################");
		}
	}
}
