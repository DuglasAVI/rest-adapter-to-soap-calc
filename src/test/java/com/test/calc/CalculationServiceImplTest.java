package com.test.calc;

import com.test.calc.config.WsConfig;
import com.test.calc.services.CalculationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CalculationServiceImpl.class, WsConfig.class})
public class CalculationServiceImplTest {

    @Autowired
    private CalculationServiceImpl service;

    @Test
    public void add() throws Exception {
        Assert.assertEquals(new Integer(10), service.add(2, 8));
    }

    @Test
    public void subtract() throws Exception {
        Assert.assertEquals(new Integer(-6), service.subtract(2, 8));
    }

    @Test
    public void multiply() throws Exception {
        Assert.assertEquals(new Integer(16), service.multiply(2, 8));
    }

    @Test
    public void divide() throws Exception {
        Assert.assertEquals(new Integer(2), service.divide(6, 3));
        Assert.assertEquals(new Integer(3), service.divide(10, 3));
    }

}
