package com.bridgelabz.model;

public class Reservation {

    private String guestName;
    private String roomType;
    private int nights;

    public Reservation(String guestName,
                       String roomType,
                       int nights) {

        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    @Override
    public String toString() {
        return "Guest = " + guestName +
                ", Room = " + roomType +
                ", Nights = " + nights;
    }
}
