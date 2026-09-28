package project;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QA {
	
	    WebDriver driver;//controls the browser
	    WebDriverWait wait;// waits for webpage elements


	    @BeforeTest // TestNG annotation.//runs methods before every test method
	    public void setup() {

	        driver = new ChromeDriver();

	        driver.manage().window().maximize();

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Wait to 5 seconds when searching for an element.

	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        driver.get("https://insight-eight-psi.vercel.app/");
	    }

	    @Test(priority = 1)
	    public void verifyDashboard() {

	        // Verify page is opened
	        //Assert.assertTrue(driver.getTitle().length() > 0);//checks whether the webpage has a title.

	        // Verify main heading
	        WebElement heading = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//*[contains(text(),'Insight into any GitHub profile')]")
	                )
	        );

	       

	      System.out.println("Dashboard module passed");
	      Assert.assertTrue(heading.isDisplayed());
	        
	    }

	    @Test(priority = 2)
	    public void searchValidGitHubUser() {

	        // Locate GitHub user search box
	        WebElement searchBox = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//input[contains(@placeholder,'Search GitHub users')]")
	                )
	        );
	        searchBox.sendKeys("torvalds");

	        // Press Enter
	        searchBox.sendKeys(Keys.ENTER);
	        wait.until(
	                ExpectedConditions.presenceOfElementLocated(
	                        By.xpath("//*[contains(text(),'torvalds')]")
	                )
	        );

	        System.out.println("Valid user search passed");
	        Assert.assertTrue(searchBox.isDisplayed(), "Valid GitHub user not found");
	    }
	    

	   @Test(priority = 3)
	    public void searchInvalidGitHubUser() {

	        WebElement searchBox = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//input[contains(@placeholder,'Search GitHub users')]")
	                )
	        );
	        searchBox.sendKeys("invaliduser123456789xyz");

	        searchBox.sendKeys(Keys.ENTER);

	        // Wait for page response
	        wait.until(ExpectedConditions.or(
	                ExpectedConditions.presenceOfElementLocated(
	                        By.xpath("//*[contains(text(),'not found')]")
	                ),
	                ExpectedConditions.presenceOfElementLocated(
	                        By.xpath("//*[contains(text(),'No user')]")
	                ),
	                ExpectedConditions.presenceOfElementLocated(
	                        By.xpath("//*[contains(text(),'error')]")
	                )
	        ));

	        System.out.println("Invalid user search passed");
	        Assert.assertTrue(searchBox.isDisplayed(), "Invalid user message is not displayed");
	    }

	   
	   
	    @Test(priority = 4)
	    public void verifyGitRating() {
	        WebElement gitRating = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("//*[contains(text(),'Git Rating')]")
	                )
	        );

	        gitRating.click();

	        // Wait for page to load
	        wait.until(ExpectedConditions.urlContains("rating"));

	        System.out.println("Git Rating module passed");
	        Assert.assertTrue(driver.getCurrentUrl().contains("rating"),
	                "Git Rating page did not open");
	    }


	    // =========================================================
	    // MODULE 5: TRENDING
	    // =========================================================

	    @Test(priority = 5)
	    public void verifyTrending() {

	        // Click Trending
	        WebElement trending = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("//*[contains(text(),'Trending')]")
	                )
	        );

	        trending.click();

	        // Wait for page load
	        wait.until(ExpectedConditions.or(
	                ExpectedConditions.urlContains("trending"),
	                ExpectedConditions.presenceOfElementLocated(
	                        By.xpath("//*[contains(text(),'Trending')]")
	                )
	        ));

	        System.out.println("Trending module passed");
	        Assert.assertTrue(driver.getCurrentUrl().contains("trending"),
	                "Trending page did not open");
	    }


	    // =========================================================
	    // MODULE 6: COMPARE
	    // =========================================================

	    @Test(priority = 6)
	    public void verifyCompareModule() {

	        WebElement compare = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("//*[contains(text(),'Compare')]")
	                )
	        );

	        compare.click();

	        // Wait for Compare page
	        wait.until(ExpectedConditions.or(
	                ExpectedConditions.urlContains("compare"),
	                ExpectedConditions.presenceOfElementLocated(
	                        By.xpath("//*[contains(text(),'Compare')]")
	                )
	        ));

	        System.out.println("Compare module passed");
	        Assert.assertTrue(driver.getCurrentUrl().contains("compare"),
	                "Compare page did not open");
	    }


	    // =========================================================
	    // MODULE 7: LEARN GIT
	    // =========================================================

	    @Test(priority = 7)
	    public void verifyLearnGit() {
	        
	        // Direct navigation to guarantee clean page state
	        driver.get("https://insight-eight-psi.vercel.app/learn");

	        // Wait until URL contains "learn" or page heading is visible
	        wait.until(
	            ExpectedConditions.or(
	                ExpectedConditions.urlContains("learn"),
	                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Learn Git')]"))
	            )
	        );

	        System.out.println("Learn Git module passed");
	        Assert.assertTrue(driver.getCurrentUrl().contains("learn"),
	                "Learn Git page did not open");
	    }


	    // =========================================================
	    // MODULE 8: SETTINGS
	    // =========================================================

	    @Test(priority = 8)
	    public void verifySettings() {

	        // Click Settings
	        WebElement settings = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("//*[contains(text(),'Settings')]")
	                )
	        );

	        settings.click();

	        // Wait for settings page
	        wait.until(ExpectedConditions.or(
	                ExpectedConditions.urlContains("settings"),
	                ExpectedConditions.presenceOfElementLocated(
	                        By.xpath("//*[contains(text(),'Settings')]")
	                )
	        ));

	        System.out.println("Settings module passed");
	        Assert.assertTrue(driver.getCurrentUrl().contains("settings"),
	                "Settings page did not open");

	    }


	    // =========================================================
	    // MODULE 9 : LOGIN
	    // =========================================================

	    @Test(priority = 9)
	    public void verifyLoginButton() {

	        // Locate Login button
	        WebElement loginButton = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("//button[contains(.,'Login')]")
	                )
	        );

	        

	        // Click Login
	        loginButton.click();

	        System.out.println("Login button module passed");
	        Assert.assertTrue(loginButton.isDisplayed());
	       
	    }


	    // =========================================================
	    // AFTER METHOD
	    // Close browser after every test
	    // =========================================================

	    @AfterTest
	    public void tearDown() {

	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}