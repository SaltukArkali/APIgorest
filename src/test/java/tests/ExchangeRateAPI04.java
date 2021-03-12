package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import pojos.Money2;
import pojos.Rates2;

import static io.restassured.RestAssured.given;

public class ExchangeRateAPI04 {
    Response response;
    String endPoint = "https://api.exchangeratesapi.io/2021-02-25/?base=USD";
    JsonPath json;

    public void getResponse() {
        response = given().accept(ContentType.JSON).when().get(endPoint);
        response.prettyPrint();
    }

    @Test
    public void TC0401() {
//        Kullanici 2021-02-25 tarihindeki döviz referans oranlarını alabilmali ve
//        asagidakilerini sirasiyla yapabilmelidir.
//                * Status kodunun 200 oldugunu,
//         * "rates" in icinde  ==> - "EUR": 0.81799591,
//                -  "TRY": 7.2265030675;
//        -  "RUB": 73.9074846626, para birmlerinin bulundugunu ve
//        karsisinda sözkonusu yukardaki degerlerin oldugunu (verify)
//                * "base" in ==>  "USD" oldugunu,
//         * "date" in ==>   2021-02-25 "yil/ay/gun" tarih zaman
//        dilimi oldugunu.(verify)
        getResponse();
        response.then().assertThat().statusCode(200);
        json = response.jsonPath();
        float eurValue = Float.parseFloat(json.getString("rates.EUR"));
        float tryValue = Float.parseFloat(json.getString("rates.TRY"));
        float rubValue = Float.parseFloat(json.getString("rates.RUB"));
        System.out.println(eurValue);
        System.out.println(tryValue);
        System.out.println(rubValue);
        Assert.assertTrue(eurValue == 0.8179959f);
        Assert.assertTrue(tryValue == 7.226503f);
        Assert.assertTrue(rubValue == 73.907486f);

        System.out.println(json.getString("base"));
        Assert.assertEquals(json.getString("base"), "USD");
        System.out.println(json.getString("date"));
        Assert.assertEquals(json.getString("date"), "2021-02-25");

    }



}
