package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			Integer number = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			LocalDate checkIn = LocalDate.parse(sc.next(),dtf);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			LocalDate checkOut = LocalDate.parse(sc.next(),dtf);
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = LocalDate.parse(sc.next(),dtf);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = LocalDate.parse(sc.next(),dtf);
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
		}
		catch(DateTimeParseException e ) {
			System.out.println("Invalid date format!");
		}
		catch(DomainException e ) {
			System.out.println("Error in reservation: "+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		
		
		sc.close();
	}

}
