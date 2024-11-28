package RunnerClass;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.qa.baseSetup.BaseSetup;
import com.qa.utils.Globalvariables;
import com.qa.utils.MangerAppiumServer;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
tags= "@Login",
glue = { "Stepdef" },
monochrome = true, 
plugin = {"pretty", "html:target/HTMLReport/Reports.html" })
public class TestRunner extends Globalvariables {
	static MangerAppiumServer mangerAppiumServer = new MangerAppiumServer();
    String iosTestDevice = System.getProperty("iosTestDevice");

	@BeforeClass
	public static void setUp() {
		try {
			MangerAppiumServer.startAppiumServer();
			BaseSetup setup=new BaseSetup();
			setup.lanuchApp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDown() {
		MangerAppiumServer.stopAppiumserver();
	}
}