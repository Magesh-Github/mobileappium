package RunnerClass;


import org.junit.runner.RunWith;
import com.qa.baseSetup.BaseSetup;
import com.qa.utils.Globalvariables;
import com.qa.utils.JenkinsVariables;
import com.qa.utils.MangerAppiumServer;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
tags= "@signup",
glue = { "Stepdef" },
monochrome = true, 
plugin = {"html:target/cucumber.html"})
public class TestRunner extends Globalvariables {
	static MangerAppiumServer mangerAppiumServer = new MangerAppiumServer();
	static JenkinsVariables jenkinsVariables = new JenkinsVariables();

	@Before
	public static void setUp() {
		MangerAppiumServer.startAppiumServer();
		BaseSetup setup=new BaseSetup();
		try {
			setup.lanuchApp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public static void tearDown() {
		MangerAppiumServer.stopAppiumserver();
	}
}