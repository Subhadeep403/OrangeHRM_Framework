package Generic_Utility;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Csv_Utility {

	public  String readCellValueFromCSV(int rowNumber, int columnNumber) throws CsvValidationException {

		String csvFilePath = "./src/test/resources/EmployeeData.csv";

		try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
			String[] nextLine;
			int currentRow = 0;
			while ((nextLine = reader.readNext()) != null) {
				if (currentRow == rowNumber) {
					if (columnNumber >= 0 && columnNumber < nextLine.length) {
						return nextLine[columnNumber];
					} else {
						System.out.println("Invalid column number: " + columnNumber);
						return null;
					}
				}
				currentRow++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Row not found: " + rowNumber);
		return null;
	}

}
