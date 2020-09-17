package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import io.qameta.allure.Step;

public class AccountPage extends TestBase{
	
	@FindBy(id = "com.jumia.android:id/button_top_login")
    WebElement btnLogin;
	
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}

	@Step("click on LoginButton")
	public void clickOnLoginButton()  {
		btnLogin.click();
    }

}
