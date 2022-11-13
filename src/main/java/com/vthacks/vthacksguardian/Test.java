package com.vthacks.vthacksguardian;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.URI;
import java.net.http.HttpRequest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {



        try {



            HttpRequest postRequest = (HttpRequest) HttpRequest.newBuilder()
                    .uri(new URI("https://www.virustotal.com/vtapi/v2/file/scan"))
                    .setHeader("accept", "text/plain")
                    .setHeader("content-type", "content-type\", \"application/x-www-form-urlencoded");

            URL url = new URL("https://www.virustotal.com/vtapi/v2/file/scan");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET"); //requests
            conn.setRequestProperty("accept", "text/plain"); //header
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
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


