package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage {

	public EmployeeListPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	private WebElement employee_Name;

	@FindBy(xpath = "//button[text()=' Search ']")
	private WebElement search;

	@FindBy(xpath = "//div[@class='oxd-table-cell oxd-padding-cell'][3]")
	private WebElement verifyName;

	// getter method
	public WebElement getSearch() {
		return search;
	}

	public WebElement getEmployee_Name() {
		return employee_Name;
	}

	public WebElement getVerifyName() {
		return verifyName;
	}

	// Logic

	public void clickSearch(WebDriver driver) {
		search.click();
	}

	public void enterEmployeeName(String emp) {
		employee_Name.sendKeys(emp);
	}

	public void verifyEmployeeName(String emp) {

		String empName = verifyName.getText();
		if (emp.contains(empName))
			System.out.println("Employee Verified  ....PASS");

		else
			System.out.println("Employee Not Found ....FAIL");
	}

}
