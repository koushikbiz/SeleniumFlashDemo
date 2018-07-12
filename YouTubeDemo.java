package demoScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class YouTubeDemo {
   public static WebDriver driver;
   
  @Test
  public static void main(String[] args) throws InterruptedException {
	   
      // Open Firefox browser
	  System.setProperty("webdriver.gecko.driver","C:/Users/Me/Downloads/geckodriver-v0.20.1-win64/geckodriver.exe");
	  //System.setProperty("webdriver.chrome.driver","C:/Users/Me/Downloads/chromedriver_win32/chromedriver.exe");
	  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	  capabilities.setCapability("marionette", true);	  
	  driver = new FirefoxDriver();
   
      // Maximize browser
      driver.manage().window().maximize();   
      
      driver.get("https://www.youtube.com/watch?v=qxoXvn2l2gA");
      Thread.sleep(2000L);
      
      WebElement video = driver.findElement(By.tagName("video"));
      JavascriptExecutor js = (JavascriptExecutor) driver;

      //pausing the video
      js.executeScript("arguments[0].pause();", video);

      Thread.sleep(5000L);

      //playing the video         
      js.executeScript("arguments[0].play();", video);
      Thread.sleep(5000L);

      WebElement ytplayer = driver.findElement(By.id("movie_player"));
      JavascriptExecutor jse = (JavascriptExecutor) driver;
      //muting the video          
      jse.executeScript("arguments[0].mute();", ytplayer);
      Thread.sleep(5000L);


      //unmuting the video            
      jse.executeScript("arguments[0].unMute();", ytplayer);
      Thread.sleep(5000L);


      //set volume
      jse.executeScript("arguments[0].setVolume(10);", ytplayer);
      Thread.sleep(5000L);

      driver.quit();

  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
