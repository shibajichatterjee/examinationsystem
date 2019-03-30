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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.examinationsystem.assesment.item.dto.AssesmentItemDto;
import com.rest.examinationsystem.assessment.item.options.dto.AssesmentItemOptionDto;

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

		Iterator<Row> rowIterator = sheet.rowIterator();
		List<AssesmentItemOptionDto> assesmentItemOptionDtoList = null;
		Map<AssesmentItemDto, List<AssesmentItemOptionDto>> assesmentItemDtoMap = new HashMap<>();
		
		AssesmentItemDto assesmentItemDto = null;
		AssesmentItemOptionDto assesmentItemOptionDto  = null;
				
		int rowIndex =0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			assesmentItemDto = new AssesmentItemDto();
			
			if (0 == rowIndex) {
				headerList = getHeader(row);
			} else {
				int emptyColumn = 0;
				assesmentItemOptionDtoList = new ArrayList<>();
				for (int j = 0; j < headerList.size(); j++) {
					Cell cell = row.getCell(j);	
					 assesmentItemOptionDto = new AssesmentItemOptionDto();
					if (cell == null || cell.getCellType() == CellType.BLANK) {
                    	if(imageMap!=null && imageMap.containsKey(rowIndex)) {
                    		Map<Integer, byte[]> imageColumnMap = imageMap.get(rowIndex);
                    		if(imageColumnMap.containsKey(j)) {
                    			 if(j==4) {
                    				 assesmentItemDto.setAssessmentItemImage(imageColumnMap.get(j));
                    			 }
                    			 if(j==7) {
                    				// assesmentItemOptionDto = new AssesmentItemOptionDto();
                    				 assesmentItemOptionDto.setOptionImage(imageColumnMap.get(j));
                    				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                    			 }
                    			 if(j==8) {
                    				 //assesmentItemOptionDto = new AssesmentItemOptionDto();
                    				 assesmentItemOptionDto.setOptionImage(imageColumnMap.get(j));
                    				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                    			 }
                    			 if(j==9) {
                    				 //assesmentItemOptionDto = new AssesmentItemOptionDto();
                    				 assesmentItemOptionDto.setOptionImage(imageColumnMap.get(j));
                    				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                    			 }
                    			 if(j==10) {
                    				 //assesmentItemOptionDto = new AssesmentItemOptionDto();
                    				 assesmentItemOptionDto.setOptionImage(imageColumnMap.get(j));
                    				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                    			 }
                    			 if(j==11) {
                    				 //assesmentItemOptionDto = new AssesmentItemOptionDto();
                    				 assesmentItemOptionDto.setOptionImage(imageColumnMap.get(j));
                    				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                    			 }
                    		}else {
                    			emptyColumn++;
                    		}
                    	}else {
                    		emptyColumn++;	
                    	}
                    }else {                 	
                    	if(cell.getCellType() == CellType.STRING) {
                    		if(j==0) {
                        		assesmentItemDto.setAssessmentItemTopic(cell.getStringCellValue());
                        	}
                        	if(j==1) {
                        		assesmentItemDto.setAssessmentItemGivenId(cell.getStringCellValue());
                        	}
                        	if(j==2) {
                        		assesmentItemDto.setAssesmentItemType(cell.getStringCellValue());
                        	}
                        	if(j==3) {
                        		assesmentItemDto.setAssessmentItemText(cell.getStringCellValue());
                        	}
                        	if(j==4) {
                        		assesmentItemDto.setAssessmentItemImage(null);
                        	}
                        	 if(j==7) {
                        		 //assesmentItemOptionDto = new AssesmentItemOptionDto();
                				 assesmentItemOptionDto.setOptionText(cell.getStringCellValue());
                				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                			 }
                			 if(j==8) {
                				// assesmentItemOptionDto = new AssesmentItemOptionDto();
                				 assesmentItemOptionDto.setOptionText(cell.getStringCellValue());
                				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                			 }
                			 if(j==9) {
                				 //assesmentItemOptionDto = new AssesmentItemOptionDto();
                				 assesmentItemOptionDto.setOptionText(cell.getStringCellValue());
                				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                			 }
                			 if(j==10) {
                				// assesmentItemOptionDto = new AssesmentItemOptionDto();
                				 assesmentItemOptionDto.setOptionText(cell.getStringCellValue());
                				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                			 }
                			 if(j==11) {
                				 //assesmentItemOptionDto = new AssesmentItemOptionDto();
                				 assesmentItemOptionDto.setOptionText(cell.getStringCellValue());
                				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                			 }
                			
                    	}
                    	if(cell.getCellType() == CellType.NUMERIC) {
                    		
                        	if(j==1) {
                        		assesmentItemDto.setAssessmentItemGivenId(String.valueOf(cell.getNumericCellValue()));
                        	}

                        	if(j==3) {
                        		assesmentItemDto.setAssessmentItemText(String.valueOf(cell.getNumericCellValue()));
                        	}
      
                        	if(j==5) {
                        		assesmentItemDto.setAssesmentItemNoOfOption((int)cell.getNumericCellValue());
                        	}
                        	if(j==6) {
                        		assesmentItemDto.setCorrectOption((int)cell.getNumericCellValue());
                        	}
                        	 if(j==7) {
                        		// assesmentItemOptionDto = new AssesmentItemOptionDto();
                				 assesmentItemOptionDto.setOptionText(String.valueOf(cell.getNumericCellValue()));
                				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                			 }
                			 if(j==8) {
                				// assesmentItemOptionDto = new AssesmentItemOptionDto();
                				 assesmentItemOptionDto.setOptionText(String.valueOf(cell.getNumericCellValue()));
                				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                			 }
                			 if(j==9) {
                				 //assesmentItemOptionDto = new AssesmentItemOptionDto();
                				 assesmentItemOptionDto.setOptionText(String.valueOf(cell.getNumericCellValue()));
                				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                			 }
                			 if(j==10) {
                				 assesmentItemOptionDto.setOptionText(String.valueOf(cell.getNumericCellValue()));
                				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                			 }
                			 if(j==11) {
                				 assesmentItemOptionDto.setOptionText(String.valueOf(cell.getNumericCellValue()));
                				 assesmentItemOptionDtoList.add(assesmentItemOptionDto);
                			 }
                			 if(j==12) {
                				 assesmentItemDto.setMaxTimeAllowed(String.valueOf(cell.getNumericCellValue()));
                			 }
                			 if(j==13) {
                				 assesmentItemDto.setAssessmentItemMarks((int)cell.getNumericCellValue());
                			 }
                			 if(j==14) {
                				 assesmentItemDto.setAssessmentItemNegativeMarks((int)cell.getNumericCellValue());
                			 }
                    	}
                     }
				}
				//assesmentItemOptionDtoList.get(assesmentItemDto.getCorrectOption()-1).setCorrectAnswer("YES");
				if(assesmentItemOptionDtoList!=null && assesmentItemOptionDtoList.size()>0) {
					assesmentItemOptionDtoList.get(assesmentItemDto.getCorrectOption()-1).setCorrectAnswer("YES");
				    assesmentItemDtoMap.put(assesmentItemDto, assesmentItemOptionDtoList);
				}
			}
			rowIndex++;
		}
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(assesmentItemDtoMap));
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
