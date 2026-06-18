package com.bridgelabz;
import java.util.List;

public class Room {

    private int availableCount;
    private double pricePerNight;
    private List<String> amenities;

    public Room(int availableCount, double pricePerNight,
                List<String> amenities) {
        this.availableCount = availableCount;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    @Override
    public String toString() {
        return "Available Rooms : " + availableCount +
                ", Price : ₹" + pricePerNight +
                ", Amenities : " + amenities;
    }
}
