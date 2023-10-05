package datadriventesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXMLTest {
	@Test
	public void getXmlParameter(XmlTest test) {
		
		System.out.println("hiiiiii");
		System.out.println(test.getParameter("browser"));
		System.out.println(test.getParameter("username"));
		System.out.println(test.getParameter("password"));
	}
}