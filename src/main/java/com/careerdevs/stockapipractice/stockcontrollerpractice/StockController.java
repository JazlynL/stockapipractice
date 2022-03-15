package com.careerdevs.stockapipractice.stockcontrollerpractice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/prac")
public class StockController {

    @Autowired
    private Environment env;


    @GetMapping("/query")

    public String practice(RestTemplate restTemplate,

    @RequestParam("symbol") String symbol ){

        String URL = "https://www.alphavantage.co/query?function=OVERVIEW&symbol=" + symbol;
        String apiKey = env.getProperty("API_KEY");
        String addKey = "&apikey=";
        URL += addKey +apiKey;
        //dont forget this part it displays the JSON data....
        String serverResponse = restTemplate.getForObject(URL,String.class);
//        System.out.println("\n\n"+URL);
       System.out.println("\n\n"+serverResponse);
       return serverResponse;


        //return restTemplate.getForObject(alpha_Vantage_Endpoint + name + "&interval=5min&" +
        //                        "=full&apikey=" + apikey,
        //                Object.class);



    }


}
