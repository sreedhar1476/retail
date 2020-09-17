package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import io.qameta.allure.Step;
import utils.TestUtil;

public class LandingPage extends TestBase {

	@FindBy(id = "com.jumia.android:id/country_name")
	List<WebElement> txtCountryName;

	@FindBy(id = "com.jumia.android:id/item_text")
	List<WebElement> txtCountryLanguage;
	
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	@Step("select country")
	public void selectCountry()  {
		TestUtil.clickONListElement(txtCountryName, "Egypt");
		
    }	
	
	@Step("select countrylanguage")
	public void selectCountryLanguage() {
		TestUtil.clickONListElement(txtCountryLanguage, "English");
	}
		
}
