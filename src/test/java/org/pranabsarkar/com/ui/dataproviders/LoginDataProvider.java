package org.pranabsarkar.com.ui.dataproviders;

import com.google.gson.Gson;
import org.pranabsarkar.com.ui.pojo.TestData;
import org.pranabsarkar.com.ui.pojo.User;
import org.pranabsarkar.com.utility.CSVReaderUtility;
import org.pranabsarkar.com.utility.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Data provider class for login test data.
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class LoginDataProvider {

    /**
     * Provides login test data from a JSON file.
     *
     * @return an iterator of object arrays, each containing a user object
     * @throws FileNotFoundException if the JSON file is not found
     */
    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> logingDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir") + "//testData//loginData.json");
        FileReader fileReader = new FileReader(testDataFile);
        TestData data = gson.fromJson(fileReader, TestData.class);
        List<Object[]> dataToReturn = new ArrayList<>();
        for (User user : data.getData()) {
            dataToReturn.add(new Object[]{user});
        }
        return dataToReturn.iterator();
    }

    /**
     * Provides login test data from a CSV file.
     *
     * @return an iterator of user objects read from the CSV file
     */
    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<User> loginCSVDataProvider() {
        return CSVReaderUtility.readCsvFile("loginData.csv");
    }

    /**
     * Provides login test data from an Excel file.
     *
     * @return an iterator of user objects read from the Excel file
     */
    @DataProvider(name = "LoginTestXLSXDataProvider")
    public Iterator<User> loginXLSXDataProvider() {
        return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
    }
}