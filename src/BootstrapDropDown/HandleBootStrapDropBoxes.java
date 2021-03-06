package BootstrapDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBootStrapDropBoxes {

	public static void main(String[] args) {

		// Revised
		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize(); // maximize the window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/"); // enter the URL

		driver.findElement(By.id("dropdownMenuButton")).click(); // button click

		List<WebElement> list = driver.findElements(By.xpath("//div[@class ='dropdown-menu' and @aria-labelledby='dropdownMenuButton']//a"));
		System.out.println(list.size());

		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("Another action")) {
				list.get(i).click();
				break;

			}

		}

	}

}
