package com.rest.examinationsystem.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelUtil {
	

	
	//public TreeMap<String, String> excelHederDetail;

	public Map<Integer, Map<Integer, byte[]>> getImageIndex(String path) throws IOException {
		Map<Integer, Map<Integer, byte[]>> pictureMap = new HashMap<>();
		FileInputStream fileInputStream = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
		XSSFDrawing xssDrawing = sheet.getDrawingPatriarch();

		if (null != xssDrawing) {
			List<XSSFShape> shapes = xssDrawing.getShapes();
			Map<Integer, byte[]> columnMap = Collections.emptyMap();
			for (XSSFShape shape : shapes) {
				if (shape instanceof XSSFPicture) {
					XSSFPicture hssfPicture = (XSSFPicture) shape;
					PictureData data = hssfPicture.getPictureData();
					byte[] picData = data.getData();
					int rowIndex = hssfPicture.getClientAnchor().getRow1();
					int colIndex = hssfPicture.getClientAnchor().getCol1();
					if (pictureMap.containsKey(rowIndex)) {
						columnMap = pictureMap.get(rowIndex);
					} else {
						columnMap = new HashMap<>();
					}
					columnMap.put(colIndex, picData);
					pictureMap.put(rowIndex, columnMap);
				}
			}
		}
		return pictureMap;
	}
	
	
	public void convertExcelToItemObject(String filePath) throws IOException {

		Map<Integer, Map<Integer, byte[]>> imageMap =  getImageIndex(filePath);
		List<String> headerList = Collections.emptyList();
		FileInputStream file = new FileInputStream(new File(filePath));

		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(file);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();
		int rowIndex = 0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (0 == rowIndex) {
				headerList = getHeader(row);
			} else {
				int emptyColumn = 0;
				for (int j = 0; j < headerList.size(); j++) {
					Cell cell = row.getCell(j);
                    if (cell == null || cell.getCellType() == CellType.BLANK) {
                    	if(imageMap!=null && imageMap.containsKey(rowIndex)) {
                    		Map<Integer, byte[]> columnMap = imageMap.get(rowIndex);
                    		if(columnMap.containsKey(j)) {
                    			System.out.println(" Row " + rowIndex + " Column "+j +" and Image "+columnMap.get(j));
                    		}else {
                    			emptyColumn++;
                    		}
                    	}else {
                    		emptyColumn++;	
                    	}
                    }
				}
			}
			rowIndex++;
		}
	}
	
	private List<String> getHeader(Row row) {
		List<String> headerList = new ArrayList<String>();
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = (Cell) cellIterator.next();
			if (cell != null && cell.getCellType() != CellType.BLANK) {
				if (cell.getCellType() == CellType.STRING) {
					headerList.add(cell.getStringCellValue());
				}
				if (cell.getCellType() == CellType.NUMERIC) {
					headerList.add(String.valueOf(cell.getNumericCellValue()));
				}
			}
		}
		return headerList;
	}

}
