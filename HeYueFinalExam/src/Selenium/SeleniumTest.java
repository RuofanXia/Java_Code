package Selenium;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
	
	WebDriver driver = new FirefoxDriver();
	
	@Test
	public void test() throws IOException {
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			driver.get("http://my.sc.edu");
		        
	        driver.findElement(By.linkText("Sign in to Self Service Carolina (SSC)")).click();
	        
	        driver.findElement(By.id("username")).sendKeys("00246928");
	        driver.findElement(By.id("password")).sendKeys("-----");
	        driver.findElement(By.name("submit")).click();
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "Main Menu";
	        if (!actualTitle.equals(expectedTitle)){
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(scrFile, new File("/Users/Fan/Desktop/ScreenShot.jpg"));
		        BufferedWriter writer = null;
		        try{
		        	String timelog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		        	timelog = timelog + ".txt";
		        	File logFile = new File(timelog);
		        	
		        	//this will output the full path where the file will be written to
		        	System.out.println(logFile.getCanonicalPath());
		        	
		        	writer = new BufferedWriter(new FileWriter(logFile));
		        	writer.write(driver.getPageSource());
		        }catch (Exception e){
		        	e.printStackTrace();
		        }finally{
		        	try{
		        		writer.close();
		        	}catch (Exception e){
		        		e.printStackTrace();
		        	}
		        }
	        }
	        
	        driver.quit();
	}

	
	@Test
	public void successfulTest() throws IOException{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("http://my.sc.edu");
	        
        driver.findElement(By.linkText("Sign in to Self Service Carolina (SSC)")).click();
        
        driver.findElement(By.id("username")).sendKeys("00246928");
        driver.findElement(By.id("password")).sendKeys("Xrf8909143518@");
        driver.findElement(By.name("submit")).click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Main Menu";
        if (actualTitle.equals(expectedTitle)){
        	
        	List<WebElement> mpdefault = driver.findElements(By.className("submenulinktext2"));
        	//the fourth webelement is student hyper-link
        	//System.out.println(mpdefault.size());
        	String studentUrl = mpdefault.get(1).getAttribute("href");
        	driver.get(studentUrl);
        	
        	List<WebElement> registList = driver.findElements(By.className("submenulinktext2"));
        	String registUrl = registList.get(1).getAttribute("href");
        	//System.out.println(registUrl);
        	driver.get(registUrl);
        	
        	List<WebElement> scheduleList = driver.findElements(By.className("submenulinktext2"));
        	String conciseSSUrl = scheduleList.get(6).getAttribute("href");
        	driver.get(conciseSSUrl);
        	
        	//search spring 2015 courses
        	Select dropdown = new Select(driver.findElement(By.id("term_id")));
        	dropdown.selectByVisibleText("Spring 2015");
        	driver.findElement(By.className("defaultButtonSmall")).click();
        	
        	//extract data
        	List<WebElement> text = driver.findElements(By.cssSelector("table.datadisplaytable"));
        	
        	BufferedWriter writer = null;
	        try{
	        	String timelog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	        	timelog = timelog + ".txt";
	        	File logFile = new File(timelog);
	        	
	        	//this will output the full path where the file will be written to
	        	System.out.println(logFile.getCanonicalPath());
	        	
	        	writer = new BufferedWriter(new FileWriter(logFile));
	        	int i=0;
	        	while(i<text.size()){
	        		writer.write(text.get(i).getText());
	        		i++;
	        	}
	        }catch (Exception e){
	        	e.printStackTrace();
	        }finally{
	        	try{
	        		writer.close();
	        	}catch (Exception e){
	        		e.printStackTrace();
	        	}
	        }
        }
        driver.quit();
	}
	
	@Test
	public void searchCourseTest() throws IOException{
		String[] courses = {"Fall 2013 (View only)", "Spring 2014 (View only)", "Fall 2014 (View only)",
    			"Spring 2015", "Fall 2015"};
		
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			driver.get("http://my.sc.edu");
		        
	        driver.findElement(By.linkText("Sign in to Self Service Carolina (SSC)")).click();
	        
	        driver.findElement(By.id("username")).sendKeys("00246928");
	        driver.findElement(By.id("password")).sendKeys("Xrf8909143518@");
	        driver.findElement(By.name("submit")).click();
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "Main Menu";
	        if (actualTitle.equals(expectedTitle)){
	        	
	        	BufferedWriter writer = null;
	        	for (int i=0; i<courses.length; i++){
	        		if ( i==0){
			        	List<WebElement> mpdefault = driver.findElements(By.className("submenulinktext2"));
			        	//the fourth webelement is student hyper-link
			        	//System.out.println(mpdefault.size());
			        	String studentUrl = mpdefault.get(1).getAttribute("href");
			        	driver.get(studentUrl);
		        	}
		        	
		        	List<WebElement> registList = driver.findElements(By.className("submenulinktext2"));
		        	String registUrl = registList.get(1).getAttribute("href");
		        	//System.out.println(registUrl);
		        	driver.get(registUrl);
		        	
		        	List<WebElement> lookup = driver.findElements(By.className("submenulinktext2"));
		        	String lookupUrl = lookup.get(2).getAttribute("href");
		        	driver.get(lookupUrl);
		        	
		        	//System.out.println(driver.getPageSource());
		        	
		        	//search spring courses
		        	Select dropdown = new Select(driver.findElement(By.id("term_input_id")));
		        	dropdown.selectByVisibleText(courses[i]);
		        	List<WebElement> buttonList = driver.findElements(By.className("defaultButtonSmall"));
		        	buttonList.get(0).click();
		        	Select selectCampus = new Select(driver.findElement(By.id("camp_id")));
		        	selectCampus.selectByVisibleText("USC Columbia");
		        	Select selectSubj = new Select(driver.findElement(By.id("subj_id")));
		        	selectSubj.selectByVisibleText("CSCE - Comp Sci & Comp Engr");
		        	List<WebElement> searchbuttonList = driver.findElements(By.className("defaultButtonSmall"));
		        	searchbuttonList.get(0).click();
		        	
		        	//System.out.println(driver.getPageSource());
		        	List<WebElement> textList = driver.findElements(By.cssSelector("table.datadisplaytable"));
		        	//System.out.println(textList.get(3).getText());
			        try{
			        	//String timelog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			        	//timelog = timelog + ".txt";
			        	String logname = courses[i] + ".txt";
			        	File logFile = new File(logname);
			        	
			        	//this will output the full path where the file will be written to
			        	System.out.println(logFile.getCanonicalPath());
			        	
			        	writer = new BufferedWriter(new FileWriter(logFile));
			        	
			        	writer.write(textList.get(3).getText());
			        	//writer.write(driver.getPageSource());
			        	//driver.findElement(By.linkText("EXIT")).click();
			        	WebElement studentElement = driver.findElement(By.className("menuSmallHighlight"));
			        	studentElement.click();
			        }catch (Exception e){
			        	e.printStackTrace();
			        }finally{
			        	try{
			        		writer.close();
			        	}catch (Exception e){
			        		e.printStackTrace();
			        	}
			        }
	        	}
	        }
	}
}
