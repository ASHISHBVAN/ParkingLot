Automated Parking Lot Ticketing System
This is a Java-based automated ticketing system for a parking lot. It allows customers to park their cars and retrieve them using a ticketing system.  

Installation and Setup  
Prerequisites  
Java Development Kit (JDK) 8 or higher installed  
Maven for dependency management (optional)  

Steps  
1. Clone the repository to your local machine:  
      git clone https://github.com/ASHISHBVAN/ParkingLot.git  

2. Navigate to the project directory:  
      cd parkinglot  

3. Build the project using Maven (if Maven is installed):  
      mvn clean package  

4. Run the application using the generated JAR file:  
      java -jar target/parkinglot.jar  

5. Follow the on-screen instructions to interact with the parking lot system.  
    Usage  
    To create a parking lot with n slots:  
       create_parking_lot n  
    To park a car with registration number regNum and color color:  
       park regNum color  
    To remove a car from a slot number slotNum:  
       leave slotNum  
    To get the status of the parking lot:  
        status  
    To get registration numbers of cars with a particular color:  
        registration_numbers_for_cars_with_colour color  
    To get slot numbers of slots where cars of a particular color are parked:  
        slot_numbers_for_cars_with_colour color  
    To get slot number in which a car with a given registration number is parked:  
        slot_number_for_registration_number regNum  
    To exit the application:  
        exit  

6. Example  
    Assuming a parking lot with 6 slots, the following commands should be run in sequence:  
  
    create_parking_lot 6  
    park KA-01-HH-1234 White  
    park KA-01-HH-9999 White  
    park KA-01-BB-0001 Black  
    park KA-01-HH-7777 Red  
    park KA-01-HH-2701 Blue  
    park KA-01-HH-3141 Black  
    leave 4  
    status  
    park KA-01-P-333 White  
    park DL-12-AA-9999 White  
    registration_numbers_for_cars_with_colour White  
    exit  
