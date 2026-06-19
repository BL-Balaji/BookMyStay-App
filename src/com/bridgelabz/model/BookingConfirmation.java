package com.bridgelabz.model;

public class BookingConfirmation {

    private String reservationId;
    private String guestName;
    private String roomType;
    private String roomId;
    private String status;

    public BookingConfirmation(String reservationId,
                               String guestName,
                               String roomType,
                               String roomId) {

        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
        this.status = "CONFIRMED";
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "\nReservation ID : " + reservationId +
                "\nGuest : " + guestName +
                "\nRoom Type : " + roomType +
                "\nRoom ID : " + roomId +
                "\nStatus : " + status;
    }
}
