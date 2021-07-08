package pageObjectModels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class exploreStorePage {
	public WebDriver driver;
	@CacheLookup
	@FindBy(xpath="//button[@class='ctaText baseBtn']") WebElement goButton;
	@FindBy(xpath="//input[@id='ctaPincode']") WebElement pinCode;
	
	public exploreStorePage(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void scrollToExploreStore() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 2800)");
	}
	public void writePinExploreStore(String pincode)
	{
		pinCode.sendKeys(pincode);
	}
	public void clickGo() {
		goButton.click();
	}
	public void verifyExploreStore() throws InterruptedException {
		Thread.sleep(5000);
		String page_title=driver.getTitle();
		System.out.println("#############################################################");
		System.out.println(page_title);
		System.out.println("#############################################################");
	}
}
