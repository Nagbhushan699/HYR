package com.hyr.calendar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDateFromDropdown {
	static WebDriver driver;
	      @Test(dataProvider = "dp1")
          public static void handleCalendar(String year,String month,String date) {
	    	  WebDriverManager.chromedriver().setup();
	  		driver=new ChromeDriver();
	  		driver.manage().window().maximize();
	  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
	  		driver.findElement(By.id("third_date_picker")).click();
        	  WebElement yr=driver.findElement(By.className("ui-datepicker-year"));
      		Select selyr=new Select(yr);
      		selyr.selectByVisibleText(year);
      		WebElement mon=driver.findElement(By.className("ui-datepicker-month"));
      		Select selmon=new Select(mon);
      		selmon.selectByVisibleText(month);
      		String xpath="//a[text()='"+date+"']";
      		driver.findElement(By.xpath(xpath)).click();	
      		driver.quit();
          }
	      @DataProvider
	      public Object[][] dp1() {
	    	  Object[][]ob= {{"2020","Nov","20"}};
	    	  return ob;
	      }
//	public static void main(String[] args) {
////		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chromedriver\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
//		driver.findElement(By.id("third_date_picker")).click();
//		handleCalendar("2020","Nov","20");
//	}

}
