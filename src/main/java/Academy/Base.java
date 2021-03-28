package Academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\Academy\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapn\\Downloads\\chromedriver_win32\\chromedriver.exe");
			//Create a map to store  preferences 
			Map<String, Object> prefs = new HashMap<String, Object>();

			//add key and value to map as follow to switch off browser notification
			//Pass the argument 1 to allow and 2 to block
			prefs.put("profile.default_content_setting_values.notifications", 2);

			//Create an instance of ChromeOptions 
			ChromeOptions options = new ChromeOptions();

			// set ExperimentalOption - prefs 
			options.setExperimentalOption("prefs", prefs);

			//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
			driver = new ChromeDriver(options);
		}
		
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\swapn\\Downloads\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\swapn\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
