package com.brightsonmacha.soapclient.services;


import com.brightsonmacha.generated.GetCountryRequest;
import com.brightsonmacha.generated.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class WebServiceClient extends WebServiceGatewaySupport {

    public Object callWebService(String url, Object request) {
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }

    public GetCountryResponse getCountry(String url, String country) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(url, request);
    }


}
