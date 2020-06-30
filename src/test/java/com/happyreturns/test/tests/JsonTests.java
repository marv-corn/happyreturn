package com.happyreturns.test.tests;

import com.happyreturns.test.BaseJsonClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import java.util.List;

public class JsonTests {

    @Test
    public void requestVariants(){
   
      Response response = RestAssured.get("https://happyreturnsqatest.free.beeceptor.com/getProductVariants");
     // System.out.println(response.getBody().asString());

      List<String> jsonResponse = response.jsonPath().getList("variants");
      for (String s: jsonResponse){
        System.out.println(s);
      }

    }


    @Test
    public void assertRequestBody() {
        BaseJsonClass baseJsonClass = new BaseJsonClass();
        System.out.println(baseJsonClass);
        Assert.assertEquals(baseJsonClass.requestBodyTest(), "{\"order\":{\"line_items\":[{\"variant_id\":447654529,\"quantity\":1}]}}");
    }
}
