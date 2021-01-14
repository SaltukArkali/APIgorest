package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Post01Example {

    Response response;
    String endpoint = "https://gorest.co.in/public-api/users/";
    Map<String,Object> myPostData = new HashMap<>();
    JsonPath jsonPath;

    public void postMethod(Map body){
        response = given().contentType(ContentType.JSON).
                auth().oauth2(ConfigReader.getProperty("token")).
                body(body).
                post(endpoint);
        response.prettyPrint();
    }

    @Test
    public void get(){
        response = given().when().get(endpoint);
        response.prettyPrint();
    }

    @Test
    public void post1(){
        String body = "{   \n" +
                "    \"name\": \"AliBey\",\n" +
                "    \"email\": \"ab41@gmail.com\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"status\": \"Active\"\n" +
                "}";
        response = given().contentType(ContentType.JSON).
                auth().oauth2(ConfigReader.getProperty("token")).
                body(body).
                post(endpoint);
        response.prettyPrint();
    }
    @Test
    public void post2(){
        myPostData.put("name", "hasan");
        myPostData.put("email",ReusableMethods.randomString(5)+"@live.com");
        myPostData.put("gender","Male");
        myPostData.put("status","Active");

        response = given().contentType(ContentType.JSON).
                auth().oauth2(ConfigReader.getProperty("token")).
                body(myPostData).
                post(endpoint);
        response.prettyPrint();
    }
    @Test
    public void post3(){
        myPostData.put("name", 999);
        myPostData.put("email",ReusableMethods.randomString(5)+"@live.com");
        myPostData.put("gender","Male");
        myPostData.put("status","Active");
        postMethod(myPostData);
        jsonPath = response.jsonPath();
        String myResponseData = jsonPath.getString("data.name");
        System.out.println(myResponseData);

    }




}
