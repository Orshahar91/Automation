package tests.basic;

import java.io.File;

import org.junit.Assert;
import org.testng.annotations.Test;

import tests.supers.TestBase;

public class CheckPDF_TestExample extends TestBase {

	@Test
	public void test() {
		try {

			String filePath = "C:\\Users\\Or\\Downloads" + File.separator + "test.pdf";
			String expectedText = "Test123";

			if (!app.fileUtilis.isTextInPDFFile(filePath, expectedText))
				Assert.fail("The text " + expectedText + " not found in the file " + filePath);
			log.info("Text was found in pdf file");

			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}

}
