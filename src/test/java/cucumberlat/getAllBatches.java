//package cucumberlat;
//	
//	import static io.restassured.RestAssured.given;
//	
//	import java.sql.Timestamp;
//	import java.text.SimpleDateFormat;
//	import java.util.Date;
//	
//	import org.json.simple.JSONObject;
//	import org.testng.Assert;
//	
//	import io.cucumber.java.en.Given;
//	import io.cucumber.java.en.Then;
//	import io.cucumber.java.en.When;
//	import io.restassured.RestAssured;
//	import io.restassured.http.ContentType;
//	import io.restassured.response.Response;
//	
//	public class getAllBatches {
//	
//		Response response;
//		JSONObject request;
//		
//		
//		@Given("user get all programs with base url")
//		public void user_get_all_programs_with_base_url() {
//	
//			 
//			RestAssured.baseURI = "https://lms-backend-service.herokuapp.com/lms";
////			request = new JSONObject();
//	  
//		}
//	
//		@When("User make a GET request to get all batches with base url")
//		public void user_make_a_get_request_to_get_all_batches_with_base_url() {
//			
//			 RestAssured.requestSpecification = given();
//			 
//			  response = RestAssured.requestSpecification.when()
//					  .get("/batches").then().extract().response();
//		 
//		
//		}
//	
//		@Then("User get response with all the batches and get status code {int}")
//		public void user_get_response_with_all_the_batches_and_get_status_code(Integer int1) {
//	System.out.print("All Batches : Response--> "+response.getBody().asPrettyString());
//		    Assert.assertEquals(response.statusCode(), 200);
////		    Assert.assertEquals(response.jsonPath().getString("programName"), request.get("programName"));
//	
//		}
//	}
////	@When("User make a GET request with an end point allProgram")
////	  public void user_make_a_get_request_with_an_end_point_all_program() {
////	    RestAssured.requestSpecification = given();
////
////	      getAll_response = RestAssured.requestSpecification.when()
////	       .get("/allPrograms").then().extract().response();   
////	  }
////	@Then("User get the status code as {int} and got a response body as programID, programName, programDescription, programStatus, creationTime, lastModTime")
////	  public void user_get_the_status_code_as_and_got_a_response_body_as_program_id_program_name_program_description_program_status_creation_time_last_mod_time(Integer int1) {
////	    if (getAll_response.getStatusCode()==200){
////	      /*  String responsebody1=getAll_response.getBody().asPrettyString();
////	        System.out.println("ResponseBody of the get request"+ responsebody1);  */
////	        getAll_response.then().statusCode(int1);
////	        isAPIHit = true;
////
////	      }else
////	        System.out.println("Get all programs is not success. Error code : " +getAll_response.getStatusCode()) ;
////	      
////	      int statuscode=getAll_response.getStatusCode();
////	      System.out.println(statuscode);
////	  }
////	
////	
//	
//	
// 
