package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.util.HashMap;
import java.util.List;
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
        Assert.assertEquals(myResponseData,"999");
    }

    @Test
    public void post4(){ // TC 0202
        myPostData.put("email",ReusableMethods.randomString(5)+"@live.com");
        myPostData.put("gender","Male");
        myPostData.put("status","Active");
        postMethod(myPostData);
        jsonPath = response.jsonPath();
        String myResponseDataName = jsonPath.getString("data.field[0]");
        System.out.println(myResponseDataName);
        String myResponseDataMessage = jsonPath.getString("data.message[0]");
        System.out.println(myResponseDataMessage);

        Assert.assertEquals(myResponseDataName,"name");
        Assert.assertEquals(myResponseDataMessage,"can't be blank");
    }
    @Test
    public void post5(){ // TC 0203
        myPostData.put("name", 666);
        myPostData.put("gender","Male");
        myPostData.put("status","Active");
        postMethod(myPostData);
        jsonPath = response.jsonPath();
        String myResponseDataEmail = jsonPath.getString("data.field[0]");
        System.out.println(myResponseDataEmail);
        String myResponseDataMessage = jsonPath.getString("data.message[0]");
        System.out.println(myResponseDataMessage);

        Assert.assertEquals(myResponseDataEmail,"email");
        Assert.assertEquals(myResponseDataMessage,"can't be blank");
    }

    @Test
    public void post6(){ // TC 0204
        myPostData.put("name", 666);
        myPostData.put("email",ReusableMethods.randomString(5)+"@live.com");
        myPostData.put("status","Active");
        postMethod(myPostData);
        jsonPath = response.jsonPath();
        String myResponseDataGender = jsonPath.getString("data.field[0]");
        System.out.println(myResponseDataGender);
        String myResponseDataMessage = jsonPath.getString("data.message[0]");
        System.out.println(myResponseDataMessage);

        Assert.assertEquals(myResponseDataGender,"gender");
        Assert.assertEquals(myResponseDataMessage,"can't be blank");
    }
    @Test
    public void post7(){ // TC 0205
        myPostData.put("name", 666);
        myPostData.put("email",ReusableMethods.randomString(5)+"@live.com");
        myPostData.put("gender","Male");
        postMethod(myPostData);
        jsonPath = response.jsonPath();
        String myResponseDataStatus = jsonPath.getString("data.field[0]");
        System.out.println(myResponseDataStatus);
        String myResponseDataMessage = jsonPath.getString("data.message[0]");
        System.out.println(myResponseDataMessage);

        Assert.assertEquals(myResponseDataStatus,"status");
        Assert.assertEquals(myResponseDataMessage,"can't be blank");
    }
    @Test
    public void post8(){ // TC 0206
        myPostData.put("name", 666);

        postMethod(myPostData);
        jsonPath = response.jsonPath();

        List<String> listField=jsonPath.getList("data.field");
        List<String> listMessage=jsonPath.getList("data.message");

        Assert.assertTrue(listField.contains("email"));
        Assert.assertTrue(listField.contains("gender"));
        Assert.assertTrue(listField.contains("status"));
        for(String w : listMessage){
            Assert.assertTrue(w.equals("can't be blank"));
        }

    }
    @Test
    public void post9(){ // TC 0207
        myPostData.put("email",ReusableMethods.randomString(5)+"@live.com");

        postMethod(myPostData);
        jsonPath = response.jsonPath();

        List<String> listField=jsonPath.getList("data.field");
        List<String> listMessage=jsonPath.getList("data.message");

        Assert.assertTrue(listField.contains("name"));
        Assert.assertTrue(listField.contains("gender"));
        Assert.assertTrue(listField.contains("status"));
        for(String w : listMessage){
            Assert.assertTrue(w.equals("can't be blank"));
        }
    }
    @Test
    public void post10(){ // TC 0208
        myPostData.put("gender","Male");

        postMethod(myPostData);
        jsonPath = response.jsonPath();

        List<String> listField=jsonPath.getList("data.field");
        List<String> listMessage=jsonPath.getList("data.message");

        Assert.assertTrue(listField.contains("name"));
        Assert.assertTrue(listField.contains("email"));
        Assert.assertTrue(listField.contains("status"));
        for(String w : listMessage){
            Assert.assertTrue(w.equals("can't be blank"));
        }
    }
    @Test
    public void post11(){ // TC 0209
        myPostData.put("status","Active");

        postMethod(myPostData);
        jsonPath = response.jsonPath();

        List<String> listField=jsonPath.getList("data.field");
        List<String> listMessage=jsonPath.getList("data.message");

        Assert.assertTrue(listField.contains("name"));
        Assert.assertTrue(listField.contains("email"));
        Assert.assertTrue(listField.contains("gender"));
        for(String w : listMessage){
            Assert.assertTrue(w.equals("can't be blank"));
        }
    }






}
