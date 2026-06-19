package com.bridgelabz.model;

public class Service {

    private String serviceName;
    private double serviceCost;

    public Service(String serviceName,
                   double serviceCost) {

        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    @Override
    public String toString() {

        return serviceName +
                " (₹" + serviceCost + ")";
    }
}
