package utils;

        	import java.io.FileInputStream;

            import java.io.FileOutputStream;

            import org.apache.poi.xssf.usermodel.XSSFCell;

        	import org.apache.poi.xssf.usermodel.XSSFRow;

        	import org.apache.poi.xssf.usermodel.XSSFSheet;

        	import org.apache.poi.xssf.usermodel.XSSFWorkbook;


    public class ExcelUtils {

        		public static XSSFSheet ExcelWSheet;

        		public static XSSFWorkbook ExcelWBook;

        		public static XSSFCell Cell;

        		public static XSSFRow Row;

    		//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    		public static void setExcelFile(String Path,String SheetName) throws Exception {

       			try {

           			// Open the Excel file

					FileInputStream ExcelFile = new FileInputStream(Path);

					// Access the required test data sheet

					ExcelWBook = new XSSFWorkbook(ExcelFile);

					ExcelWSheet  = ExcelWBook.getSheet(SheetName);

					} catch (Exception e){

						throw (e);

					}

			}
    		
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   		
    		
    		//This method will fetch the row count
    		
    		public static int getrowcount(int Sheetnumber) throws Exception {

       			try {

       				
       				int rwCnt = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
       				return rwCnt;
					} catch (Exception e){

						throw (e);

					}
				

			}
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   		
    		
    		public static void redexcelrows() throws Exception {

    			int rwCnt= ExcelUtils.getrowcount(0);
    			System.out.println(rwCnt);
    			
    			for(int i=0;i<rwCnt+1;i++){
    				
    				Row  = ExcelWSheet.getRow(i);
    				
				    				for (int j = 0; j < Row.getLastCellNum(); j++) {
				    					
				    					System.out.print(Row.getCell(j).getStringCellValue()+"|| ");
					
				    					}
    				System.out.println();
    			}
    			
    			}
    		
    		
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   		
    		
    		
			
    			
    		

      		//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    	    public static String getCellData(int RowNum, int ColNum) throws Exception{

       			try{

          			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

          			String CellData = Cell.getStringCellValue();

          			return CellData;

          			}catch (Exception e){

						return"";

          			}

		    }
    	    
    	    
    	    
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  	    

    		//This method is to write in the Excel cell, Row num and Col num are the parameters

    		public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

//       			try{
//       				
//          			Row  = ExcelWSheet.getRow(RowNum);
//
//					Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
//
//					if (Cell == null) {
//
//						Cell = Row.createCell(ColNum);
//
//						Cell.setCellValue(Result);
//
//						} else {
//
//							Cell.setCellValue(Result);
//
//						}

          // Constant variables Test Data path and Test Data file name
					
					
					
					
					
					ExcelWSheet.getRow(RowNum).createCell(ColNum).setCellValue(Result);

          				FileOutputStream fileOut = new FileOutputStream(Constants.testDataPath);

          				ExcelWBook.write(fileOut);

          				fileOut.flush();

 						fileOut.close();

					}
 						//catch(Exception e){
//
//							throw (e);
//
//					}

				//}

	
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
		
		}
    
    