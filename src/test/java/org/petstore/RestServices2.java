package org.petstore;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.data.PetDetails2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RestServices2 {
	
	
		static int petid;
		@DataProvider(name="pet")
		public Object [][] getPet(){
			return new Object[][] {{250,"Vasi"}};
		}
		
		@Test(priority = 1,dataProvider = "pet")
		public void addPet(int id,String name) {
		RestAssured.baseURI= "https://petstore.swagger.io/v2/";
		
		//Using Post Request
		String postResponse = given().log().all().header("Content-Type","application/json").body(PetDetails2.petData2(id, name))
		.when().post("/pet")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Response="+postResponse);
		
		JsonPath j = new JsonPath(postResponse);
		 petid = j.getInt("id");
		System.out.println("Pet id="+id);
		}
		//using get method request
		@Test(priority = 2)
		public void retrievePet() {
		given().log().all().header("Content-Type","application/json").pathParam("id", petid)
		.when().get("/pet/{id}")
		.then().log().all().assertThat().statusCode(200);
		
	}

}
