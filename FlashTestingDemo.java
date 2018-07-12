package demoScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import config.FlashObjectWebDriver;	

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class FlashTestingDemo {
   public static WebDriver driver;
	
  @Test  
   
   public static void main(String[] args) throws InterruptedException {
   
      // Open Firefox browser
	  //System.setProperty("webdriver.gecko.driver","C:/Users/Me/Downloads/geckodriver-v0.20.1-win64/geckodriver.exe");
	  System.setProperty("webdriver.chrome.driver","C:/Users/Me/Downloads/chromedriver_win32/chromedriver.exe");
	  /*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	  capabilities.setCapability("marionette", true);	  
	  driver = new FirefoxDriver();*/
	  driver = new ChromeDriver();
	  
	  // Pass the URL of video
      driver.get("http://www.permadi.com/tutorial/flashjscommand/");      
      Thread.sleep(2000L);
   
      // Maximize browser
      driver.manage().window().maximize();
   
      //FlashObjectWebDriver is seperate class which is available inside jar which we have attached
      FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "myFlashMovie");   
        
   /*
      // let the video load
      while (Integer.parseInt(flashApp.callFlashObject("getPlayerState")) == 3){
      Thread.sleep(1000L);
      } */
   
      // Play the video for 10 seconds
      Thread.sleep(10000);
   
      // pause video using pauseVideo method
      flashApp.callFlashObject("Play");
   
      Thread.sleep(5000);
   
      // play video using playVideo method
      flashApp.callFlashObject("StopPlay");
      Thread.sleep(5000);
   
      // Seek to is method which will forword video to 140 second
      flashApp.callFlashObject("Rewind");
   
      // Wait for 5 seconds
      Thread.sleep(5000);
   
      //print out messaage
      System.out.println(flashApp.callFlashObject("GetVariable", "/:message"));
   
      // Wait for 5 seconds
      Thread.sleep(5000);
   
      //set the volume of  video using setVolume method
      flashApp.callFlashObject("SetVariable", "/:message", "Learn Flash testing with webdriver");
   
      // wait for 5 seconds
      Thread.sleep(5000);
      
      System.out.println(flashApp.callFlashObject("GetVariable", "/:message"));
      
      driver.quit();
   
  }
   
	
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
