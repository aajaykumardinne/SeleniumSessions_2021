package AlertsandPopUpConcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {

	// Revised
	public static void main(String[] args) throws InterruptedException {

		// Important topic for the Interview -- 100% 
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Launch Chrome

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click(); // click on Sign in button

		Thread.sleep(5000); 
		// pauses the web page even though the elements are loaded 
		// completeley for the web page.

		Alert alert = driver.switchTo().alert();
        // Alert is a method which returns the alert class.
		System.out.println(alert.getText());

		String text = alert.getText();

		if (text.equals("Please enter a valid user name")) {
			System.out.println("correct alert message");
		}

		else {
			System.out.println("incorrect alert message");

		}

		alert.accept(); // click on ok button

	//	alert.dismiss(); // click on cancel button

	}

}
