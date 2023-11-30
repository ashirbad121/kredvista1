package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataIntoPropertyFiles {

	public static void main(String[] args) throws IOException {
		
		//create object of properties class
		Properties pObj=new Properties();
		pObj.setProperty("browser", "chrome");
		pObj.setProperty("url", "http://localhost:8888");
		pObj.setProperty("username", "admin");
		pObj.setProperty("password", "root");
		
		//create obj of fileOutputStream
		FileOutputStream fos=new FileOutputStream("./src/test/resources/CommonData.properties");
		pObj.store(fos, "write data");
		
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		pObj.load(fis);
		
		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

	}

}
