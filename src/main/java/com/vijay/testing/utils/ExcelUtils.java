package com.vijay.testing.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    // method for loading Excel
    public static void loadExcel(String filePath,String sheetName) throws IOException {

        try(FileInputStream file = new FileInputStream(filePath)){
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
            if(sheet == null){
                throw new IllegalArgumentException("Sheet '" + sheetName + "' does not exist in " + filePath);
            }
        }
    }

    // method to get the data from cell
    public static String getCellData(int row,int col){

        Row excelRow = sheet.getRow(row);
        if (excelRow == null) {
            return "";
        }
        Cell cell = excelRow.getCell(col);
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
            default:
                return "";
        }

    }

    // get row count
    public static int getRowCount(){
        return sheet.getPhysicalNumberOfRows();
    }

    // closing the excel
    public static void closeExcel() throws IOException {
        workbook.close();
    }


}
