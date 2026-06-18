package com.bridgelabz;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomInventoryManager {

    private final Map<String, Room> roomInventory;

    public RoomInventoryManager() {
        roomInventory = new HashMap<>();
    }

    public void addRoomType(String roomType,
                            int count,
                            double price,
                            List<String> amenities) {

        if (count < 0 || price <= 0) {
            throw new IllegalArgumentException(
                    "Invalid room count or price.");
        }

        roomInventory.put(
                roomType,
                new Room(count, price, amenities)
        );

        System.out.println(roomType + " added successfully.");
    }

    public void updateRoomCount(String roomType, int newCount) {

        validateRoomType(roomType);

        roomInventory.get(roomType)
                .setAvailableCount(newCount);
    }

    public void updateRoomPrice(String roomType,
                                double newPrice) {

        validateRoomType(roomType);

        roomInventory.get(roomType)
                .setPricePerNight(newPrice);
    }

    public Map<String, Room> getInventory() {
        return roomInventory;
    }

    private void validateRoomType(String roomType) {

        if (!roomInventory.containsKey(roomType)) {
            throw new IllegalArgumentException(
                    "Room Type Not Found : " + roomType);
        }
    }
}