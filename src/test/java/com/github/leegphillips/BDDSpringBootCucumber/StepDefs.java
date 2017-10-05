package com.github.leegphillips.BDDSpringBootCucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.http.HttpStatus;

public class StepDefs extends SpringIntegrationTest {

    @LocalServerPort
    private int randomServerPort;

    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable{
        executeGet("http://localhost:" + randomServerPort + "/version");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : "+
                latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }
}
