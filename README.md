# BookMyStay App

## Overview

BookMyStay is a Hotel Booking Management System designed as a learning project to demonstrate Core Java concepts, Object-Oriented Programming (OOP), Collections Framework, Data Structures, and Software Design Principles.

The application allows guests to search rooms, place booking requests, reserve rooms using a First-Come-First-Served (FCFS) approach, attach add-on services, and maintain booking history with reporting capabilities.

Each use case introduces a real-world business problem and maps it to suitable Java data structures.

---

# Project Objectives

* Manage hotel room inventory efficiently.
* Provide real-time room availability.
* Implement fair booking allocation using FIFO.
* Prevent double-booking through unique room allocation.
* Support optional hotel services.
* Maintain complete booking history and reporting.
* Demonstrate practical usage of Java Collections Framework.

---

# Technology Stack

* Java
* OOP Principles
* Collections Framework
* Exception Handling
* Streams API
* HashMap
* HashSet
* Queue (LinkedList)
* ArrayList

---

# System Architecture

```text
BookMyStay
│
├── model
│   ├── Room
│   ├── Reservation
│   ├── BookingConfirmation
│   └── Service
│
├── inventory
│   └── RoomInventoryManager
│
├── service
│   ├── SearchService
│   ├── BookingQueueService
│   ├── ReservationService
│   ├── AddOnServiceManager
│   └── BookingHistoryService
│
└── BookMyStayApp
```

---

# Use Case 1: Room Inventory Setup & Management

## Description

The Room Inventory Management module is responsible for maintaining hotel room information. It serves as the central repository for room availability, pricing, and amenities.

## Actors

* Hotel Admin
* Inventory Service

## Data Structures Used

```java
HashMap<String, Room>
```

## Key Concepts

* Fast Lookup
* Centralized Inventory
* Data Consistency
* Inventory Management

## Functional Requirements

* Add room types
* Store room count
* Store room pricing
* Store amenities
* Update room inventory
* View available rooms

## Flow

```text
Admin Adds Room
        ↓
Store in HashMap
        ↓
Update Count / Price
        ↓
Inventory Available for Search
```

## Benefits

* O(1) lookup time
* Centralized data management
* Easy scalability
* Consistent inventory tracking

## Example

```text
Single Room -> 10 Rooms -> ₹2500
Double Room -> 5 Rooms -> ₹4500
Suite Room -> 2 Rooms -> ₹9000
```

---

# Use Case 2: Room Search & Availability Check

## Description

Guests can search room availability without modifying inventory. The system displays available room types, prices, and amenities.

## Actors

* Guest
* Search Service

## Data Structures Used

```java
HashMap<String, Room>
```

## Key Concepts

* Read-only Operations
* Availability Validation
* Fast Search
* Defensive Checks

## Functional Requirements

* Search available rooms
* View room details
* Show room pricing
* Show amenities
* Prevent booking unavailable rooms

## Flow

```text
Guest Search Request
          ↓
HashMap Lookup
          ↓
Availability Check
          ↓
Display Results
```

## Benefits

* No inventory modification
* Real-time availability
* Fast response time

---

# Use Case 3: Booking Request (First-Come-First-Served)

## Description

Booking requests are stored in a queue and processed according to the order in which they arrive.

## Actors

* Guest
* Booking Queue Service

## Data Structures Used

```java
Queue<Reservation>
LinkedList<Reservation>
```

## Key Concepts

* FIFO Principle
* Fair Allocation
* Request Ordering
* Queue Management

## Functional Requirements

* Accept booking requests
* Maintain request order
* Handle high traffic situations
* Process requests fairly

## Flow

```text
Booking Request
       ↓
Queue (Enqueue)
       ↓
Wait for Processing
       ↓
Processed in FIFO Order
```

## Benefits

* Fair booking allocation
* Predictable request handling
* No request starvation

## Example

```text
Balaji
Rahul
Amit

Processing Order

Balaji
Rahul
Amit
```

---

# Use Case 4: Reservation Confirmation & Room Allocation

## Description

Confirmed bookings receive unique room allocations. The system prevents duplicate room assignment and updates inventory immediately.

## Actors

* Booking Service
* Inventory Service

## Data Structures Used

```java
HashSet<String>
HashMap<String, Set<String>>
```

## Key Concepts

* Uniqueness Enforcement
* Duplicate Prevention
* Inventory Synchronization
* Atomic Allocation

## Functional Requirements

* Generate unique room IDs
* Assign room to guest
* Prevent duplicate allocation
* Reduce inventory count

## Flow

```text
Dequeue Request
        ↓
Check Availability
        ↓
Generate Room ID
        ↓
Assign Room
        ↓
Update Inventory
```

## Benefits

* Zero double-booking
* Fast allocation
* Strong booking integrity

## Example

```text
Single -> S100
Single -> S101
Double -> D102
Suite  -> SU103
```

---

# Use Case 5: Add-On Service Selection

## Description

Guests can enhance their booking experience by selecting additional hotel services.

## Actors

* Guest
* Service Management Module

## Data Structures Used

```java
Map<String, List<Service>>
```

## Key Concepts

* One-to-Many Relationship
* Composition
* Extensible Design
* Service Mapping

## Functional Requirements

* Attach services to reservation
* Support multiple services
* Calculate service cost
* Manage service history

## Available Services

* Breakfast
* Airport Pickup
* Spa
* Laundry
* Gym Access

## Flow

text
Select Service
        ↓
Add to Service List
        ↓
Map to Reservation ID
        ↓
Calculate Cost

## Benefits

* Flexible service management
* Accurate billing
* Easy future enhancements

## Example

text
RES1000

Breakfast      ₹500
Airport Pickup ₹1200
Spa            ₹2500

Total = ₹4200
```

---

# Use Case 6: Booking History & Reporting

## Description

All confirmed reservations are stored for future retrieval, reporting, cancellation management, and auditing.

## Actors

* Admin
* Reporting Service

## Data Structures Used

```java
List<BookingConfirmation>
```

## Key Concepts

* Historical Tracking
* Ordered Data Storage
* Reporting
* Audit Support

## Functional Requirements

* Store booking history
* View booking details
* Cancel bookings
* Generate reports
* Support auditing

## Flow

```text
Booking Confirmed
         ↓
Store in List
         ↓
Retrieve Later
         ↓
Generate Reports
```

## Benefits

* Complete booking history
* Audit trail
* Customer support assistance
* Reporting capabilities

## Example Report

```text
Total Bookings : 10
Confirmed      : 8
Cancelled      : 2
```

---

# Time Complexity Analysis

| Operation               | Data Structure | Complexity |
| ----------------------- | -------------- | ---------- |
| Add Room                | HashMap        | O(1)       |
| Search Room             | HashMap        | O(1)       |
| Add Booking Request     | Queue          | O(1)       |
| Process Booking         | Queue          | O(1)       |
| Allocate Room           | HashSet        | O(1)       |
| Add Service             | List           | O(1)       |
| Booking History Storage | ArrayList      | O(1)       |
| Report Generation       | List           | O(n)       |

---

# Core Java Concepts Covered

## Object-Oriented Programming

* Classes and Objects
* Encapsulation
* Abstraction
* Composition

## Collections Framework

* HashMap
* HashSet
* ArrayList
* Queue
* LinkedList

## Exception Handling

* IllegalArgumentException
* IllegalStateException
* Validation

## Stream API

* Filtering
* Counting
* Aggregation

---

# Learning Outcomes

By implementing BookMyStay, developers will learn:

* Real-world system design
* Java Collections Framework
* Data structure selection
* OOP best practices
* Inventory management
* Booking workflow design
* Reporting and auditing systems
* Service-oriented architecture principles

---

# Future Enhancements

## UC7: Billing & Invoice Generation

* Room cost calculation
* Service cost calculation
* Tax calculation
* Final invoice generation

## UC8: Payment Processing

* UPI
* Credit Card
* Net Banking

## UC9: Room Cancellation & Refund

* Refund calculation
* Cancellation policies

## UC10: Analytics Dashboard

* Occupancy reports
* Revenue reports
* Service utilization reports

---

# Conclusion

BookMyStay demonstrates the complete lifecycle of a hotel booking system using Java Collections and Object-Oriented Design. The application evolves incrementally through multiple use cases, allowing developers to understand how different data structures solve real-world business problems while maintaining scalability, performance, and maintainability.
