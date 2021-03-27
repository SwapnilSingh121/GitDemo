package Academy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePage extends Base {
	
	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		
		driver=initializeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("swapnilsingh.121@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Facebook@1234");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.findElement(By.cssSelector("div[aria-label='Search by name or group']")).click();
		driver.findElement(By.cssSelector("input[aria-label='Search by name or group']")).sendKeys("vaibhav");
		
		List<WebElement> name=driver.findElements(By.xpath("//ul/li[@class=\"k4urcfbm\"]"));
		for(WebElement element:name) {
		if(element.getText().equalsIgnoreCase("Vaibhav Jindal")) {
			element.click();
			break;
		}
		}
		WebElement chatbox=driver.findElement(By.cssSelector("div[data-pagelet='ChatTab']"));
		chatbox.findElement(By.cssSelector("div[class='_1mf _1mj']")).sendKeys("hey bro"+Keys.ENTER);
		//driver.close();
	}

}
