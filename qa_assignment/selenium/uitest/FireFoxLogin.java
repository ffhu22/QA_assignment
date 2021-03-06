package uitest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FireFoxLogin {
	private WebDriver driver;
	private Navigation navigation;
	private String baseUrl = "http://localhost:8080/Web_Application/logon.jsp";
	//http://68d56a5d.ngrok.io/Web_Application/
	/***
	@Before
	public void setUp() {
		//设置Chrome浏览器的位置
		System.setProperty("webdriver.gecko.driver", "/Users/fangfanghu/Documents/All/Tech/Selenium_Practice/geckodriver");	
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app");	
		driver = new FirefoxDriver();
	
		driver.manage().window().setSize(new Dimension(1280,800));
		navigation = driver.navigate();
		try {						
			//Thread.sleep(500);
			//TimeUnit.MILLISECONDS.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		if(driver!=null) {
			driver.close();
		}
	}	

	@Test
	public void loginFailedEmptyUsername() throws IOException {
		//加载到指定url
		navigation.to(baseUrl);
		
		//Verify login UI elements
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SeleniumUtils.assertAndTakeSnapshot(driver, SeleniumUtils.isTextInInput(driver, "username", ""));
	    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));

		//Input username/password, Click Login, open Homepage
	    List<WebElement> buttons = driver.findElements(By.tagName("input"));
	    driver.findElement(By.name("password")).sendKeys("123");
	    buttons.get(2).click();
	   
	    //Verify login displays, and UI elements are correct
	    //Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
	    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
	    assertEquals(driver.getTitle(), ("Logon Sample System"));
	}	


	@Test
	public void loginFailedEmptyPassword() throws IOException {
		//加载到指定url
		navigation.to(baseUrl);
		
		//Verify login UI elements
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SeleniumUtils.assertAndTakeSnapshot(driver, SeleniumUtils.isTextInInput(driver, "username", ""));
	    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));

		//Input username/password, Click Login, open Homepage
	    List<WebElement> buttons = driver.findElements(By.tagName("input"));
	    driver.findElement(By.name("username")).sendKeys("Amber");
	    buttons.get(2).click();
	   
	    //Verify login displays, and UI elements are correct
	    //Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login.png"));
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
	    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
	    assertEquals(driver.getTitle(), ("Logon Sample System"));
	}	
	
	@Test
	public void loginAndExitSucessfully() throws IOException {
		//加载到指定url
		navigation.to(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Verify login UI elements
		//Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
		SeleniumUtils.assertAndTakeSnapshot(driver, SeleniumUtils.isTextInInput(driver, "username", ""));
	    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
	    assertEquals(driver.getTitle(), ("Logon Sample System"));
	    
		//Input username/password, Click Login, open Homepage
		List<WebElement> buttons = driver.findElements(By.tagName("input"));
		assertEquals(buttons.get(2).getAttribute("Value"), "Login");
	    driver.findElement(By.name("username")).sendKeys("Amber");
	    driver.findElement(By.name("password")).sendKeys("123");
	    buttons.get(2).click();
	   
	    //Verify Homepage displays, and UI elements are correct
	    //Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "homepage_Amber.png"));
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Amber"));
	    Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "You are in homepage"));
	    assertEquals(driver.getTitle(), ("Logon success"));
	    
	    
	    //Click Exit to back to login page 
	    driver.findElement(By.cssSelector("input")).click();
	    //Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "login_Amber.png"));
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", "Amber"));
	    Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Sign Up"));
	    assertEquals(driver.getTitle(), ("Logon Sample System"));
	}
	
	
	@Test
	public void openLoginPage() throws IOException{
		navigation.to(baseUrl);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> buttons = driver.findElements(By.tagName("input"));
		assertEquals(buttons.get(2).getAttribute("Value"), "Login");
		Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
	    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
	    assertEquals(driver.getTitle(), ("Logon Sample System"));
	}
	@Test
	public void loginSucessfully() throws IOException {
		navigation.to(baseUrl);
		
		//Verify login UI elements
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		
		List<WebElement> buttons = driver.findElements(By.tagName("input"));
		assertEquals(buttons.get(2).getAttribute("Value"), "Login");
		assertEquals(driver.getTitle(), ("Logon Sample System"));
		Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "username", ""));
	    Assert.assertTrue(SeleniumUtils.isTextInInput(driver, "password", ""));
		//Input username/password, Click Login, open Homepage
	    driver.findElement(By.name("username")).sendKeys("Amber");
	    driver.findElement(By.name("password")).sendKeys("123");
	    buttons.get(2).click();
	   
	    //Verify Homepage displays, and user name and other UI elements are correct
	    //Assert.assertTrue(SeleniumUtils.verifyScreenshot(driver, "homepage_Amber.png"));
	    assertEquals(driver.getTitle(), ("Logon success"));
	    Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "Amber"));
		Assert.assertTrue(SeleniumUtils.isContentAppeared(driver, "You are in homepage"));
	}
	***/
}