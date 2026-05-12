package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public WebDriver driver;
	
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}

	public void selectDragDropWithIndex(WebElement element, int index) {
		
		Select object=new Select(element);
		object.selectByIndex(index);
	}

	
    public void selectDragDropWithVisibleText(WebElement element, String text) {
		
		Select object=new Select(element);
		object.selectByVisibleText(text);
	}
    
    public void clickWithJSexecutor(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    
    public void javascriptExecutorScrollDown(WebDriver driver,WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,350)", "");
    }
    
    public void javascriptExecutorScrollUp(WebDriver driver,WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,-350)", "");
    }
    
    public void verifyRightClick(WebDriver driver,WebElement element) {
    	
    	Actions action=new Actions(driver);
		action.contextClick(element).build().perform();
    }
    
    public void verifyDoubleClick(WebDriver driver,WebElement element) {
    	
    	Actions action=new Actions(driver);
		action.doubleClick(element).build().perform();
    }
    
    public void verifyMouseHover(WebDriver driver,WebElement element) {
    	
    	Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
    }
    
    public void verifyTotalFramesCount() {
    	
    	List<WebElement> totalframes=driver.findElements(By.tagName("iframe"));
		System.out.println(totalframes.size());
    }
    
    public void verifySwitchToFrames() {
    	
    	WebElement frames=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frames);
    }
    
    
    
}
