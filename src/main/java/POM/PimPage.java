package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPage {

	public PimPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Add Employee")
	private WebElement Add_Employee;

	@FindBy(linkText = "Employee List")
	private WebElement Employee_List;

	//// getters methods
	public WebElement getEmployee_List() {
		return Employee_List;
	}

	public WebElement getAdd_Employee() {
		return Add_Employee;

	}

	// logic
	public void addEmployee(WebDriver driver) {
		Add_Employee.click();
	}

	public void clickEmployee_List(WebDriver driver) {
		Employee_List.click();
	}

}
