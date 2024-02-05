package org.petstore;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.data.PetDetails;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class RestServices {
	
	static int petid;
	@DataProvider(name="pet")
	public Object[][] getPet(){
		return new Object[][] {{256,"aero"},{257,"tiger"}};
	}
	//public static void main(String[] args) {
		
		//Rest Assured
		//given- header,parameter
		//when-- HTTP method ,resource
		//then-- validate response
		@Test(priority = 1,dataProvider = "pet")
		public void addPet(int id,String name) {
		RestAssured.baseURI= "https://petstore.swagger.io/v2/";
		
		// Add a New Pet 
		String postResponse = given().log().all().header("Content-Type","application/json").body(PetDetails.petData(id, name))
		.when().post("/pet")
		.then().assertThat().statusCode(200).extract().asString();
		System.out.println("respose:"+postResponse);
		
		JsonPath j = new JsonPath(postResponse);
		petid = j.get("id");
		System.out.println("ID:"+id);
		//Get pet by id
		}
		@Test(priority = 2)
		public void retrivePet() {
		given().log().all().header("Content-Type","application/json")
		.pathParam("id", petid)
		.when().get("/pet/{id}")
		.then().log().all().assertThat().statusCode(200);
	}

}
