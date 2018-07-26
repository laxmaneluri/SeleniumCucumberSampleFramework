/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.core;

import java.util.concurrent.TimeUnit;

import com.laxel.framework.helpers.Configuration;
import com.laxel.framework.helpers.Utilities;

import com.laxel.framework.testreports.ReportManager;

public class BaseTest {


    public static void ClassInit() {

    }

    public static void ClassCleanup() {

    }

    public void testInit() {
        ReportManager.initalizeTestCase("Dummy Scenario Name", "Dummy Scenario ID");
    }

    public void SuiteInit() {
        ReportManager.intializeTestReport("Cucumber Test Report");
        ExecutionEngine.CreateSeleniumWebDriver();
        ExecutionEngine.getSeleniumWebDriver().navigate().to(Configuration.getProperty("URL"));
        ExecutionEngine.getSeleniumWebDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Utilities.delayFor(3000);
    }

    public void SuiteCleanup() {

        try {
            ExecutionEngine.getSeleniumWebDriver().close();
            ExecutionEngine.getSeleniumWebDriver().quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        ReportManager.SaveTestReport();
    }


    public void testCleanup() {
        ReportManager.ClostTestCaseReport();
    }

}