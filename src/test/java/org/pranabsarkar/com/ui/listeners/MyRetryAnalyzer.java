package org.pranabsarkar.com.ui.listeners;

import org.pranabsarkar.com.constants.Env;
import org.pranabsarkar.com.utility.JSONUtility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Retry analyzer for TestNG tests.
 *
 * <p>Determines whether a failed test should be retried based on the maximum number of attempts.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class MyRetryAnalyzer implements IRetryAnalyzer {
    //    private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));
    private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMax_number_of_attempts();
    private static int currentAttempt = 1;

    /**
     * Determines whether the test should be retried.
     *
     * @param result the result of the test method that was executed
     * @return true if the test should be retried, false otherwise
     */
    @Override
    public boolean retry(ITestResult result) {
        if (currentAttempt < MAX_NUMBER_OF_ATTEMPTS) {
            currentAttempt++;
            return true;
        }
        return false;
    }
}