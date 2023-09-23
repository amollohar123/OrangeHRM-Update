package OrangeHRM;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class project {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//login to Orangehrm Account
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button")).click();
		Thread.sleep(2000);
		
		//Profile Picture Upload
		driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[6]")).click();
		driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-image']")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		Robot rb=new Robot();
		rb.delay(1000);
		//this will put path to fill in clipboard
		StringSelection ss=new StringSelection("C:\\Users\\Amol\\OneDrive\\Desktop\\ironman.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Thread.sleep(2000);
		
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_CONTROL);

		rb.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(3000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@class='oxd-toast-start']")).getText());
		
		
		driver.findElement(By.xpath("(//div[@role='tablist']/div)[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Ramlal");
		driver.findElement(By.cssSelector("input[name='middleName']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.cssSelector("input[name='middleName']")).sendKeys("hiralal");
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Thakur");
		driver.findElement(By.xpath("(//form//div//div//div//input)[4]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		driver.findElement(By.xpath("(//form//div//div//div//input)[4]")).sendKeys("Ramu");
		driver.findElement(By.xpath("(//form//div//div//div//input)[5]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		driver.findElement(By.xpath("(//form//div//div//div//input)[5]")).sendKeys("1245");
		driver.findElement(By.xpath("(//form//div//div//div//input)[6]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		driver.findElement(By.xpath("(//form//div//div//div//input)[6]")).sendKeys("54321");
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]")).sendKeys("00000");
		driver.findElement(By.xpath("(//form//div//div//div//input)[8]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		driver.findElement(By.xpath("(//form//div//div//div//input)[8]")).sendKeys("2023-06-08");
		
		WebElement ele = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		
		Thread.sleep(1000);
	
		
		driver.findElement(By.xpath("//div/i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")).click();
		String Country="Indian";
		List<WebElement> listOfCountries=driver.findElements(By.xpath("//div[@role='listbox']//div/span"));
		for(WebElement c :listOfCountries)
		{
			if(c.getText().contains(Country)) {
				c.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("(//div/i)[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Single')]")).click();
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='yyyy-mm-dd'])[2]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		driver.findElement(By.xpath("(//input[@placeholder='yyyy-mm-dd'])[2]")).sendKeys("2023-09-06");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		
		
		}
}
