package pageObjectModels;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		Thread.sleep(5000);
		String window_titel= driver.getTitle();
		System.out.println("#############################################################");
		System.out.println(window_titel);
		System.out.println("#############################################################");
		return window_titel;
	}
	public void takeScreenShot(String name) throws Exception {
		File scfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scfile, new File(name));
	}
}
