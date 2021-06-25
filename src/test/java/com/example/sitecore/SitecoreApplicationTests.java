package com.example.sitecore;

import com.example.sitecore.repository.RouteRepository;
import com.example.sitecore.service.RouteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
public class SitecoreApplicationTests {

    @Autowired
    RouteService routeService;

    @Autowired
    RouteRepository routeRepository;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void checkMinimumRoute1() throws Exception {
        routeService.processgraph("DUB", "SYD");

        assertEquals("21", outputStreamCaptor.toString().substring(outputStreamCaptor.toString().lastIndexOf("\n\n")).trim());
    }


    @Test
    public void checkMinimumRoute2() throws Exception {
        routeService.processgraph("DUB", "LAS");

        assertEquals("8", outputStreamCaptor.toString().substring(outputStreamCaptor.toString().lastIndexOf("\n\n")).trim());
    }

    @Test
    public void checkIfLocationServed() throws Exception {


        Assertions.assertThrows(RuntimeException.class, () -> {
            routeService.processgraph("dub", "SYD");
        });

    }

    @Test
    public void checkIfRouteAvailable() throws Exception {


        Assertions.assertThrows(RuntimeException.class, () -> {
            routeService.processgraph("SYD", "DUB");
        });

    }
}
