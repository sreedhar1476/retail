package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import io.qameta.allure.Step;
import utils.TestUtil;

public class LoginPage extends TestBase{
	
	
	@FindBy(id = "com.jumia.android:id/text_field")
    List<WebElement> txtlogin;
	
	@FindBy(id = "com.jumia.android:id/login_button_continue")
    WebElement btnLoginButton;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@Step("Login by proving eamil and password")
	public void login()  {
		
		TestUtil.enterTextONListElement(txtlogin, "Email", "sreeshree@gmail.com");
		TestUtil.enterTextONListElement(txtlogin, "Password", "Password");
		btnLoginButton.click();
		
    }

}
