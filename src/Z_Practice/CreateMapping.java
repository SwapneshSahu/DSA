package Z_Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CreateMapping {
	public static void main(String[] args) {
        String excelFilePath = "path/to/your/file.xlsx"; // Replace with the actual path to your Excel file

        try (FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read from the first sheet
            Map<String, String> dataMap = new HashMap<>();

            // Assuming Header 3 is at column index 2 and Header 4 is at column index 3
            int header3Index = 2;
            int header4Index = 3;

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Skip rows before Header 3
                if (row.getRowNum() < 2) {
                    continue;
                }

                Cell header3Cell = row.getCell(header3Index);
                Cell header4Cell = row.getCell(header4Index);

                if (header3Cell != null && header4Cell != null) {
                    String key = header3Cell.getStringCellValue();
                    String value = header4Cell.getStringCellValue();
                    dataMap.put(key, value);
                }
            }

            // Print the HashMap
            dataMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
