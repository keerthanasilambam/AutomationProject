package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Fluent{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String web = "https://ui.vision/demo/webtest/implicitwaiting/";
		WebDriver d = new ChromeDriver();
	       d.get(web);
	       WebElement  drop = d.findElement(By.id("minutesSelect"));
	       Select dp = new Select(drop);
	       dp.selectByValue("4"); //5 secs
	       FluentWait<WebDriver> wait = new FluentWait<>(d)
	    		   .withTimeout(Duration.ofSeconds(10))
	    		   .pollingEvery(Duration.ofSeconds(2));
	       WebElement image =
	    		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img")));
	       System.out.println("Alarm clock Displayed: "+ image.isDisplayed());
	       

	}

}
