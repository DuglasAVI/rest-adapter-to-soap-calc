package com.test.calc.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceOperations;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class WsConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(WsConfig.class.getName());


    @Bean
    public Jaxb2Marshaller marshaller() {
        LOGGER.debug("Creating marshaller");
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("org.tempuri");
        return marshaller;
    }


    @Bean
    public WebServiceOperations webService(Jaxb2Marshaller marshaller) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        template.setMessageSender(messageSender());
        return template;
    }


    private HttpComponentsMessageSender messageSender() {
        RequestConfig config = RequestConfig.custom().build();

        CloseableHttpClient client = HttpClients.custom()
                .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
                .setDefaultRequestConfig(config)
                .build();

        return new HttpComponentsMessageSender(client);
    }
}
