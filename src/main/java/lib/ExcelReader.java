package lib;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private Sheet sheet;

    public ExcelReader(String filename, String sheetname) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename);
             Workbook wb = new XSSFWorkbook(fis)) {
            sheet = wb.getSheet(sheetname);
        }
    }

    public Object[][] excelToArray() {
        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[totalRows - 1][totalColumns];

        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            for (int c = 0; c < totalColumns; c++) {
                data[r - 1][c] = getCellData(row.getCell(c));
            }
        }
        return data;
    }

    private String getCellData(Cell cell) {
        if (cell == null) return "";

        CellType type = cell.getCellType();

        switch (type) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                double numericValue = cell.getNumericCellValue();
                // Convert to int if no decimal part
                if (numericValue % 1 == 0) {
                    return String.valueOf((int) numericValue);
                } else {
                    return String.valueOf(numericValue);
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                // Evaluate formula result as string
                return cell.getCellFormula();
            case BLANK:
            default:
                return "";
        }
    }
}
