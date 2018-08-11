package mypac

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class Autocheck {

	@Keyword
	public void login(){

		WebUI.navigateToUrl('https://qa.gsihealth.net/dashboard/')

		//WebUI.maximizeWindow()

		WebUI.setText(findTestObject('Object Repository/userid') ,"jonsnow@qa.com")

		WebUI.setText(	findTestObject('Object Repository/login/password') , "Test123#")

		WebUI.click(findTestObject('Object Repository/login/loginbtn'))

		System.out.println("Login Sucessfully...")
		System.out.println("Login Sucessfully...")

		//WebUI.click(findTestObject('Object Repository/login/logout'))

		//WebUI.click(findTestObject('Object Repository/login/yes'))

	}
	@Keyword
	public void demo(){
		WebUI.click(findTestObject('Object Repository/demo/demoapp') )
		WebUI.click( findTestObject('Object Repository/demo/addpatient'))
		WebUI.setText(findTestObject('Object Repository/demo/firstname'), "daniel")
		WebUI.setText(findTestObject('Object Repository/demo/lastname') , "warner")
		WebUI.setText(findTestObject('Object Repository/demo/address1'), "convent Road")
		WebUI.setText(findTestObject('Object Repository/demo/dob'),"10101996")
		WebUI.click(findTestObject('Object Repository/demo/gendericon'))
		WebUI.click(findTestObject('Object Repository/demo/gendermale'))
		Thread.sleep(1000);
		WebUI.setText(findTestObject('Object Repository/demo/city'),"Trichy")
		WebUI.click(findTestObject('Object Repository/demo/stateicon'))
		WebUI.click( findTestObject('Object Repository/demo/state'))
		Thread.sleep(1000);
		WebUI.setText(findTestObject('Object Repository/demo/zipcode'),"12345")
		Thread.sleep(1000);
		WebUI.scrollToElement(findTestObject('Object Repository/demo/savebtn'),1)
		Thread.sleep(1000);
		WebUI.click(findTestObject('Object Repository/demo/savebtn'))
		System.out.println("Details saved successfully.....");
		System.out.println("Details saved successfully.....");
	}

	@Keyword
	public void verification(){
		def patient_id = "307805";
		WebUI.click(findTestObject('Object Repository/demo/demoapp'))
		WebUI.click(findTestObject('Object Repository/searchpatient/srchurbtn'))
		Thread.sleep(1000);
		WebUI.setText(findTestObject('Object Repository/searchpatient/patientId'), "307805")

		WebUI.click(findTestObject('Object Repository/demosearch/programtab'))
		Thread.sleep(1000);
		WebUI.scrollToElement(findTestObject('Object Repository/demosearch/parentname'), 1)
		WebUI.click(findTestObject('Object Repository/demosearch/parentname'))
		WebUI.click(findTestObject('Object Repository/demosearch/t1'))

		WebUI.click(findTestObject('Object Repository/demosearch/programname'))
		Thread.sleep(1000);
		WebUI.click(findTestObject('Object Repository/demosearch/programnameobj'))
		WebUI.click(findTestObject('Object Repository/demosearch/patientstatus'))
		WebUI.click(findTestObject('Object Repository/demosearch/programstatusobj'))

		Thread.sleep(1000);
		WebUI.scrollToElement(findTestObject('Object Repository/searchpatient/abovesearch'),1)
		WebUI.click(findTestObject('Object Repository/searchpatient/abovesearch'))
		Thread.sleep(2000);
		WebUI.click(findTestObject('Object Repository/demosearch/headerpid'))
		def pid =WebUI.getText(findTestObject('Object Repository/demosearch/headerpid'))

		if (pid == patient_id) {
			System.out.println("patientid is Matching");
		}else{
			System.out.print("dasdd");
		}

		System.out.println("Enrolled successfully.....");
		System.out.println("Enrolled successfully.....");
	}
	@Keyword
	public void programwizard(){
		WebUI.click(findTestObject('Object Repository/programwizard/programtab'))
		Thread.sleep(1000);
		WebUI.click(findTestObject('Object Repository/programwizard/addbtn' ))
		WebUI.click(findTestObject('Object Repository/programwizard/iconone'))
		WebUI.click(findTestObject('Object Repository/programwizard/t1'))
		//parent_name = WebUI.getText(findTestObject('Object Repository/programwizard/t1'))
		//println(parent_name);
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/programwizard/icontwo'))
		Thread.sleep(1000);
		WebUI.click(findTestObject('Object Repository/programwizard/icon2obj'))
		def program_name = WebUI.getText(findTestObject('Object Repository/programwizard/icon2obj'))
		println(program_name);
		Thread.sleep(1000);
		WebUI.click(findTestObject('Object Repository/programwizard/patientstatusicon'))
		WebUI.click(findTestObject('Object Repository/programwizard/pending'))
		def patient_status = WebUI.getText(findTestObject('Object Repository/programwizard/pending'))
		println(patient_status);
		Thread.sleep(1000);

		WebUI.click(findTestObject('Object Repository/programwizard/savebtn'))
		Thread.sleep(1000);
		WebUI.click(findTestObject('Object Repository/programwizard/Xbtn'))
		//WebUI.click(findTestObject('Object Repository/programwizard/cancelbtn'))
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/programwizard/discard'), 1)){
			WebUI.click(findTestObject('Object Repository/programwizard/discard'))
		}else{
			WebUI.click(findTestObject('Object Repository/programwizard/cdeny'))
		}

		System.out.println("Program Added  successfully.....");
		System.out.println("Program Added successfully.....");
		Thread.sleep(1000);


	}
	@Keyword
	public void prodelete(){
		WebUI.click(findTestObject('Object Repository/programwizard/delete') )
		WebUI.click(findTestObject('Object Repository/programwizard/deletebtn'))
		WebUI.click(findTestObject('Object Repository/programwizard/lastdeletebtn'))
		WebUI.click(findTestObject('Object Repository/programwizard/okbtn_dlt'))
		System.out.println("Deleted successfully.....");
		System.out.println("Deleted successfully.....");
	}
	@Keyword
	public void checkid(){
		WebUI.click(findTestObject('Object Repository/demosearch/demographic'))
		WebUI.click(findTestObject('Object Repository/searchpatient/srchurbtn'))
		WebUI.click(findTestObject('Object Repository/searchpatient/patientId'), "307805")
	}
	@Keyword
	public void search(){
		def patient_id = "307805";
		WebUI.click(findTestObject('Object Repository/demo/demoapp'))
		WebUI.click(findTestObject('Object Repository/searchpatient/srchurbtn'))
		Thread.sleep(1000);
		WebUI.setText(findTestObject('Object Repository/searchpatient/patientId'), "307805")
		Thread.sleep(1000);
		//WebUI.scrollToElement(findTestObject('Object Repository/searchpatient/abovesearch'),1)
		WebUI.click(findTestObject('Object Repository/searchpatient/abovesearch'))
		Thread.sleep(1000);
		WebUI.click(findTestObject('Object Repository/demosearch/pid'))
		WebUI.click(findTestObject('Object Repository/searchpatient/selectbtn'))
		Thread.sleep(1000);
		WebUI.click(findTestObject('Object Repository/searchpatient/enroll'))
		Thread.sleep(1000);
		//WebUI.click(findTestObject('Object Repository/programwizard/close'))
		System.out.println("Enrollment denied successfully");
		System.out.println("Enrollment denied successfully");
	}
}



