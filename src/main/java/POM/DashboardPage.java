package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Webdriver_utility;
public class DashboardPage {

	

			public DashboardPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			//declaration
			
				@FindBy(xpath="(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]")
				private WebElement PIM;
				
				@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
				private WebElement profileImg;
				
				@FindBy(linkText="Logout")
				private WebElement Logout;
				
				
				//getters methods
			
				public WebElement getProfileImg() {
					return profileImg;
				}
		       public WebElement getLogoutLink() {
					return Logout;
				}
			  
		         
		         //Business Logic --------------
		        
				
		         //Business Logic for PIM
				public void clickPIM(WebDriver driver)
				{
					Webdriver_utility wlib = new  Webdriver_utility();
					 wlib.mouseOverOnElement(driver, PIM);
					 PIM.click();
				}
				
		        // Logout
				public void LogoutLink(WebDriver driver)
				{
				/*	WebElement Administrator = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
					Actions a = new Actions(driver);
					a.moveToElement(Administrator).perform();
					driver.findElement(By.linkText("Sign Out")).click();
					
				      Actions act=new Actions(driver);
				          act.moveToElement(profileImg).perform();
				          */
					profileImg.click();
				          Logout.click();
				        
				}
			
			
		}



