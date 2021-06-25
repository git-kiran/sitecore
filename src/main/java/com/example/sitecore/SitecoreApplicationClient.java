package com.example.sitecore;

import com.example.sitecore.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Profile("!test")
public class SitecoreApplicationClient implements CommandLineRunner {

    @Autowired
    RouteService routeService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter Departure and arrival");
        Scanner scanner = new Scanner(System.in);
        String departure = scanner.next();
        String arrival = scanner.next();

        routeService.processgraph(departure, arrival);
    }
}
