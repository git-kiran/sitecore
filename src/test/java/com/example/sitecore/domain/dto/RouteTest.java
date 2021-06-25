package com.example.sitecore.domain.dto;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class RouteTest {
    @Test
    public void gettersAndSettersShouldFunctionCorrectly() {
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(Route.class);
    }
}
