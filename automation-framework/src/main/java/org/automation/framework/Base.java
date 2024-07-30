package org.automation.framework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.opencsv.CSVWriter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<ChromeOptions> ctOptions = new ThreadLocal<ChromeOptions>();
	private static String browserName;
	private static boolean isHeadless = false;
	static ChromeOptions chOptions;
	protected Properties prop = new Properties();
	

	int explWaitTime;

	
	public static WebDriver initialzedriver() throws IOException
	{
		String projectPath = System.getProperty("user.dir");

		browserName = "chrome";
		
		System.out.println(browserName);
		
		switch(browserName.toUpperCase())
		{
		case "CHROME":
			
			chOptions = new ChromeOptions();
			ctOptions.set(chOptions);
			if (isHeadless) {
				ctOptions.get().addArguments("headless");
			}
			System.out.println("Before driver initialisation"); //for debug
			try{
			driver = WebDriverManager.chromedriver().capabilities(chOptions).create();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("After driver initialisation"); //for debug

			System.out.println("Before setting driver in thread");
			tdriver.set(driver);
			System.out.println("After setting driver in thread");

			break;

		case "FIREFOX":
			
			FirefoxOptions fxOptions = new FirefoxOptions();
			if (browserName.contains("headless")) {
				fxOptions.addArguments("headless");
			}
			
			driver = WebDriverManager.firefoxdriver().capabilities(fxOptions).create();
			tdriver.set(driver);
			break;

		case "EDGE":
			EdgeOptions edgeOptions = new EdgeOptions();
			
			driver = WebDriverManager.edgedriver().create();
			tdriver.set(driver);
			break;

		default:
			break;
		}
		
		tdriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		tdriver.get().manage().deleteAllCookies();
		tdriver.get().manage().window().maximize();
		return tdriver.get();
		
	}
	
	private boolean isEmptyCheck(String value)
	{
		return  value == null || value.isBlank() || value.isEmpty() || value.equalsIgnoreCase("") ? true : false;
	}
	
	public void navigateToURL(String URL) {
		if(!isEmptyCheck(URL))
		{
			tdriver.get().get(URL);
		}
	}
	
	public void clickButton(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(tdriver.get(), Duration.ofSeconds(5));
		if(!(webElement==null))
		{
			wait.until(ExpectedConditions.visibilityOf(webElement));
			webElement.click();
		}
	}
	
	public void moveToElementAction(WebElement webElement)
	{
		WebDriverWait wait = new WebDriverWait(tdriver.get(), Duration.ofSeconds(5));
		tdriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Actions action = new Actions(tdriver.get());
		if(!(webElement==null))
		{
			wait.until(ExpectedConditions.visibilityOf(webElement));
			action.moveToElement(webElement);
			action.perform();
		}
	}
	
	public void clickAction(WebElement webElement)
	{
		WebDriverWait wait = new WebDriverWait(tdriver.get(), Duration.ofSeconds(5));
		tdriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Actions action = new Actions(tdriver.get());
		if(!(webElement==null))
		{
			wait.until(ExpectedConditions.visibilityOf(webElement));
			action.moveToElement(webElement).click().build().perform();
			
		}
	}
	
	public void scrollTillTheBottom()
	{
		tdriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) tdriver.get();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}
	
	public  void writeCsvData(String filePath , List<String[]> data) 
	{ 
	   
	    File file = new File(filePath); 
	    try { 
	        // create FileWriter object with file as parameter 
	        FileWriter outputfile = new FileWriter(file); 
	  
	        // create CSVWriter object filewriter object as parameter 
	        CSVWriter writer = new CSVWriter(outputfile); 
	  
	        // add data to csv
	        data.stream().forEach(a -> writer.writeNext(a)); 
	       
	        // closing writer connection 
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        // TODO Auto-generated catch block 
	        e.printStackTrace(); 
	    } 
	} 
	

}
