package com.bridgelabz.service;

import com.bridgelabz.model.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOnServiceManager {

    private final Map<String,
            List<Service>> reservationServices =
            new HashMap<>();

    /**
     * Attach service to reservation
     */
    public void addService(String reservationId,
                           Service service) {

        reservationServices
                .computeIfAbsent(
                        reservationId,
                        id -> new ArrayList<>())
                .add(service);

        System.out.println(
                service.getServiceName()
                        + " added to "
                        + reservationId);
    }

    /**
     * Display all services
     */
    public void displayServices(
            String reservationId) {

        List<Service> services =
                reservationServices.get(
                        reservationId);

        if (services == null ||
                services.isEmpty()) {

            System.out.println(
                    "No services selected.");
            return;
        }

        System.out.println(
                "\nServices for "
                        + reservationId);

        services.forEach(
                System.out::println);
    }

    /**
     * Calculate total service cost
     */
    public double calculateServiceCost(
            String reservationId) {

        List<Service> services =
                reservationServices.get(
                        reservationId);

        if (services == null) {
            return 0;
        }

        return services.stream()
                .mapToDouble(
                        Service::getServiceCost)
                .sum();
    }
}
