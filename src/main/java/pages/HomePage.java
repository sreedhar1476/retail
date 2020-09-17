package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import io.qameta.allure.Step;


public class HomePage extends TestBase {
	
	
	@FindBy(id = "com.jumia.android:id/navigation_account")
	WebElement lnkAccount;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@Step("click on Account link")
	public void clickOnAccountLink()  {
		lnkAccount.click();
    }
	
	
	
	
	

}
