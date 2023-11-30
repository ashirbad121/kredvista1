package com.onlinebanking.GenereicUtils;


	import java.io.IOException;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Parameters;

	import com.ObjectRepo.HomePage;
	import com.ObjectRepo.StaffHomePage;
	import com.ObjectRepo.StaffLoginPage;

	public class BaseClass {

		public DBUtils dLib=new DBUtils();
		public ExcelUtils eLib=new ExcelUtils();
		public FileUtils fLib=new FileUtils();
		public WebDriverUtils wLib=new WebDriverUtils();
		public WebDriver driver;
		public static WebDriver sdriver;
		
		@BeforeSuite(alwaysRun = true)
		public void config_DB() throws Throwable {
			dLib.connectDB();
			System.out.println("---connect to DB---");
		}
		
		//@Parameters("BROWSER")
		@BeforeClass(alwaysRun = true)
		public void config_BC() throws IOException {
			String BROWSER=fLib.readDataFromPropertyFile("browser");
			if(BROWSER.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
				System.out.println("chrome launched");
			}
			else if(BROWSER.equalsIgnoreCase("edge")) {
				driver=new EdgeDriver();
				System.out.println("edge launched");
			}
			else {
				System.out.println("---Invalid browser----");
			}
			sdriver=driver;
			wLib.maximizeWindow(driver);
			System.out.println("browser launched");
		}
		
		@BeforeMethod(alwaysRun = true)
		public void config_BM() throws Throwable {
			String URL=fLib.readDataFromPropertyFile("url");
			String USERNAME=fLib.readDataFromPropertyFile("staffUsername");
			String PASSWORD=fLib.readDataFromPropertyFile("staffPassword");
			
			
			driver.get(URL);
			wLib.waitForPageLoad(driver, 10);

			HomePage hp=new HomePage(driver);
			hp.clickOnStaffLoginLink();
			
			StaffLoginPage slp=new StaffLoginPage(driver);
			slp.StaffLogin(USERNAME, PASSWORD);
			
			System.out.println("---staff login---");
			
		}
		
		@AfterMethod(alwaysRun = true)
		public void config_AM() {
			StaffHomePage shp= new StaffHomePage(driver);
			shp.clickOnLogOutButton();
			System.out.println("---Logout---");
		}
		
		@AfterClass(alwaysRun = true)
		public void config_AC() {
			driver.quit();
			System.out.println("---Close browser----");
		}
		
		@AfterSuite(alwaysRun = true)
		public void config_AS() throws Throwable {
			dLib.disconnectDB();
		}
		
	}
	
	
