package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.UserPojo;
import pojos.UserPojo2;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post02Example {

    Response response;
    String endpoint = "https://gorest.co.in/public-api/users/";
    Map<String,Object> myPostData = new HashMap<>();
    JsonPath jsonPath;

    public void postMethod(Object body){
        response = given().contentType(ContentType.JSON).
                auth().oauth2(ConfigReader.getProperty("token")).
                body(body).
                post(endpoint);
        response.prettyPrint();
    }
    @Test
    public void post1(){
        myPostData.put("name", "Fadime");
        myPostData.put("email",ReusableMethods.randomString(5)+"@live.com");
        myPostData.put("gender","Female");
        myPostData.put("status","Active");

        postMethod(myPostData);
    }

    @Test
    public void post2(){
        UserPojo2 body = new UserPojo2(654,"mehwap@gmail.com","Female","Active");
        response = given().contentType(ContentType.JSON).
                auth().oauth2(ConfigReader.getProperty("token")).
                body(body).
                post(endpoint);
        response.prettyPrint();

    }

    @Test
    public void post3(){
        UserPojo2 body = new UserPojo2("Nazike","nazike2@gmail.com");
        response = given().contentType(ContentType.JSON).
                auth().oauth2(ConfigReader.getProperty("token")).
                body(body).
                post(endpoint);
        response.prettyPrint();

        jsonPath = response.jsonPath();

        List<String> listField=jsonPath.getList("data.field");
        List<String> listMessage=jsonPath.getList("data.message");

        Assert.assertTrue(listField.contains("gender"));
        Assert.assertTrue(listField.contains("status"));
        for(String w : listMessage){
            Assert.assertTrue(w.equals("can't be blank"));
            System.out.println("Test successful");
        }

    }

    @Test
    public void post4(){
        UserPojo2 body = new UserPojo2();
        body.setEmail("awli4w5@live.com");
        body.setStatus("Inactive");
        body.setGender("Male");
        body.setName("Ali");
//        response = given().contentType(ContentType.JSON).
//                auth().oauth2(ConfigReader.getProperty("token")).
//                body(body).
//                post(endpoint);
//        response.prettyPrint();
        postMethod(body);

    }



}
