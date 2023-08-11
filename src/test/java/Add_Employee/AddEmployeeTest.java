package Add_Employee;

import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import Generic_Utility.AddEmp;
import Generic_Utility.BaseClass;
import Generic_Utility.Webdriver_utility;
import POM.AddEmployeePage;
import POM.DashboardPage;
import POM.EmployeeListPage;
import POM.PimPage;

public class AddEmployeeTest extends BaseClass {
	@Test
	public void AddEmployee() throws IOException, InterruptedException, CsvValidationException {

		Webdriver_utility w = new Webdriver_utility();
		w.implicitlyWait(driver);
		// maximizing the web page
		w.maximize(driver);
		// click on PIM
		DashboardPage d = new DashboardPage(driver);
		d.clickPIM(driver);
		// click add Employee link
		PimPage pim = new PimPage(driver);
		pim.addEmployee(driver);
		// add emp
		AddEmp a = new AddEmp();

		AddEmployeePage emp = new AddEmployeePage(driver);
		for (int i = 1; i <= 3; i++) {
			emp.addFirstName(a.getEmployee(i, 0));
			emp.addMiddleName(a.getEmployee(i, 1));
			emp.addLastName(a.getEmployee(i, 2));
			emp.addEmployee_Id();
			emp.clickSave(driver);
			Thread.sleep(2000);
			pim.addEmployee(driver);
		}
		Thread.sleep(2000);
		// click on Employee_List
		pim.clickEmployee_List(driver);

		EmployeeListPage emplist = new EmployeeListPage(driver);
		//enter added employee name
		String name = a.getEmployee(1, 0)+" "+a.getEmployee(1, 1)+" "+a.getEmployee(1, 2);
		emplist.enterEmployeeName(name);
		Thread.sleep(2000);
		emplist.clickSearch(driver);
		Thread.sleep(2000);
		//verify employee from employee list
		emplist.verifyEmployeeName(name);

	}
}