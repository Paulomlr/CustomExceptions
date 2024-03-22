package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = in.nextInt();in.nextLine();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(in.nextLine(), dtf);
        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(in.nextLine(), dtf);

        if (!checkOut.isAfter(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(in.nextLine(), dtf);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(in.nextLine(), dtf);

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null){
                System.out.println("Error in reservation: " + error);
            }
            else {
                System.out.println("Reservation: " + reservation);
            }
        }
        in.close();
    }
}