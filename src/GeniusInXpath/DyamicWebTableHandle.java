package GeniusInXpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DyamicWebTableHandle {

	// Revised
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); // launch chrome
		
		driver.manage().window().maximize(); // maximize the window
		driver.manage().deleteAllCookies();  // delete all the cookies
		
		// dynamic wait
		
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		driver.get("https://classic.freecrm.com/");
		
		driver.findElement(By.name("username")).sendKeys("aajaykumardinne");
		driver.findElement(By.name("password")).sendKeys("Meat@2050");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		// WebTable : data is stored in the form of rows and columns.
		
		//*[@id='vContactsForm']/table/tbody/tr[4]/td[2]/a
		//*[@id='vContactsForm']/table/tbody/tr[5]/td[2]/a
		//*[@id='vContactsForm']/table/tbody/tr[6]/td[2]/a
		//*[@id='vContactsForm']/table/tbody/tr[7]/td[2]/a
		
          // In html tr means the row , td means the column
		
		String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
		String after_xpath = "]/td[2]/a";
				

		//Method-1:
		for(int i=4; i<=6; i++) {
			String name = driver.findElement(By.xpath(before_xpath+i+ after_xpath)).getText();
			System.out.println(name);
			if(name.contains("Aajay34 Dinne34")) {
				//*[@id="vContactsForm"]/table/tbody/tr[5]/td[1]/input
				
				driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr["+i+"]/td[1]/input")).click();
			}
		}
		

	  //Method-2:
	
//	driver.findElement(By.xpath("//a[contains(text(),'Aajay34 Dinne34')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	

	}

}

