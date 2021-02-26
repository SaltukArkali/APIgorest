package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import pojos.Money;
import pojos.Rates;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ExchangeRateAPI02Onceki {
    Response response;
    String endPoint = "https://api.exchangeratesapi.io/latest";
    JsonPath json;
    Money money;
    Rates rates;
    ObjectMapper objectMapper = new ObjectMapper();

    public void getResponse() {
        response = given().accept(ContentType.JSON).when().get(endPoint);
//      response.prettyPrint();
    }

    @Test
    public void TC01() throws JsonProcessingException {
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
        response.then().assertThat().statusCode(200);

        money = objectMapper.readValue(response.asString(), Money.class);
        System.out.println(money.getRates());

        Assert.assertTrue(money.getRates().getCAD() == 1.5418f);
        Assert.assertTrue(money.getRates().getUSD() == 1.2108f);
        Assert.assertTrue(money.getRates().getTRY() == 8.501f);
        Assert.assertEquals(money.getBase(), "EUR");
        Assert.assertEquals(money.getDate(), "2021-02-12");

    }

    @Test
    public void TC02() {
//         * "EUR" ya göre en yüksek rate'in (en degerli paranin) ==>"GBP"para birimi oldugu ve
//        rate'in ise  0.8765'oldugunu (verify)

        getResponse();
        json = response.jsonPath();
        Map<String, Float> allRates = json.getMap("rates");

        float euro = 1.0F;
        for (String currencyKey : allRates.keySet()) {
            float rate = allRates.get(currencyKey);

            if (currencyKey.toUpperCase().equals("GBP")) {
                Assert.assertTrue(euro > rate);
            } else {
                Assert.assertTrue(euro < rate);
            }
        }
    }


}
