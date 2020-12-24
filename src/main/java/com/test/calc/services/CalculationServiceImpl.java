package com.test.calc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.core.WebServiceOperations;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.tempuri.*;

@Service
public class CalculationServiceImpl implements CalculationService {

    public static final String ENDPOINT_URL = "http://www.dneonline.com/calculator.asmx";

    private final WebServiceOperations webService;

    private static final String DEFAULT_NAMESPACE = "http://tempuri.org/";
    private static final String ADD_NAMESPACE = "Add";
    private static final String SUBTRACT_NAMESPACE = "Subtract";
    private static final String MULTIPLY_NAMESPACE = "Multiply";
    private static final String DIVIDE_NAMESPACE = "Divide";
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculationServiceImpl.class);

    public CalculationServiceImpl(WebServiceOperations webService) {
        this.webService = webService;
    }

    @Override
    public Integer add(Integer a, Integer b) {
        Add request = new Add();
        request.setIntA(a);
        request.setIntB(b);
        try {
            AddResponse addResponse = (AddResponse) webService.marshalSendAndReceive(
                    ENDPOINT_URL,
                    request,
                    new SoapActionCallback(DEFAULT_NAMESPACE + ADD_NAMESPACE));
            return addResponse.getAddResult();
        } catch (XmlMappingException | WebServiceClientException exception) {
            LOGGER.warn("Cant get addResult", exception);
            return null;
        }
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        Subtract request = new Subtract();
        request.setIntA(a);
        request.setIntB(b);
        try {
            SubtractResponse subtractResponse = (SubtractResponse) webService.marshalSendAndReceive(
                    ENDPOINT_URL,
                    request,
                    new SoapActionCallback(DEFAULT_NAMESPACE + SUBTRACT_NAMESPACE));
            return subtractResponse.getSubtractResult();
        } catch (XmlMappingException | WebServiceClientException exception) {
            LOGGER.warn("Cant get subtractResult", exception);
            return null;
        }
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        Multiply request = new Multiply();
        request.setIntA(a);
        request.setIntB(b);
        try {
            MultiplyResponse multiplyResponse = (MultiplyResponse) webService.marshalSendAndReceive(
                    ENDPOINT_URL,
                    request,
                    new SoapActionCallback(DEFAULT_NAMESPACE + MULTIPLY_NAMESPACE));
            return multiplyResponse.getMultiplyResult();
        } catch (XmlMappingException | WebServiceClientException exception) {
            LOGGER.warn("Cant get multiplyResult", exception);
            return null;
        }

    }

    @Override
    public Integer divide(Integer a, Integer b) {
        Divide request = new Divide();
        request.setIntA(a);
        request.setIntB(b);
        try {
            DivideResponse divideResponse = (DivideResponse) webService.marshalSendAndReceive(
                    ENDPOINT_URL,
                    request,
                    new SoapActionCallback(DEFAULT_NAMESPACE + DIVIDE_NAMESPACE));
            return divideResponse.getDivideResult();
        } catch (XmlMappingException | WebServiceClientException exception) {
            LOGGER.warn("Cant get divideResult", exception);
            return null;
        }
    }
}
