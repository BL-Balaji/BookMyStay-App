package com.bridgelabz;

import com.bridgelabz.inventory.RoomInventoryManager;
import com.bridgelabz.model.Reservation;
import com.bridgelabz.service.BookingQueueService;
import com.bridgelabz.service.SearchService;

import java.util.List;

public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventoryManager inventoryManager =
                new RoomInventoryManager();

        inventoryManager.addRoomType(
                "Single",
                10,
                2500,
                List.of("WiFi", "AC", "TV"));

        inventoryManager.addRoomType(
                "Double",
                5,
                4500,
                List.of("WiFi", "AC", "TV", "Mini Bar"));

        SearchService searchService =
                new SearchService(inventoryManager);

        searchService.searchAvailableRooms();

        BookingQueueService queueService =
                new BookingQueueService();

        queueService.submitBookingRequest(
                new Reservation(
                        "Balaji",
                        "Single",
                        2));

        queueService.submitBookingRequest(
                new Reservation(
                        "Rahul",
                        "Double",
                        3));

        queueService.submitBookingRequest(
                new Reservation(
                        "Amit",
                        "Single",
                        1));

        queueService.displayQueue();

        System.out.println("\n");

        queueService.processNextRequest();

        queueService.processNextRequest();

        queueService.displayQueue();
    }
}