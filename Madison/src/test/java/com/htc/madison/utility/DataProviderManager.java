package com.htc.madison.utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.htc.madison.GlobalVars;

public class DataProviderManager {
	
//	@DataProvider(name = "Registration_Details")
//	public Object[][] registrationDetails(){
//		ExcelFileHandler ref = new ExcelFileHandler(GlobalVars.datarepository_madinson_excelfile);
//		Object[][] registrationDataSet =ref.getDataRecords(GlobalVars.datarepository_madinson_excelfile_sheetname_register);
//		return registrationDataSet;
//	}
//
//	@DataProvider(name = "Billing_Information")
//	public Object[][] billingInfo(){
//		ExcelFileHandler ref = new ExcelFileHandler(GlobalVars.datarepository_madinson_excelfile);
//		Object[][] registrationDataSet =ref.getDataRecords(GlobalVars.datarepository_madinson_excelfile_sheetname_billinginfo);
//		return registrationDataSet;
//	}
//
//	@DataProvider(name = "Login")
//	public Object[][] LoginDetails(){
//		ExcelFileHandler ref = new ExcelFileHandler(GlobalVars.datarepository_madinson_excelfile);
//		Object[][] registrationDataSet =ref.getDataRecords(GlobalVars.datarepository_madinson_excelfile_sheetname_login);
//		return registrationDataSet;
//	}
	
	
	@DataProvider(name = "Data")
	public Object[][] dataProvider(Method method){
		
		ExcelFileHandler ref = new ExcelFileHandler(GlobalVars.datarepository_madinson_excelfile);
		Object[][] dataSet = null;
		
		if(method.getName().equals("registrationTest"))
		{
			dataSet = ref.getDataRecords(GlobalVars.datarepository_madinson_excelfile_sheetname_register);
		}
		
		else if(method.getName().equals("loginTest"))
		{
			dataSet = ref.getDataRecords(GlobalVars.datarepository_madinson_excelfile_sheetname_login);
		}
		
		else if(method.getName().equals("productPurchaseTest"))
		{
			dataSet = ref.getDataRecords(GlobalVars.datarepository_madinson_excelfile_sheetname_billinginfo);
		}
		
		return dataSet;
		
	}


}





























//Properties prop;

//public DataProviderManager(){
//	prop = new Properties();
//	FileInputStream fis;
//	try {
//		fis = new FileInputStream("src//test//resources//props.properties");
//		prop.load(fis);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}	
//}



//@DataProvider(name = "Invalid_Login_Details")
//public Object[][] invalidLoginDetails(){
//	ExcelFileHandler ref = new ExcelFileHandler(prop.getProperty("datarepository.madinson.excelfile"));
//	Object[][] registrationDataSet =ref.getDataRecords(prop.getProperty("datarepository.madinson.excelfile.sheetname.invalidlogin"));
//	return registrationDataSet;
//}


//@DataProvider(name = "Valid_Login_Details")
//public Object[][] validLoginDetails(){
//	ExcelFileHandler ref = new ExcelFileHandler(prop.getProperty("datarepository.madinson.excelfile"));
//	Object[][] registrationDataSet =ref.getDataRecords(prop.getProperty("datarepository.madinson.excelfile.sheetname.validlogin"));
//	return registrationDataSet;
//}




//@DataProvider(name = "Registration_Details")
//public Object[][] registrationDetails(){
//	ExcelFileHandler ref = new ExcelFileHandler(prop.getProperty("datarepository.madinson.excelfile"));
//	Object[][] registrationDataSet =ref.getDataRecords(prop.getProperty("datarepository.madinson.excelfile.sheetname.register"));
//	return registrationDataSet;
//}