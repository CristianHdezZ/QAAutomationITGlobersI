package co.com.itglobers.certification.testqa.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/cerveceriasTestBackend.feature",
        glue = {"co.com.itglobers.certification.testqa.stepdefinitions"},
        snippets = SnippetType.CAMELCASE
)
public class CerveceriasTestBackendRunner {
}
