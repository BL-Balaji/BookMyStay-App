package com.bridgelabz;
import java.util.HashMap;
import java.util.Map;

public class RoomInventoryManager {

    // Room Type -> Available Count
    private final Map<String, Integer> roomInventory;

    // Room Type -> Price Per Night
    private final Map<String, Double> roomPrices;

    public RoomInventoryManager() {
        roomInventory = new HashMap<>();
        roomPrices = new HashMap<>();
    }

    /**
     * Add a new room type to inventory
     */
    public void addRoomType(String roomType, int count, double price) {

        if (count < 0 || price <= 0) {
            throw new IllegalArgumentException("Count and price must be positive.");
        }

        roomInventory.put(roomType, count);
        roomPrices.put(roomType, price);

        System.out.println(roomType + " room added successfully.");
    }

    /**
     * Update available room count
     */
    public void updateRoomCount(String roomType, int newCount) {

        validateRoomType(roomType);

        if (newCount < 0) {
            throw new IllegalArgumentException("Room count cannot be negative.");
        }

        roomInventory.put(roomType, newCount);

        System.out.println(roomType + " inventory updated.");
    }

    /**
     * Update room price
     */
    public void updateRoomPrice(String roomType, double newPrice) {

        validateRoomType(roomType);

        if (newPrice <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        roomPrices.put(roomType, newPrice);

        System.out.println(roomType + " price updated.");
    }

    /**
     * Check room availability
     */
    public int getAvailableRooms(String roomType) {

        validateRoomType(roomType);

        return roomInventory.get(roomType);
    }

    /**
     * Get room price
     */
    public double getRoomPrice(String roomType) {

        validateRoomType(roomType);

        return roomPrices.get(roomType);
    }

    /**
     * Display complete inventory
     */
    public void displayInventory() {

        System.out.println("\n========== ROOM INVENTORY ==========");

        for (String roomType : roomInventory.keySet()) {

            System.out.println(
                    "Room Type : " + roomType +
                            " | Available : " + roomInventory.get(roomType) +
                            " | Price/Night : ₹" + roomPrices.get(roomType)
            );
        }

        System.out.println("====================================");
    }

    private void validateRoomType(String roomType) {

        if (!roomInventory.containsKey(roomType)) {
            throw new IllegalArgumentException(
                    "Room Type '" + roomType + "' does not exist."
            );
        }
    }
}
