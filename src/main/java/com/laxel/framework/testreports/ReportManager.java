/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.testreports;

import java.io.File;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.laxel.framework.helpers.Utilities;

/**
 * This class is to manage the test reporting functionality.
 */

public class ReportManager {

	private static TestSuite testSuite;

	/**
	 * This function will initialize the test reports. Generally will be
	 * initialized at the beginning of test execution. Can be called
	 * at @AssemblyInitialize function
	 * 
	 * @param testSuiteID
	 *            unique id for current test suite execution
	 * @author J9216LE
	 */

	public static void intializeTestReport(String testSuiteID) {
		ReportManager.testSuite = new TestSuite();
		testSuite.setId(testSuiteID);
		testSuite.setStart_time(Calendar.getInstance().getTime());
	}

	public static void initalizeTestCase(String testcaseID, String description) {
		if (testSuite == null) {
			ReportManager.testSuite = new TestSuite();
			testSuite.setId("Temp_Report_001");
		}

		testSuite.addNewTest(testcaseID, description);
	}

	private static Testcase getTestReport() {
		if (testSuite == null) {
			ReportManager.testSuite = new TestSuite();
			testSuite.setId("Temp_Report_001");
		}
		if (testSuite.getCurrentTestcase() == null) {
			testSuite.addNewTest("temp_001", "My dummy description");
		}
		return testSuite.getCurrentTestcase();
	}

	public static void LogMessage(String Step_id, String description, String expected_result, String actual_result,
			String status, Boolean ScreenShot) {
		if (ScreenShot) {
			String screenShotPath = "./Results/Reports/ScreenShots/ScreenShot_" + System.currentTimeMillis()
					+ ".png";
			Utilities.captureScreen(screenShotPath);
			screenShotPath = screenShotPath.replace("Results/", "");
			ReportManager.getTestReport().addNewTestStep(Step_id, description, expected_result, actual_result, status,
					"../" + screenShotPath);
		} else {
			ReportManager.getTestReport().addNewTestStep(Step_id, description, expected_result, actual_result, status,
					"");
		}
	}

	public static void LogSuccess(String Step_id, String description, String expected_result, String actual_result,
			Boolean ScreenShot) {
		ReportManager.LogMessage(Step_id, description, expected_result, actual_result, "Pass", ScreenShot);
	}

	public static void LogFailure(String Step_id, String description, String expected_result, String actual_result,
			Boolean ScreenShot) {
		ReportManager.LogMessage(Step_id, description, expected_result, actual_result, "fail", ScreenShot);
	}

	public static void LogInfo(String Step_id, String description, String expected_result, String actual_result,
			Boolean ScreenShot) {
		ReportManager.LogMessage(Step_id, description, expected_result, actual_result, "Info", ScreenShot);
	}
	// private String screenshot_path;
	// private String time_stamp;

	public static void SaveTestReport() {
		testSuite.setEnd_time((Calendar.getInstance().getTime()));
		testSuite.setDuration(Utilities.getDuration(testSuite.getStart_time(), testSuite.getEnd_time()));
		try {

			File file = new File("./Results/Reports/Result.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(TestSuite.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(testSuite, file);
			jaxbMarshaller.marshal(testSuite, System.out);
			Utilities.trasformXMLtoHTML("./Results/Reports/Result.xml", "./Results/Resource/ReportStylesheet.xsl",
					"./Results/Reports/Results.html");
			
			File resultFile = new File("./Results/Reports/Results.html");
			
			//Utilities.InvokeProcess("C:/Program Files/Internet Explorer/iexplore.exe", resultFile.getAbsolutePath());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void ClostTestCaseReport() {

		if (testSuite.getCurrentTestcase() != null)
		{
			testSuite.getCurrentTestcase().setEnd_time(Calendar.getInstance().getTime());
			
		}
	}
}