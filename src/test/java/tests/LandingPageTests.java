package tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import listeners.AllureListener;
import pages.AccountPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;

@Listeners({ AllureListener.class })
public class LandingPageTests extends TestBase {

	LandingPage landingpage;
	HomePage homepage;
	AccountPage accountPage;
	LoginPage loginPage;
	

	public LandingPageTests() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		landingpage = new LandingPage();
		homepage= new HomePage();
		accountPage = new AccountPage();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	@Description("Verify country language selected sucessfully")
	public void validateAddedTask() throws InterruptedException{
		landingpage.selectCountry();
		landingpage.selectCountryLanguage();
		homepage.clickOnAccountLink();
		accountPage.clickOnLoginButton();
		loginPage.login();
		}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
