package org.pranabsarkar.com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.logging.log4j.Logger;
import org.pranabsarkar.com.ui.pojo.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Utility class responsible for reading CSV test data files and mapping their contents
 * into respective Plain Old Java Objects (POJOs) for data-driven testing.
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class CSVReaderUtility {
    private static final Logger logger = LoggerUtility.getLogger(CSVReaderUtility.class);

    /**
     * Reads a specified CSV file from the test data directory, skips the header row,
     * maps each subsequent row to a User object, and returns an iterator of User data.
     *
     * @param fileName The name of the CSV file located within the testData directory.
     * @return An Iterator containing populated User objects from the CSV file.
     */
    public static Iterator<User> readCsvFile(String fileName) {
        File file = new File(System.getProperty("user.dir") + "//testData//" + fileName);
        FileReader fileReader = null;
        CSVReader csvReader;
        String[] line;
        List<User> userList = null;
        User userData;
        try {
            fileReader = new FileReader(file);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext(); // Skipping column header
            userList = new ArrayList<User>();
            while ((line = csvReader.readNext()) != null) {
                userData = new User(line[0], line[1]);
                userList.add(userData);
            }
        } catch (CsvValidationException | IOException e) {
            logger.error("Error occurred while reading the CSV file: " + fileName, e);
        }
        return userList != null ? userList.iterator() : new ArrayList<User>().iterator();
    }
}