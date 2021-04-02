package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.math3.analysis.function.Add;
import org.junit.Test;
import org.testng.Assert;

import java.util.*;

import static io.restassured.RestAssured.given;

public class ExchangeRateAPI06 {
    Response response;
    String endPoint1 = "https://api.exchangeratesapi.io/history?start_at=2018-01-01&end_at=2018-09-01";
    String endPoint2 = "https://api.exchangeratesapi.io/history?start_at=2018-01-01&end_at=2018-09-01";
    JsonPath json;

    public void getResponse(String endPoint) {
        response = given().accept(ContentType.JSON).when().get(endPoint);
        response.prettyPrint();
    }

    @Test
    public void TC0601() {
//        Kullanici ilgili Endpoint ile asagidakilerini sirasiyla yapabilmelidir.
//                * Status kodunun 200 oldugunu,
//         * "2018-05-04" ==> dönemindeki en degerli Para biriminin ==>"GBP" oldugunu,
//         * "TRY" nin ise Euro karsisindaki degerinin ==> "5.0963" oldugunu dogrulayiniz.
        getResponse(endPoint1);
        response.then().assertThat().statusCode(200);
        json = response.jsonPath();
        Map<String,Double> mapRates = json.getMap("rates.2018-05-04");
        System.out.println("mapRates.get(\"GBP\") = " + mapRates.get("GBP"));

        Map<String,Double> treeMap = new TreeMap<>(mapRates);

        Map<String,Double> sortedMap = new LinkedHashMap<>();
        System.out.println("Tree Map : " + treeMap);

        treeMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                forEachOrdered(t->sortedMap.put(t.getKey(),t.getValue()));
        System.out.println("Sorted Map : " +sortedMap);

        Object[] allKeys = sortedMap.keySet().toArray();
        System.out.println("Arraylist hali : " +Arrays.toString(allKeys));
        System.out.println("Biggest Value : " + allKeys[0].toString());
        Assert.assertTrue(allKeys[0].toString().equals("GBP"));

        System.out.println("mapRates.get(\"TRY\") = " + mapRates.get("TRY"));

        String valueTRY = mapRates.get("TRY")+"";

 //       Float.parseFloat(valueTRY);

        Assert.assertTrue(Float.parseFloat(valueTRY)==5.0963);

        mapRates.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }

    @Test
    public void TC0602() {
//        Kullanici ilgili Endpoint ile asagidakilerini sirasiyla yapabilmelidir.
//                * Status kodunun 200 oldugunu,
//         * "start_at" in ==>  "2018-01-01",
//         * "base" in ==>  "EUR" oldugunu,
//         *  "end_at" in ==> "2018-09-01" oldugunu ,
//
//         * Belirtilen baslangic ve bitis tarihleri arasindaki dönemde GPD ' nin en yüksek degerine
//        "2018-08-28" döneminde ulastigini ve bunun ise ==> "GBP": 0.9068, oldugunu.
        getResponse(endPoint2);
        response.then().assertThat().statusCode(200);
        json = response.jsonPath();
        Assert.assertTrue(json.getString("start_at").equals("2018-01-01"));
        Assert.assertTrue(json.getString("base").equals("EUR"));
        Assert.assertTrue(json.getString("end_at").equals("2018-09-01"));

        List<Double> allGPDData = new ArrayList<>();
        Map<String,Double> myDataMap=json.getMap("rates");

        for(String w : myDataMap.keySet()){
            allGPDData.add(json.getDouble("rates."+w+".GBP"));
        }

        Double data = json.getDouble("rates.2018-08-28.GBP");
        Assert.assertEquals(Collections.max(allGPDData),data);




    





    }

}
