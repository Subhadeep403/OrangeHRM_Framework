package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
		@FindBy(name="username")
		private WebElement usernametbx;
		@FindBy(name="password")
		private WebElement passwordtbx;
		@FindBy(xpath="//button[@type='submit']")
		private WebElement loginBtn;
		
		public WebElement getusernametbx() {
			return usernametbx;
		}
			public WebElement getpasswordtbx() {
				return passwordtbx;
			}
				public WebElement getsubmitBtn() {
					return loginBtn;
				}
				public  LoginPage(WebDriver driver) {
					PageFactory.initElements(driver,this);
					//PageFactory.........class
					//initElements.........static method
				}
				//Business logic
				/**
				 * 
				 * @param un
				 * @param pw
				 */
				public void setLogin(String un,String pw) {
					usernametbx.sendKeys(un);
					passwordtbx.sendKeys(pw);
					loginBtn.click();
		}
	}


