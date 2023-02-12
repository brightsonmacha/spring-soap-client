package com.brightsonmacha.soapclient.config;

import com.brightsonmacha.soapclient.services.WebServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.brightsonmacha.generated");
        return marshaller;
    }
    @Bean
    public WebServiceClient countryClient(Jaxb2Marshaller marshaller) {
        WebServiceClient client = new WebServiceClient();
        client.setDefaultUri("http://localhost:8080/ws/country");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
