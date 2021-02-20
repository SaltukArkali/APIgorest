package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Money;
import pojos.Money2;
import pojos.Rates2;

import static io.restassured.RestAssured.given;

public class ExchangeRateAPI0202 {

    Response response;
    String endPoint = " https://api.exchangeratesapi.io/2010-01-12";
    JsonPath json;
    Money2 money;
    Rates2 rates;
    ObjectMapper objectMapper = new ObjectMapper();

    public void getResponse() {
        response = given().accept(ContentType.JSON).when().get(endPoint);
        response.prettyPrint();
    }
    @Test
    public void TC0201() throws JsonProcessingException {
//        (Pojo nun pekismesi icin Pojo ile yapilacak)
//        Kullanici 2010-01-12 tarihindeki döviz referans oranlarını alabilmali ve
//        asagidakilerini sirasiyla yapabilmelidir.
//                * Status kodunun 200 oldugunu,
//         * "rates" in icinde  ==> - "TRY": 2.1084,
//                -  "CZK": 26.258,
//                -  "PLN": 4.0838, para birmlerinin bulundugunu ve
//        karsisinda sözkonusu yukardaki degerlerin oldugunu (verify)
//                * "base" in ==>  "EUR" oldugunu,
//         * "date" in ==>   2010-01-12 "yil/ay/gun" tarih zaman
//        dilimi oldugunu.(verify)
        getResponse();
        response.then().assertThat().statusCode(200);

        money = objectMapper.readValue(response.asString(), Money2.class);
        System.out.println(money.getRates());

        Assert.assertTrue(money.getRates().getTRY()==2.1084f);
        Assert.assertTrue(money.getRates().getCZK()==26.258f);
        Assert.assertTrue(money.getRates().getPLN()==4.0838f);
        Assert.assertTrue(money.getBase().equals("EUR"));
        Assert.assertEquals(money.getDate(),"2010-01-12");

    }
    @Test
    public void TC0202() {

//     * "EUR" ya göre en yüksek 3'üncü rate'in (en degerli paranin) ==>"USD"para birimi oldugu ve
//    rate'inin ise  1.4481'oldugunu,
//     - ayrica söz konusu tarihteki  en düsük para biriminin "HUF" oldugunu ve
//     degerinin ise 268.18 oldugunu(verify)

//        jsonPath = myResponse(endPoint).jsonPath();
//        Map<String,Integer> myRates = jsonPath.getMap("rates");
//        TreeMap<String,Integer>myOrderedRates = new TreeMap<>(myRates);
//        System.out.println(myOrderedRates);
//        //kucukten buyuge
//        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
//        myOrderedRates.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue())
//                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
//        System.out.println(sortedMap);
//        //buyukten kucuge
//        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
//        myOrderedRates.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
//        System.out.println(reverseSortedMap);






    }

}
