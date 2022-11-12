package com.vthacks.vthacksguardian;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://emailrep.io/krizh822%40gmail.com")
//                .get()
//                .addHeader("accept", "application/json")
//                .build();
//
//        Response response = client.newCall(request).execute();

         /*
        Maven dependency for JSON-simple:
            <dependency>
                <groupId>com.googlecode.json-simple</groupId>
                <artifactId>json-simple</artifactId>
                <version>1.1.1</version>
            </dependency>
         */

        try {
            //Public API:
            //https://www.metaweather.com/api/location/search/?query=<CITY>
            //https://www.metaweather.com/api/location/44418/

            URL url = new URL("https://emailrep.io/krizh822%40gmail.com");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET"); //requests
            conn.setRequestProperty("accept", "application/json"); //header
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                System.out.println(informationString);


                //JSON simple library Setup with Maven is used to convert strings to JSON
                JSONParser parse = new JSONParser();
                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

                //Get the first JSON object in the JSON array
                System.out.println(dataObject.get(0));

                JSONObject countryData = (JSONObject) dataObject.get(0);

                System.out.println(countryData.get("woeid"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


