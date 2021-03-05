package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import pojos.Money;

import static io.restassured.RestAssured.given;

public class ExchangeRateAPI03 {
    Response response;
    String endPoint = "https://api.exchangeratesapi.io/2021-02-25/?base=USD";
    JsonPath json;
    Money money;
    ObjectMapper objectMapper = new ObjectMapper();

    public void getResponse() {
        response = given().accept(ContentType.JSON).when().get(endPoint);
        response.prettyPrint();
    }

    @Test
    public void TC0301() {
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
//        String eurValue =json.getString("rates.EUR");
//        String tryValue = json.getString("rates.TRY");
//        String rubValue = json.getString("rates.RUB");

        Double eurValue = json.getDouble("rates.EUR");
        Double tryValue = json.getDouble("rates.TRY");;
        Double rubValue = json.getDouble("rates.RUB");

        System.out.println(eurValue);
        System.out.println(tryValue);
        System.out.println(rubValue);
        Assert.assertTrue(eurValue == 0.8179959);
        Assert.assertTrue(tryValue == 7.226503);
        Assert.assertTrue(rubValue == 73.907486);

        System.out.println(json.getString("base"));
        Assert.assertEquals(json.getString("base"), "USD");
        System.out.println(json.getString("date"));
        Assert.assertEquals(json.getString("date"), "2021-02-25");

    }

    @Test
    public void TC0302() throws JsonProcessingException {
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
        money = objectMapper.readValue(response.asString(),Money.class);

        Float eurValue =money.getRates().getEUR();
        Float tryValue = money.getRates().getTRY();
        Float rubValue = money.getRates().getRUB();
        System.out.println(eurValue);
        System.out.println(tryValue);
        System.out.println(rubValue);
        Assert.assertTrue(eurValue == 0.81799591f);
        Assert.assertTrue(tryValue == 7.2265030675f);
        Assert.assertTrue(rubValue == 73.9074846626f);

        System.out.println(money.getBase());
        Assert.assertEquals(money.getBase(), "USD");
        System.out.println(money.getDate());
        Assert.assertEquals(money.getDate(), "2021-02-25");

    }






}
