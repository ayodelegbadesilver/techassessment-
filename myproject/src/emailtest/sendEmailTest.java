package emailtest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sendEmailTest {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	//open gmail account
	driver.get("https://mail.google.com/");
	driver.manage().window().maximize();
	
	String title = driver.getTitle();
	System.out.println(title);
	
	driver.findElement(By.id("identifierId")).sendKeys("fadiqwade2021@gmail.com");
	driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys("Test1234$$");
	driver.findElement(By.xpath("//*[@id='passwordNext']")).click();
	
	
	//Compose Email
	driver.findElement(By.cssSelector("div.T-I.T-I-KE.L3")).click();
	driver.findElement(By.name("to")).clear();
	driver.findElement(By.name("to")).sendKeys("aysilver@yopmail.com");
	driver.findElement(By.name("subjectbox")).clear();
	driver.findElement(By.name("subjectbox")).sendKeys("hi");
	driver.findElement(By.xpath("//td[2]/div[2]/div")).clear();
	driver.findElement(By.xpath("//td[2]/div[2]/div")).sendKeys("Automation test");
	driver.findElement(By.xpath("//div[4]/table/tbody/tr/td/div/div[2]/div")).click();
	
	//Switching to new tab
	((JavascriptExecutor) driver).executeScript("window.open()");
	
	ArrayList<String> Available_tabs =new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(Available_tabs.get(1));
	driver.get("https://yopmail.com/en/");
	String titled = driver.getTitle();
	System.out.println(titled);
	
	//Search for Email
	driver.findElement(By.id("login")).clear();
	driver.findElement(By.id("login")).sendKeys("aysilver@yopmail.com");
	
	driver.findElement(By.xpath("//button/i")).click();

	String Text = driver.findElement(By.xpath("//div/div/div/div")).getText();
	System.out.println(Text);
	System.out.println("Automation email recieved");
	
	driver.quit();
	
	
	
	
}

}
