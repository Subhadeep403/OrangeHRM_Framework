package Generic_Utility;

import com.opencsv.exceptions.CsvValidationException;

public class AddEmp {
	public String getEmployee(int i,int j) throws CsvValidationException {
	
	Csv_Utility c= new Csv_Utility();
	
		String name = c.readCellValueFromCSV(i,j);
	
	return name;
	
}
}
