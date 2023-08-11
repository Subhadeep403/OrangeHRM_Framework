package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Java_Utility;

public class AddEmployeePage {
	
	public AddEmployeePage(WebDriver driver)
	{
	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement firstName;
	
	@FindBy(name="middleName")
	private WebElement middleName;
	
	@FindBy(name="lastName")
	private WebElement lastName;
	
	@FindBy(xpath="(//div//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement employee_Id;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement savebutton;
	
	//getter method
	public WebElement getFirstName() {
		return firstName;
	}
		public WebElement getMiddleName() {
			return middleName;
		}
			public WebElement getLastName() {
				return lastName;
			}
			
			public WebElement getSavebutton() {
				return savebutton;
			}
			
			public WebElement getemployeeId() {
				return employee_Id;
			}
			
			//Logicemployee_Id
			
			public void addFirstName(String name) {
				firstName.sendKeys(name);
			}
			
			public void addMiddleName(String name) {
				middleName.sendKeys(name);
			}
			public void addLastName(String name) {
				lastName.sendKeys(name);
			}
			
			public void addEmployee_Id() {
				Java_Utility j=new Java_Utility();
				int num = j.getRandomNum();
				employee_Id.sendKeys(""+num);
			}
			
			public void clickSave(WebDriver driver) {
				savebutton.click();
			}

	}
	

