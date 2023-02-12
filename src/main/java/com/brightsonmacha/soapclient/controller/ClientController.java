package com.brightsonmacha.soapclient.controller;

import com.brightsonmacha.generated.GetCountryResponse;
import com.brightsonmacha.soapclient.services.WebServiceClient;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final Gson gson = new Gson();

    @Autowired
    private WebServiceClient webServiceClient;

    @RequestMapping("/country/{name}")
    public ResponseEntity<?> getCountry(@PathVariable String name) {
        String url = "http://localhost:8080/ws/country";

        //GetCountryRequest request = new GetCountryRequest();
        //request.setName(name);
        //GetCountryResponse response = (GetCountryResponse) countryClientWeb.callWebService(url, request);

        GetCountryResponse response = webServiceClient.getCountry(url, name);
        logger.info("response: {}", gson.toJson(response));


        return new ResponseEntity<>(response.getCountry(), HttpStatus.OK);
    }

    @RequestMapping("/country/{name}")
    public ResponseEntity<?> getStudent(@PathVariable String name) {
        String url = "http://localhost:8080/ws/country";

        GetCountryResponse response = webServiceClient.getCountry(url, name);
        logger.info("response: {}", gson.toJson(response));


        return new ResponseEntity<>(response.getCountry(), HttpStatus.OK);
    }
}
