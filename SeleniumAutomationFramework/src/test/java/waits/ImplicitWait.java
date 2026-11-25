package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String Web = "https://www.hyrtutorials.com/p/waits-demo.html";
	       WebDriver d = new ChromeDriver();
	       d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       d.get(Web);
	       d.findElement(By.id("btn1")).click();
	       
	       d.findElement(By.id("txt1")).sendKeys("Hello");
	       
	       
		}

	}


