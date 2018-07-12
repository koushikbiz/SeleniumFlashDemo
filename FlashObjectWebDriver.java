package config;

import org.openqa.selenium.WebDriver;

public class FlashObjectWebDriver
{
  private final WebDriver webDriver;
  private final String flashObjectId;
  
  public FlashObjectWebDriver(final WebDriver webDriver, final String flashObjectId) {
    this.webDriver = webDriver;
    this.flashObjectId = flashObjectId;
  }
  
  public String click(String objectId, String optionalButtonLabel) {
    return callFlashObject("doFlexClick", new String[] { objectId, optionalButtonLabel });
  }
  
  public String click(String objectId) {
    return click(objectId, "");
  }
  
  public String callFlashObject(final String functionName, final String... args) {
    final Object result = 
      ((org.openqa.selenium.JavascriptExecutor)webDriver).executeScript(
      makeJsFunction(functionName, args), 
      new Object[0]);
    
    return result != null ? result.toString() : null;
  }
  
  private String makeJsFunction(final String functionName, final String... args) {
    final StringBuffer functionArgs = new StringBuffer();
    
    if (args.length > 0) {
      for (int i = 0; i < args.length; i++) {
        if (i > 0) {
          functionArgs.append(",");
        }
        functionArgs.append(String.format("'%1$s'", new Object[] { args[i] }));
      }
    }
    return String.format(
      "return document.%1$s.%2$s(%3$s);", new Object[] {
      flashObjectId, 
      functionName, 
      functionArgs });
  }
}
