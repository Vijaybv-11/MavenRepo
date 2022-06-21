package Data_Driven_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Data {
public static  Object[][] readData(String sname, String File_Name) throws EncryptedDocumentException, IOException{
		
		File file = new File(File_Name);
		FileInputStream fs = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sheet = wb.getSheet(sname);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int columnCount= sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object data[][] = new Object[rowCount-1][columnCount];
		for(int i =1;i<rowCount;i++) {
			for(int j=0;j<columnCount;j++) {		
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;	
	}
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	    Object[][]  data=Excel_Data.readData("Sheet1","./src/test/resources/TestData/ELF34.xlsx");
		
	   // System.out.println(Arrays.deepToString(data));
	}
}
