package excelExercise2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exercise2 {

	public static void main(String[] args) throws IOException {

	}
	
	public ArrayList<String> getData(String testCaseName) throws IOException{

		ArrayList<String> a = new ArrayList<String>();		
		FileInputStream fis = new FileInputStream("C://Users//90543//Desktop//veriler.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		
		int sheets =workbook.getNumberOfSheets();
		
		for (int i = 0; i < sheets; i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testData1")){
			
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> row = sheet.iterator();//bir sayfanýn aþaðýya inen satýrlarý için 
				Row firstRow =row.next();
				Iterator<Cell> cell =firstRow.cellIterator();//sayfanýn saða giden satýrlarý için 
				int k=0;
				int coloumn =0;
				
				while(cell.hasNext()){
					
					Cell value =cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")){
						
						coloumn =k;
					}
					
					k++;
				}
				System.out.println(coloumn);
				
				while(row.hasNext()){
					
					Row r =row.next();
					if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testCaseName)){
						
						Iterator<Cell> cý =r.cellIterator();
						while(cý.hasNext()){
							
							a.add(cý.next().getStringCellValue());
						}
					}
					
				}
				
			}
			
		}
	
		return a;
	}
	
		
		
	

}
