package com.atmecs.falcon_web.demoblaze.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon_web.demoblaze.constant.FilePathConstants;

import testDataProvider.ContactUsData;

public class ContactUsDataProvider {
	@DataProvider(name = "ContactUsDataSheet")
	
	public static Object[][] getXlsData () {
		XlsReader xlsReader = new XlsReader();
		try {
		xlsReader.setPath(FilePathConstants.EXCEL_DATA_PATH);
		} catch (IOException e) {
		e.printStackTrace();
		}
		String sheetName = "ContactUsDataSheet";
		int rowCount = xlsReader.getRowCount(sheetName);
		int colCount = xlsReader.getColumnCount(sheetName);

		System.out.println("rowCount =" + rowCount);
		System.out.println("colCount =" + colCount);

		Object[][] data = new Object[rowCount][1];

		for (int rowIndex = 1; rowIndex < rowCount + 1; rowIndex++) {
			ContactUsData contactUsData = new ContactUsData();
			contactUsData.setEmail(xlsReader.getCellDataByColumnIndex(sheetName, 0, rowIndex));
			contactUsData.setName(xlsReader.getCellDataByColumnIndex(sheetName, 1, rowIndex));
			contactUsData.setMessage(xlsReader.getCellDataByColumnIndex(sheetName, 2, rowIndex));
			data[rowIndex - 1][0] = contactUsData;
		}
		return data;


}
	}
