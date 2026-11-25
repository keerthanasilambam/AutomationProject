package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Web = "https://www.hyrtutorials.com/p/waits-demo.html";
	       WebDriver d = new ChromeDriver();
	       d.get(Web);
	       WebDriverWait wait =new WebDriverWait(d,Duration.ofSeconds(10));
	       d.findElement(By.id("btn1")).click();
	       WebElement textField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt1")));
	       textField.sendKeys("Hi");
	}

}
