package testNg;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pageObjectModels.androidPage;
import pageObjectModels.enquirePage;
import pageObjectModels.exploreStorePage;
import pageObjectModels.iosPage;
import pageObjectModels.mobileNumberPage;

public class asPaintTestNg {
	WebDriver driver;
	enquirePage enquirePageWebElements;
	iosPage iosPageWebElements;
	androidPage androidPageWebElements;
	exploreStorePage exploreStorePageWebElement;
	mobileNumberPage mobileNumberPageWebElement;
	ExtentReports extent;
	XSSFWorkbook wb;
	
	

  @BeforeSuite
  public void steuoReport() {
	  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreport.html");
	  extent = new ExtentReports();
      extent.attachReporter(htmlReporter);
  }
  @BeforeMethod
  public void beforeTest() throws IOException {
		Properties properties = new Properties();
		FileInputStream inputstream = new FileInputStream("src\\test\\resources\\properties\\asianPaint.properties");
		properties.load(inputstream);
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		
		  System.out.println("before senario");
		  System.setProperty("webdriver.chrome.driver",properties.getProperty("chromeDriverPath"));
		  String baseUrl=properties.getProperty("baseUrl");
		  driver =new ChromeDriver(options);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.get(baseUrl); 
		  enquirePageWebElements=new enquirePage(driver);
		  iosPageWebElements = new iosPage(driver);
		  androidPageWebElements = new androidPage(driver);
		  exploreStorePageWebElement =new exploreStorePage(driver);
		  mobileNumberPageWebElement =new mobileNumberPage(driver);
		  
  }
  //Method 1: Test Enquire form using valid Details
  @Test (priority= 1, dataProvider="testCase1")
  public void EnquireFormWithValidData(String name, String email, int mobile, int pin, String message ) throws InterruptedException {
	  System.out.println(name+email+mobile+pin);
	  enquirePageWebElements.writeName(name);
	  enquirePageWebElements.writeEmail(email);
	  enquirePageWebElements.writeMobile(Integer.toString(mobile));
	  enquirePageWebElements.writePincode(Integer.toString(pin));
	  enquirePageWebElements.clickEnquireNow();
	  String recievedmessage=enquirePageWebElements.verifySuccessMessage();
	  ExtentTest test = extent.createTest("Test Enquire form using valid Details", "Test Enquire form using valid Details");
	  
	  if (recievedmessage.equalsIgnoreCase(message)) {
		  test.pass(message);
	  }
	  else {
		  test.fail(message);
	  }
	  Assert.assertEquals(message, recievedmessage);
	  
	  
  }
//Method 2: Test Enquire form using invalid name
  @Test (priority= 2, dataProvider="testCase2")
  public void EnquireFormWithInvalidName(String name, String email, int mobile, int pin, String message ) throws InterruptedException {
	  System.out.println(name+email+mobile+pin);
	  enquirePageWebElements.writeName(name);
	  enquirePageWebElements.writeEmail(email);
	  enquirePageWebElements.writeMobile(Integer.toString(mobile));
	  enquirePageWebElements.writePincode(Integer.toString(pin));
	  enquirePageWebElements.clickEnquireNow();
	  String recievedmessage=enquirePageWebElements.verifyErrorMessages();
	  ExtentTest test = extent.createTest("Test Enquire form using invalid name", "Test Enquire form using invalid name");
	  
	  if (recievedmessage.equalsIgnoreCase(message)) {
		  test.pass(message);
	  }
	  else {
		  test.fail(message);
	  }
	  Assert.assertEquals(message, recievedmessage);
	  
  }
//Method 3: Test Enquire form using invalid email
  @Test (priority= 3, dataProvider="testCase3")
  public void EnquireFormWithInvalidEmail(String name, String email, int mobile, int pin, String message ) throws InterruptedException {
	  System.out.println(name+email+mobile+pin);
	  enquirePageWebElements.writeName(name);
	  enquirePageWebElements.writeEmail(email);
	  enquirePageWebElements.writeMobile(Integer.toString(mobile));
	  enquirePageWebElements.writePincode(Integer.toString(pin));
	  enquirePageWebElements.clickEnquireNow();
	  String recievedmessage=enquirePageWebElements.verifyErrorMessages();
	  ExtentTest test = extent.createTest("Test Enquire form using invalid email", "Test Enquire form using invalid email");
	  
	  if (recievedmessage.equalsIgnoreCase(message)) {
		  test.pass(message);
	  }
	  else {
		  test.fail(message);
	  }
	  Assert.assertEquals(message, recievedmessage);
	  
  }
//Method 4: Test Enquire form using invalid mobile
  @Test (priority= 4, dataProvider="testCase4")
  public void EnquireFormWithInvalidMobile(String name, String email, int mobile, int pin, String message ) throws InterruptedException {
	  System.out.println(name+email+mobile+pin);
	  enquirePageWebElements.writeName(name);
	  enquirePageWebElements.writeEmail(email);
	  enquirePageWebElements.writeMobile(Integer.toString(mobile));
	  enquirePageWebElements.writePincode(Integer.toString(pin));
	  enquirePageWebElements.clickEnquireNow();
	  String recievedmessage=enquirePageWebElements.verifyErrorMessages();
	  ExtentTest test = extent.createTest("Test Enquire form using invalid mobile", "Test Enquire form using invalid mobile");
	  
	  if (recievedmessage.equalsIgnoreCase(message)) {
		  test.pass(message);
	  }
	  else {
		  test.fail(message);
	  }
	  Assert.assertEquals(message, recievedmessage);
  }
//Method 5: Test Enquire form using invalid pinCode
  @Test (priority= 5, dataProvider="testCase5")
  public void EnquireFormWithInvalidPincode(String name, String email, int mobile, int pin, String message ) throws InterruptedException {
	  System.out.println(name+email+mobile+pin);
	  enquirePageWebElements.writeName(name);
	  enquirePageWebElements.writeEmail(email);
	  enquirePageWebElements.writeMobile(Integer.toString(mobile));
	  enquirePageWebElements.writePincode(Integer.toString(pin));
	  enquirePageWebElements.clickEnquireNow();
	  String recievedmessage=enquirePageWebElements.verifyErrorMessages();
	  ExtentTest test = extent.createTest("Test Enquire form using invalid pincode", "Test Enquire form using invalid pincode");
	  
	  if (recievedmessage.equalsIgnoreCase(message)) {
		  test.pass(message);
	  }
	  else {
		  test.fail(message);
	  }
	  Assert.assertEquals(message, recievedmessage);
	  
  }
  
//Method 6: Test Explore store using pin code
  @Test (priority= 6, dataProvider="testCase6")
  public void exploreStore(int pin,String message) throws Exception {
	  System.out.println(pin+message);
	  exploreStorePageWebElement.scrollToExploreStore();
	  exploreStorePageWebElement.writePinExploreStore(Integer.toString(pin));
	  exploreStorePageWebElement.clickGo();
	  String recievedmessage=exploreStorePageWebElement.verifyExploreStore();
	  ExtentTest test = extent.createTest("Test Explore store using pin code", "Sopplied Data:"+pin);
	  if (recievedmessage.equalsIgnoreCase(message)) {
		  test.pass(message);
	  }
	  else {
		  test.fail(message);
	  }
	  Assert.assertEquals(message, recievedmessage);
  }
//Method 7: Test app download through sms part using valid mobile number
  @Test (priority =7, dataProvider="testCase7")
  public void appDownloadSmsValidNumber(int mobile,String message) throws InterruptedException {
	  System.out.println(mobile+message);
	  mobileNumberPageWebElement.writeMobileNumber(Integer.toString(mobile));
	  mobileNumberPageWebElement. clickGetLink();
	  String recievedmessage=mobileNumberPageWebElement.verifySms();
	  ExtentTest test = extent.createTest("Test app download through sms part using valid mobile number", "Sopplied Data:"+mobile);
	  if (recievedmessage.equalsIgnoreCase(message)) {
		  test.pass(message);
	  }
	  else {
		  test.fail(message);
	  }
	  Assert.assertEquals(message, recievedmessage);
  }
//Method 8: Test app download through sms part using invalid mobile number
  @Test (priority =8, dataProvider="testCase8")
  public void appDownloadSmsInvalidNumber(int mobile,String message) throws InterruptedException {
	  System.out.println(mobile+message);
	  mobileNumberPageWebElement.writeMobileNumber(Integer.toString(mobile));
	  mobileNumberPageWebElement. clickGetLink();
	  String recievedmessage=mobileNumberPageWebElement.verifySms();
	  ExtentTest test = extent.createTest("Test app download through sms part using invalid mobile number", "Sopplied Data:"+mobile);
	  if (recievedmessage.equalsIgnoreCase(message)) {
		  test.pass(message);
	  }
	  else {
		  test.fail(message);
	  }
	  Assert.assertEquals(message, recievedmessage);
  }
//Method 9: Test android colors app download link
  @Test (priority =9)
  public void androidPlaystoreLink() throws Exception {
	  androidPageWebElements.downloadAndroidApp();
	  String recievedmessage="Colour with Asian Paints - Wall Paint & Design App - Apps on Google Play";
	  String message= androidPageWebElements.verifyPlayStorePage();
	  String filename="androidError.png";
	  ExtentTest test = extent.createTest("Test android colors app download link", message);
	  if (recievedmessage.equalsIgnoreCase(message)) {
		  test.pass(message);
	  }
	  else {
		  test.fail(message);
		  androidPageWebElements.takeScreenShot(filename);
		  test.addScreenCaptureFromPath(filename);
	  }
	  Assert.assertEquals(message, recievedmessage);
  }
//Method 10: Test ios colors app download link
  @Test (priority =10)
  public void iosAppstoreLink() throws Exception {
	  iosPageWebElements.scrollToColorsapp();
	  iosPageWebElements.clickDownloadIosApp();
	  String filename="iosError.png";
	  String recievedmessage= iosPageWebElements.verifyAppStorePage();
	  String message="Colour with Asian Paints on the App?Store error";
	  ExtentTest test = extent.createTest("Test ios colors app download link", message);
	  if (recievedmessage.contains(message)) {
		  test.pass(message);
	  }
	  else {
		  test.fail(message);
		  iosPageWebElements.takeScreenShot(filename);
		  test.addScreenCaptureFromPath(filename);
	  }

	  Assert.assertEquals(true, recievedmessage.contains(message));
  }

  @AfterMethod
  public void afterTest() throws Exception {
	  driver.quit();
  }
  @AfterSuite
  public void afterSute() throws IOException {
	  wb.close();
	  extent.flush();
  }
  

  @BeforeSuite
  public void beforeSuite() {
	  
  }
  @DataProvider(name="testCase1")
  public Object[][] getTestDataTC1() throws Exception {
	  File src= new File("src\\test\\resources\\testData\\testData.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  wb= new XSSFWorkbook(fis);
	  System.out.println("Data Provider");
	  XSSFSheet sheet1=wb.getSheetAt(0);
	  Object[][] data= new Object[1][5];
	  data[0][0]=sheet1.getRow(0).getCell(0).getStringCellValue();
	  data[0][1]=sheet1.getRow(0).getCell(1).getStringCellValue();
	  data[0][2]=(int) sheet1.getRow(0).getCell(2).getNumericCellValue();
	  data[0][3]=(int) sheet1.getRow(0).getCell(3).getNumericCellValue();
	  data[0][4]=sheet1.getRow(0).getCell(4).getStringCellValue();
	  return data;
  }
  @DataProvider(name="testCase2")
  public Object[][] getTestDataTC2() throws Exception {
	  File src= new File("src\\test\\resources\\testData\\testData.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  wb= new XSSFWorkbook(fis);
	  System.out.println("Data Provider");
	  XSSFSheet sheet1=wb.getSheetAt(0);
	  Object[][] data= new Object[1][5];
	  data[0][0]=sheet1.getRow(1).getCell(0).getStringCellValue();
	  data[0][1]=sheet1.getRow(1).getCell(1).getStringCellValue();
	  data[0][2]=(int) sheet1.getRow(1).getCell(2).getNumericCellValue();
	  data[0][3]=(int) sheet1.getRow(1).getCell(3).getNumericCellValue();
	  data[0][4]=sheet1.getRow(1).getCell(4).getStringCellValue();
	  return data;
  }
  @DataProvider(name="testCase3")
  public Object[][] getTestDataTC3() throws Exception {
	  File src= new File("src\\test\\resources\\testData\\testData.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  wb= new XSSFWorkbook(fis);
	  System.out.println("Data Provider");
	  XSSFSheet sheet1=wb.getSheetAt(0);
	  Object[][] data= new Object[1][5];
	  data[0][0]=sheet1.getRow(2).getCell(0).getStringCellValue();
	  data[0][1]=sheet1.getRow(2).getCell(1).getStringCellValue();
	  data[0][2]=(int) sheet1.getRow(2).getCell(2).getNumericCellValue();
	  data[0][3]=(int) sheet1.getRow(2).getCell(3).getNumericCellValue();
	  data[0][4]=sheet1.getRow(2).getCell(4).getStringCellValue();
	  return data;
  }
  @DataProvider(name="testCase4")
  public Object[][] getTestDataTC4() throws Exception {
	  File src= new File("src\\test\\resources\\testData\\testData.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  wb= new XSSFWorkbook(fis);
	  System.out.println("Data Provider");
	  XSSFSheet sheet1=wb.getSheetAt(0);
	  Object[][] data= new Object[1][5];
	  data[0][0]=sheet1.getRow(3).getCell(0).getStringCellValue();
	  data[0][1]=sheet1.getRow(3).getCell(1).getStringCellValue();
	  data[0][2]=(int) sheet1.getRow(3).getCell(2).getNumericCellValue();
	  data[0][3]=(int) sheet1.getRow(3).getCell(3).getNumericCellValue();
	  data[0][4]=sheet1.getRow(3).getCell(4).getStringCellValue();
	  return data;
  }
  @DataProvider(name="testCase5")
  public Object[][] getTestDataTC5() throws Exception {
	  File src= new File("src\\test\\resources\\testData\\testData.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  wb= new XSSFWorkbook(fis);
	  System.out.println("Data Provider");
	  XSSFSheet sheet1=wb.getSheetAt(0);
	  Object[][] data= new Object[1][5];
	  data[0][0]=sheet1.getRow(4).getCell(0).getStringCellValue();
	  data[0][1]=sheet1.getRow(4).getCell(1).getStringCellValue();
	  data[0][2]=(int) sheet1.getRow(4).getCell(2).getNumericCellValue();
	  data[0][3]=(int) sheet1.getRow(4).getCell(3).getNumericCellValue();
	  data[0][4]=sheet1.getRow(4).getCell(4).getStringCellValue();
	  return data;
  }
  @DataProvider(name="testCase6")
  public Object[][] getTestDataTC6() throws Exception {
	  File src= new File("src\\test\\resources\\testData\\testData.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  wb= new XSSFWorkbook(fis);
	  System.out.println("Data Provider");
	  XSSFSheet sheet2=wb.getSheetAt(1);
	  Object[][] data= new Object[1][2];
	  data[0][0]=(int) sheet2.getRow(0).getCell(0).getNumericCellValue();
	  data[0][1]=sheet2.getRow(0).getCell(1).getStringCellValue();
	  return data;
  }
  @DataProvider(name="testCase7")
  public Object[][] getTestDataTC7() throws Exception {
	  File src= new File("src\\test\\resources\\testData\\testData.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  wb= new XSSFWorkbook(fis);
	  System.out.println("Data Provider");
	  XSSFSheet sheet3=wb.getSheetAt(2);
	  Object[][] data= new Object[1][2];
	  data[0][0]=(int) sheet3.getRow(0).getCell(0).getNumericCellValue();
	  data[0][1]=sheet3.getRow(0).getCell(1).getStringCellValue();
	  return data;
  }
  @DataProvider(name="testCase8")
  public Object[][] getTestDataTC8() throws Exception {
	  File src= new File("src\\test\\resources\\testData\\testData.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  wb= new XSSFWorkbook(fis);
	  System.out.println("Data Provider");
	  XSSFSheet sheet3=wb.getSheetAt(2);
	  Object[][] data= new Object[1][2];
	  data[0][0]=(int) sheet3.getRow(1).getCell(0).getNumericCellValue();
	  data[0][1]=sheet3.getRow(1).getCell(1).getStringCellValue();
	  return data;
  }



}
