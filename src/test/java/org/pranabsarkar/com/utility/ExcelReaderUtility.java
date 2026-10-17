package org.pranabsarkar.com.utility;

import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.pranabsarkar.com.ui.pojo.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Utility class responsible for reading Excel (.xlsx) test data files and mapping
 * sheet contents into Plain Old Java Objects (POJOs) for data-driven testing.
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class ExcelReaderUtility {
    private static final Logger logger = LoggerUtility.getLogger(ExcelReaderUtility.class);

    /**
     * Reads the "LoginDetails" sheet from a specified Excel (.xlsx) file, skips the header row,
     * extracts user credentials from each row, and returns an iterator of User POJOs.
     *
     * @param fileName The name of the Excel file located within the testData directory.
     * @return An Iterator containing populated User objects from the Excel sheet.
     */
    public static Iterator<User> readExcelFile(String fileName) {
        File xlsx = new File(System.getProperty("user.dir") + "//testData//" + fileName);
        XSSFWorkbook xssfWorkbook = null;
        XSSFSheet sheet = null;
        Iterator<Row> rowIterator;
        Row row;
        Cell emailAddressCell;
        Cell passwordCell;
        User user;
        List<User> userList = null;
        try {
            xssfWorkbook = new XSSFWorkbook(xlsx);
            sheet = xssfWorkbook.getSheet("LoginDetails");
            rowIterator = sheet.rowIterator();
            rowIterator.next(); // Skipping the columns header
            userList = new ArrayList<>();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                user = new User(emailAddressCell.toString(), passwordCell.toString());
                userList.add(user);
                xssfWorkbook.close();
            }
        } catch (InvalidFormatException | IOException e) {
            logger.error("Error occurred while reading Excel file: " + fileName, e);
        }
        assert userList != null;
        return userList.iterator();
    }
}