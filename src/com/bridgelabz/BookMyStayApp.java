package com.bridgelabz;
public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventoryManager inventoryManager =
                new RoomInventoryManager();

        // Initialize Room Types
        inventoryManager.addRoomType("Single", 20, 2500);
        inventoryManager.addRoomType("Double", 15, 4000);
        inventoryManager.addRoomType("Suite", 5, 8000);

        // Display Inventory
        inventoryManager.displayInventory();

        // Update Inventory
        inventoryManager.updateRoomCount("Single", 18);

        // Update Price
        inventoryManager.updateRoomPrice("Suite", 9000);

        System.out.println("\nAvailable Single Rooms : "
                + inventoryManager.getAvailableRooms("Single"));

        System.out.println("Suite Price : ₹"
                + inventoryManager.getRoomPrice("Suite"));

        inventoryManager.displayInventory();
    }
}
