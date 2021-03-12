package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import pojos.Money;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ExchangeRateAPI05 {
    Response response;
    String endPoint1 = "https://api.exchangeratesapi.io/latest?symbols=USD,GBP";
    String endPoint2 = "https://api.exchangeratesapi.io/history?start_at=2018-01-01&end_at=2018-09-01";
    JsonPath json;

    public void getResponse(String endPoint) {
        response = given().accept(ContentType.JSON).when().get(endPoint);
        response.prettyPrint();
    }

    @Test
    public void TC0501() {
//        Kullanici ilgili Endpoint ile asagidakilerini sirasiyla yapabilmelidir.
//                * Status kodunun 200 oldugunu,
//         * "rates" in icinde  ==> - "USD": 1.1969,
//                -  "GPD": 0.8567
//        para birmlerinin bulundugunu ve  karsisinda sözkonusu
//        yukardaki degerlerin güncel halinin bulundugunu (verify)
//                * "base" in ==>  "USD" oldugunu,(verify)
        getResponse(endPoint1);
        response.then().assertThat().statusCode(200);
        json = response.jsonPath();
        Double usdValue =json.getDouble("rates.USD");
        Double gbpValue = json.getDouble("rates.GBP");
        System.out.println(usdValue);
        Assert.assertTrue(usdValue== 1.1933);
        System.out.println(gbpValue);
        Assert.assertTrue(gbpValue==0.85835);
        System.out.println(json.getString("base"));
        Assert.assertNotEquals(json.getString("base"), "USD");

    }

    @Test
    public void TC0502() throws JsonProcessingException {
//        Kullanici ilgili Endpoint ile asagidakilerini sirasiyla yapabilmelidir.
//                * Status kodunun 200 oldugunu,
//         * "start_at" in ==>  "2018-01-01",
//         * "base" in ==>  "EUR" oldugunu,
//         *  "end_at" in ==> "2018-09-01" oldugunu (verify)
        getResponse(endPoint2);
        response.then().assertThat().statusCode(200);

        json = response.jsonPath();
        Map<String,Double> mapRates = json.getMap("rates.2018-05-04");
        System.out.println("mapRates.get(\"CAD\") = " + mapRates.get("CAD"));//mapRates.get("CAD") = 1.541


    }

}
