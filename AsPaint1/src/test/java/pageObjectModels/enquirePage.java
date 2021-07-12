package pageObjectModels;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class enquirePage {
	public WebDriver driver;
	@CacheLookup
	@FindBy(id="enquire-name")WebElement enqName;
	@FindBy(id="enquire-email") WebElement enqEmail;
	@FindBy(id="enquire-mobile") WebElement enqMobile;
	@FindBy(id="enquire-pincode")WebElement enqPinCode;
	@FindBy(xpath="//button[@class=\"ctaText enquireForm--step-1-submit track_form_submit\"]")WebElement enqButton;
	@FindBy(xpath="//div[@class='thank-you-message']")WebElement successMsg;
	@FindBy(xpath="//input[@id='enquire-name']/following-sibling::div")WebElement errorName;
	@FindBy(xpath="//input[@id='enquire-email']/following-sibling::div")WebElement errorEmail;
	@FindBy(xpath="//input[@id='enquire-mobile']/following-sibling::div")WebElement errorMobile;
	@FindBy(xpath="//input[@id='enquire-pincode']/following-sibling::div")WebElement errorPincode;
	
	public enquirePage(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void openPage(String baseUrl) {
	System.out.println("Asian Paints home page loaded "+baseUrl);
	}
	public void writeName(String name) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 400)"); 
		enqName.sendKeys(name);
	}
	public void writeEmail(String email) {
		enqEmail.sendKeys(email);
	}
	public void writeMobile(String mobile) {
		enqMobile.sendKeys(mobile);
	}
	public void writePincode(String pin) {
		enqPinCode.sendKeys(pin);
	}
	public void clickEnquireNow() {
		enqButton.click();
	}
	public String verifySuccessMessage() throws InterruptedException {
		try {
		Thread.sleep(4000);
		String data= successMsg.getText(); 
		System.out.println("#############################################################");
		System.out.println(data);
		System.out.println("#############################################################");
		return data;}
		catch(Exception e) {
			System.out.println("#############################################################");
			System.out.println("Eliment not found");
			System.out.println("#############################################################");
			return null;
		}
	}
	public void closePage() {
		System.out.println("Browser Closed");
	}
	public String verifyErrorMessages() throws InterruptedException {
		Thread.sleep(2000);
		String error_name=errorName.getText();
		String error_email=errorEmail.getText();
		String error_mobile=errorMobile.getText();
		String error_pin=errorPincode.getText();
		
		String output=error_name+error_email+error_mobile+error_pin;
		System.out.println("#############################################################");
		System.out.println(error_name+error_email+error_mobile+error_pin);
		System.out.println("#############################################################");
		return output;
	
	}
}
