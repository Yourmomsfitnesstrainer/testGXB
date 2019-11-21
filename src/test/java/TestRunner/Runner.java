package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="..\\TestTask\\src\\test\\java\\resources_features\\",
        glue = {"step_definitions"},
               tags = "@addChannel",
        dryRun = false,
        strict = false,
        snippets = SnippetType.UNDERSCORE
)

public class Runner {

}


