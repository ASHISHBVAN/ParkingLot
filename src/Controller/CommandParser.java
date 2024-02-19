package Controller;
import Service.ParkingLot;

public class CommandParser {
	private ParkingLot parkingLot;

    public CommandParser(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String parseCommand(String input) {
        String[] parts = input.trim().split("\\s+");
        if (parts.length == 0) {
            return "Invalid command.";
        }
        String command = parts[0].toLowerCase();
        switch (command) {
            case "create_parking_lot":
                if (parts.length != 2) {
                    return "Usage: create_parking_lot <capacity>";
                }
                int capacity = Integer.parseInt(parts[1]);
                parkingLot = new ParkingLot(capacity);
                return "Created a parking lot with " + capacity + " slots.";
            case "park":
                if (parts.length != 3) {
                    return "Usage: park <registration_number> <color>";
                }
                return parkingLot.parkCar(parts[1], parts[2]);
            case "leave":
                if (parts.length != 2) {
                    return "Usage: leave <slot_number>";
                }
                int slotNumber = Integer.parseInt(parts[1]);
                return parkingLot.leaveCar(slotNumber);
            case "status":
                return parkingLot.getStatus();
            case "registration_numbers_for_cars_with_colour":
                if (parts.length != 2) {
                    return "Usage: registration_numbers_for_cars_with_colour <color>";
                }
                return parkingLot.getRegistrationNumbersForCarsWithColor(parts[1]);
            case "slot_number_for_registration_number":
                if (parts.length != 2) {
                    return "Usage: slot_number_for_registration_number <registration_number>";
                }
                return parkingLot.getSlotNumberForRegistrationNumber(parts[1]);
            case "slot_numbers_for_cars_with_colour":
                if (parts.length != 2) {
                    return "Usage: slot_numbers_for_cars_with_colour <color>";
                }
                return parkingLot.getSlotNumbersForCarsWithColor(parts[1]);
            case "exit":
                return "Exiting...";
            default:
                return "Invalid command.";
        }
    }
}