package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import utilities.ConfigReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ExchangeRateAPI01 {
    Response response;
    String endPoint = "https://api.exchangeratesapi.io/latest";
    JsonPath json;
    List<Integer> exchangeRateList = new ArrayList<>();

    public void getResponse(){
        response = given().accept(ContentType.JSON).when().get(endPoint);
//      response.prettyPrint();
   }
    @Test
    public void TC01(){
        //    (Pojo Ile Yapilacak)
//    Kullanici aktuel döviz referans oranlarını alabilmali ve
//    asagidakilerini sirasiyla yapabilmelidir.
//         * Status kodunun 200 oldugunu,
//            * "rates" in icinde  ==> - "CAD": 1.5394,
//            -  "USD": 1.2127,
//            -  "TRY": 8.5503, para birmlerinin bulundugugunu ve
//    karsisinda sözkonusu yukardaki degerlerin oldugunu (verify)
//         * "base" in ==>  "EUR" oldugunu,
//            * "date" in ==>   Rate'lerin alindigi (testinin yapildigi) gündeki "yil/ay/gun" tarih zaman
//    dilimi oldugunu.(verify)
        getResponse();
        Assert.assertEquals(response.getStatusCode(),200);
        json=response.jsonPath();
        System.out.println(json.getString("rates"));

        String cadValue = json.getString("rates.CAD");
        String usdValue = json.getString("rates.USD");
        String tryValue = json.getString("rates.TRY");
        Assert.assertTrue(cadValue.equals("1.5418"));
        Assert.assertTrue(usdValue.equals("1.2108"));
        Assert.assertTrue(tryValue.equals("8.501"));

        System.out.println(json.getString("base"));
        Assert.assertEquals(json.getString("base"),"EUR");
        System.out.println(json.getString("date"));
        Assert.assertEquals(json.getString("date"),"2021-02-12");

    }

    @Test
    public void TC02(){
//         * "EUR" ya göre en yüksek rate'in (en degerli paranin) ==>"GBP"para birimi oldugu ve
//        rate'in ise  0.8765'oldugunu (verify)

        getResponse();
        json=response.jsonPath();
        Map<String,Integer> moneyRateList = new HashMap<>();

        for (int i=1;i<32;i++) {


        }

        System.out.println(moneyRateList);

  //      Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8");




    }








}
