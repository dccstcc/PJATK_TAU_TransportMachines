package bddCucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:report"},
				 //glue="cucumber.steps",
				 features= {"src/test/resources/bddCucumber/search.feature", "src/test/resources/bddCucumber/delete.feature"} 
				 //tags="@Search, @Delete"
				 )
public class RunCucumberTest {

}
