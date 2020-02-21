package Practice.JavaScriptHighlight;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javasecripttest 
{

	public static void main(String[] args) 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://ui.freecrm.com/");
		driver.findElement(By.name("email")).sendKeys("benzzsp@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Password@49");
		WebElement logbtn=driver.findElement(By.xpath("//div[.='Login']"));
		flash(driver,logbtn);
	}
	public static void flash(WebDriver driver,WebElement element)
	{
		
		//JavaScriptExecutor Js =(JavaScriptExecutor)driver;
		String bckgndcolur=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++)
		{
			changeColor("rgb(0,255,0)",element,driver);
			changeColor(bckgndcolur,element,driver);
		}
	}
	
	public static void changeColor(String color,WebElement element,WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
		try {
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			
		}
	}
	
	}

