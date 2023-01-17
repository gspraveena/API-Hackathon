package cucumberlat;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getallprograms {

	Response response;
	JSONObject request;

	@Given("user get all programs with base url")
	public void user_get_all_programs_with_base_url() {

		RestAssured.baseURI = "https://lms-backend-service.herokuapp.com/lms";

	}

	@When("User make a GET request to get all programs with base url")
	public void user_make_a_get_request_to_get_all_programs_with_base_url() {

		RestAssured.requestSpecification = given();
		response = RestAssured.requestSpecification.when().get("/allPrograms").then().extract().response();

	}

	@Then("User get response with all the programs and get status code {int}")
	public void user_get_response_with_all_the_programs_and_get_status_code(Integer int1)

	{
		System.out.print("Getting AllPrograms: Response--> " + response.getBody().asPrettyString());

		Assert.assertEquals(response.statusCode(), 200);

	}
}
