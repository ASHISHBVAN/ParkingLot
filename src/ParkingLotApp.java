import java.util.Scanner;

import Controller.CommandParser;
import Service.ParkingLot;

public class ParkingLotApp {
	
	public static void main(String[] args) {
		
       ParkingLot parkingLot = new ParkingLot(6);
        CommandParser commandParser = new CommandParser(parkingLot);
        
        System.out.println("------Ashish Bhavandasani welcome you to the car parking service------ \n");
        System.out.println(" Please Follow the same commands to interact with application ");
        System.out.println(" To create parking lot Eg:- create_parking_lot 6");

        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("$ ");
            input = scanner.nextLine();
            String output = commandParser.parseCommand(input);
            System.out.println(output);
        } while (!input.equals("exit"));

        scanner.close();
    }

}
