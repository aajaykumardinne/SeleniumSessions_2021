package TestNgConcepts;

import org.testng.annotations.Test;

public class TestNgFeatures {

	// Revised

	@Test
	public void loginTest() {
		System.out.println("login test");
		int i = 9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void HomePageTest() {
		System.out.println("Home Page  test");
	}
	
	
	@Test(dependsOnMethods = "loginTest")
	public void SearchPageTest() {
		System.out.println("Search Page  test");
	}
	
	

	@Test(dependsOnMethods = "loginTest")
	public void RegPageTest() {
		System.out.println("Reg  Page  test");
	}
	
}
