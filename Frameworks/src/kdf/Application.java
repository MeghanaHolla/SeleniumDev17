package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.GenericMethods;

public class Application {

	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelOct28\\TestData.xlsx", "Sheet2");
		
		for(int i =1; i < data.length; i++) {
			String keyword = data[i][3];
			switch(keyword) {
				case "openBrowser":
					Methods.openBrowser();
					break;
				case "maximizeBrowser":
					Methods.maximizeBrowserWindow();
					break;
				case "impWait":
					Methods.implicitWait();
					break;
				case "navigateToAUT":
					Methods.navigateToAplication(data[i][6]);
					break;
				case "enterUserName":
					Methods.enterUserID(data[i][4],data[i][5], data[i][6]);
					break;
				case "enterPassword":
					Methods.enterPassword(data[i][4],data[i][5], data[i][5]);
					break;
				case "clickLogin":
					Methods.clickButton(data[i][4],data[i][5]);
					break;
				case "verifyErrMsg":
					String actualMsg = Methods.verifyErrorMessage(data[i][5]);
					String expectedErrorMsg = data[i][6];
					SoftAssert softassert = new SoftAssert();
					softassert.assertEquals(actualMsg, expectedErrorMsg);
					Assert.assertEquals(actualMsg, expectedErrorMsg);
				case "closeBrowser":
					Methods.closeApplication();
			}
		}
	}
}
