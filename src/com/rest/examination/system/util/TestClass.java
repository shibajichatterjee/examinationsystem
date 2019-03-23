package com.rest.examination.system.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xlsx4j.sml.Worksheet;

public class TestClass {

	public static void  main (String[] args) throws IOException, InvalidFormatException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream(new File("H:\\JAVA\\SchoolProject\\MCQ.xls"));
		
		//XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
		 org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(file);
		//XSSFSheet xssfSheet = workbook.getSheetAt(0);
		 org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
		 int i = 0;
		 List lst = workbook.getAllPictures();
		    for (Iterator it = lst.iterator(); it.hasNext(); ) {
		    	
		    	
		        PictureData pict = (PictureData)it.next();
		        System.out.println(pict.getMimeType()); 
		        String ext = pict.suggestFileExtension();
		        byte[] data = pict.getData();
		        //if (ext.equals("png")){
		          try (OutputStream out = new FileOutputStream("H:\\JAVA\\SchoolProject\\pict-"+(i++)+".jpg")) {
 		            out.write(data);
		          }
		      //  }
		    }
		 
		 
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			 int xx = 0;
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = (Cell) cellIterator.next();
				
				//PictureData pict = (PictureData)cell;
				
				//String ext = pict.suggestFileExtension();
				//System.out.println(ext);
				
				System.out.println(cell.getCellType() + "Hello" + xx++);

				switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				System.out.println("xxxxxxxxxxxxxxxx " + cell.getStringCellValue());

				break;

		case Cell.CELL_TYPE_NUMERIC:
					System.out.println("xxxxxxxxxxxxxxxx " + cell.getNumericCellValue());

				break;
			default:
				break;
				}

			}
			
		}
		
	}

}
