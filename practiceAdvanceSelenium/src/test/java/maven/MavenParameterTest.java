package maven;

import org.testng.annotations.Test;

public class MavenParameterTest {
	@Test
	public void recieveParameter() {
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}
}
