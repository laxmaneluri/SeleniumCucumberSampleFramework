/*
 * @author Laxman Eluri
 *
 */

package com.laxel.framework.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.laxel.framework.helpers.Configuration;
import com.laxel.framework.testreports.ReportManager;

public class TestDataProvider {

	public static Object [][] getTestData (String testName)
	{
		TestDataProvider testDataProvider = new TestDataProvider();
		
		String testDataSource = Configuration.getProperty("TestDataSource");
		if (testDataSource.equalsIgnoreCase("excel"))
		{
			return testDataProvider.readExcelData(testName);
		}
		else if(testDataSource.equalsIgnoreCase("xml"))
		{
			return testDataProvider.readXmlData(testName);
		}
		else if(testDataSource.equalsIgnoreCase("csv"))
		{
			return testDataProvider.readCsvData(testName);
		}
		else
		{
			ReportManager.LogFailure("TA_Framework_Internal", "Reading Excel Data", "Check configuration file", "datasource is mentioned as " + testDataSource + " in configuration file. Allowed formats are CSV, XML, Excel", false);
			return null;
		}
	}

	private Object[][] readCsvData(String testName) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object[][] readExcelData(String testName) {
		
		try
		{
			FileInputStream fis = new FileInputStream(Configuration.getProperty("TestDataFileLocation"));
				
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheetAt(workbook.getSheetIndex(testName));
			fis.close();
			
			int dataLength = sheet.getPhysicalNumberOfRows();
			
			Object[][] testData = new Object[dataLength-1][1];
			
			for (int intRowIterator = 1; intRowIterator < dataLength; intRowIterator++) 
			{
					HSSFRow headerRow = sheet.getRow(0);
					HSSFRow dataRow = sheet.getRow(intRowIterator);
					HashMap<String,String> tmpHashmap = new HashMap<String, String>();
					
					for (int intColIterator = 0; intColIterator < dataRow.getPhysicalNumberOfCells(); intColIterator++) {
						if (dataRow.getCell(intColIterator) != null) {
							
								tmpHashmap.put(headerRow.getCell(intColIterator).toString().trim(), dataRow.getCell(intColIterator).toString().trim());
						}
					}
					testData[intRowIterator-1] [0] = tmpHashmap;
			}
			return testData;
		}
		catch (Exception ex)
		{
			ReportManager.LogFailure("TA_Framework_Internal", "Reading Excel Data", "Read Excel Data", "Exception occured while reading test data from excel sheet. Exception message is: " + ex.getMessage(), false);
			return null;
		}		
	}
	
	private Object[][] readXmlData(String testName) {
		// TODO Auto-generated method stub
		
		try
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(new File(Configuration.getProperty("TestDataFileLocation")));
	        doc.getDocumentElement().normalize();
	
	        XPath xPath =  XPathFactory.newInstance().newXPath();
	
	        String expression = "//testcase[@id='" + testName + "']/iteration";
	        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
	        int dataLength = nodeList.getLength();
	        Object[][] testData = new Object[dataLength][1];
	        
	        for (int nodeIterator = 0; nodeIterator < nodeList.getLength() ; nodeIterator++) 
	        {
	        	Element nNode = (Element) nodeList.item(nodeIterator);
	        	HashMap<String,String> tmpHashmap = new HashMap<String, String>();
	        	for (int keyIterator = 0; keyIterator<= nNode.getElementsByTagName("entry").getLength()-1;keyIterator++)
	        	{
	        		Element textNode = (Element) nNode.getElementsByTagName("entry").item(keyIterator);
	        		tmpHashmap.put(textNode.getAttribute("key"), textNode.getTextContent());
	        	}
	        	testData[nodeIterator][0] = tmpHashmap;
	        }
	        return testData;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}
}