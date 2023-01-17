package cucumberlat;

import static io.restassured.RestAssured.given;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.JSONObject;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Programs {

	Response response1, response2, response12, Update_response1, Update_response2, response3, response4,
			Update_response3;
	JSONObject request1, request2, request3, request4, request12;
	String base_URI = "https://lms-backend-service.herokuapp.com/lms";

	String programId1, programId2, programId3, batchId1, batchId2;
	String programName1, programName2, programName3, batchName1, batchName2;
	int randomInt;

	Date date = new Date();
	Timestamp timestamp2 = new Timestamp(date.getTime());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
	String dtString = sdf.format(timestamp2);
	Long program_Id = date.getTime();
	Long program_Id2 = date.getTime();

	// <---saveProgram--->

	@Given("user create 1st program with base url")
	public void user_create_1st_program_with_base_url() {

		RestAssured.baseURI = base_URI;
		request1 = new JSONObject();

		request1.put("programName", date + "-NinjaSurvivors-SDET-094-" + randomInt);
		request1.put("programDescription", "API-Hackathon1");
		request1.put("programStatus", "Active");
		request1.put("creationTime", dtString);
		request1.put("lastModTime", dtString);

		System.out.println(request1.toJSONString());
		RestAssured.requestSpecification = given().header("Content-Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(request1.toJSONString());

	}

	@When("user make a post request with end point {string}")
	public void user_make_a_post_request_with_end_point(String string) {
		response1 = RestAssured.requestSpecification.when().post("/saveprogram");
		String responseBody = response1.getBody().asString();

		JsonPath js = new JsonPath(responseBody);
		programId1 = js.getString("programId");
		programName1 = js.getString("programName");
		System.out.println("programId : " + programId1);
		System.out.println("programName : " + programName1);

	}

	@Then("user should get response body and status code should be {int}")
	public void user_should_get_response_body_and_status_code_should_be(Integer int1) {

		Response response = response1.then().extract().response();

		System.out.print("\n**************** CREATING FIRST PROGRAM *********************\n");

		System.out.print(" Response--> \n " + response.getBody().asPrettyString());

		Assert.assertEquals(response.statusCode(), 201);

		System.out.println("\n Status code is: " + response.statusCode());

		Assert.assertEquals(response.jsonPath().getString("programName"), request1.get("programName"));

	}

// <--create second program-->

	@Given("user create 2nd program with base url and request body")
	public void user_create_2nd_program_with_base_url_and_request_body() {

		RestAssured.baseURI = base_URI;
		request2 = new JSONObject();

		request2.put("programName", date + "-NinjaSurvivors2-SDET-094-" + randomInt);
		request2.put("programDescription", "API-Hackathon2");
		request2.put("programStatus", "Active");
		request2.put("creationTime", dtString);
		request2.put("lastModTime", dtString);

		System.out.println(request2.toJSONString());
		RestAssured.requestSpecification = given().header("Content-Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(request2.toJSONString());

	}

	@When("user make a post request for 2nd program with end point {string}")
	public void user_make_a_post_request_for_2nd_program_with_end_point(String string) {

		response2 = RestAssured.requestSpecification.when().post("/saveprogram").then().extract().response();
		String responseBody = response2.getBody().asString();

		JsonPath js = new JsonPath(responseBody);
		programId2 = js.getString("programId");
		programName2 = js.getString("programName");
		System.out.println("programId : " + programId2);
		System.out.println("programName : " + programName2);

	}

	@Then("user get response body {int}")
	public void user_get_response_body(Integer int1) {

		System.out.print("\n**************** CREATING SECOND PROGRAM *********************\n");

		System.out.print("  Response--> \n " + response2.getBody().asPrettyString());

		Assert.assertEquals(response2.statusCode(), 201);

		System.out.println("\n Status code is: " + response2.statusCode());
		Assert.assertEquals(response2.jsonPath().getString("programName"), request2.get("programName"));

	}
//	<--create 3rd Program-->

	@Given("user create 3rd program with given base url")
	public void user_create_3rd_program_with_given_base_url() {

		RestAssured.baseURI = base_URI;
		request12 = new JSONObject();

		request12.put("programName", date + "-NinjaSurvivors3-SDET-094-" + randomInt);
		request12.put("programDescription", "API-Hackathon-AutomationTesting");
		request12.put("programStatus", "Active");
		request12.put("creationTime", dtString);
		request12.put("lastModTime", dtString);

		System.out.println(request12.toJSONString());
		RestAssured.requestSpecification = given().header("Content-Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(request12.toJSONString());
	}

	@When("user make a post request for 3rd program with end point {string}")
	public void user_make_a_post_request_for_3rd_program_with_end_point(String string) {

		response12 = RestAssured.requestSpecification.when().post("/saveprogram").then().extract().response();
		String responseBody = response12.getBody().asString();

		JsonPath js = new JsonPath(responseBody);
		programId3 = js.getString("programId");
		programName3 = js.getString("programName");
		System.out.println("programId : " + programId3);
		System.out.println("programName : " + programName3);
	}

	@Then("user get response body and get {int} as status code")
	public void user_get_response_body_and_get_as_status_code(Integer int1) {

		System.out.print("\n**************** CREATING THIRD PROGRAM *********************\n");

		System.out.print("  Response--> \n " + response12.getBody().asPrettyString());

		Assert.assertEquals(response12.statusCode(), 201);

		System.out.println("\n Status code is: " + response12.statusCode());

		Assert.assertEquals(response12.jsonPath().getString("programName"), request12.get("programName"));
	}

//	  <--GetProgramById-->

	@When("user make a get request with an end point {string}")
	public void user_make_a_get_request_with_an_end_point(String string) {

		response1 = RestAssured.requestSpecification.when().get("/programs/" + programId1).then().extract().response();

		response2 = RestAssured.requestSpecification.when().get("/programs/" + programId2).then().extract().response();

	}

	@Then("user should get status code as {string} and responsebody")
	public void user_should_get_status_code_as_and_responsebody(String string) {

		System.out.print("\n**************** GETTING FIRST PROGRAM BY PROGRAM ID *********************\n");

		System.out.print("  Response--> \n " + response1.getBody().asPrettyString());

		Assert.assertEquals(response1.statusCode(), 200);

		System.out.println("\n Status code is:" + response1.statusCode());

		System.out.print("\n**************** GETTING SECOND PROGRAM BY PROGRAM NAME *********************\n");

		System.out.print("  Response--> \n " + response2.getBody().asPrettyString());

		Assert.assertEquals(response2.statusCode(), 200);

		System.out.println("\n Status code is:" + response2.statusCode());

	}
	// <--Update 1st program by program name-->

	@When("User make a PUT request to update program by using programName\\(Modify 1st program)")
	public void user_make_a_put_request_to_update_program_by_using_program_name_modify_1st_program() {

		request1.put("programDescription", "API-Hackathon1-postman");
		System.out.println("Request :" + request1.toJSONString());

		RestAssured.requestSpecification = given().header("Content-Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(request1.toJSONString());

		Update_response1 = RestAssured.requestSpecification.when().put("/program/" + programName1).then().extract()
				.response();

	}

	@Then("User should get status code as {string} and updated response body")
	public void user_should_get_status_code_as_and_updated_response_body(String string) {

		System.out.print("\n**************** UPDATING FIRST PROGRAM BY PROGRAM ID *********************\n");

		System.out.print("  Response--> \n" + Update_response1.getBody().asPrettyString());

		Assert.assertEquals(Update_response1.statusCode(), 200);

		System.out.println("\n Status code is:" + Update_response1.statusCode());

	}

	// <--Update 2nd program by program Id-->

	@When("User make a PUT request to update program by using programId\\(Modify 2nd program)")
	public void user_make_a_put_request_to_update_program_by_using_program_id_modify_2nd_program() {

		request2.put("programDescription", "Cucumber-testng");
		System.out.println("Request :" + request2.toJSONString());

		RestAssured.requestSpecification = given().header("Content-Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(request2.toJSONString());

		Update_response2 = RestAssured.requestSpecification.when().put("/putprogram/" + programId2).then().extract()
				.response();

	}

	@Then("User get status code as {string} and updated response body")
	public void user_get_status_code_as_and_updated_response(String string) {

		System.out.print("\n**************** UPDATING SECOND PROGRAM BY PROGRAM NAME *********************\n");

		System.out.print(" Response--> \n " + Update_response2.getBody().asPrettyString());

		Assert.assertEquals(Update_response2.statusCode(), 200);

		System.out.println("\n Status code is:" + Update_response2.statusCode());

	}

//	<--delete program by program ID-->

	@When("User make a DELETE request with an endpoint {string}")
	public void user_make_a_delete_request_with_an_endpoint(String string) {

		RestAssured.baseURI = base_URI;
		response12 = RestAssured.requestSpecification.when().delete("/deletebyprogid/" + programId3).then().extract()
				.response();

	}

	@Then("User gets status code and program will be deleted")
	public void user_gets_status_code_and_program_will_be_deleted() {

		System.out.print("\n *********** Deleting Third Program with programId3 ************");
		Assert.assertEquals(response12.statusCode(), 200);
		System.out.println("\n Status code is:" + response12.statusCode());
		System.out.print("Third Program is deleted successfully \n");
	}
	// <== create first Batch ==>

	@Given("User create 1st batch with base Url")
	public void user_create_1st_batch_with_base_url() {

//		RestAssured.baseURI = base_URI;
		request3 = new JSONObject();

		request3.put("batchName", date + "-Ninjasurvivors-SDET-SDET94-PG-Batch01");
		request3.put("batchDescription", "Selenium Training sessions");
		request3.put("batchStatus", "Active");
		request3.put("batchNoOfClasses", "200");
		request3.put("programId", programId1);

		System.out.println(request3.toJSONString());
		RestAssured.requestSpecification = given().header("Content-Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(request3.toJSONString());

	}

	@When("User make a POST request  for batch with end point {string}")
	public void user_make_a_post_request_for_batch_with_end_point(String string) {

		RestAssured.baseURI = base_URI;

		response3 = RestAssured.requestSpecification.when().post("/batches").then().extract().response();
		String responseBody = response3.getBody().asString();

		JsonPath js = new JsonPath(responseBody);
		batchId1 = js.getString("batchId");
		batchName1 = js.getString("batchName");
		System.out.println("BatchId : " + batchId1);
		System.out.println("BatchName : " + batchName1);

	}

	@Then("User  get response body and status code should be {int}")
	public void user_get_response_body_and_status_code_should_be(Integer int1) {

		System.out.print("\n**************** CREATING FIRST BATCH *********************\n");

		System.out.println(" Response--> \n" + response3.getBody().asPrettyString());

		Assert.assertEquals(response3.statusCode(), 201);

		System.out.println("\n Status code is: " + response3.statusCode());

		Assert.assertEquals(response3.jsonPath().getString("batchName"), request3.get("batchName"));

	}
//	<-- create 2nd batch-->

	@Given("User create 2nd batch with base Url")
	public void user_create_2nd_batch_with_base_url() {

		RestAssured.baseURI = base_URI;
		request4 = new JSONObject();

		request4.put("batchName", "Jan23-Ninjasurvivors-SDET-SDET94-PG-Batch02");
		request4.put("batchDescription", "Sql bootcamp");
		request4.put("batchStatus", "Active");
		request4.put("batchNoOfClasses", "200");
		request4.put("programId", programId2);

		System.out.println(request4.toJSONString());
		RestAssured.requestSpecification = given().header("Content-Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(request4.toJSONString());

	}

	@When("User make a POST request  for  2nd batch with end point {string}")
	public void user_make_a_post_request_for_2nd_batch_with_end_point(String string) {

		response4 = RestAssured.requestSpecification.when().post("/batches").then().extract().response();
		String responseBody = response4.getBody().asString();

		JsonPath js = new JsonPath(responseBody);
		batchId2 = js.getString("batchId");
		batchName2 = js.getString("batchName");
		System.out.println("BatchId : " + batchId2);
		System.out.println("BatchName : " + batchName2);

	}

	@Then("User get response body for 2nd batch and status code should be {int}")
	public void user_get_response_body_for_2nd_batch_and_status_code_should_be(Integer int1) {

		System.out.print("\n**************** CREATING SECOND BATCH *********************\n");

		System.out.println(" Response--> \n" + response4.getBody().asPrettyString());

		Assert.assertEquals(response4.statusCode(), 201);

		System.out.println("\n Status code is: " + response4.statusCode());

		Assert.assertEquals(response4.jsonPath().getString("batchName"), request4.get("batchName"));

	}
//    <--GetBatchById-->

	@When("User make GET request with an end point {string}")
	public void user_make_get_request_with_an_end_point(String string) {

		RestAssured.baseURI = base_URI;

		response3 = RestAssured.requestSpecification.when().get("/batches/batchId/" + batchId1).then().extract()
				.response();

		response4 = RestAssured.requestSpecification.when().get("/batches/batchName/" + batchName1).then().extract()
				.response();

	}

	@Then("User gets status code as {string} and response body")
	public void user_gets_status_code_as_and_response_body(String string) {

		System.out.print("\n**************** GETTING BATCH WITH BATCH ID *********************\n");

		System.out.print("  Response--> \n " + response3.getBody().asPrettyString());

		Assert.assertEquals(response3.statusCode(), 200);

		System.out.println("\n Status code is:" + response3.statusCode());

		System.out.print("\n**************** GETTING BATCH WITH BATCH NAME *********************\n");

		System.out.print("  Response--> \n " + response4.getBody().asPrettyString());

		Assert.assertEquals(response4.statusCode(), 200);

		System.out.println("\n Status code is:" + response4.statusCode());

	}

//	 <--UpdatebatchByBatchId-->

	@When("User make a PUT request to update program with end point {string}")
	public void user_make_a_put_request_to_update_program_with_end_point(String string) {

		request3.put("batchDescription", "internal assessment");
		System.out.println("Request :" + request3.toJSONString());

		RestAssured.requestSpecification = given().header("Content-Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(request3.toJSONString());

		Update_response3 = RestAssured.requestSpecification.when().put("/batches/" + batchId1).then().extract()
				.response();
	}

	@Then("User should get status code as {string} for batch and response body")
	public void user_should_get_status_code_as_for_batch_and_response_body(String string) {

		System.out.print("\n**************** UPDATING BATCH WITH BATCH ID *********************\n");

		System.out.print("Updated Batch : Response--> " + Update_response3.getBody().asPrettyString());

		Assert.assertEquals(Update_response3.statusCode(), 200);

		System.out.println("\n Status code is:" + Update_response3.statusCode());

	}

//	<--DeleteBatchById-->

	@When("User make a DELETE request with an end point {string}")
	public void user_make_a_delete_request_with_an_end_point(String string) {

		RestAssured.baseURI = base_URI;

		response3 = RestAssured.requestSpecification.when().delete("/batches/" + batchId1).then().extract().response();

	}

	@Then("User gets status code {string} batch will be deleted")
	public void user_gets_status_code_batch_will_be_deleted(String string) {

		System.out.print("\n********** Deleting First Batch with batchId *************");
		Assert.assertEquals(Update_response3.statusCode(), 200);
		System.out.println("\n Status code is:" + Update_response3.statusCode());
		System.out.print("Batch is deleted successfully");
	}
}
