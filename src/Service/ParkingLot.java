package Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Car;

public class ParkingLot {
	private int capacity;
    private Map<Integer, Car> slots;
    private Map<String, Integer> registrationNumberToSlotNumber;
    private Map<String, List<String>> colorToRegistrationNumbers;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.slots = new HashMap<>();
        this.registrationNumberToSlotNumber = new HashMap<>();
        this.colorToRegistrationNumbers = new HashMap<>();
    }

    public String parkCar(String registrationNumber, String color) {
        if (registrationNumberToSlotNumber.containsKey(registrationNumber)) {
            return "Car with registration number " + registrationNumber + " is already parked.";
        }
        if (isFull()) {
            return "Sorry, parking lot is full.";
        }
        int slotNumber = getNearestAvailableSlot();
        Car car = new Car(registrationNumber, color);
        slots.put(slotNumber, car);
        registrationNumberToSlotNumber.put(registrationNumber, slotNumber);
        colorToRegistrationNumbers.computeIfAbsent(color, k -> new ArrayList<>()).add(registrationNumber);
        return "Allocated slot number: " + slotNumber;
    }

    public String leaveCar(int slotNumber) {
        if (!slots.containsKey(slotNumber)) {
            return "Slot number " + slotNumber + " is already free.";
        }
        Car car = slots.remove(slotNumber);
        String registrationNumber = car.getRegistrationNumber();
        String color = car.getColor();
        registrationNumberToSlotNumber.remove(registrationNumber);
        colorToRegistrationNumbers.get(color).remove(registrationNumber);
        return "Slot number " + slotNumber + " is free.";
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder("Slot No.    Registration No    Colour\n");
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) {
            Car car = entry.getValue();
            sb.append(entry.getKey()).append("           ").append(car.getRegistrationNumber()).append("      ").append(car.getColor()).append("\n");
        }
        return sb.toString();
    }

    public String getRegistrationNumbersForCarsWithColor(String color) {
        List<String> registrationNumbers = colorToRegistrationNumbers.getOrDefault(color, Collections.emptyList());
        return String.join(", ", registrationNumbers);
    }

    public String getSlotNumberForRegistrationNumber(String registrationNumber) {
        Integer slotNumber = registrationNumberToSlotNumber.get(registrationNumber);
        if (slotNumber == null) {
            return "Not found";
        }
        return slotNumber.toString();
    }

    public String getSlotNumbersForCarsWithColor(String color) {
        List<String> registrationNumbers = colorToRegistrationNumbers.getOrDefault(color, Collections.emptyList());
        List<String> slotNumbers = new ArrayList<>();
        for (String registrationNumber : registrationNumbers) {
            Integer slotNumber = registrationNumberToSlotNumber.get(registrationNumber);
            if (slotNumber != null) {
                slotNumbers.add(slotNumber.toString());
            }
        }
        return String.join(", ", slotNumbers);
    }

    private boolean isFull() {
        return slots.size() == capacity;
    }

    private int getNearestAvailableSlot() {
        for (int i = 1; i <= capacity; i++) {
            if (!slots.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }
}
